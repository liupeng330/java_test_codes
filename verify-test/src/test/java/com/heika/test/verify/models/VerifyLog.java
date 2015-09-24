package com.heika.test.verify.models;

import com.heika.test.utils.HibernateUtil;
import com.heika.test.utils.JsonParser;
import com.heika.test.utils.MappingWordUtil;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class VerifyLog
{
    private BigDecimal amount;
    private Timestamp createTime;
    private String level;
    private String note;
    private String operation;
    private String operationResult;
    private String verifyUser;

    private final static String query =
        "select s.amount, s.create_time as createTime, c.name as level, s.note, s.operation, s.operation_result as operationResult, u.real_name as verifyUser\n" +
        "from verify_user_status_log as s \n" +
        "left join verify_user as u \n" +
        "on s.verify_user_id=u.id\n" +
        "left join card_product as c\n" +
        "on s.card_product_id=c.id\n" +
        "where user_id=:uid\n" +
        "order by createTime;";

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    public String getOperationResult()
    {
        return operationResult;
    }

    public void setOperationResult(String operationResult)
    {
        this.operationResult = operationResult;
    }

    public String getVerifyUser()
    {
        return verifyUser;
    }

    public void setVerifyUser(String verifyUser)
    {
        this.verifyUser = verifyUser;
    }

    public static List getFromDB(int userId)
    {
        Session session = HibernateUtil.currentSession();
        try
        {
            List list = session.createSQLQuery(query)
                    .setInteger("uid", userId)
                    .setResultTransformer(Transformers.aliasToBean(VerifyLog.class))
                    .list();
            for(Object obj: list)
            {
                VerifyLog verifyLog = (VerifyLog)obj;
                String ret;
                if ((ret = MappingWordUtil.getCN(verifyLog.getOperation())) != null)
                {
                    verifyLog.setOperation(ret);
                }
                if ((ret = MappingWordUtil.getCN(verifyLog.getOperationResult())) != null)
                {
                    verifyLog.setOperationResult(ret);
                }
            }
            return list;
        }
        finally
        {
            HibernateUtil.closeSession();
        }
    }

    public static List getFromResponse(String response, String query)
    {
        List<LinkedHashMap<String, Object>> data = new JsonParser().jsonGetHashMapList(response, query);
        List<VerifyLog> logs = new ArrayList<>();
        for (LinkedHashMap<String, Object> map : data)
        {
            VerifyLog verifyLog = new VerifyLog();
            if (map.get("amount") != null)
                verifyLog.setAmount(new BigDecimal(map.get("amount").toString()).setScale(2));
            if (map.get("createTime") != null)
                verifyLog.setCreateTime(new Timestamp(Long.parseLong(map.get("createTime").toString())));
            if (map.get("level") != null) verifyLog.setLevel(map.get("level").toString());
            if (map.get("note") != null) verifyLog.setNote(map.get("note").toString());
            if (map.get("operation") != null) verifyLog.setOperation(map.get("operation").toString());
            if (map.get("operationResult") != null) verifyLog.setOperationResult(map.get("operationResult").toString());
            if (map.get("verify") != null) verifyLog.setVerifyUser(map.get("verify").toString());
            logs.add(verifyLog);

        }
        return logs;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerifyLog that = (VerifyLog) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;
        if (operationResult != null ? !operationResult.equals(that.operationResult) : that.operationResult != null)
            return false;
        if (verifyUser != null ? !verifyUser.equals(that.verifyUser) : that.verifyUser != null) return false;

        return true;
    }
}
