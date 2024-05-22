package com.ynjabo77.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ynjabo77.project.model.entity.InterfaceInfo;

/**
* @author ynjabo77
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-05-20 20:07:46
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
