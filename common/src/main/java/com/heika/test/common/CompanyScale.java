package com.heika.test.common;

/**
 * 公司规模
 */
public enum CompanyScale {

    // 0
    LESSTHANTEN() {
        @Override
        public String toString() {
            return "10人以下";
        }
    },
    // 1
    TENTOONEHAN() {
        @Override
        public String toString() {
            return "10-100人";
        }
    },
    // 2
    ONEHANTOFIVEHAN() {
        @Override
        public String toString() {
            return "100-500人";
        }
    },
    // 3
    GREATTHANFIVEHAN() {
        @Override
        public String toString() {
            return "500人以上";
        }
    };

    @Override
    public abstract String toString();

}
