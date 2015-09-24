package com.heika.test.common;

public enum MarriageStatus {
    // 0
    UNMARRIED() {
        @Override
        public String toString() {
            return "未婚";
        }
    },
    // 1
    MARRIED() {
        @Override
        public String toString() {
            return "已婚";
        }
    },
    // 2
    DIVORCED() {
        @Override
        public String toString() {
            return "离异";
        }
    },
    // 3
    WIDOWED() {
        @Override
        public String toString() {
            return "丧偶";
        }
    };

    @Override
    public abstract String toString();

}
