package cn.hsa.its.form.bo;

import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.FormInstanceDTO;

/**
 * Creator 陈瑜
 * @author 陈瑜  CN31524
 * description: 事项表单实例BO
 * date 2020年5月25日
 */
public interface FormInstanceBO {

    /**
     * 取得主键ID
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年8月8日 10:57:01
     * @return String  主键ID
     */
    String getKeyId();

    /**
     * 取得行ID
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年8月8日 10:57:01
     * @return String 行ID
     */
    String getRowId();

    /**
     * 查询表单实例列表
     * @author chenyu CN31524
     * @date 20/7/14 10:43
     * @param formInstance 实例查询参数
     * @return PageResultData<FormInstanceDTO> 表单实例列表
     */
    PageResultData<FormInstanceDTO> listFormInstance(FormInstanceDTO formInstance);

    /**
     * 获取表单实例详情
     * @author chenyu CN31524
     * @date 20/7/14 10:43
     * @param formInstance 实例查询参数
     * @return FormInstanceDTO 实例详情
     */
    FormInstanceDTO getFormInstance(FormInstanceDTO formInstance);

    /**
     * 保存表单实例信息
     * @author chenyu CN31524
     * @date 20/7/14 10:43
     * @param formInstance 待保存实例信息
     * @return String 实例ID
     */
    String saveFormInstance(FormInstanceDTO formInstance);

    /**
     * 删除表单实例
     * @author chenyu CN31524
     * @date 20/7/14 10:43
     * @param formInstance 待删除实例信息
     * @return Integer 删除成功标志
     */
    Integer deleteFormInstance(FormInstanceDTO formInstance);
}
