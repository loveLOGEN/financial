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
 * @date 2020-02-25 14:24:35
 */
@ApiModel
@Data
@TableName("t_account_log")
public class AccountLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(name = "aId",value = "主键")
	private Integer aId;
	/**
	 * 用户id
	 */
	@ApiModelProperty(name = "aUserId",value = "用户id")
	private Integer aUserId;
	/**
	 * 主账户id
	 */
	@ApiModelProperty(name = "aMainAccountId",value = "主账户id")
	private Integer aMainAccountId;
	/**
	 * 投资记录主键
	 */
	@ApiModelProperty(name = "pId",value = "投资记录主键")
	private Integer pId;
	/**
	 * 当前期
	 */
	@ApiModelProperty(name = "aCurrentPeriod",value = "当前期")
	private String aCurrentPeriod;
	/**
	 * 收付
	 */
	@ApiModelProperty(name = "aReceiveOrPay",value = "收付")
	private String aReceiveOrPay;
	/**
	 * 交易流水号
	 */
	@ApiModelProperty(name = "aTransferSerialNo",value = "交易流水号")
	private Integer aTransferSerialNo;
	/**
	 * 交易时间
	 */
	@ApiModelProperty(name = "aDate",value = "交易时间")
	private Date aDate;
	/**
	 * 交易类型 
	 */
	@ApiModelProperty(name = "aType",value = "交易类型 ")
	private Integer aType;
	/**
	 * 交易状态
	 */
	@ApiModelProperty(name = "aTransferStatus",value = "交易状态")
	private String aTransferStatus;
	/**
	 * 交易前金额
	 */
	@ApiModelProperty(name = "aBeforeTradingMoney",value = "交易前金额")
	private BigDecimal aBeforeTradingMoney;
	/**
	 * 金额
	 */
	@ApiModelProperty(name = "aAmount",value = "金额")
	private BigDecimal aAmount;
	/**
	 * 交易后金额
	 */
	@ApiModelProperty(name = "aAfterTradingMoney",value = "交易后金额")
	private BigDecimal aAfterTradingMoney;
	/**
	 * 交易详情
	 */
	@ApiModelProperty(name = "aDescreption",value = "交易详情")
	private String aDescreption;

}