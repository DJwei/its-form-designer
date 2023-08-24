package cn.hsa.its.form.dao;

import cn.hsa.its.form.dto.FormInstanceParaDTO;
import cn.hsa.its.form.entity.FormInstanceParaDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


/**
 * Creator 陈瑜
 * @author 陈瑜 CN31524
 * description: 表单实例DAO
 * date 2020年5月25日
 */
public interface FormInstanceParaDAO extends BaseMapper<FormInstanceParaDO> {

    /**
     * 查询表单实例
     * @author chenyu CN31524
     * @date 20/7/14 10:47
     * @param formInstancePara 表单实例参数DTO
     * @return List<FormInstanceParaDTO> 表单实例DTO列表
     */
    List<FormInstanceParaDTO> listFormInstancePara(FormInstanceParaDTO formInstancePara);

    /**
     * 获取表单实例详情
     * @author chenyu CN31524
     * @date 20/7/14 10:47
     * @param formInstancePara 表单实例参数DTO
     * @return FormInstanceParaDTO 表单实例DTO
     */
    FormInstanceParaDTO getFormInstancePara(FormInstanceParaDTO formInstancePara);

    /**
     * 删除表单实例
     * @author chenyu CN31524
     * @date 20/7/14 10:47
     * @param formInstId 业务ID
     * @return Integer 删除成功标志
     */
    Integer deleteFormInstanceParaByFormInstId(String formInstId);

    /**
     * 删除表单实例
     * @author chenyu CN31524
     * @date 20/7/14 10:47
     * @param bizId 业务ID
     * @return Integer 删除成功标志
     */
    Integer deleteFormInstanceParaByBizId(String bizId);
}
