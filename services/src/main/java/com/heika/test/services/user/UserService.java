package com.heika.test.services.user;

import com.heika.test.common.Channel;
import com.heika.test.common.SearchUserType;
import com.heika.test.common.UserType;
import com.heika.test.common.VerifyUserStatus;
import com.heika.test.entities.user.UserEntity;
import com.heika.test.models.user.UserSearchResult;

import java.sql.Timestamp;
import java.util.List;

public interface UserService
{
    Integer addUser(boolean isBan, Channel channel, Integer channelId, boolean isFrozen, Integer inviteUserId,
                    String mobile, String nickName, Timestamp registerTime, UserType usertype, Integer version, Timestamp updateTime);
    Integer addUser(UserEntity userEntity);
    void deleteUser(Integer id);
    UserEntity getUser(Integer id);
    UserEntity getUser(String nickName);
    UserEntity nextUser();
}
