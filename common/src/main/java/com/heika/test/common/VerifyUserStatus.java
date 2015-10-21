package com.heika.test.common;

/**
 * 审核状态
 *
 * @author zhoujiuping
 */
public enum VerifyUserStatus
{
    // 0 初始状态
    UNCOMMIT {
        @Override
        public String toString() {
            return "等待提交";
        }
    },
    // 调查中
    INQUIREING {
        @Override
        public String toString() { return "等待调查"; }
    },
    INQUIRE_SUCCESS {
        @Override
        public String toString() { return "等待一审"; }
    },
    VERIFY_FAIL {
        @Override
        public String toString() { return "补件"; }
    },
    FIRST_VERIFY_SUCCESS {
        @Override
        public String toString() { return "等待二审"; }
    },
    FIRST_SEND_BACK {
        @Override
        public String toString() { return "一审退回"; }
    },
    FIRST_VERIFY_REJECT {
        @Override
        public String toString() { return "一审退件"; }
    },
    SECOND_SEND_BACK {
        @Override
        public String toString() { return "二审退回"; }
    },
    SECOND_VERIFY_REJECT {
        @Override
        public String toString() { return "二审退件";  }
    },
    VERIFY_REJECT {
        @Override
        public String toString() { return "退件";  }
    },
    VERIFY_SUCCESS {
        @Override
        public String toString() { return "审核通过"; }
    };

    @Override
    public abstract String toString();
}
