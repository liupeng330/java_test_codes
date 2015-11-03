package com.heika.test.common;

/**
 * 审核操作
 * 
 * @author lining
 */
public enum VerifyUserStatusOperateEnum {

    // 用户注册
    USER_REGISTER {
        @Override
        public String toString() {
            return "用户注册";
        }
    },
    // 提交审核

    SUBMIT_AUDIT {
        @Override
        public String toString() {
            return "提交审核";
        }
    },
    // 调查
    INQUIRE {
        @Override
        public String toString() {
            return "调查";
        }
    },
    // 一审
    FIRST_VERIFY {
        @Override
        public String toString() {
            return "一审";
        }
    },
    // 二审
    SECOND_VERIFY {
        @Override
        public String toString() {
            return "二审";
        }

    },
    
 // 三审
    THIRD_VERIFY {
        @Override
        public String toString() {
            return "三审";
        }

    };

    @Override
    public abstract String toString();

}