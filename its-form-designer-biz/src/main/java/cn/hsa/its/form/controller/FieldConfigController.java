package cn.hsa.its.form.controller;

import cn.hsa.its.form.dto.*;
import cn.hsa.its.form.service.FieldConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字段配置管理 FieldConfigController
 * Creator 李光明
 * @author 陈瑜  CN31524
 * date 2020-04-17 16:45:35
 */
@RequestMapping("/web/its/form/fieldConfig")
@RestController
@Slf4j
@Api(tags = {"01_字段配置"})
public class FieldConfigController{
    /** 字段配置服务*/
    @Resource
    private FieldConfigService fieldConfigService;

	/**
	 * Description: 查询字段列表
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 19:13
	 * @param fieldConfigParam:
	 * @return {@link WrapperResponse< PageResultData< FieldConfigDTO>>}
	 */
	@PostMapping("/listFieldConfig")
    @ApiOperation("查询字段列表")
	public WrapperResponse<PageResultData<FieldConfigDTO>> listFieldConfig(@RequestBody FieldConfigParamDTO fieldConfigParam){
        //查询字段配置列表
        return fieldConfigService.listFieldConfig(fieldConfigParam);
    }

	/**
	 * Description: 查询字段配置详情
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 19:13
	 * @param fieldConfigParam:
	 * @return {@link WrapperResponse< FieldConfigDTO>}
	 */
	@PostMapping("/getFieldConfig")
    @ApiOperation("查询字段配置详情")
	public WrapperResponse<FieldConfigDTO> getFieldConfig(@RequestBody FieldConfigParamDTO fieldConfigParam){
        //查询字段配置详情
        return fieldConfigService.getFieldConfig(fieldConfigParam);
    }

	/**
	 * Description: 保存字段配置
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 19:13
	 * @param fieldConfig:
	 * @return {@link WrapperResponse< Integer>}
	 */
	@PostMapping("/saveFieldConfig")
    @ApiOperation("保存字段配置")
	public WrapperResponse<Integer> saveFieldConfig(@RequestBody FieldConfigDTO fieldConfig){
        //保存字段配置
        return fieldConfigService.saveFieldConfig(fieldConfig);
    }

    /**
     * Description: 删除字段配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 19:12
     * @param fieldConfigParam:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/deleteFieldConfig")
    @ApiOperation("删除字段配置")
    public WrapperResponse<Integer> deleteFieldConfig(@RequestBody FieldConfigParamDTO fieldConfigParam){
        //删除字段配置
        return fieldConfigService.deleteFieldConfig(fieldConfigParam);
    }

	/**
	 * Description: 查询字段字典
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 19:13
	 * @return {@link WrapperResponse<List<CodeTableDTO>}
	 */
	@GetMapping("/getFieldDict")
	@ApiOperation("查询字段字典")
	public WrapperResponse<List<CodeTableDTO>> getFieldDict(){
		//查询字段配置详情
		return fieldConfigService.getFieldDict();
	}
}
