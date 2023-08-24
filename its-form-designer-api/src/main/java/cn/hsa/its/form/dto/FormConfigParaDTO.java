package cn.hsa.its.form.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <h3>表单参数配置DTO</h3>
 * Class Name: FormParaConfigDTO
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-30 20:32
 * @version 1.0.0
 */
@Data
public class FormConfigParaDTO extends BaseDTO implements Serializable {

    public static final String KEY_ID="ITS:FORM:FORM_PARA_CFG_B:PARA_ID";
    private static final long serialVersionUID = -9089429218304677504L;

    /*** 唯一记录号*/
    @ApiModelProperty("唯一记录号")
    private String rid;

    /*** 参数ID*/
    @ApiModelProperty("参数ID")
    private String paraId;

    /*** 表单ID*/
    @ApiModelProperty("表单ID")
    private String formId;

    /*** 参数顺序号*/
    @ApiModelProperty("参数顺序号")
    private Integer paraSeq;

    /*** 参数名称*/
    @ApiModelProperty("参数名称")
    private String paraName;

    /*** 参数值*/
    @ApiModelProperty("参数值")
    private String paraval;

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

}
