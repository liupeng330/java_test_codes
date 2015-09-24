package com.heika.test.services.user;

import com.heika.test.common.Channel;
import com.heika.test.common.UserType;
import com.heika.test.entities.user.UserEntity;

import java.sql.Timestamp;

public interface UserService
{
    Integer addUser(boolean isBan, Channel channel, Integer channelId, boolean isFrozen, Integer inviteUserId,
                    String mobile, String nickName, Timestamp registerTime, UserType usertype, Integer version, Timestamp updateTime);
    Integer addUser(UserEntity userEntity);
    void deleteUser(Integer id);
    UserEntity getUser(Integer id);
    UserEntity nextUser();
}
