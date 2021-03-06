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
@TableName("t_claims_transfer")
public class ClaimsTransferEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(name = "cId",value = "主键")
	private Integer cId;
	/**
	 * 债权id
	 */
	@ApiModelProperty(name = "cClaimsId",value = "债权id")
	private Integer cClaimsId;
	/**
	 * 转让流水号
	 */
	@ApiModelProperty(name = "cTransferSerialNo",value = "转让流水号")
	private String cTransferSerialNo;
	/**
	 * 债权持有人
	 */
	@ApiModelProperty(name = "cUserId",value = "债权持有人")
	private Integer cUserId;
	/**
	 * 债权类型 :新借款 129,到期赎回 130,期限内回款 131
	 */
	@ApiModelProperty(name = "cClaimsType",value = "债权类型 :新借款 129,到期赎回 130,期限内回款 131")
	private String cClaimsType;
	/**
	 * 转让时间
	 */
	@ApiModelProperty(name = "cTransferDate",value = "转让时间")
	private Date cTransferDate;
	/**
	 *  债权权重
	 */
	@ApiModelProperty(name = "cClaimsWeight",value = " 债权权重")
	private Integer cClaimsWeight;
	/**
	 * 债权金额
	 */
	@ApiModelProperty(name = "cTransferMoney",value = "债权金额")
	private BigDecimal cTransferMoney;
	/**
	 * 审核状态
	 */
	@ApiModelProperty(name = "cAuditStatus",value = "审核状态")
	private String cAuditStatus;
	/**
	 * 是否锁定:11404,锁定中(匹配中);11403,未锁定(未匹配)
	 */
	@ApiModelProperty(name = "cIsLocked",value = "是否锁定:11404,锁定中(匹配中);11403,未锁定(未匹配)")
	private String cIsLocked;

}
