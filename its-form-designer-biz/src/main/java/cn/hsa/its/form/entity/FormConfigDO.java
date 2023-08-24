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
 * <h3>表单配置DO</h3>
 * Class Name: FormConfigDO
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-30 17:28
 * @version 1.0.0
 */
@TableName(value="form_cfg_b")
@Data
public class FormConfigDO implements Serializable {

    /*** 序列化ID*/
    private static final long serialVersionUID = 7925788227475048L;

    /*** 唯一记录号*/
    private String  rid;

    /*** 表单ID*/
    @TableId(value="form_id",type= IdType.INPUT)
    private String  formId;

    /*** 表单代码*/
    private String  formCode;

    /*** 表单名称*/
    private String  formName;

    /*** 表单描述*/
    private String  formDesc;

    /*** 表单列数*/
    private BigDecimal formCol;

    /*** 标题宽度*/
    private BigDecimal ttlWid;

    /*** 模板标志，0-不是模板；1-是模板*/
    private String  tmplFlag;

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


    private String formGetInter;

    private String formSaveInter;

    private String formApplyInter;
}
