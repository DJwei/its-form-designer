package cn.hsa.its.form.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <h3>Description</h3>
 * Class Name: CodeTableDTO
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @version 1.0.0
 * @date 2021-12-02 9:27
 */
@Data
public class CodeTableDTO implements Serializable {
    /*** 序列化ID*/
    private static final long serialVersionUID = 7083063543930267251L;

    /** 代码类型*/
    @ApiModelProperty("代码类型")
    private String dicCodeType;

    /** 数据值*/
    @ApiModelProperty("数据值")
    private String dataVal;

    /** 显示值*/
    @ApiModelProperty("显示值")
    private String dispVal;

    /** 显示序号*/
    @ApiModelProperty("显示序号")
    private String dispSeq;

    /** 上级数据值*/
    @ApiModelProperty("上级数据值")
    private String prntDataVal;

    /** 子级码表*/
    private List<CodeTableDTO> children;
}
