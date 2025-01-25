package com.cao.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cao.api.common.ErrorCode;
import com.cao.api.exception.BusinessException;
import com.cao.api.mapper.UserInterfaceInfoMapper;
import com.cao.api.service.UserInterfaceInfoService;
import com.cao.caoapicommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author caodaxian
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
 * @createDate 2025-01-12 15:17:41
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    @Resource
    private TransactionTemplate transactionTemplate;

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //创建时
        if (add) {
            if (userInterfaceInfo.getId() <= 0 || userInterfaceInfo.getInterfaceInfoId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户或接口不存在");
            }
        }

        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余调用次数不能小于0");
        }

    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        //参数校验
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //防止用户瞬间调用大量接口次数，为了避免统计出错，加锁防止出现多个线程同时修改同一个数据，造成数据不一致的情况。
        //比方说，多个用户正在正常访问该接口，
        // 突然某个用户对该接口发起了100万次请求，可能会导致其他用户无法正常访问或者连接超时，我们要限制用户的访问频率。
        String lock = String.valueOf(userId).intern();
        synchronized (lock) {
            //开启事务，保证原子性，要么用户接口信息全部更新成功，要么全部更新失败回滚。
            Boolean execute = transactionTemplate.execute(status -> {
                //构造查询条件
                boolean result = this.lambdaUpdate().eq(UserInterfaceInfo::getInterfaceInfoId, interfaceInfoId)
                        .eq(UserInterfaceInfo::getUserId, userId)
                        .setSql("leftNum = leftNum - 1,totalNum = totalNum + 1")
                        .update();
                if (!result) {
                    throw new BusinessException(ErrorCode.OPERATION_ERROR, "接口统计失败");
                }
                return true;
            });
        }
        return true;
    }
}




