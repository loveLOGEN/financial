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
@TableName("t_product_account")
public class ProductAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(name = "pId",value = "主键")
	private Integer pId;
	/**
	 * 产品id
	 */
	@ApiModelProperty(name = "pProductId",value = "产品id")
	private Integer pProductId;
	/**
	 * 用户id
	 */
	@ApiModelProperty(name = "pUId",value = "用户id")
	private Integer pUId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "pSerialNo",value = "")
	private String pSerialNo;
	/**
	 * 加入日期
	 */
	@ApiModelProperty(name = "pBeginDate",value = "加入日期")
	private Date pBeginDate;
	/**
	 * 到期日期
	 */
	@ApiModelProperty(name = "pEndDate",value = "到期日期")
	private Date pEndDate;
	/**
	 * 赎回日期
	 */
	@ApiModelProperty(name = "pRedeemDate",value = "赎回日期")
	private Date pRedeemDate;
	/**
	 * 匹配日期
	 */
	@ApiModelProperty(name = "pMatchDate",value = "匹配日期")
	private Date pMatchDate;
	/**
	 * 金额
	 */
	@ApiModelProperty(name = "pAmount",value = "金额")
	private BigDecimal pAmount;
	/**
	 * 系统时间
	 */
	@ApiModelProperty(name = "pDate",value = "系统时间")
	private Date pDate;
	/**
	 * 产品类型
	 */
	@ApiModelProperty(name = "pProType",value = "产品类型")
	private String pProType;
	/**
	 * 收益率类型
	 */
	@ApiModelProperty(name = "pEarningsType",value = "收益率类型")
	private String pEarningsType;
	/**
	 * 收益率
	 */
	@ApiModelProperty(name = "pEarnings",value = "收益率")
	private String pEarnings;
	/**
	 * 提前赎回利率
	 */
	@ApiModelProperty(name = "pAdvRedemption",value = "提前赎回利率")
	private String pAdvRedemption;
	/**
	 * 选择期限
	 */
	@ApiModelProperty(name = "pDeadline",value = "选择期限")
	private String pDeadline;
	/**
	 * 当前期（账户资金日志表）
	 */
	@ApiModelProperty(name = "aCurrentPeriod",value = "当前期（账户资金日志表）")
	private String aCurrentPeriod;
	/**
	 * 预期收益
	 */
	@ApiModelProperty(name = "pProEarnings",value = "预期收益")
	private BigDecimal pProEarnings;
	/**
	 * 预期年化收益
	 */
	@ApiModelProperty(name = "pExpAnnualIncome",value = "预期年化收益")
	private BigDecimal pExpAnnualIncome;
	/**
	 * 每月盈取利息
	 */
	@ApiModelProperty(name = "pMonthInterest",value = "每月盈取利息")
	private BigDecimal pMonthInterest;
	/**
	 * 每月提取利息
	 */
	@ApiModelProperty(name = "pMonthlyExtInterest",value = "每月提取利息")
	private BigDecimal pMonthlyExtInterest;
	/**
	 * 开始计息时间
	 */
	@ApiModelProperty(name = "pInterestStartDate",value = "开始计息时间")
	private Date pInterestStartDate;
	/**
	 * 结束计息时间
	 */
	@ApiModelProperty(name = "pInterestEndDate",value = "结束计息时间")
	private Date pInterestEndDate;
	/**
	 * 收益是否完成
	 */
	@ApiModelProperty(name = "pEarIsFinished",value = "收益是否完成")
	private String pEarIsFinished;
	/**
	 * 可用余额
	 */
	@ApiModelProperty(name = "pAvaBal",value = "可用余额")
	private BigDecimal pAvaBal;
	/**
	 * 冻结金额
	 */
	@ApiModelProperty(name = "pFrozenMoney",value = "冻结金额")
	private BigDecimal pFrozenMoney;
	/**
	 * 每月回款日
	 */
	@ApiModelProperty(name = "pSysPayDate",value = "每月回款日")
	private Date pSysPayDate;
	/**
	 * 当前期（用户购买产品记录表）
	 */
	@ApiModelProperty(name = "pCurrentMonth",value = "当前期（用户购买产品记录表）")
	private String pCurrentMonth;
	/**
	 * 扣去利息
	 */
	@ApiModelProperty(name = "pDeductInterest",value = "扣去利息")
	private BigDecimal pDeductInterest;
	/**
	 * 未投资金额
	 */
	@ApiModelProperty(name = "pNotInvMon",value = "未投资金额")
	private BigDecimal pNotInvMon;
	/**
	 * 状态
	 */
	@ApiModelProperty(name = "pStatus",value = "状态")
	private String pStatus;
	/**
	 * 到期应回总本息
	 */
	@ApiModelProperty(name = "pEndInvTotMon",value = "到期应回总本息")
	private BigDecimal pEndInvTotMon;
	/**
	 * 当前期实回总本息
	 */
	@ApiModelProperty(name = "pCurRealTotMon",value = "当前期实回总本息")
	private BigDecimal pCurRealTotMon;
	/**
	 * 统计
	 */
	@ApiModelProperty(name = "pDeadlineCount",value = "统计")
	private Integer pDeadlineCount;
	/**
	 * 产品名称
	 */
	@ApiModelProperty(name = "pProductName",value = "产品名称")
	private String pProductName;
	/**
	 * 月存
	 */
	@ApiModelProperty(name = "pMonthlyDeposit",value = "月存")
	private BigDecimal pMonthlyDeposit;
	/**
	 * 月存笔数
	 */
	@ApiModelProperty(name = "pMonthlyDepositCount",value = "月存笔数")
	private Integer pMonthlyDepositCount;
	/**
	 * 月乘
	 */
	@ApiModelProperty(name = "pTakeMonth",value = "月乘")
	private BigDecimal pTakeMonth;
	/**
	 * 月乘笔数
	 */
	@ApiModelProperty(name = "pTakeMonthCount",value = "月乘笔数")
	private Integer pTakeMonthCount;
	/**
	 * 月取
	 */
	@ApiModelProperty(name = "pMayTake",value = "月取")
	private BigDecimal pMayTake;
	/**
	 * 月取笔数
	 */
	@ApiModelProperty(name = "pMayTakeCount",value = "月取笔数")
	private Integer pMayTakeCount;
	/**
	 * 总天数
	 */
	@ApiModelProperty(name = "pTotalAsDay",value = "总天数")
	private Integer pTotalAsDay;
	/**
	 * 投资天数
	 */
	@ApiModelProperty(name = "pDeadlineAsDay",value = "投资天数")
	private Integer pDeadlineAsDay;
	/**
	 * 
	 */
	@ApiModelProperty(name = "pDays",value = "")
	private Integer pDays;
	/**
	 * 投资期限
	 */
	@ApiModelProperty(name = "pDeadlines",value = "投资期限")
	private Integer pDeadlines;
	/**
	 * 投资用户名
	 */
	@ApiModelProperty(name = "uUserName",value = "投资用户名")
	private String uUserName;
	/**
	 * 已赚取利息
	 */
	@ApiModelProperty(name = "pEarnedInter",value = "已赚取利息")
	private BigDecimal pEarnedInter;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "pRemark",value = "备注")
	private String pRemark;
	/**
	 * SUM(可用余额+冻结金额)
	 */
	@ApiModelProperty(name = "sumAvabalFrozenmoney",value = "SUM(可用余额+冻结金额)")
	private BigDecimal sumAvabalFrozenmoney;
	/**
	 * 总计
	 */
	@ApiModelProperty(name = "pTotal",value = "总计")
	private BigDecimal pTotal;

}
