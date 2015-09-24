package com.heika.test.common;

/**
 * 最高学历
 */
public enum Graduation {

    // 0
    HIGHSCHOOL() {
        @Override
        public String toString() {
            return "高中或以下";
        }
    },
    // 1
    COLLEGE() {
        @Override
        public String toString() {
            return "大专";
        }
    },
    // 2
    UNDERGRADUATE() {
        @Override
        public String toString() {
            return "本科";
        }
    },
    // 3
    GRADUATE() {
        @Override
        public String toString() {
            return "研究生或以上";
        }
    };

    @Override
    public abstract String toString();

}