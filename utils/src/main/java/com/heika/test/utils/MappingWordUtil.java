package com.heika.test.utils;

import java.util.HashMap;
import java.util.Map;

public final class MappingWordUtil
{
    final static Map<String, String> en_to_cn = new HashMap<>();

    static
    {
        en_to_cn.put("UNCOMMIT", "等待提交");
        en_to_cn.put("INQUIREING", "等待调查");
        en_to_cn.put("INQUIRE", "调查");
        en_to_cn.put("INQUIRE_SUCCESS", "等待一审");
        en_to_cn.put("FIRST_VERIFY", "一审");
        en_to_cn.put("FIRST_VERIFY_SUCCESS", "等待二审");
        en_to_cn.put("FIRST_SEND_BACK", "一审退回");
        en_to_cn.put("SECOND_VERIFY", "二审");
        en_to_cn.put("VERIFY_SUCCESS", "审核通过");
        en_to_cn.put("SECOND_SEND_BACK", "二审退回");
        en_to_cn.put("USER_REGISTER", "用户注册");
        en_to_cn.put("SUBMIT_AUDIT", "提交审核");
        en_to_cn.put("VERIFY_FAIL", "补件");
        en_to_cn.put("VERIFY_REJECT", "退件");

        en_to_cn.put("APPROVE", "通过审批");
        en_to_cn.put("DECLINE", "拒绝审批");

        en_to_cn.put("BD_IMPORT", "BD渠道用户");
        en_to_cn.put("PERSONAL_REGISTER", "普通用户");
    }

    public static String getCN(String en)
    {
        return en_to_cn.get(en);
    }
}
