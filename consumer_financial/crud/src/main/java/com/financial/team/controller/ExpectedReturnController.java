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

import com.financial.team.entity.ExpectedReturnEntity;
import com.financial.team.service.ExpectedReturnService;




/**
 * 
 *
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:34
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("team/expectedreturn")
public class ExpectedReturnController {
    @Autowired
    private ExpectedReturnService expectedReturnService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('team:expectedreturn:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = expectedReturnService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{tId}")
    @PreAuthorize("hasAuthority('team:expectedreturn:info')")
    public Resp<ExpectedReturnEntity> info(@PathVariable("tId") Integer tId){
		ExpectedReturnEntity expectedReturn = expectedReturnService.getById(tId);

        return Resp.ok(expectedReturn);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('team:expectedreturn:save')")
    public Resp<Object> save(@RequestBody ExpectedReturnEntity expectedReturn){
		expectedReturnService.save(expectedReturn);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('team:expectedreturn:update')")
    public Resp<Object> update(@RequestBody ExpectedReturnEntity expectedReturn){
		expectedReturnService.updateById(expectedReturn);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('team:expectedreturn:delete')")
    public Resp<Object> delete(@RequestBody Integer[] tIds){
		expectedReturnService.removeByIds(Arrays.asList(tIds));

        return Resp.ok(null);
    }

}
