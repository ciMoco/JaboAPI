package com.ynjabo77.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ynjabo77.jaboapicommon.model.entity.UserInterfaceInfo;

/**
 * @author ynjabo77
 * @description 针对表【user_interface_info(调用接口关系表)】的数据库操作Service
 * @createDate 2024-06-02 14:37:57
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
