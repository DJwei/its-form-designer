package cn.hsa.its.form.dao;

import cn.hsa.its.form.dto.FormConfigParaDTO;
import cn.hsa.its.form.entity.FormConfigParaDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * Creator 陈瑜
 * @author 陈瑜 CN31524
 * date 2020年5月25日
 * 表单配置参数DAO
 */
public interface FormConfigParaDAO extends BaseMapper<FormConfigParaDO> {

    /**
     * 查询表单配置参数列表
     * Creator 陈瑜
     * @author 陈瑜 CN31524
     * date 2020年5月25日
     * @param formConfigPara 表单配置参数查询参数
     * @return PageResultData<FormConfigParaDTO> 表单配置参数列表
     */
    List<FormConfigParaDTO> listFormConfigPara(FormConfigParaDTO formConfigPara);

    /**
     * 查询表单配置参数详情
     * Creator 陈瑜
     * @author 陈瑜 CN31524
     * date 2020年5月25日
     * @param formConfigPara 表单配置参数查询参数
     * @return FormConfigParaDTO 表单配置参数详情
     */
    FormConfigParaDTO getFormConfigPara(FormConfigParaDTO formConfigPara);

    /**
     * 删除表单配置参数
     * Creator 陈瑜
     * @author 陈瑜 CN31524
     * date 2020年5月25日
     * @param formId 表单配置参数ID
     * @return Integer 删除表单配置参数数量
     */
    Integer deleteFormConfigPara(String formId);
}
