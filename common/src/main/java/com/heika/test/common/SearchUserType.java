package com.heika.test.common;

public enum SearchUserType
{
    MOBILE {
        @Override
        public String toString() {
            return "手机号";
        }
    },
    NICKNAME {
        @Override
        public String toString() {
            return "昵称";
        }
    },
    IDCARD {
        @Override
        public String toString() {
            return "身份证号";
        }
    },
    USERNAME {
        @Override
        public String toString() {
            return "姓名";
        }
    },
    CHANNELNAME {
        @Override
        public String toString() {
            return "BD渠道号";
        }
    };

    @Override
    public abstract String toString();
}
