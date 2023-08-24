package cn.hsa.its.form.controller;

import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.FormInstanceDTO;
import cn.hsa.its.form.dto.WrapperResponse;
import cn.hsa.its.form.service.FormInstanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <h3>表单实例</h3>
 * Class Name: FormInstanceController
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-12-01 19:19
 * @version 1.0.0
 */
@RequestMapping("/web/its/form/formInstance")
@RestController
@Slf4j
@Api(tags = {"04_表单实例"})
public class FormInstanceController{
    /** 表单实例服务*/
    @Resource
    private FormInstanceService formInstanceService;

    /**
     * Description: 查询表单实例列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 19:20
     * @param formInstance:
     * @return {@link WrapperResponse< PageResultData< FormInstanceDTO>>}
     */
    @PostMapping("/listFormInstance")
    @ApiOperation("查询表单实例列表")
    public WrapperResponse<PageResultData<FormInstanceDTO>> listFormInstance(@RequestBody FormInstanceDTO formInstance){
        //查询表单实例列表
        return formInstanceService.listFormInstance(formInstance);
    }

    /**
     * Description: 获取表单实例详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 19:20
     * @param formInstance:
     * @return {@link WrapperResponse< FormInstanceDTO>}
     */
    @PostMapping("/getFormInstance")
    @ApiOperation("获取表单实例详情")
    public WrapperResponse<FormInstanceDTO> getFormInstance(@RequestBody FormInstanceDTO formInstance){
        //获取表单实例详情
        return formInstanceService.getFormInstance(formInstance);
    }

    /**
     * Description: 保存表单实例信息
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 19:20
     * @param formInstance:
     * @return {@link WrapperResponse< String>}
     */
    @PostMapping("/saveFormInstance")
    @ApiOperation("保存表单实例信息")
    public WrapperResponse<String> saveFormInstance(@RequestBody FormInstanceDTO formInstance){
        //保存表单实例信息
        return formInstanceService.saveFormInstance(formInstance);
    }

    /**
     * Description: 删除表单实例记录
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 19:20
     * @param formInstance:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/deleteFormInstance")
    @ApiOperation("删除表单实例记录")
    public WrapperResponse<Integer> deleteFormInstance(@RequestBody FormInstanceDTO formInstance){
        //删除表单实例记录
        return formInstanceService.deleteFormInstance(formInstance);
    }
}
