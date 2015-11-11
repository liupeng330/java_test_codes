package com.heika.test.common;

public enum VerifyUserInvestigateResultEnum
{
    VALID {
        public String toString() {
            return "调查通过";
        }
    },
    PENDING {
        public String toString() {
            return "未调查";
        }
    },
    NOTMATCH {
        public String toString() {
            return "调查不符";
        }
    },
    NOTVERIFY {
        public String toString() {
            return "无法核实";
        }
    };

    private VerifyUserInvestigateResultEnum() {
    }

    public abstract String toString();
}
