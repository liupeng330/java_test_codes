package com.heika.test.services.user;

import com.heika.test.models.verify.VerifyLogResult;

import java.util.List;

public interface VerifyLogResultService
{
    List<VerifyLogResult> getVerifyLogResultFromDB(Integer userId);
    List<VerifyLogResult> getVerifyLogResultFromResponse(String response);
}
