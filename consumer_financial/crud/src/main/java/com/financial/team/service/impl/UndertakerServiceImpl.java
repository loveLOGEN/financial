package com.financial.team.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.financial.team.dao.UndertakerDao;
import com.financial.team.entity.UndertakerEntity;
import com.financial.team.service.UndertakerService;


@Service("undertakerService")
public class UndertakerServiceImpl extends ServiceImpl<UndertakerDao, UndertakerEntity> implements UndertakerService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<UndertakerEntity> page = this.page(
                new Query<UndertakerEntity>().getPage(params),
                new QueryWrapper<UndertakerEntity>()
        );

        return new PageVo(page);
    }

}