package com.financial.team.controller;

import java.util.Arrays;


import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;
import com.atguigu.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.financial.team.entity.AccountEntity;
import com.financial.team.service.AccountService;




/**
 * 
 *
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:34
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("team/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('team:account:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = accountService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{tId}")
    @PreAuthorize("hasAuthority('team:account:info')")
    public Resp<AccountEntity> info(@PathVariable("tId") Integer tId){
		AccountEntity account = accountService.getById(tId);

        return Resp.ok(account);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('team:account:save')")
    public Resp<Object> save(@RequestBody AccountEntity account){
		accountService.save(account);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('team:account:update')")
    public Resp<Object> update(@RequestBody AccountEntity account){
		accountService.updateById(account);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('team:account:delete')")
    public Resp<Object> delete(@RequestBody Integer[] tIds){
		accountService.removeByIds(Arrays.asList(tIds));

        return Resp.ok(null);
    }

}
