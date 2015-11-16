package com.heika.test.common;

public enum RealNameVerifyStatusEnum {
    // 0：认证不符
    NOTMATCH { // 0
        @Override
        public String toString() {
            return "认证不符";
        }
    },
    // 1：认证通过
    VALID {
        @Override
        public String toString() {
            return "认证通过";
        }
    },
    // 2：无法核实
    NOTVERIFY {
        @Override
        public String toString() {
            return "无法核实";
        }
    };
    @Override
    public abstract String toString();
}
