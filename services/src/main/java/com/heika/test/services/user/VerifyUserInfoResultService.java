package com.heika.test.services.user;

import java.util.Map;

public interface VerifyUserInfoResultService
{
    Map<String, String> getResultsByUserId(Integer userId);
    Map<String, String> getAllValidResult();
}
