package com.cao.api.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cao.api.common.ErrorCode;
import com.cao.api.exception.BusinessException;
import com.cao.api.mapper.UserMapper;
import com.cao.caoapicommon.model.entity.User;
import com.cao.caoapicommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        // 参数校验
        if (StringUtils.isBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建查询构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accesskey", accessKey);

        // 使用 UserMapper 的selectOne 方法查询用户信息
        return userMapper.selectOne(queryWrapper);

    }
}
