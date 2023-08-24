package cn.hsa.its.form.controller;

import cn.hsa.its.form.dto.ComponentConfigDTO;
import cn.hsa.its.form.dto.ComponentConfigParamDTO;
import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.WrapperResponse;
import cn.hsa.its.form.service.ComponentConfigService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ComponentConfigController
 * @Creator 李光明
 * @author 卢云祥 CN31831
 * @date 2020/9/24 16:51
 */

@RequestMapping("/web/its/form/componentConfig")
@RestController
@Slf4j
public class ComponentConfigController {

    /*** 组件配置Service*/
    @Resource
    private ComponentConfigService componentConfigService;

    /**
     * Description: 查询组件配置列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:42
     * @param componentConfigParam:
     * @return {@link WrapperResponse< PageResultData<  ComponentConfigDTO >>}
     */
    @PostMapping("/listComponentConfig")
    @ApiOperation("查询组件配置列表")
    public WrapperResponse<PageResultData<ComponentConfigDTO>> listComponentConfig(@RequestBody ComponentConfigParamDTO componentConfigParam){
        //查询组件配置列表
        return componentConfigService.listComponentConfig(componentConfigParam);
    }

    /**
     * Description: 查询组件配置详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:43
     * @param componentConfigParam:
     * @return {@link WrapperResponse<  ComponentConfigDTO >}
     */
    @PostMapping("/getComponentConfig")
    @ApiOperation("查询组件配置详情")
    public WrapperResponse<ComponentConfigDTO> getComponentConfig(@RequestBody ComponentConfigParamDTO componentConfigParam){
        //查询组件配置详情
        return componentConfigService.getComponentConfig(componentConfigParam);
    }

    /**
     * Description: 保存组件配置信息
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:43
     * @param componentConfig:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/saveComponentConfig")
    @ApiOperation("保存组件配置信息")
    public WrapperResponse<Integer> saveComponentConfig(@RequestBody ComponentConfigDTO componentConfig){
        //保存组件配置信息
        return componentConfigService.saveComponentConfig(componentConfig);
    }

    /**
     * Description: 删除组件配置信息
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:42
     * @param componentConfigParam:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/deleteComponentConfig")
    @ApiOperation("删除组件配置信息")
    public WrapperResponse<Integer> deleteComponentConfig(@RequestBody ComponentConfigParamDTO componentConfigParam){
        //删除组件配置信息
        return componentConfigService.deleteComponentConfig(componentConfigParam);
    }

}
