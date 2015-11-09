package com.heika.test.services.user;

public interface PrepareTestDataService
{
    void updateUserStatusToINQUIREING(Integer userId);
    void updateUserStatusResultToPending(Integer userId);
    void cleanupUserInfoRefine(Integer userId);
    void cleanupUserStatusLog(Integer userId);
    void cleanupStrategyOutput(Integer userId);
}
