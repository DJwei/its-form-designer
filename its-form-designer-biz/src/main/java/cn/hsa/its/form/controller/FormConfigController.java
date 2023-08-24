package cn.hsa.its.form.controller;

import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.FormConfigDTO;
import cn.hsa.its.form.dto.FormConfigParamDTO;
import cn.hsa.its.form.dto.WrapperResponse;
import cn.hsa.its.form.service.FormConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <h3>表单维护</h3>
 * Class Name: FormConfigController
 * <p>Description: </p>
 * @author 李磊(cn32040)
 * @date 2021-12-01 19:17
 * @version 1.0.0
 */
@RequestMapping("/web/its/form/formConfig")
@RestController
@Slf4j
@Api(tags = {"03_表单维护"})
public class FormConfigController{
    /** 表单维护服务*/
    @Resource
    private FormConfigService formConfigService;

    /**
     * Description: 查询表单列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 19:17
     * @param formConfigParam:
     * @return {@link WrapperResponse< PageResultData< FormConfigDTO>>}
     */
    @PostMapping("/listFormConfig")
    @ApiOperation("查询表单列表")
    public WrapperResponse<PageResultData<FormConfigDTO>> listFormConfig(@RequestBody FormConfigParamDTO formConfigParam){
        //查询表单集
        return formConfigService.listFormConfig(formConfigParam);
    }

    /**
     * Description: 获取表单详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 19:17
     * @param formConfigParam:
     * @return {@link WrapperResponse< FormConfigDTO>}
     */
    @PostMapping("/getFormConfig")
    @ApiOperation("获取表单详情")
    public WrapperResponse<FormConfigDTO> getFormConfig(@RequestBody FormConfigParamDTO formConfigParam){
        //获取表单详情
        return formConfigService.getFormConfig(formConfigParam);
    }

    /**
     * Description: 获取表单详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 19:17
     * @param formConfigParam:
     * @return {@link WrapperResponse< FormConfigDTO>}
     */
    @PostMapping("/getFormConfigByCode")
    @ApiOperation("获取表单详情")
    public WrapperResponse<FormConfigDTO> getFormConfigByCode(@RequestBody FormConfigParamDTO formConfigParam){
        //获取表单详情
        return formConfigService.getFormConfigByCode(formConfigParam);
    }

    /**
     * Description: 保存表单
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 19:17
     * @param formConfig:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/saveFormConfig")
    @ApiOperation("保存表单")
    public WrapperResponse<Integer> saveFormConfig(@RequestBody FormConfigDTO formConfig){
        //保存表单
        return formConfigService.saveFormConfig(formConfig);
    }

    /**
     * Description: 删除表单
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 19:17
     * @param formConfigParam:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/deleteFormConfig")
    @ApiOperation("删除表单")
    public WrapperResponse<Integer> deleteFormConfig(@RequestBody FormConfigParamDTO formConfigParam){
        //删除表单
        return formConfigService.deleteFormConfig(formConfigParam);
    }
}
