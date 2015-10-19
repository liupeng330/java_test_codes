package com.heika.test.models.common;

import com.heika.test.utils.JsonParser;

public class PageInfo
{
    private String pageNum;
    private String pageSize;
    private String totalElements;
    private String totalPage;

    public PageInfo(String responseBody)
    {
        JsonParser parser = new JsonParser();
        this.pageNum = parser.jsonGet(responseBody, "$.data.pageInfo.pageNum");
        this.pageSize = parser.jsonGet(responseBody, "$.data.pageInfo.pageSize");
        this.totalElements = parser.jsonGet(responseBody, "$.data.pageInfo.totalElements");
        this.totalPage = parser.jsonGet(responseBody, "$.data.pageInfo.totalPage");
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