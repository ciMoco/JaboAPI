package com.ynjabo77.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ynjabo77.jaboapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author ynjabo77
* @description 针对表【user_interface_info(调用接口关系表)】的数据库操作Mapper
* @createDate 2024-06-02 14:37:57
* @Entity com.ynjabo77.project.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




