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
@TableName("t_productearngrate")
public class ProductearngrateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	@ApiModelProperty(name = "tId",value = "编号")
	private Integer tId;
	/**
	 * 利率值
	 */
	@ApiModelProperty(name = "tIncomerate",value = "利率值")
	private Double tIncomerate;
	/**
	 * 月份
	 */
	@ApiModelProperty(name = "tMonth",value = "月份")
	private Date tMonth;
	/**
	 * 产品编号
	 */
	@ApiModelProperty(name = "tPid",value = "产品编号")
	private Integer tPid;

}
