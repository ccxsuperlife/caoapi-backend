package com.cao.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cao.api.common.ErrorCode;
import com.cao.api.exception.BusinessException;
import com.cao.api.mapper.InterfaceInfoMapper;
import com.cao.api.model.entity.InterfaceInfo;
import com.cao.api.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author caodaxian
 * @description 针对表【interface_info(接口信息)】的数据库操作Service实现
 * @createDate 2025-01-09 10:30:35
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //接口名称
        String name = interfaceInfo.getName();
        //创建时
        if (add) {
            if (StringUtils.isBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口名称不存在");
            }
        }

        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口名称过长");
        }


    }
}




