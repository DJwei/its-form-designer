package cn.hsa.its.form.service.impl;

import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.bo.FormInstanceBO;
import cn.hsa.its.form.dto.FormInstanceDTO;
import cn.hsa.its.form.dto.WrapperResponse;
import cn.hsa.its.form.service.FormInstanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <h3>表单实例BO</h3>
 * Class Name: FormInstanceServiceImpl
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @version 1.0.0
 * @date 2021-12-01 9:10
 */
@Service
public class FormInstanceServiceImpl implements FormInstanceService {

    @Resource
    private FormInstanceBO formInstanceBO;

    /**
     * Description: 查询表单实例列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:38
     * @param formInstance:
     * @return {@link WrapperResponse< PageResultData< FormInstanceDTO>>}
     */
    @Override
    public WrapperResponse<PageResultData<FormInstanceDTO>> listFormInstance(FormInstanceDTO formInstance) {
        try {
            return WrapperResponse.success(formInstanceBO.listFormInstance(formInstance));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }

    /**
     * Description: 查询表单实例详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:38
     * @param formInstance:
     * @return {@link WrapperResponse< FormInstanceDTO>}
     */
    @Override
    public WrapperResponse<FormInstanceDTO> getFormInstance(FormInstanceDTO formInstance) {
        try {
            return WrapperResponse.success(formInstanceBO.getFormInstance(formInstance));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }

    /**
     * Description: 保存表单实例
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:38
     * @param formInstance:
     * @return {@link WrapperResponse< String>}
     */
    @Override
    public WrapperResponse<String> saveFormInstance(FormInstanceDTO formInstance) {
        try {
            return WrapperResponse.success(formInstanceBO.saveFormInstance(formInstance));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }

    /**
     * Description: 删除表单实例
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:38
     * @param formInstance:
     * @return {@link WrapperResponse< Integer>}
     */
    @Override
    public WrapperResponse<Integer> deleteFormInstance(FormInstanceDTO formInstance) {
        try {
            return WrapperResponse.success(formInstanceBO.deleteFormInstance(formInstance));
        }catch (Exception e){
            return WrapperResponse.fail(e.getMessage(), null);
        }
    }
}
