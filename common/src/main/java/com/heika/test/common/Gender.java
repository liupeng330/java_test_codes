package com.heika.test.common;

/**
 * 性别
 */
public enum Gender {

    // 0
    MALE() {
        @Override
        public String toString() {
            return "男";
        }
    },
    // 1
    FEMALE() {
        @Override
        public String toString() {
            return "女";
        }
    };

    @Override
    public abstract String toString();

}
