package cn.hsa.its.form.dao;

import cn.hsa.its.form.dto.CodeTableDTO;
import cn.hsa.its.form.dto.FieldConfigDTO;
import cn.hsa.its.form.dto.FieldConfigParamDTO;
import cn.hsa.its.form.entity.FieldConfigDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 字段配置Dao
 * @author 陈瑜 CN31524
 * @date 20/8/28 14:04
 */
public interface FieldConfigDAO extends BaseMapper<FieldConfigDO> {
    /**
     * 查询字段配置列表
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 20:04:09
     * @param fieldConfigParam 字段配置查询参数
     * @return PageResultData<FieldConfigDTO> 字段配置列表
     */
    List<FieldConfigDTO> listFieldConfig(FieldConfigParamDTO fieldConfigParam);

    /**
     * 查询字段配置详情
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 20:04:09
     * @param fieldConfigParam 字段配置查询参数
     * @return FieldConfigDTO 字段配置详情
     */
    FieldConfigDTO getFieldConfig(FieldConfigParamDTO fieldConfigParam);

    /**
     * 删除字段配置
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 20:04:09
     * @param fldId 字段配置ID
     * @return Integer 删除字段配置数量
     */
    Integer deleteFieldConfig(String fldId);

    /**
     * Description: 查询字段字典
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-02 17:46
     * @return {@link List<CodeTableDTO>}
     */
    List<CodeTableDTO> getFieldDict();
}
