package cn.hsa.its.form.service;


import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.FormConfigDTO;
import cn.hsa.its.form.dto.FormConfigParamDTO;
import cn.hsa.its.form.dto.WrapperResponse;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <h3>表单配置Service</h3>
 * Class Name: TemplateConfigService
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-18 10:04
 * @version 1.0.0
 */
public interface FormConfigService {
    /**
     * Description: 查询表单配置列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:22
     * @param formConfigParam:
     * @return {@link WrapperResponse< PageResultData< FormConfigDTO>>}
     */
    @PostMapping("/api/its/form/config/listFormConfig")
    WrapperResponse<PageResultData<FormConfigDTO>> listFormConfig(FormConfigParamDTO formConfigParam);

    /**
     * Description: 查询表单配置详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:22
     * @param formConfigParam:
     * @return {@link WrapperResponse< FormConfigDTO>}
     */
    @PostMapping("/api/its/form/config/getFormConfig")
    WrapperResponse<FormConfigDTO> getFormConfig(FormConfigParamDTO formConfigParam);

    /**
     * 通过编码查询
     * @param formConfigParam
     * @return
     */
    @PostMapping("/api/its/form/config/getFormConfigByCode")
    WrapperResponse<FormConfigDTO> getFormConfigByCode(FormConfigParamDTO formConfigParam);

    /**
     * Description: 保存表单配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:22
     * @param FormConfig:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/api/its/form/config/saveFormConfig")
    WrapperResponse<Integer> saveFormConfig(FormConfigDTO FormConfig);

    /**
     * Description: 删除表单配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:22
     * @param formConfigParam:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/api/its/form/config/deleteFormConfig")
    WrapperResponse<Integer> deleteFormConfig(FormConfigParamDTO formConfigParam);
}
