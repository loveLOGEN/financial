package com.financial.team.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author fanyudong
 * @email 1300141550@qq.com
 * @date 2020-02-25 14:24:34
 */
@ApiModel
@Data
@TableName("t_undertaker")
public class UndertakerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "tId",value = "")
	private Integer tId;
	/**
	 * 手续费
	 */
	@ApiModelProperty(name = "tCost",value = "手续费")
	private BigDecimal tCost;
	/**
	 * 承担者: 1 表示用户承担，0 表示平台承担
	 */
	@ApiModelProperty(name = "tUndertaker",value = "承担者: 1 表示用户承担，0 表示平台承担")
	private Integer tUndertaker;
	/**
	 * 0 充值; 1提现
	 */
	@ApiModelProperty(name = "tType",value = "0 充值; 1提现")
	private Integer tType;

}
