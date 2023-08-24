package cn.hsa.its.form.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <h3>字段配置参数DTO</h3>
 * Class Name: FieldConfigParamDTO
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-18 10:08
 * @version 1.0.0
 */

@Data
public class FieldConfigParamDTO extends BaseDTO implements Serializable {
    /*** 序列化ID*/
    private static final long serialVersionUID = 3266756845749612749L;

    /*** 字段ID*/
    @ApiModelProperty("字段ID")
    private String fldId;

    /*** 字段代码*/
    @ApiModelProperty("字段代码")
    private String fldCode;

    /*** 字段名称*/
    @ApiModelProperty("字段名称")
    private String fldName;

    /*** 系统编号*/
    @ApiModelProperty("系统编号")
    private String sysNo;

    /*** 有效标志*/
    @ApiModelProperty("有效标志")
    private String valiFlag;

    /*** 所属医保区划*/
    @ApiModelProperty("所属医保区划")
    private String insuAdmdvs;

    /*** 医保区划*/
    @ApiModelProperty("医保区划")
    private String admdvs;

    /*** 统筹区编号*/
    @ApiModelProperty("统筹区编号")
    private String poolareaNo;

    /*** 创建人ID*/
    @ApiModelProperty("创建人ID")
    private String crterId;

    /*** 创建人姓名*/
    @ApiModelProperty("创建人姓名")
    private String crterName;

    /*** 创建机构编号*/
    @ApiModelProperty("创建机构编号")
    private String crteOptinsNo;

    /*** 创建时间*/
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date crteTime;

    /*** 经办人ID*/
    @ApiModelProperty("经办人ID")
    private String opterId;

    /*** 经办人姓名*/
    @ApiModelProperty("经办人姓名")
    private String opterName;

    /*** 经办机构编号*/
    @ApiModelProperty("经办机构编号")
    private String optinsNo;

    /*** 经办时间*/
    @ApiModelProperty("经办时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date optTime;

    /*** 更新时间*/
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date updtTime;
}
