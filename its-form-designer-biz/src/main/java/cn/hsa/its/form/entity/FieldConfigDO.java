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
 * <h3>字段配置DO</h3>
 * Class Name: FieldConfigDO
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-30 17:04
 * @version 1.0.0
 */

@Data
@TableName(value = "fld_cfg_b")
public class FieldConfigDO implements Serializable {

    private static final long serialVersionUID = 7816355671313423108L;

    /*** 唯一记录号*/
    private String  rid;

    /*** 字段ID*/
    @TableId(value="fld_id",type= IdType.INPUT)
    private String  fldId;

    /*** 字段代码*/
    private String  fldCode;

    /*** 字段名称*/
    private String  fldName;

    /*** 系统编号*/
    private String  sysNo;

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
