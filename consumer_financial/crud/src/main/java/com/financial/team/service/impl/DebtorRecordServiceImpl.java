package com.financial.team.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.financial.team.dao.DebtorRecordDao;
import com.financial.team.entity.DebtorRecordEntity;
import com.financial.team.service.DebtorRecordService;


@Service("debtorRecordService")
public class DebtorRecordServiceImpl extends ServiceImpl<DebtorRecordDao, DebtorRecordEntity> implements DebtorRecordService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<DebtorRecordEntity> page = this.page(
                new Query<DebtorRecordEntity>().getPage(params),
                new QueryWrapper<DebtorRecordEntity>()
        );

        return new PageVo(page);
    }

}