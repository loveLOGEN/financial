package com.financial.team.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.financial.team.dao.ProductearngrateDao;
import com.financial.team.entity.ProductearngrateEntity;
import com.financial.team.service.ProductearngrateService;


@Service("productearngrateService")
public class ProductearngrateServiceImpl extends ServiceImpl<ProductearngrateDao, ProductearngrateEntity> implements ProductearngrateService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<ProductearngrateEntity> page = this.page(
                new Query<ProductearngrateEntity>().getPage(params),
                new QueryWrapper<ProductearngrateEntity>()
        );

        return new PageVo(page);
    }

}