package cn.hsa.its.form.bo;

import cn.hsa.its.form.dto.CodeTableDTO;
import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.FieldConfigDTO;
import cn.hsa.its.form.dto.FieldConfigParamDTO;

import java.util.List;

/**
 * 字段配置BO
 * @author 陈瑜 CN31524
 * @date 20/8/28 11:35
 */
public interface FieldConfigBO {

    /**
     * 取得主键ID
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年8月8日 10:57:01
     * @return String  主键ID
     */
    String getKeyId();

    /**
     * 取得行ID
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年8月8日 10:57:01
     * @return String 行ID
     */
    String getRowId();

    /**
     * 查询字段配置列表
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 19:24:44
     * @param param 字段配置查询配置
     * @return PageResultData<FieldConfigDTO> 字段配置列表
     */
    PageResultData<FieldConfigDTO> listFieldConfig(FieldConfigParamDTO param);

    /**
     * 查询字段配置详情
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 19:24:39
     * @param param 字段配置查询配置
     * @return FieldConfigDTO 字段配置详情
     */
    FieldConfigDTO getFieldConfig(FieldConfigParamDTO param);

    /**
     * 保存字段配置信息
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 19:24:35
     * @param formFieldCfg 字段配置查询配置
     * @return int 保存字段配置信息记录数
     */
    int saveFieldConfig(FieldConfigDTO formFieldCfg);

    /**
     * 删除字段配置
     * @author 李光明 CN31418
     * date 2020年9月24日 19:24:30
     * @param fldId 字段配置ID
     * @return Integer 删除字段配置数量
     */
    Integer deleteFieldConfig(String fldId);

    /**
     * Description: 查询字段字典
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-02 17:49
     * @return {@link List<CodeTableDTO>}
     */
    List<CodeTableDTO> getFieldDict();
}
