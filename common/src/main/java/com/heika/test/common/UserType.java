package com.heika.test.common;

public enum UserType
{
    // 0
    SYSTEM
    {
        @Override
        public String toString() {
            return "系统用户";
        }
    },
    // 1
    COMMON
    {
        @Override
        public String toString() {
            return "普通用户";
        }
    },
    // 2
    SPECIAL
    {
        @Override
        public String toString() { return "特殊用户"; }
    },
    //3
    TEST
    {
        @Override
        public String toString() { return "测试用户"; }
    }
}
