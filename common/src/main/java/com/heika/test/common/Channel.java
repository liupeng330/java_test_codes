package com.heika.test.common;

public enum Channel
{
    BD_IMPORT
    {
            @Override
            public String toString() { return "BD导入"; }
    },
    PERSONAL_REGISTER
    {
            @Override
            public String toString() { return "用户个人注册"; }
    }
}
