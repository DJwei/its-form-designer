package cn.hsa.its.form.service.impl;

import cn.hsa.its.form.dto.*;
import cn.hsa.its.form.bo.FieldConfigBO;
import cn.hsa.its.form.service.FieldConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <h3>字段配置Service</h3>
 * Class Name: FieldConfigServiceImpl
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @version 1.0.0
 * @date 2021-12-01 9:09
 */
@Service
public class FieldConfigServiceImpl implements FieldConfigService {

    @Resource
    private FieldConfigBO fieldConfigBO;

    /**
     * Description: 查询字段配置列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:32
     * @param fieldConfigParam:
     * @return {@link WrapperResponse< PageResultData< FieldConfigDTO>>}
     */
    @Override
    public WrapperResponse<PageResultData<FieldConfigDTO>> listFieldConfig(FieldConfigParamDTO fieldConfigParam) {
        try {
            return WrapperResponse.success(fieldConfigBO.listFieldConfig(fieldConfigParam));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }

    /**
     * Description: 查询字段配置详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:32
     * @param fieldConfigParam:
     * @return {@link WrapperResponse< FieldConfigDTO>}
     */
    @Override
    public WrapperResponse<FieldConfigDTO> getFieldConfig(FieldConfigParamDTO fieldConfigParam) {
        try {
            return WrapperResponse.success(fieldConfigBO.getFieldConfig(fieldConfigParam));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }

    /**
     * Description: 保存字段配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:32
     * @param fieldConfig:
     * @return {@link WrapperResponse< Integer>}
     */
    @Override
    public WrapperResponse<Integer> saveFieldConfig(FieldConfigDTO fieldConfig) {
        try {
            return WrapperResponse.success(fieldConfigBO.saveFieldConfig(fieldConfig));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }

    /**
     * Description: 删除字段配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:31
     * @param fieldConfigParam:
     * @return {@link WrapperResponse< Integer>}
     */
    @Override
    public WrapperResponse<Integer> deleteFieldConfig(FieldConfigParamDTO fieldConfigParam) {
        try {
            if (fieldConfigParam == null || StringUtils.isBlank(fieldConfigParam.getFldId())){
                WrapperResponse.fail("删除字段失败，字段ID不能为空", 0);
            }
            return WrapperResponse.success(fieldConfigBO.deleteFieldConfig(fieldConfigParam.getFldId()));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }

    /**
     * Description: 查询字段字典
     * Creator 李磊(cn32040)
     *
     * @return {@link WrapperResponse<  List <  CodeTableDTO >>}
     * @author 李磊(cn32040)
     * date 2021-12-02 17:48
     */
    @Override
    public WrapperResponse<List<CodeTableDTO>> getFieldDict() {
        return WrapperResponse.success(fieldConfigBO.getFieldDict());
    }
}
