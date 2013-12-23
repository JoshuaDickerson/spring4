package com.springapp4.mvc.model;

/**
 * Created by josh on 12/22/13.
 */
public class Constants {
    public static enum JSON_TYPE {
        ARRAY, OBJECT, INVALID, PRIMITIVE, NULL;
    }

    public static enum METRIC_VALUE_TYPE{
        QUANT(0),
        BOOL(1),
        STAR(2),
        CAT(3);

         METRIC_VALUE_TYPE(int i) {

         }
    }
}
