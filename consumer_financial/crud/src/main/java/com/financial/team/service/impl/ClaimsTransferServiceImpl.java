package com.financial.team.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.financial.team.dao.ClaimsTransferDao;
import com.financial.team.entity.ClaimsTransferEntity;
import com.financial.team.service.ClaimsTransferService;


@Service("claimsTransferService")
public class ClaimsTransferServiceImpl extends ServiceImpl<ClaimsTransferDao, ClaimsTransferEntity> implements ClaimsTransferService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<ClaimsTransferEntity> page = this.page(
                new Query<ClaimsTransferEntity>().getPage(params),
                new QueryWrapper<ClaimsTransferEntity>()
        );

        return new PageVo(page);
    }

}