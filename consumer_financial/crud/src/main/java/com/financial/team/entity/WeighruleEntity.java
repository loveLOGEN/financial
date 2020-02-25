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
 * @date 2020-02-25 14:24:35
 */
@ApiModel
@Data
@TableName("t_weighrule")
public class WeighruleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(name = "tId",value = "主键")
	private Integer tId;
	/**
	 * 类别编号
	 */
	@ApiModelProperty(name = "tSerialno",value = "类别编号")
	private Integer tSerialno;
	/**
	 * 权重规则类型名称
	 */
	@ApiModelProperty(name = "tWeighruleName",value = "权重规则类型名称")
	private String tWeighruleName;
	/**
	 * 权重类别  资金类 140 债权类 140
	 */
	@ApiModelProperty(name = "tWeigthruleClass",value = "权重类别  资金类 140 债权类 140")
	private String tWeigthruleClass;
	/**
	 * 权重类型   
	 */
	@ApiModelProperty(name = "tWeigthType",value = "权重类型   ")
	private Integer tWeigthType;
	/**
	 * 权重值
	 */
	@ApiModelProperty(name = "tWeigthValue",value = "权重值")
	private String tWeigthValue;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "tOrder",value = "排序")
	private String tOrder;
	/**
	 * 权重类别名称
	 */
	@ApiModelProperty(name = "tWeigthruleClassname",value = "权重类别名称")
	private String tWeigthruleClassname;

}
