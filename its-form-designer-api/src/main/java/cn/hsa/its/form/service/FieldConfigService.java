package cn.hsa.its.form.service;

import cn.hsa.its.form.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * <h3>字段配置Service</h3>
 * Class Name: FieldConfigService
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-18 10:03
 * @version 1.0.0
 */

public interface FieldConfigService {
    /**
     * Description: 查询字段配置列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:21
     * @param fieldConfigParam:
     * @return {@link WrapperResponse< PageResultData< FieldConfigDTO>>}
     */
    @PostMapping("/api/its/form/config/listFieldConfig")
    WrapperResponse<PageResultData<FieldConfigDTO>> listFieldConfig(FieldConfigParamDTO fieldConfigParam);

    /**
     * Description: 查询字段配置详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:21
     * @param fieldConfigParam:
     * @return {@link WrapperResponse< FieldConfigDTO>}
     */
    @PostMapping("/api/its/form/config/getFieldConfig")
    WrapperResponse<FieldConfigDTO> getFieldConfig(FieldConfigParamDTO fieldConfigParam);

    /**
     * Description: 保存字段配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:21
     * @param fieldConfig:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/api/its/form/config/saveFieldConfig")
    WrapperResponse<Integer> saveFieldConfig(FieldConfigDTO fieldConfig);

    /**
     * Description: 删除字段配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:21
     * @param fieldConfigParam:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/api/its/form/config/deleteFieldConfig")
    WrapperResponse<Integer> deleteFieldConfig(FieldConfigParamDTO fieldConfigParam);

    /**
     * Description: 查询字段字典
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-02 17:48
     * @return {@link WrapperResponse< List< CodeTableDTO>>}
     */
    @GetMapping("/api/its/form/config/getFieldDict")
    WrapperResponse<List<CodeTableDTO>> getFieldDict();
}

