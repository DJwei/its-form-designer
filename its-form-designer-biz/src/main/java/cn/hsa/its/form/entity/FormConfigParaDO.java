package cn.hsa.its.form.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <h3>表单参数配置DO</h3>
 * Class Name: FormParaConfigDO
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-30 20:46
 * @version 1.0.0
 */
@Data
@TableName(value = "form_cfg_para_b")
public class FormConfigParaDO implements Serializable {

    private static final long serialVersionUID = 6743781737942886767L;

    /*** 唯一记录号*/
    private String  rid;

    /*** 参数ID*/
    @TableId(value="para_id",type= IdType.INPUT)
    private String  paraId;

    /*** 表单ID*/
    private String  formId;

    /*** 参数顺序号*/
    private Integer  paraSeq;

    /*** 参数名称*/
    private String  paraName;

    /*** 参数值*/
    private String  paraval;

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

}
