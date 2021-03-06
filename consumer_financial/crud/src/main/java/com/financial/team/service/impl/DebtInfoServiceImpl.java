package com.financial.team.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.financial.team.dao.DebtInfoDao;
import com.financial.team.entity.DebtInfoEntity;
import com.financial.team.service.DebtInfoService;


@Service("debtInfoService")
public class DebtInfoServiceImpl extends ServiceImpl<DebtInfoDao, DebtInfoEntity> implements DebtInfoService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<DebtInfoEntity> page = this.page(
                new Query<DebtInfoEntity>().getPage(params),
                new QueryWrapper<DebtInfoEntity>()
        );

        return new PageVo(page);
    }

}