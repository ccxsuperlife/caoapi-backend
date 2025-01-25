package com.cao.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cao.caoapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author caodaxian
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2025-01-12 15:17:41
* @Entity generator.domain.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    /**
     * -- 获取接口调用次数的统计信息，并按照调用总次数降序排列，最后取前三个接口作为结果
     * select interfaceInfoId, sum(totalNum) as totalNum
     * from user_interface_info
     * group by interfaceInfoId
     * order by totalNum desc
     * limit 3;
     */

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




