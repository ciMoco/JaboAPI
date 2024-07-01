package com.ynjabo77.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ynjabo77.jaboapiclientsdk.model.entity.InterfaceInfo;

/**
 * 接口信息数据库操作Service
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
