package com.ynjabo77.project.service.impl.inner;

import com.ynjabo77.jaboapiclientsdk.common.ErrorCode;
import com.ynjabo77.jaboapiclientsdk.exception.BusinessException;
import com.ynjabo77.jaboapiclientsdk.model.entity.InterfaceInfo;
import com.ynjabo77.jaboapiclientsdk.service.InnerInterfaceInfoService;
import com.ynjabo77.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return interfaceInfoMapper.getApiUrl(url, method);
    }
}
