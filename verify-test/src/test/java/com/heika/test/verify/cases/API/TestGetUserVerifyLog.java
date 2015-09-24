package com.heika.test.verify.cases.API;

import com.github.kevinsawicki.http.HttpRequest;
import com.heika.test.verify.models.VerifyLog;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestGetUserVerifyLog extends TestBase
{
    @Parameters({"verify_getUserVerifyLog"})
    @Test(groups= {"verify"}, description = "审核后台，用户查询页面下获取用户流水的接口测试。 接口： user/getUserVerifyLog")
    public void getUserVerifyLog(String userId)
    {
        Integer id = Integer.parseInt(userId);

        //Getting data from DB
        List ret_DB = VerifyLog.getFromDB(id);

        //Getting data from response
        HttpRequest request = HttpRequest.post(baseURL + "/user/getUserVerifyLog")
                .header("cookie", this.session)
                .send("userId=" + id);
        org.testng.Assert.assertEquals(200, request.code(), "Response code is not 200!!");
        List ret_response = VerifyLog.getFromResponse(request.body(), "$.data.userVerifyLog");

        //Compare them
        org.testng.Assert.assertEquals(ret_DB, ret_response, "Diff for verify log list!!");
    }
}
