package cn.hsa.its.form.service.impl;

import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.bo.FormConfigBO;
import cn.hsa.its.form.dto.FormConfigDTO;
import cn.hsa.its.form.dto.FormConfigParamDTO;
import cn.hsa.its.form.dto.WrapperResponse;
import cn.hsa.its.form.service.FormConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <h3>Description</h3>
 * Class Name: FormConfigServiceImpl
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @version 1.0.0
 * @date 2021-12-01 9:09
 */
@Service
public class FormConfigServiceImpl implements FormConfigService {

    @Resource
    private FormConfigBO formConfigBO;

    /**
     * Description: 查询表单配置列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:35
     * @param formConfigParam:
     * @return {@link WrapperResponse< PageResultData< FormConfigDTO>>}
     */
    @Override
    public WrapperResponse<PageResultData<FormConfigDTO>> listFormConfig(FormConfigParamDTO formConfigParam) {
        try {
            return WrapperResponse.success(formConfigBO.listFormConfig(formConfigParam));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }

    /**
     * Description: 查询表单配置详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:34
     * @param formConfigParam:
     * @return {@link WrapperResponse< FormConfigDTO>}
     */
    @Override
    public WrapperResponse<FormConfigDTO> getFormConfig(FormConfigParamDTO formConfigParam) {
        try {
            return WrapperResponse.success(formConfigBO.getFormConfig(formConfigParam));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }
    @Override
    public WrapperResponse<FormConfigDTO> getFormConfigByCode(FormConfigParamDTO formConfigParam) {
        try {
            return WrapperResponse.success(formConfigBO.getFormConfigByCode(formConfigParam));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }

    /**
     * Description: 保存表单配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:34
     * @param formConfig:
     * @return {@link WrapperResponse< Integer>}
     */
    @Override
    public WrapperResponse<Integer> saveFormConfig(FormConfigDTO formConfig) {
//        try {
            return WrapperResponse.success(formConfigBO.saveFormConfig(formConfig));
//        }catch (Exception e){
//            return WrapperResponse.fail(e.getMessage(), null);
//        }
    }

    /**
     * Description: 删除表单配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:34
     * @param formConfigParam:
     * @return {@link WrapperResponse< Integer>}
     */
    @Override
    public WrapperResponse<Integer> deleteFormConfig(FormConfigParamDTO formConfigParam) {
        if (formConfigParam == null || StringUtils.isBlank(formConfigParam.getFormId())){
            WrapperResponse.fail("删除表单失败，表单ID不能为空", 0);
        }
        try {
            return WrapperResponse.success(formConfigBO.deleteFormConfig(formConfigParam.getFormId()));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }
}
