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

import com.financial.team.entity.AccountLogEntity;
import com.financial.team.service.AccountLogService;




/**
 * 
 *
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:35
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("team/accountlog")
public class AccountLogController {
    @Autowired
    private AccountLogService accountLogService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('team:accountlog:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = accountLogService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{aId}")
    @PreAuthorize("hasAuthority('team:accountlog:info')")
    public Resp<AccountLogEntity> info(@PathVariable("aId") Integer aId){
		AccountLogEntity accountLog = accountLogService.getById(aId);

        return Resp.ok(accountLog);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('team:accountlog:save')")
    public Resp<Object> save(@RequestBody AccountLogEntity accountLog){
		accountLogService.save(accountLog);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('team:accountlog:update')")
    public Resp<Object> update(@RequestBody AccountLogEntity accountLog){
		accountLogService.updateById(accountLog);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('team:accountlog:delete')")
    public Resp<Object> delete(@RequestBody Integer[] aIds){
		accountLogService.removeByIds(Arrays.asList(aIds));

        return Resp.ok(null);
    }

}
