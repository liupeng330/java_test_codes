package com.heika.test.verify.models;

import com.heika.test.entities.verify.VerifyStrategyOutputEntity;
import com.heika.test.entities.verify.VerifyUserStatusEntity;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import com.heika.test.utils.HibernateUtil;
import com.heika.test.utils.JsonParser;
import com.heika.test.utils.MappingWordUtil;

public class UserDetail
{
    private VerifyUserStatusEntity verifyUserStatusEntity;
    private VerifyStrategyOutputEntity verifyStrategyOutputEntity;
    private final static String queryForVerifyUserStatus = "select * from verify_user_status where user_id=:userId";
    private final static String queryForRealName = "select real_name from verify_user where id=:id";
    private final static String queryForCardName = "select name from card_product where id=:id";
    private final static String queryForStrategyOutput = "select * from verify_strategy_output where user_id=:userId";
    private String firstVerifyCardProductName;
    private String secondVerifyCardProductName;
    private String investigateUserName;
    private String firstVerifyUserName;
    private String secondVerifyUserName;
    private String strategyCardProductName;

    public static UserDetail getFromDB(int userId)
    {
        UserDetail detail = new UserDetail();
        Session session = HibernateUtil.currentSession();
        try
        {
            List verifyUserStatus = session.createSQLQuery(queryForVerifyUserStatus)
                    .addEntity(VerifyUserStatusEntity.class)
                    .setInteger("userId", userId)
                    .list();

            if (verifyUserStatus.size() != 1)
            {
                return null;
            }
            detail.verifyUserStatusEntity = (VerifyUserStatusEntity) verifyUserStatus.get(0);

            List strategyOutputs = session.createSQLQuery(queryForStrategyOutput)
                    .addEntity(VerifyStrategyOutputEntity.class)
                    .setInteger("userId", userId)
                    .list();

            if (strategyOutputs.size() == 1)
            {
                detail.verifyStrategyOutputEntity = (VerifyStrategyOutputEntity) strategyOutputs.get(0);
                if (detail.verifyStrategyOutputEntity.getResult() != null)
                {
                    detail.verifyStrategyOutputEntity.setResult(MappingWordUtil.getCN(detail.verifyStrategyOutputEntity.getResult()));
                }
                detail.strategyCardProductName = getCardProductNameFromDB(((VerifyStrategyOutputEntity) strategyOutputs.get(0)).getCardProductId());
            }
            else
            {
                detail.verifyStrategyOutputEntity = new VerifyStrategyOutputEntity();
            }

            detail.firstVerifyUserName = getRealNameFromDB(detail.verifyUserStatusEntity.getFirstVerifyUserId());
            detail.secondVerifyUserName = getRealNameFromDB(detail.verifyUserStatusEntity.getSecondVerifyUserId());
            detail.investigateUserName = getRealNameFromDB(detail.verifyUserStatusEntity.getInvestigateUserId());
            detail.firstVerifyCardProductName = getCardProductNameFromDB(detail.verifyUserStatusEntity.getFirstVerifyCardProductId());
            detail.secondVerifyCardProductName = getCardProductNameFromDB(detail.verifyUserStatusEntity.getSecondVerifyCardProductId());

            return detail;
        }
        finally
        {
            HibernateUtil.closeSession();
        }
    }

    private static String getRealNameFromDB(Integer userId)
    {
        if (userId == null) return null;
        Session session = HibernateUtil.currentSession();
        try
        {
            List names = session.createSQLQuery(queryForRealName)
                    .setInteger("id", userId)
                    .list();
            if (names.size() != 1)
            {
                return null;
            }
            return names.get(0).toString();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
    }

    private static String getCardProductNameFromDB(Integer cardId)
    {
        if (cardId == null) return null;
        Session session = HibernateUtil.currentSession();
        try
        {
            List names = session.createSQLQuery(queryForCardName)
                    .setInteger("id", cardId)
                    .list();
            if (names.size() != 1)
            {
                return null;
            }
            return names.get(0).toString();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
    }

    public static UserDetail getFromResponse(String response)
    {
        UserDetail userDetail = new UserDetail();
        VerifyUserStatusEntity verifyUserStatusEntity = new VerifyUserStatusEntity();
        VerifyStrategyOutputEntity verifyStrategyOutputEntity = new VerifyStrategyOutputEntity();

        //Parse investigateNoteInfo
        HashMap<String, Object> investigateNoteInfos = new JsonParser().jsonGetHashMap(response, "$.data.investigateNoteInfo");
        if (investigateNoteInfos.get("investigateNote") != null)
            verifyUserStatusEntity.setInvestigateNote(investigateNoteInfos.get("investigateNote").toString());
        if (investigateNoteInfos.get("investigateTime") != null)
            verifyUserStatusEntity.setInvestigateTime(new Timestamp(Long.parseLong(investigateNoteInfos.get("investigateTime").toString())));
        if (investigateNoteInfos.get("investigateUserName") != null)
            userDetail.investigateUserName = investigateNoteInfos.get("investigateUserName").toString();

        //Parse firstVerifyNote
        HashMap<String, Object> firstVerifyNote = new JsonParser().jsonGetHashMap(response, "$.data.firstVerifyNote");
        if (firstVerifyNote.get("firstVerifyAmount") != null)
            verifyUserStatusEntity.setFirstVerifyAmount(new BigDecimal(firstVerifyNote.get("firstVerifyAmount").toString()).setScale(2));
        if (firstVerifyNote.get("firstVerifyNote") != null)
            verifyUserStatusEntity.setFirstVerifyNote(firstVerifyNote.get("firstVerifyNote").toString());
        if (firstVerifyNote.get("firstVerifyTime") != null)
            verifyUserStatusEntity.setFirstVerifyTime(new Timestamp(Long.parseLong(firstVerifyNote.get("firstVerifyTime").toString())));
        if (firstVerifyNote.get("firstVerifyUserName") != null)
            userDetail.firstVerifyUserName = firstVerifyNote.get("firstVerifyUserName").toString();
        if (firstVerifyNote.get("firstVerifyCardProductName") != null)
            userDetail.firstVerifyCardProductName = firstVerifyNote.get("firstVerifyCardProductName").toString();

        //Parse secondVerify
        HashMap<String, Object> secondVerifyNote = new JsonParser().jsonGetHashMap(response, "$.data.secondVerify");
        if (secondVerifyNote.get("secondVerifyAmount") != null)
            verifyUserStatusEntity.setSecondVerifyAmount(new BigDecimal(secondVerifyNote.get("secondVerifyAmount").toString()).setScale(2));
        if (secondVerifyNote.get("secondVerifyNote") != null)
            verifyUserStatusEntity.setSecondVerifyNote(secondVerifyNote.get("secondVerifyNote").toString());
        if (secondVerifyNote.get("secondVerifyTime") != null)
            verifyUserStatusEntity.setSecondVerifyTime(new Timestamp(Long.parseLong(secondVerifyNote.get("secondVerifyTime").toString())));
        if (secondVerifyNote.get("secondVerifyUserName") != null)
            userDetail.secondVerifyUserName = secondVerifyNote.get("secondVerifyUserName").toString();
        if (secondVerifyNote.get("secondVerifyCardProductName") != null)
            userDetail.secondVerifyCardProductName = secondVerifyNote.get("secondVerifyCardProductName").toString();

        //Parse strategy
        HashMap<String, Object> strategy = new JsonParser().jsonGetHashMap(response, "$.data.strategy");
        if (strategy.get("amount") != null)
            verifyStrategyOutputEntity.setAmount(new BigDecimal(strategy.get("amount").toString()).setScale(2));
        if (strategy.get("cardProductId") != null)
            userDetail.strategyCardProductName = strategy.get("cardProductId").toString();
        if (strategy.get("result") != null) verifyStrategyOutputEntity.setResult(strategy.get("result").toString());
        if (strategy.get("isOld") != null)
        {
            verifyStrategyOutputEntity.setIsRrdUser(strategy.get("isOld").equals("1") ? true : false);
        }

        userDetail.verifyStrategyOutputEntity = verifyStrategyOutputEntity;
        userDetail.verifyUserStatusEntity = verifyUserStatusEntity;

        return userDetail;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetail that = (UserDetail) o;

        if (firstVerifyCardProductName != null ? !firstVerifyCardProductName.equals(that.firstVerifyCardProductName) : that.firstVerifyCardProductName != null)
            return false;
        if (secondVerifyCardProductName != null ? !secondVerifyCardProductName.equals(that.secondVerifyCardProductName) : that.secondVerifyCardProductName != null)
            return false;
        if (investigateUserName != null ? !investigateUserName.equals(that.investigateUserName) : that.investigateUserName != null)
            return false;
        if (firstVerifyUserName != null ? !firstVerifyUserName.equals(that.firstVerifyUserName) : that.firstVerifyUserName != null)
            return false;
        if (secondVerifyUserName != null ? !secondVerifyUserName.equals(that.secondVerifyUserName) : that.secondVerifyUserName != null)
            return false;
        if (verifyStrategyOutputEntity.getResult() != null && !verifyStrategyOutputEntity.getResult().equals("拒绝审批"))
        {
            if (strategyCardProductName != null ? !strategyCardProductName.equals(that.strategyCardProductName) : that.strategyCardProductName != null)
                return false;
        }
        if (verifyUserStatusEntity != null ? !verifyUserStatusEntity.equalsForUserDetail(that.verifyUserStatusEntity) : that.verifyUserStatusEntity != null)
            return false;
        if (verifyStrategyOutputEntity != null ? !verifyStrategyOutputEntity.equalsForUserDetail(that.verifyStrategyOutputEntity) : that.verifyStrategyOutputEntity != null)
            return false;

        return true;
    }
}
