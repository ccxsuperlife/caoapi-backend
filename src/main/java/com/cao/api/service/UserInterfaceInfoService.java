package com.cao.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cao.caoapicommon.model.entity.UserInterfaceInfo;

/**
 * @author caodaxian
 * @description 针对表【interface_info(接口信息)】的数据库操作Service
 * @createDate 2025-01-09 10:30:35
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    boolean invokeCount(long interfaceInfoId, long userId);
}
