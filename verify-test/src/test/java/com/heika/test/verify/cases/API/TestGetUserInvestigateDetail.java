package com.heika.test.verify.cases.API;

import com.heika.test.common.RealNameVerifyStatusEnum;
import com.heika.test.models.user.UserInvestigateDetailResult;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGetUserInvestigateDetail extends TestBase
{
    @Parameters({"verify_getUserInvDetail"})
    @Test(groups= {"verify-debug"}, description = "")
    public void getUserInvDetail(String userId)
    {
        Integer id = Integer.parseInt(userId);
        UserInvestigateDetailResult resultInDB = this.userInvestigateDetailResultService.getInvestigateDetailResultFromDB(id, RealNameVerifyStatusEnum.NOTMATCH);
    }
}
