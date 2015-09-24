package com.heika.test.common;

/**
 * 公司行业
 */
public enum CompanyIndustry {

    // 0
    MANUFACTURE() {
        @Override
        public String toString() {
            return "制造业";
        }
    },
    // 1
    IT() {
        @Override
        public String toString() {
            return "IT";
        }
    },
    // 2
    GOVERNMENT() {
        @Override
        public String toString() {
            return "政府机关";
        }
    },
    // 3
    MEDIAADVERTISIING() {
        @Override
        public String toString() {
            return "媒体/广告";
        }
    },
    // 4
    RETAIL() {
        @Override
        public String toString() {
            return "零售/批发";
        }
    },
    // 5
    EDUCATION() {
        @Override
        public String toString() {
            return "教育/培训";
        }
    },
    // 6
    UTILITIES() {
        @Override
        public String toString() {
            return "公共事业";
        }
    },
    // 7
    TRANSPORTATION() {
        @Override
        public String toString() {
            return "交通运输业";
        }
    },
    // 8
    ESTATE() {
        @Override
        public String toString() {
            return "房地产业";
        }
    },
    // 9
    ENERGY() {
        @Override
        public String toString() {
            return "能源业";
        }
    },
    // 10
    FINANCIAL() {
        @Override
        public String toString() {
            return "金融/法律";
        }
    },
    // 11
    CATERING() {
        @Override
        public String toString() {
            return "餐饮/旅馆业";
        }
    },
    // 12
    MEDICAL() {
        @Override
        public String toString() {
            return "医疗/卫生/保健";
        }
    },
    // 13
    BUILDING() {
        @Override
        public String toString() {
            return "建筑工程";
        }
    },
    // 14
    FARM() {
        @Override
        public String toString() {
            return "农业";
        }
    },
    // 15
    ENTERTAINMENT() {
        @Override
        public String toString() {
            return "娱乐服务业";
        }
    },
    // 16
    SPORTS() {
        @Override
        public String toString() {
            return "体育/艺术";
        }
    },
    // 17
    COMMUNITY() {
        @Override
        public String toString() {
            return "公益组织";
        }
    },
    // 18
    OTHER() {
        @Override
        public String toString() {
            return "其它";
        }
    };

    @Override
    public abstract String toString();

}
