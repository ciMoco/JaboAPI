package com.ynjabo77.jaboapiclientsdk.service;

import com.ynjabo77.jaboapiclientsdk.model.entity.InterfaceInfo;

public interface InnerInterfaceInfoService {
    /**
     * 从数据库中查询模拟接口是否存在
     */
    InterfaceInfo getInterfaceInfo(String path, String method);
}
