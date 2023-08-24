package cn.hsa.its.form.service.impl;

import cn.hsa.its.form.dto.ComponentConfigDTO;
import cn.hsa.its.form.dto.ComponentConfigParamDTO;
import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.bo.ComponentConfigBO;
import cn.hsa.its.form.dto.WrapperResponse;
import cn.hsa.its.form.service.ComponentConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <h3>组件配置Service</h3>
 * Class Name: ComponentConfigServiceImpl
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @version 1.0.0
 * @date 2021-12-01 9:08
 */
@Service
public class ComponentConfigServiceImpl implements ComponentConfigService {

    @Resource
    private ComponentConfigBO componentConfigBO;
    /**
     * Description: 查询组件配置列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:19
     * @param componentConfigParam:
     * @return {@link WrapperResponse< PageResultData<  ComponentConfigDTO >>}
     */
    @Override
    public WrapperResponse<PageResultData<ComponentConfigDTO>> listComponentConfig(ComponentConfigParamDTO componentConfigParam) {
        try {
            return WrapperResponse.success(componentConfigBO.listComponentConfig(componentConfigParam));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }

    }

    /**
     * Description: 查询组件配置详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:19
     * @param componentConfigParam:
     * @return {@link WrapperResponse<  ComponentConfigDTO >}
     */
    @Override
    public WrapperResponse<ComponentConfigDTO> getComponentConfig(ComponentConfigParamDTO componentConfigParam) {
        try {
            return WrapperResponse.success(componentConfigBO.getComponentConfig(componentConfigParam));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }

    }

    /**
     * Description: 保存组件配置列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:19
     * @param componentConfig:
     * @return {@link WrapperResponse< Integer>}
     */
    @Override
    public WrapperResponse<Integer> saveComponentConfig(ComponentConfigDTO componentConfig) {
        try {
            return WrapperResponse.success(componentConfigBO.saveComponentConfig(componentConfig));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }

    /**
     * Description: 删除组件配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:19
     * @param componentConfigParam:
     * @return {@link WrapperResponse< Integer>}
     */
    @Override
    public WrapperResponse<Integer> deleteComponentConfig(ComponentConfigParamDTO componentConfigParam) {
        try {
            if (componentConfigParam == null || StringUtils.isBlank(componentConfigParam.getComtId())){
                WrapperResponse.fail("删除组件失败，组件ID不能为空", 0);
            }
            return WrapperResponse.success(componentConfigBO.deleteComponentConfig(componentConfigParam.getComtId()));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }
}
