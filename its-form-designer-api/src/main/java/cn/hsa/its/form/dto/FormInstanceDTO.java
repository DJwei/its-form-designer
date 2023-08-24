package cn.hsa.its.form.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <h3>表单实例DTO</h3>
 * Class Name: FormInstanceDTO
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-30 20:18
 * @version 1.0.0
 */
@Data
public class FormInstanceDTO extends BaseDTO implements Serializable {

    public static final String KEY_ID="ITS:FORM:FORM_INST_B:FORM_INST_ID";

    private static final long serialVersionUID = 9202176912203325935L;

    /*** 唯一记录号*/
    @ApiModelProperty("唯一记录号")
    private String rid;

    /*** 表单实例ID*/
    @ApiModelProperty("表单实例ID")
    private String formInstId;

    /*** 业务ID*/
    @ApiModelProperty("业务ID")
    private String bizId;

    /*** 表单ID*/
    @ApiModelProperty("表单ID")
    private String formId;

    /*** 表单代码*/
    @ApiModelProperty("表单代码")
    private String formCode;

    /*** 表单名称*/
    @ApiModelProperty("表单名称")
    private String formName;

    /*** 表单内容*/
    @ApiModelProperty("表单实例内容")
    private String formInstanceContent;

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
