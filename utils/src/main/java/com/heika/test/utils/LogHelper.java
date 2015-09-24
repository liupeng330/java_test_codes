package com.heika.test.utils;

import org.testng.Reporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogHelper
{
    private static String getFormat()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return String.format("[Testing] [%s] ", dateFormat.format(new Date())) + "[%s]";
    }

    public static void log(String content)
    {
        log(content, 0, true);
    }

    public static void log(String content, int level, boolean outputToConsole)
    {
        Reporter.log(String.format(getFormat(), content), level, outputToConsole);
    }
}
