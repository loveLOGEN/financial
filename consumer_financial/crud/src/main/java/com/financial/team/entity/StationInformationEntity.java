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
@TableName("t_station_information")
public class StationInformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(name = "sId",value = "主键")
	private Integer sId;
	/**
	 * 消息状态
	 */
	@ApiModelProperty(name = "sMessageState",value = "消息状态")
	private String sMessageState;
	/**
	 * 消息内容
	 */
	@ApiModelProperty(name = "sMessageContent",value = "消息内容")
	private String sMessageContent;
	/**
	 * 发送时间
	 */
	@ApiModelProperty(name = "sSystemTime",value = "发送时间")
	private Date sSystemTime;
	/**
	 * 发送类型
	 */
	@ApiModelProperty(name = "sInformationType",value = "发送类型")
	private String sInformationType;
	/**
	 * 用户id
	 */
	@ApiModelProperty(name = "sReceiveUserId",value = "用户id")
	private Integer sReceiveUserId;

}
