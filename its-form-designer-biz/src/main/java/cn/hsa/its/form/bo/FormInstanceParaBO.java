package cn.hsa.its.form.bo;

import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.FormInstanceParaDTO;

/**
 * Creator 陈瑜
 * @author 陈瑜  CN31524
 * description: 事项表单实例BO
 * date 2020年5月25日
 */
public interface FormInstanceParaBO {

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
     * @param formInstancePara 实例查询参数
     * @return PageResultData<FormInstanceDTO> 表单实例列表
     */
    PageResultData<FormInstanceParaDTO> listFormInstancePara(FormInstanceParaDTO formInstancePara);

    /**
     * 查询表单参数配置详情
     * Creator 陈瑜
     * @author 陈瑜  CN31524
     * date 2020年5月25日
     * @param formInstancePara 表单参数配置查询参数
     * @return MatterFieldDTO 表单参数配置详情
     */
    FormInstanceParaDTO getFormInstancePara(FormInstanceParaDTO formInstancePara);

    /**
     * 保存表单参数配置信息
     * Creator 陈瑜
     * @author 陈瑜  CN31524
     * date 2020年5月25日
     * @param formInstancePara 表单参数配置查询参数
     * @return int 保存表单参数配置信息记录数
     */
    Integer saveFormInstancePara(FormInstanceParaDTO formInstancePara);

    /**
     * 删除表单参数配置
     * @author 陈瑜  CN31524
     * date 2020年5月25日
     * @param formInstancePara 表单参数配置参数DTO
     * @return Integer 删除表单参数配置数量
     */
    Integer deleteFormInstancePara(FormInstanceParaDTO formInstancePara);
}
