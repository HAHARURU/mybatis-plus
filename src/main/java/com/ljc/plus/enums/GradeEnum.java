package com.ljc.plus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author liujiangchun
 * @date 2020-07-02
 */
public enum GradeEnum {

    PRIMARY(1, "小学"),
    MIDDLE(2, "中学"),
    HIGH(3, "高中");

    GradeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @EnumValue//标记数据库存的值是code
    private final int code;

    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
