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

import com.financial.team.entity.DebtInfoEntity;
import com.financial.team.service.DebtInfoService;




/**
 * 
 *
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:35
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("team/debtinfo")
public class DebtInfoController {
    @Autowired
    private DebtInfoService debtInfoService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('team:debtinfo:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = debtInfoService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{dId}")
    @PreAuthorize("hasAuthority('team:debtinfo:info')")
    public Resp<DebtInfoEntity> info(@PathVariable("dId") Integer dId){
		DebtInfoEntity debtInfo = debtInfoService.getById(dId);

        return Resp.ok(debtInfo);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('team:debtinfo:save')")
    public Resp<Object> save(@RequestBody DebtInfoEntity debtInfo){
		debtInfoService.save(debtInfo);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('team:debtinfo:update')")
    public Resp<Object> update(@RequestBody DebtInfoEntity debtInfo){
		debtInfoService.updateById(debtInfo);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('team:debtinfo:delete')")
    public Resp<Object> delete(@RequestBody Integer[] dIds){
		debtInfoService.removeByIds(Arrays.asList(dIds));

        return Resp.ok(null);
    }

}
