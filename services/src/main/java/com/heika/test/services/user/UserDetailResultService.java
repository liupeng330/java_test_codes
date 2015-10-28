package com.heika.test.services.user;

import com.heika.test.models.user.UserDetailResult;

public interface UserDetailResultService
{
    UserDetailResult getUserDetailResultFromDB(Integer userId);
    UserDetailResult getUserDetailResultFromResponse(String response);
}
