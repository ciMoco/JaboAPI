package com.ynjabo77.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ynjabo77.jaboapiclientsdk.model.entity.InterfaceInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 接口信息数据库操作
 */
public interface InterfaceInfoMapper extends BaseMapper<InterfaceInfo> {

    InterfaceInfo getApiUrl(@Param("apiUrl") String apiUrl, @Param("method") String method);
}



