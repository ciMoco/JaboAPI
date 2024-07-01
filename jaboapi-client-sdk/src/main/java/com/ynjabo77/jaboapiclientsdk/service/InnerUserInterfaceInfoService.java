package com.ynjabo77.jaboapiclientsdk.service;

public interface InnerUserInterfaceInfoService {
    /**
     * 调用接口统计
     *
     * @param interfaceInfoId 接口id
     * @param userId          用户id
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 剩余调用次数
     *
     * @param userId
     * @return
     */
    boolean invokeResidueCount(long userId);
}
