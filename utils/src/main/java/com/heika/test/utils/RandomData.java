package com.heika.test.utils;

import javax.persistence.Entity;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CancellationException;

public class RandomData
{
    public static final String LETTERCHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERCHAR = "0123456789";
    public static final String ALLCHAR = NUMBERCHAR + LETTERCHAR;

    private Random random;

    public Random getRandom()
    {
        return random;
    }

    public RandomData()
    {
        this.random = new Random();
    }

    public RandomData(long seed)
    {
        this.random = new Random(seed);
    }

    public boolean nextBoolean()
    {
        return random.nextBoolean();
    }

    public int nextBit()
    {
        return this.nextInt(0, 1);
    }

    public int nextInt(int min, int max)
    {
        return this.random.nextInt((max - min) + 1) + min;
    }

    private long nextLong(long n)
    {
        long bits, val;
        do
        {
            bits = (random.nextLong() << 1) >>> 1;
            val = bits % n;
        }
        while (bits-val+(n-1) < 0L);
        return val;
    }

    public long nextLong(long min, long max)
    {
        return this.nextLong((max - min) + 1) + min;
    }

    public Double nextDouble(Double min, Double max)
    {
        if(min < 0 || min > max)
        {
            return null;
        }
        return this.random.nextDouble() * (max - min) + min;
    }

    public BigDecimal nextBigDecimal()
    {
         return new BigDecimal(this.random.nextDouble());
    }

    public BigDecimal nextBigDecimal(Double max)
    {
        if(max < 0)
        {
            return null;
        }
        return this.nextBigDecimal(0.0, max);
    }

    public BigDecimal nextBigDecimal(Double min, Double max)
    {
        return new BigDecimal(this.nextDouble(min, max));
    }

    public String nextDigits(int length)
    {
        StringBuffer ret = new StringBuffer();
        for(int i=0; i<length; i++)
        {
           ret.append(nextInt(0, 9));
        }
        return ret.toString();
    }

    public <T> T nextChoice(List<T> choices)
    {
        if(choices == null)
        {
            throw new IllegalArgumentException("choices cannot be null!!");
        }
        if(choices.size() == 0)
        {
            throw new IllegalArgumentException("The length of choices cannot be 0!!");
        }
        Object[] arr = choices.toArray();
        return (T)arr[this.nextInt(0, choices.size() - 1)];
    }

    public <T> T nextChoice(T ...choices)
    {
        return nextChoice(Arrays.asList(choices));
    }

    public String nextEnglishString(int length)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++)
        {
            sb.append(LETTERCHAR.charAt(random.nextInt(LETTERCHAR.length())));
        }
        return sb.toString();
    }

    public String nextEnglisthStringLowercase(int length)
    {
        return nextEnglishString(length).toLowerCase();
    }

    public String nextEnglisthStringUppercase(int length)
    {
        return nextEnglishString(length).toUpperCase();
    }

    public String nextMobilePhoneNumber()
    {
        String[] prefixes = {"131", "135", "136", "137", "138", "139", "151", "156", "158", "186", "188", "189"};
        return nextChoice(prefixes) + nextDigits(8);
    }

    public String nextChineseString()
    {
        String str = null;
        int highPos, lowPos;
        highPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = 161 + Math.abs(random.nextInt(93));
        byte[] b = new byte[2];
        b[0] = (new Integer(highPos)).byteValue();
        b[1] = (new Integer(lowPos)).byteValue();
        try
        {
            str = new String(b, "GB2312");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return str;
    }

    public String nextChineseString(int length)
    {
        String str = "";
        for (int i = length; i > 0; i--)
        {
            str = str + nextChineseString();
        }
        return str;
    }

    public String nextChineseString(int start, int end)
    {
        String str = "";
        int length = new Random().nextInt(end + 1);
        if (length < start)
        {
            str = nextChineseString(start, end);
        }
        else
        {
            for (int i = 0; i < length; i++)
            {
                str = str + nextChineseString();
            }
        }
        return str;
    }

    public String nextChineseName()
    {
        return nextChineseString(2, 3);
    }

    public Date nextDate(Date from, Date to)
    {
        long beginTime = from.getTime();
        long endTime = to.getTime();

        long diff = endTime - beginTime + 1;
        long randomTime = beginTime + (long)(Math.random() * diff);
        return new Date(randomTime);
    }

    public String nextDate(String from, String to)
    {
        try
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date randomDate = nextDate(simpleDateFormat.parse(from), simpleDateFormat.parse(to));
            return simpleDateFormat.format(randomDate);
        }
        catch(ParseException ex)
        {
            return null;
        }
    }

    public Timestamp nextTimeStamp(Date from)
    {
        return new Timestamp(nextDate(from, new Date()).getTime());
    }

    public Timestamp nextTimeStamp(Timestamp from)
    {
        return new Timestamp(nextDate(new Date(from.getTime()), new Date()).getTime());
    }

    public Timestamp nextTimeStamp(Date from, Date to)
    {
        return new Timestamp(nextDate(from, to).getTime());
    }

    public Timestamp nextTimeStamp(int fromNowToLastDays)
    {
        return nextTimeStamp(new Date(), fromNowToLastDays);
    }

    public Timestamp nextTimeStamp(Timestamp from, int toLastDays)
    {
        return nextTimeStamp(new Date(from.getTime()), toLastDays);
    }

    public Timestamp nextTimeStamp(Date from, int toLastDays)
    {
        Date nDaysBefore = new Date(from.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(nDaysBefore);
        c.add(Calendar.DATE, toLastDays * -1);
        nDaysBefore.setTime(c.getTime().getTime());

        return nextTimeStamp(nDaysBefore, from);
    }

    public String nextEnumName(Class clazz)
    {
        Object[] objs = clazz.getEnumConstants();
        List<String> names = new ArrayList<>();
        for(int i=0; i<objs.length; i++)
        {
            names.add(((Enum) objs[i]).name());
        }

        return this.nextChoice(names.toArray(new String[0]));
    }

    public String nextEmail()
    {
        return nextEnglishString(8) + "@" + nextEnglishString(3) + ".com";
    }
}
