package com.heika.test.common;

public enum StrategyResultEnum {
    // 通过
    APPROVE{
        @Override
        public String toString() {
            return "通过审批";
        }
    },
    // 拒绝
    DECLINE {
        @Override
        public String toString() {
            return "拒绝审批";
        }
    };

    @Override
    public abstract String toString();
}
