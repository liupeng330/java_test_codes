package com.heika.test.verify.cases.API;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import com.heika.test.common.SearchUserType;
import com.heika.test.common.VerifyUserStatus;
import com.heika.test.models.common.PageInfo;
import com.heika.test.models.user.UserSearchResult;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.kevinsawicki.http.HttpRequest;
import org.apache.commons.lang3.StringUtils;

public class TestSearchUser extends TestBase
{
    @DataProvider(name = "pageSize")
    public Object[][] createData()
    {
        return new Object[][] {{10}, {20}, {50}, {100}, {200}};
    }

    @Test(groups = {"verify"}, description = "审核后台，用户查询的接口测试，根据pageSize获取相应的用户信息", timeOut = 60000, dataProvider = "pageSize")
    public void searchUser_by_pageNum(int pageSize) throws SQLException
    {
        //1. Get total element
        //Integer expectedTotalElements = UserSearchResult.getTotalCount(this.sqlHelper);
        Integer expectedTotalElements = userSearchService.getTotalCountForSearchUser();

        //2. Calculate totalPage
        Integer expectedTotalPage = (expectedTotalElements/pageSize) + 1;

        //3. Sending request
        HttpRequest request = HttpRequest.post(baseURL + "/user/searchUser")
                .header("cookie", this.session)
                .send(String.format("pageNum=1&pageSize=%s&type=&key=" , pageSize));

        org.testng.Assert.assertEquals(200, request.code(), "Response code is not 200!!");

        //4. Compare page info
        PageInfo pageInfo = new PageInfo(request.body());
        org.testng.Assert.assertEquals(expectedTotalPage.toString(), pageInfo.getTotalPage(),"The totalPage is incorrect!");
        org.testng.Assert.assertEquals(expectedTotalElements.toString(), pageInfo.getTotalElements(), "The totalElement is incorrect!");

        //5. Verify every page's count
        for(int i = 1; i<=expectedTotalPage; i++)
        {
            request = HttpRequest.post(baseURL + "/user/searchUser")
                    .header("cookie", this.session)
                    .send(String.format("pageNum=%s&pageSize=%s&type=&key=" , i, pageSize));
            org.testng.Assert.assertEquals(200, request.code(), "Response code is not 200!!");
            String response = request.body();
            Reporter.log(String.format("The element count for page num %s, page size %s\n", i, pageSize), true);
            List<UserSearchResult> usersFromResponse = userSearchService.getUsersFromResponse(response);
            org.testng.Assert.assertNotNull(
                    usersFromResponse,
                    "Fail to get user list from response JSON, response content: " + response);
            org.testng.Assert.assertEquals(
                    i == expectedTotalPage ? (expectedTotalElements % pageSize) : pageSize,
                    usersFromResponse.size(),
                    String.format("The element count for page num %s, page size %s is incorrect!!", i, pageSize));
        }
    }

    @DataProvider(name = "verifyStatus")
    public Object[][] createDataForVerifySearch()
    {
        return new Object[][] {
                {"", "", "UNCOMMIT"},
                {"", "", "INQUIREING"},
                {"", "", "VERIFY_FAIL"},
                {"", "", "INQUIRE_SUCCESS"},
                {"", "", "FIRST_SEND_BACK"},
                {"", "", "FIRST_VERIFY_SUCCESS"},
                {"", "", "SECOND_SEND_BACK"},
                {"", "", "VERIFY_REJECT"},
                {"", "", "VERIFY_SUCCESS"},
                {"NICKNAME", "", "UNCOMMIT"},
                {"MOBILE", "", "UNCOMMIT"},
                {"IDCARD", "", "UNCOMMIT"},
                {"USERNAME", "", "UNCOMMIT"},
                {"NICKNAME", "", "INQUIREING"},
                {"MOBILE", "", "INQUIREING"},
                {"IDCARD", "", "INQUIREING"},
                {"USERNAME", "", "INQUIREING"},
                {"NICKNAME", "", "VERIFY_FAIL"},
                {"MOBILE", "", "VERIFY_FAIL"},
                {"IDCARD", "", "VERIFY_FAIL"},
                {"USERNAME", "", "VERIFY_FAIL"},
                {"NICKNAME", "", "INQUIRE_SUCCESS"},
                {"MOBILE", "", "INQUIRE_SUCCESS"},
                {"IDCARD", "", "INQUIRE_SUCCESS"},
                {"USERNAME", "", "INQUIRE_SUCCESS"},
                {"NICKNAME", "", "FIRST_SEND_BACK"},
                {"MOBILE", "", "FIRST_SEND_BACK"},
                {"IDCARD", "", "FIRST_SEND_BACK"},
                {"USERNAME", "", "FIRST_SEND_BACK"},
                {"NICKNAME", "", "FIRST_VERIFY_SUCCESS"},
                {"MOBILE", "", "FIRST_VERIFY_SUCCESS"},
                {"IDCARD", "", "FIRST_VERIFY_SUCCESS"},
                {"USERNAME", "", "FIRST_VERIFY_SUCCESS"},
                {"NICKNAME", "", "SECOND_SEND_BACK"},
                {"MOBILE", "", "SECOND_SEND_BACK"},
                {"IDCARD", "", "SECOND_SEND_BACK"},
                {"USERNAME", "", "SECOND_SEND_BACK"},
                {"NICKNAME", "", "VERIFY_REJECT"},
                {"MOBILE", "", "VERIFY_REJECT"},
                {"IDCARD", "", "VERIFY_REJECT"},
                {"USERNAME", "", "VERIFY_REJECT"},
                {"NICKNAME", "", "VERIFY_SUCCESS"},
                {"MOBILE", "", "VERIFY_SUCCESS"},
                {"IDCARD", "", "VERIFY_SUCCESS"},
                {"USERNAME", "", "VERIFY_SUCCESS"},
                {"NICKNAME", "final_test31", "UNCOMMIT"},
                {"MOBILE", "13612100001", "UNCOMMIT"},
                {"IDCARD", "620600198111148628", "UNCOMMIT"},
                {"USERNAME", "王大1", "UNCOMMIT"},
                {"NICKNAME", "rrd_111", "INQUIREING"},
                {"MOBILE", "13812200111", "INQUIREING"},
                {"IDCARD", "620600198111148628", "INQUIREING"},
                {"USERNAME", "测试111", "INQUIREING"},
                {"NICKNAME", "rrd_80", "VERIFY_FAIL"},
                {"MOBILE", "13812200080", "VERIFY_FAIL"},
                {"IDCARD", "620600198111148628", "VERIFY_FAIL"},
                {"USERNAME", "测试80", "VERIFY_FAIL"},
                {"NICKNAME", "rrd_92", "INQUIRE_SUCCESS"},
                {"MOBILE", "13812200092", "INQUIRE_SUCCESS"},
                {"IDCARD", "620600198111148628", "INQUIRE_SUCCESS"},
                {"USERNAME", "测试92", "INQUIRE_SUCCESS"},
                {"NICKNAME", "rrd_88", "FIRST_SEND_BACK"},
                {"MOBILE", "13812200088", "FIRST_SEND_BACK"},
                {"IDCARD", "620600198111148628", "FIRST_SEND_BACK"},
                {"USERNAME", "测试88", "FIRST_SEND_BACK"},
                {"NICKNAME", "rrd_85", "FIRST_VERIFY_SUCCESS"},
                {"MOBILE", "13812200085", "FIRST_VERIFY_SUCCESS"},
                {"IDCARD", "620600198111148628", "FIRST_VERIFY_SUCCESS"},
                {"USERNAME", "测试85", "FIRST_VERIFY_SUCCESS"},
                {"NICKNAME", "rrd_48", "SECOND_SEND_BACK"},
                {"MOBILE", "13812200048", "SECOND_SEND_BACK"},
                {"IDCARD", "620600198111148628", "SECOND_SEND_BACK"},
                {"USERNAME", "测试48", "SECOND_SEND_BACK"},
                {"NICKNAME", "rrd_20", "VERIFY_REJECT"},
                {"MOBILE", "13812200020", "VERIFY_REJECT"},
                {"IDCARD", "620600198111148628", "VERIFY_REJECT"},
                {"USERNAME", "测试20", "VERIFY_REJECT"},
                {"NICKNAME", "rrd_69", "VERIFY_SUCCESS"},
                {"MOBILE", "13812200069", "VERIFY_SUCCESS"},
                {"IDCARD", "620600198111148628", "VERIFY_SUCCESS"},
                {"USERNAME", "测试69", "VERIFY_SUCCESS"},

                {"NICKNAME", "shenshuo111", ""},
                {"MOBILE", "15911027605", ""},
                {"IDCARD", "610830198212012014", ""},
                {"USERNAME", "史良万", ""},

                {"NICKNAME", "", ""},
                {"MOBILE", "", ""},
                {"IDCARD", "", ""},
                {"USERNAME", "", ""}
        };
    }

    @Test(groups = {"verify"}, description = "审核后台，按照type、key与verifyStatus进行用户信息的查询", dataProvider = "verifyStatus", timeOut = 60000 * 10)
    public void searchUser_by_verifyStatus(String type, String key, String verifyStatus) throws SQLException
    {
        //Sending request
        String postBody = String.format("pageNum=1&pageSize=999&type=%s&key=%s&verifyStatuses=%s", type, key, verifyStatus);
        Reporter.log("Sending request with following params: " + postBody, true);
        HttpRequest request = HttpRequest.post(baseURL + "/user/searchUser")
                .header("cookie", this.session)
                .send(postBody);
        org.testng.Assert.assertEquals(200, request.code(), "Response code is not 200!!");

        //Get data from response
        List<UserSearchResult> usersFromResponse = userSearchService.getUsersFromResponse(request.body());

        //Get data from mysql
        if(StringUtils.isEmpty(key))
        {
            type = "";
        }

        SearchUserType searchUserType = null;
        if(StringUtils.isNotEmpty(type))
        {
            searchUserType = Enum.valueOf(SearchUserType.class, type);
        }

        VerifyUserStatus status = null;
        if(StringUtils.isNotEmpty(verifyStatus))
        {
            status = Enum.valueOf(VerifyUserStatus.class, verifyStatus);
        }
        List<UserSearchResult> usersFromDB = userSearchService.getUsersFromDB(searchUserType, key, status);

        //Compare them
        Collections.sort(usersFromResponse);
        Collections.sort(usersFromDB);
        org.testng.Assert.assertEquals(usersFromDB, usersFromResponse, "Diff for user detail objects!!");
    }
}

