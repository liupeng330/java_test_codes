package com.heika.test.services.user;

import com.heika.test.common.RealNameVerifyStatusEnum;
import com.heika.test.models.user.UserInvestigateDetailResult;

public interface UserInvestigateDetailResultService
{
    UserInvestigateDetailResult getInvestigateDetailResultFromDB(Integer userId, RealNameVerifyStatusEnum realNameVerifyStatusEnum);
    UserInvestigateDetailResult getInvestigateDetailResultFromResponse(String response);
}
