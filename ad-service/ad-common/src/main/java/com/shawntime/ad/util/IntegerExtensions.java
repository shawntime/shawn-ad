package com.shawntime.ad.util;

public final class IntegerExtensions {

    private static final int DEFAULT_VALUE = 0;

    private IntegerExtensions() {
        // private constructor
    }

    public static boolean isMoreThanZero(Integer integer) {
        return integer != null && integer.intValue() > 0 ? true : false;
    }

    public static int getIntValue(Integer integer, int defaultValue) {
        if (integer == null) {
            return defaultValue;
        } else {
            return integer.intValue();
        }
    }

    public static int getDefaultZeroValue(Integer integer) {
        return getIntValue(integer, DEFAULT_VALUE);
    }

    public static boolean equals(Integer value1, Integer value2) {
        return getIntValue(value1, DEFAULT_VALUE) == getIntValue(value2, DEFAULT_VALUE);
    }
}
