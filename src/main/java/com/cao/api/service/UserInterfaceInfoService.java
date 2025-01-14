package com.cao.api.service;

import com.cao.api.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author caodaxian
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
 * @createDate 2025-01-12 15:17:41
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 参数校验
     *
     * @param userInterfaceInfo
     * @param add
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     *
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
