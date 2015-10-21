package com.heika.test.dao.user;

import com.heika.test.dao.base.BaseDaoHibernate4;
import com.heika.test.entities.user.UserEntity;
import com.heika.test.entities.user.UserInfoEntity;

import java.util.ArrayList;
import java.util.List;

public class UserInfoDao extends BaseDaoHibernate4<UserInfoEntity>
{
    public void deleteByUserId(Integer userId)
    {
        this.delete(UserInfoEntity.class, "userId", userId);
    }

    public UserInfoEntity getByUserId(Integer userId)
    {
        return this.get(UserInfoEntity.class, "userId", userId);
    }

    public List<UserInfoEntity> getByUserIds(List<Integer> userIds)
    {
        return this.getList(UserInfoEntity.class, "userId", userIds);
    }

    public List<UserInfoEntity> getByUserIdsAndIdNoPreSearch(List<Integer> userIds, String idNo)
    {
        List<UserInfoEntity> searchByIdNo = new ArrayList<>();
        this.getByUserIds(userIds).forEach(i ->
        {
            if (i.getIdNo().startsWith(idNo))
            {
                searchByIdNo.add(i);
            }
        });
        return searchByIdNo;
    }

    public List<UserInfoEntity> getByUserIdsAndRealNamePreSearch(List<Integer> userIds, String realname)
    {
        List<UserInfoEntity> searchByRealName = new ArrayList<>();
        this.getByUserIds(userIds).forEach(i ->
        {
            if (i.getRealName().startsWith(realname))
            {
                searchByRealName.add(i);
            }
        });
        return searchByRealName;
    }
}
