package com.heika.test.common;

public enum MaterialType
{
    IDCARDFRONT
    {
        @Override
        public String toString() { return "IDCARDFRONT"; }
    },
    IDCARDBACK
    {
        @Override
        public String toString () { return "IDCARDFRONT"; }
    }
}
