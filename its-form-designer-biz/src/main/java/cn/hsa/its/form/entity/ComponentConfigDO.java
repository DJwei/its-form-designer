package cn.hsa.its.form.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <h3>组件配置DO</h3>
 * Class Name: ComponentConfigDO
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-30 17:11
 * @version 1.0.0
 */
@TableName(value="comt_cfg_b")
@Data
public class ComponentConfigDO implements Serializable {

	/*** 序列化ID*/
	private static final long serialVersionUID = 4752529132238755825L;

	/*** 唯一记录号*/
	private String  rid;

	/*** 组件ID*/
	@TableId(value="comt_id",type=IdType.INPUT)
	private String  comtId;

	/*** 组件字段序号*/
	private String  fldSn;

	/*** 组件字段名称*/
	private String  comtFldName;

	/*** 组件字段代码*/
	private String  comtFldCode;

	/*** 组件描述*/
	private String  comtDscr;

	/*** 组件提示*/
	private String  comtWarn;

	/*** 组件类型 1 input 2 下拉框 3 textarea 4 单选 5 多选*/
	private String  comtType;

	/*** 标签占用列数*/
	private BigDecimal lablOccpCol;

	/*** 组件占用列数*/
	private BigDecimal comtOccpCol;

	/*** 数据类型 1 str 2 num 31 date 32 datetime 33 time*/
	private String  dataType;

	/*** 数据来源*/
	private String  dataSouc;

	/*** 数据来源URL*/
	private String  dataSoucUrl;

	/*** 必填标志*/
	private String  mustlFlag;

	/*** 只读标志*/
	private String  readoFlag;

	/*** 禁用标志*/
	private String  dsabFlag;

	/*** 后缀名称*/
	private String  sufxName;

	/*** 搜索标志*/
	private String  srchFlag;

	/*** 字段数值集合,[{label:"label1",value:"value1"},{label:"label2",value:"value2"}]*/
	private String  fldvalSets;

	/*** 长度*/
	private BigDecimal leng;

	/*** 最大值*/
	private BigDecimal maxVal;

	/*** 最小值*/
	private BigDecimal minVal;

	/*** 正则表达式*/
	private String reglExpr;

	/*** 系统编号*/
	private String  sysNo;

	/*** 模板标志，0-不是模板；1-是模板*/
	private String  tmplFlag;

	/*** 占位字符*/
	private String placeholder;

	/*** 开始占位字符*/
	private String startPlaceholder;

	/*** 结束占位字符*/
	private String endPlaceholder;

	/*** 有效标志*/
	private String  valiFlag;

	/*** 所属医保区划*/
	private String  insuAdmdvs;

	/*** 医保区划*/
	private String  admdvs;

	/*** 统筹区编号*/
	private String  poolareaNo;

	/*** 创建人ID*/
	private String  crterId;

	/*** 创建人姓名*/
	private String  crterName;

	/*** 创建机构编号*/
	private String  crteOptinsNo;

	/*** 创建时间*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private  Date crteTime;

	/*** 经办人ID*/
	private String  opterId;

	/*** 经办人姓名*/
	private String  opterName;

	/*** 经办机构编号*/
	private String  optinsNo;

	/*** 经办时间*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private  Date optTime;

	/*** 更新时间*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private  Date updtTime;

}
