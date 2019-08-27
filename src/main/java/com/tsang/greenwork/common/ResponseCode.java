package com.tsang.greenwork.common;

/**
 * Created by Lzbin、lantian on 2017/11/2.
 *
 * @version 1.0
 * @PACKAGE_NAME cn.lantian.ssm.common
 * @Dercripton
 * @Time 下午2:15
 */
public enum ResponseCode {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
