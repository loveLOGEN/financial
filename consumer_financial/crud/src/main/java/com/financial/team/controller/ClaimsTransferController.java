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

import com.financial.team.entity.ClaimsTransferEntity;
import com.financial.team.service.ClaimsTransferService;




/**
 * 
 *
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:35
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("team/claimstransfer")
public class ClaimsTransferController {
    @Autowired
    private ClaimsTransferService claimsTransferService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('team:claimstransfer:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = claimsTransferService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{cId}")
    @PreAuthorize("hasAuthority('team:claimstransfer:info')")
    public Resp<ClaimsTransferEntity> info(@PathVariable("cId") Integer cId){
		ClaimsTransferEntity claimsTransfer = claimsTransferService.getById(cId);

        return Resp.ok(claimsTransfer);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('team:claimstransfer:save')")
    public Resp<Object> save(@RequestBody ClaimsTransferEntity claimsTransfer){
		claimsTransferService.save(claimsTransfer);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('team:claimstransfer:update')")
    public Resp<Object> update(@RequestBody ClaimsTransferEntity claimsTransfer){
		claimsTransferService.updateById(claimsTransfer);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('team:claimstransfer:delete')")
    public Resp<Object> delete(@RequestBody Integer[] cIds){
		claimsTransferService.removeByIds(Arrays.asList(cIds));

        return Resp.ok(null);
    }

}
