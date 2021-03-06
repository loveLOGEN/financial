package com.financial.team.controller;

import java.util.Arrays;
import java.util.Map;


import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;
import com.atguigu.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.financial.team.entity.ProductearngrateEntity;
import com.financial.team.service.ProductearngrateService;




/**
 * 
 *
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:34
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("team/productearngrate")
public class ProductearngrateController {
    @Autowired
    private ProductearngrateService productearngrateService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('team:productearngrate:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = productearngrateService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{tId}")
    @PreAuthorize("hasAuthority('team:productearngrate:info')")
    public Resp<ProductearngrateEntity> info(@PathVariable("tId") Integer tId){
		ProductearngrateEntity productearngrate = productearngrateService.getById(tId);

        return Resp.ok(productearngrate);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('team:productearngrate:save')")
    public Resp<Object> save(@RequestBody ProductearngrateEntity productearngrate){
		productearngrateService.save(productearngrate);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('team:productearngrate:update')")
    public Resp<Object> update(@RequestBody ProductearngrateEntity productearngrate){
		productearngrateService.updateById(productearngrate);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('team:productearngrate:delete')")
    public Resp<Object> delete(@RequestBody Integer[] tIds){
		productearngrateService.removeByIds(Arrays.asList(tIds));

        return Resp.ok(null);
    }

}
