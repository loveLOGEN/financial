package com.financial.team.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.financial.team.entity.ProductearngrateEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 
 *
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:34
 */
public interface ProductearngrateService extends IService<ProductearngrateEntity> {

    PageVo queryPage(QueryCondition params);
}

