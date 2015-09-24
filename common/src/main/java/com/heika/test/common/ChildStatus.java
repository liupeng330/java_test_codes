package com.heika.test.common;

public enum ChildStatus {
    // 0
    ZERO() {
        @Override
        public String toString() {
            return "无";
        }
    },
    // 1
    ONE() {
        @Override
        public String toString() {
            return "1个";
        }
    },
    // 2
    TWO() {
        @Override
        public String toString() {
            return "2个";
        }
    },
    // 3
    THREE() {
        @Override
        public String toString() {
            return "3个";
        }
    },
    FOUR_OR_MORE() {
        @Override
        public String toString() {
            return "4个及其以上";
        }
    };

    @Override
    public abstract String toString();
}

