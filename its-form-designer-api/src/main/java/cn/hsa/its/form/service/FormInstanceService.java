package cn.hsa.its.form.service;

import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.FormInstanceDTO;
import cn.hsa.its.form.dto.WrapperResponse;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <h3>表单实例Service</h3>
 * Class Name: FormInstanceService
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-18 10:04
 * @version 1.0.0
 */
public interface FormInstanceService {
    /**
     * Description: 查询表单实例列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:23
     * @param formInstance:
     * @return {@link WrapperResponse< PageResultData< FormInstanceDTO>>}
     */
    @PostMapping("/api/its/form/listFormInstance")
    WrapperResponse<PageResultData<FormInstanceDTO>> listFormInstance(FormInstanceDTO formInstance);

    /**
     * Description: 查询表单实例详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:23
     * @param formInstance:
     * @return {@link WrapperResponse< FormInstanceDTO>}
     */
    @PostMapping("/api/its/form/getFormInstance")
    WrapperResponse<FormInstanceDTO> getFormInstance(FormInstanceDTO formInstance);

    /**
     * Description: 保存表单实例
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:23
     * @param formInstance:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/api/its/form/saveFormInstance")
    WrapperResponse<String> saveFormInstance(FormInstanceDTO formInstance);

    /**
     * Description: 删除表单实例
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:23
     * @param formInstance:
     * @return {@link WrapperResponse< Integer>}
     */
    @PostMapping("/api/its/form/deleteFormInstance")
    WrapperResponse<Integer> deleteFormInstance(FormInstanceDTO formInstance);

}
