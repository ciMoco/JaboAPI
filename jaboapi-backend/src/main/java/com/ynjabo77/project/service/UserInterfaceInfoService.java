package com.ynjabo77.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ynjabo77.jaboapiclientsdk.model.entity.UserInterfaceInfo;

/**
 * 用户调用接口关系数据库操作Service
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 统计接口调用次数
     *
     * @param interfaceInfoId 接口id
     * @param userId          用户id
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 剩余调用次数
     *
     * @param userId 用户id
     * @return
     */
    boolean invokeResidueCount(long userId);

    /**
     * 添加用户调用接口记录
     *
     * @param userId          用户id
     * @param interfaceInfoId 接口id
     * @return
     */
    boolean addUserInvokeInterface(long userId, long interfaceInfoId);
}
