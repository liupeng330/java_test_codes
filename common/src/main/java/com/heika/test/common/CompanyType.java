package com.heika.test.common;

/**
 * 公司类别
 */
public enum CompanyType {

    // 0
    STATORGAN() {
        @Override
        public String toString() {
            return "国家机关";
        }
    },
    // 1
    INSTITUTIONS() {
        @Override
        public String toString() {
            return "事业单位";
        }
    },
    // 2
    CENTERRATE() {
        @Override
        public String toString() {
            return "央企（包括下级单位）";
        }
    },
    // 3
    LOCALRATE() {
        @Override
        public String toString() {
            return "地方国资委直属企业";
        }
    },
    // 4
    WORDRATE() {
        @Override
        public String toString() {
            return "世界500强（包括合资企业及下级单位）";
        }
    },
    // 5
    FOREGNRATE() {
        @Override
        public String toString() {
            return "外资企业（包括合资企业）";
        }
    },
    // 6
    GENERALRATE() {
        @Override
        public String toString() {
            return "一般上市公司（包括国外上市）";
        }
    },
    // 7
    PRIVATERATE() {
        @Override
        public String toString() {
            return "一般民营企业";
        }
    },
    // 8
    INDIVIDUALRATE() {
        public String toString() {
            return "个体经营者";
        }
    },
    // 9
    OTHER() {
        public String toString() {
            return "其他";
        }
    };

    @Override
    public abstract String toString();

}
