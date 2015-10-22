package com.heika.test.services.user;

import com.heika.test.common.SearchUserType;
import com.heika.test.common.VerifyUserStatus;
import com.heika.test.models.user.UserSearchResult;

import java.util.List;

public interface UserSearchService
{
    List<UserSearchResult> getUsersFromDB(SearchUserType type, String searchContent, VerifyUserStatus status);
    Integer getTotalCountForSearchUser();
    List<UserSearchResult> getUsersFromResponse(String responseBody);
}
