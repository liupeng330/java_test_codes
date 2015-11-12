package com.heika.test.services.user;

import com.heika.test.common.VerifyUserStatus;
import com.heika.test.entities.verify.VerifyUserStatusEntity;

public interface VerifyUserStatusService
{
    Integer addVerifyUserStatus(VerifyUserStatusEntity verifyUserStatusEntity);
    void deleteVerifyUserStatusByUserId(Integer userId);

    VerifyUserStatusEntity nextUncommitVerifyUserStatus(Integer userId);
    VerifyUserStatusEntity nextInquireingVerifyUserStatus(Integer userId);
    VerifyUserStatusEntity nextInquireSuccessVerifyUserStatus(Integer userId, Integer investigateUserId);
    VerifyUserStatusEntity nextVerifyFailVerifyUserStatus(Integer userId, Integer investigateUserId);
    VerifyUserStatusEntity nextFirstVerifySuccessVerifyUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId);
    VerifyUserStatusEntity nextFirstSendBackVerifyUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId);
    VerifyUserStatusEntity nextFirstVerifyRejectVerifyUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId);
    VerifyUserStatusEntity nextSecondVerifySuccessVerifyUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId, Integer secondVerifyUserId);
    VerifyUserStatusEntity nextSecondSendBackVerifyUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId, Integer secondVerifyUserId);
    VerifyUserStatusEntity nextSecondVerifyRejectUserStatus(Integer userId, Integer investigateUserId, Integer firstVerifyUserId, Integer secondVerifyUserId);
    VerifyUserStatusEntity nextVerifyUserStatusByStatus(Integer userId,
                                                        VerifyUserStatus status,
                                                        Integer investigateUserId,
                                                        Integer firstVerifyUserId,
                                                        Integer secondVerifyUserId);
    Boolean isInquireSuccessStatus(Integer userId, Integer invUserId, String invNote, Integer onlineTime);
}
