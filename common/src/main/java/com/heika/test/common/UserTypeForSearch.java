package com.heika.test.common;

public enum UserTypeForSearch
{
    BD_IMPORT
            {
                @Override
                public String toString() { return "BD渠道用户"; }
            },
    PERSONAL_REGISTER
            {
                @Override
                public String toString() { return "普通用户"; }
            }
}
