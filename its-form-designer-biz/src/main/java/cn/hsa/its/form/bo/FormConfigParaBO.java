package cn.hsa.its.form.bo;

import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.FormConfigParaDTO;

/**
 * 表单参数配置BO
 * Creator 陈瑜
 * @author 陈瑜  CN31524
 * @date 2020年5月25日
 */
public interface FormConfigParaBO {

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
     * 查询表单参数配置列表
     * Creator 陈瑜
     * @author 陈瑜  CN31524
     * date 2020年5月25日
     * @param formConfigPara 表单参数配置查询参数
     * @return PageResultData<MatterFieldDTO> 表单参数配置列表
     */
    PageResultData<FormConfigParaDTO> listFormConfigPara(FormConfigParaDTO formConfigPara);

    /**
     * 查询表单参数配置详情
     * Creator 陈瑜
     * @author 陈瑜  CN31524
     * date 2020年5月25日
     * @param formConfigPara 表单参数配置查询参数
     * @return MatterFieldDTO 表单参数配置详情
     */
    FormConfigParaDTO getFormConfigPara(FormConfigParaDTO formConfigPara);

    /**
     * 保存表单参数配置信息
     * Creator 陈瑜
     * @author 陈瑜  CN31524
     * date 2020年5月25日
     * @param formConfigPara 表单参数配置查询参数
     * @return int 保存表单参数配置信息记录数
     */
    Integer saveFormConfigPara(FormConfigParaDTO formConfigPara);

    /**
     * 删除表单参数配置
     * @author 陈瑜  CN31524
     * date 2020年5月25日
     * @param formConfigPara 表单参数配置参数DTO
     * @return Integer 删除表单参数配置数量
     */
    Integer deleteFormConfigPara(FormConfigParaDTO formConfigPara);
}
