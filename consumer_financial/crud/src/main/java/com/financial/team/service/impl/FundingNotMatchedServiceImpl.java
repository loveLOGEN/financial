package com.financial.team.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.financial.team.dao.FundingNotMatchedDao;
import com.financial.team.entity.FundingNotMatchedEntity;
import com.financial.team.service.FundingNotMatchedService;


@Service("fundingNotMatchedService")
public class FundingNotMatchedServiceImpl extends ServiceImpl<FundingNotMatchedDao, FundingNotMatchedEntity> implements FundingNotMatchedService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<FundingNotMatchedEntity> page = this.page(
                new Query<FundingNotMatchedEntity>().getPage(params),
                new QueryWrapper<FundingNotMatchedEntity>()
        );

        return new PageVo(page);
    }

}