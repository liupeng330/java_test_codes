package com.heika.test.models.common;

import com.alibaba.fastjson.JSON;
import com.heika.test.utils.JsonParser;
import com.heika.test.utils.JsonUtil;
import org.json.JSONObject;

public class PageInfo
{
    private String pageNum;
    private String pageSize;
    private String totalElements;
    private String totalPage;

    public PageInfo(){}

    public static PageInfo CreateInstance(String responseBody)
    {
        String parsedJson = JsonUtil.parseDataFromResponse(responseBody);
        JSONObject obj = new JSONObject(parsedJson);
        parsedJson = obj.get("pageInfo").toString();
        return JSON.parseObject(parsedJson, PageInfo.class);
    }

    public String getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(String pageNum)
    {
        this.pageNum = pageNum;
    }

    public String getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(String pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getTotalElements()
    {
        return totalElements;
    }

    public void setTotalElements(String totalElements)
    {
        this.totalElements = totalElements;
    }

    public String getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(String totalPage)
    {
        this.totalPage = totalPage;
    }
}