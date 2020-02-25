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

import com.financial.team.entity.ProductEntity;
import com.financial.team.service.ProductService;




/**
 * 
 *
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:34
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("team/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('team:product:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = productService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{tPid}")
    @PreAuthorize("hasAuthority('team:product:info')")
    public Resp<ProductEntity> info(@PathVariable("tPid") Integer tPid){
		ProductEntity product = productService.getById(tPid);

        return Resp.ok(product);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('team:product:save')")
    public Resp<Object> save(@RequestBody ProductEntity product){
		productService.save(product);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('team:product:update')")
    public Resp<Object> update(@RequestBody ProductEntity product){
		productService.updateById(product);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('team:product:delete')")
    public Resp<Object> delete(@RequestBody Integer[] tPids){
		productService.removeByIds(Arrays.asList(tPids));

        return Resp.ok(null);
    }

}
