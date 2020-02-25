package com.financial.team.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("t_bankcard")
public class BankcardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "tId",value = "")
	private Integer tId;
	/**
	 * 银行卡号长度18位
	 */
	@ApiModelProperty(name = "tNum",value = "银行卡号长度18位")
	private String tNum;
	/**
	 * 开户银行
	 */
	@ApiModelProperty(name = "tBank",value = "开户银行")
	private String tBank;
	/**
	 * 城市Id
	 */
	@ApiModelProperty(name = "tCityId",value = "城市Id")
	private Integer tCityId;
	/**
	 * 用户表主键
	 */
	@ApiModelProperty(name = "tUserId",value = "用户表主键")
	private Integer tUserId;
	/**
	 * 银行编号
	 */
	@ApiModelProperty(name = "tBankId",value = "银行编号")
	private Integer tBankId;
	/**
	 * 银行支行
	 */
	@ApiModelProperty(name = "tBankBranch",value = "银行支行")
	private String tBankBranch;
	/**
	 * 绑定手机号码
	 */
	@ApiModelProperty(name = "tPhoneNum",value = "绑定手机号码")
	private String tPhoneNum;

}
