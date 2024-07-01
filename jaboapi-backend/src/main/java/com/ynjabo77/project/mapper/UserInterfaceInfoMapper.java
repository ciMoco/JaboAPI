package com.ynjabo77.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ynjabo77.jaboapiclientsdk.model.entity.UserInterfaceInfo;

import java.util.List;

/**
 * 用户调用接口关系数据库操作
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> getTopInvokerInterfaceInfo(int limit);
}




