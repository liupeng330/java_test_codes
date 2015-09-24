package com.heika.test.verify;

import org.apache.commons.cli.*;

public class GenerateTestData
{
    public static void main( String[] args )
    {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try
        {
            cmd = parser.parse(createOption(), args);
        }
        catch (ParseException ex)
        {
            System.out.println("解析命令行参数出错！！");
            ex.printStackTrace();
        }

        Integer countOfTestData = Integer.parseInt(cmd.getOptionValue("c"));
        if(countOfTestData != null)
        {
            System.out.println(countOfTestData);
        }
    }

    private static Options createOption()
    {
        Options options = new Options();
        options.addOption("c", true, "产生数据的条目");

        return options;
    }
}
