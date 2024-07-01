package com.ynjabo77.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ynjabo77.jaboapiclientsdk.common.ErrorCode;
import com.ynjabo77.jaboapiclientsdk.exception.BusinessException;
import com.ynjabo77.jaboapiclientsdk.model.entity.User;
import com.ynjabo77.jaboapiclientsdk.model.entity.UserInterfaceInfo;
import com.ynjabo77.project.mapper.UserMapper;
import com.ynjabo77.project.service.UserInterfaceInfoService;
import com.ynjabo77.project.mapper.UserInterfaceInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户调用接口关系数据库操作Service实现
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 校验
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("userId", userId);
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.setSql("totalNum = totalNum + 1");
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", userId);
        wrapper.setSql("leftNum = leftNum - 1");
        userMapper.update(new User(), wrapper);
        return this.update(updateWrapper);
    }

    @Override
    public boolean invokeResidueCount(long userId) {
        if (userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在");
        }
        User user = userMapper.selectById(userId);
        return user.getLeftNum() > 0;
    }

    @Override
    public boolean addUserInvokeInterface(long userId, long interfaceInfoId) {
        if (userId <= 0 || interfaceInfoId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
        }
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("interfaceInfoId", interfaceInfoId);
        UserInterfaceInfo one = this.getOne(queryWrapper);
        if (one != null) {
            return false;
        }
        UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
        userInterfaceInfo.setUserId(userId);
        userInterfaceInfo.setInterfaceInfoId(interfaceInfoId);
        boolean save = this.save(userInterfaceInfo);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "添加用户接口信息失败");
        }
        return true;
    }
}




