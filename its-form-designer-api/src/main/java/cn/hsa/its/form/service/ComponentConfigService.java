package cn.hsa.its.form.service;


import cn.hsa.its.form.dto.ComponentConfigParamDTO;
import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.ComponentConfigDTO;
import cn.hsa.its.form.dto.WrapperResponse;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <h3>组件配置Service</h3>
 * Class Name: ComponentConfigService
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-18 10:03
 * @version 1.0.0
 */
public interface ComponentConfigService {
	/**
	 * Description: 查询组件配置列表
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 17:21
	 * @param componentConfigParam:
	 * @return {@link WrapperResponse< PageResultData<  ComponentConfigDTO >>}
	 */
	@PostMapping("/api/its/form/config/listComponentConfig")
	WrapperResponse<PageResultData<ComponentConfigDTO>> listComponentConfig(ComponentConfigParamDTO componentConfigParam);

	/**
	 * Description: 查询组件配置详情
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 17:20
	 * @param componentConfigParam:
	 * @return {@link WrapperResponse<  ComponentConfigDTO >}
	 */
	@PostMapping("/api/its/form/config/getComponentConfig")
	WrapperResponse<ComponentConfigDTO> getComponentConfig(ComponentConfigParamDTO componentConfigParam);

	/**
	 * Description: 保存组件配置
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 17:20
	 * @param componentConfig:
	 * @return {@link WrapperResponse< Integer>}
	 */
	@PostMapping("/api/its/form/config/saveComponentConfig")
	WrapperResponse<Integer> saveComponentConfig(ComponentConfigDTO componentConfig);

	/**
	 * Description: 删除组件配置
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 17:20
	 * @param componentConfigParam:
	 * @return {@link WrapperResponse< Integer>}
	 */
	@PostMapping("/api/its/form/config/deleteComponentConfig")
	WrapperResponse<Integer> deleteComponentConfig(ComponentConfigParamDTO componentConfigParam);
}
