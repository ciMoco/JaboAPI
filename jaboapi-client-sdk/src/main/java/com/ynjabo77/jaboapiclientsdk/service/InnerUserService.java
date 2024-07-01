package com.ynjabo77.jaboapiclientsdk.service;

import com.ynjabo77.jaboapiclientsdk.model.entity.User;

/**
 * 用户服务
 */
public interface InnerUserService {
    /**
     * 数据库中查是否已分配给用户密钥
     *
     * @param accessKey 密钥
     * @return
     */
    User getInvokeUser(String accessKey);
}
