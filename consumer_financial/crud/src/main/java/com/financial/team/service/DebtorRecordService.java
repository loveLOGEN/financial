package com.financial.team.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.financial.team.entity.DebtorRecordEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 
 *
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:35
 */
public interface DebtorRecordService extends IService<DebtorRecordEntity> {

    PageVo queryPage(QueryCondition params);
}

