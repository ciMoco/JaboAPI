package com.ynjabo77.jaboapicommon.service;

import com.ynjabo77.jaboapicommon.model.entity.User;

/**
 * 用户服务
 */
public interface InnerUserService {
    /**
     * 数据库中查是否已分配给用户密钥（accessKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
