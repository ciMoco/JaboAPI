package com.ynjabo77.project.model.enums;

import lombok.Getter;

/**
 * 接口信息状态枚举
 */
@Getter
public enum InterfaceInfoStatusEnum {

    OFFLINE("关闭", 0),
    ONLINE("上线", 1);

    private final String text;

    private final int value;

    InterfaceInfoStatusEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }
}
