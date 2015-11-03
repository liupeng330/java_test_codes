package com.heika.test.services.user.impl;

import com.heika.test.common.*;
import com.heika.test.dao.user.UserDao;
import com.heika.test.entities.user.UserEntity;
import com.heika.test.services.user.UserService;
import com.heika.test.utils.LogHelper;
import com.heika.test.utils.RandomData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Transactional
@Service
public class UserImpl implements UserService
{
    @Autowired
    UserDao userDao;

    @Autowired
    LogHelper logHelper;

    @Autowired
    RandomData randomData;

    @Override
    public Integer addUser(boolean isBan, Channel channel, Integer channelId, boolean isFrozen, Integer inviteUserId,
                           String mobile, String nickName, Timestamp registerTime, UserType usertype, Integer version, Timestamp updateTime)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setIsBan(isBan);
        userEntity.setChannel(channel.name());
        userEntity.setChannelId(channelId);
        userEntity.setIsFrozen(isFrozen);
        userEntity.setInviteUserId(inviteUserId);
        userEntity.setMobile(mobile);
        userEntity.setNickName(nickName);
        userEntity.setRegisterTime(registerTime);
        userEntity.setUserType(usertype.name());
        userEntity.setVersion(version);
        userEntity.setUpdateTime(updateTime);

        return addUser(userEntity);
    }

    @Override
    public Integer addUser(UserEntity userEntity)
    {
        logHelper.log("创建UserEntry: " + userEntity.toString());
        return (Integer)userDao.save(userEntity);
    }

    @Override
    public void deleteUser(Integer id)
    {
        logHelper.log("删除UseEntry: userId=" + id);
        userDao.delete(UserEntity.class, id);
    }

    @Override
    public UserEntity getUser(Integer id)
    {
        logHelper.log("获取UserEntry: userId=" + id);
        return userDao.get(UserEntity.class, id);
    }

    @Override
    public UserEntity nextUser()
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setIsBan(false);
        userEntity.setChannel(randomData.nextChoice(Channel.BD_IMPORT.name(), Channel.PERSONAL_REGISTER.name()));
        userEntity.setIsBan(false);
        userEntity.setChannelId(randomData.nextChoice(1, 2));
        userEntity.setIsFrozen(false);
        userEntity.setMobile(randomData.nextMobilePhoneNumber());
        userEntity.setNickName(randomData.nextChineseString(2, 3));
        userEntity.setRegisterTime(randomData.nextTimeStamp(5));
        userEntity.setUserType(UserType.COMMON.name());
        userEntity.setVersion(0);
        userEntity.setUpdateTime(randomData.nextTimeStamp(2));

        return userEntity;
    }
}
