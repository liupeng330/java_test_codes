package com.heika.test.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.nebhale.jsonpath.JsonPath;

public class JsonParser
{
	public String jsonGet(String match, String string)
	{
		return JsonPath.read(string,match, String.class);
	}

    public <K, V> List<LinkedHashMap<K, V>> jsonGetHashMapList(String match, String string)
    {
        return (List<LinkedHashMap<K, V>>)JsonPath.read(string, match, List.class);
    }

    public <T> List<T> jsonGetList(String match, String string)
    {
        return (List<T>)JsonPath.read(string, match, List.class);
    }

    public <K, V> HashMap<K, V> jsonGetHashMap(String match, String string)
    {
        return (HashMap<K, V>)JsonPath.read(string, match, HashMap.class);
    }
}
