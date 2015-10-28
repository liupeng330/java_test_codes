package com.heika.test.verify.cases.API;

import com.github.kevinsawicki.http.HttpRequest;
import com.heika.test.models.user.UserDetail;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGetUserDetail extends TestBase
{
    @Parameters({"verify_getUserDetail"})
    @Test(groups= {"verify-debug"}, description = "审核后台，获取用户详情接口测试。接口： /user/getUserDetail")
    public void getUserDetailInfo(String userId)
    {
        //Getting data from DB
//        UserDetail detailFromDB = UserDetail.getFromDB(Integer.parseInt(userId));

        //Getting data from response
        HttpRequest request = HttpRequest.get(this.baseURL + "user/getUserDetail?userId=" + userId);
        request.header("cookie", this.session);
        org.testng.Assert.assertEquals(200, request.code(), "Response code is not 200!!");
        String responseBody = request.body();
        Reporter.log("Response: " + responseBody, true);
        UserDetail detailFromResponse = UserDetail.getFromResponse(responseBody);

        //Compare them
//        Assert.assertEquals(detailFromResponse, detailFromDB, "There are differences between user detail info from response and from DB");
    }
}
