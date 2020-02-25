package com.financial.team.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.financial.team.entity.StationInformationEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 
 *
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:34
 */
public interface StationInformationService extends IService<StationInformationEntity> {

    PageVo queryPage(QueryCondition params);
}

