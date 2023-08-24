package cn.hsa.its.form.dao;

import cn.hsa.its.form.dto.FormInstanceDTO;
import cn.hsa.its.form.entity.FormInstanceDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


/**
 * Creator 陈瑜
 * @author 陈瑜 CN31524
 * description: 表单实例DAO
 * date 2020年5月25日
 */
public interface FormInstanceDAO extends BaseMapper<FormInstanceDO> {

    /**
     * 查询表单实例
     * @author chenyu CN31524
     * @date 20/7/14 10:47
     * @param formInstance 表单实例参数DTO
     * @return List<FormInstanceDTO> 表单实例DTO列表
     */
    List<FormInstanceDTO> listFormInstance(FormInstanceDTO formInstance);

    /**
     * 获取表单实例详情
     * @author chenyu CN31524
     * @date 20/7/14 10:47
     * @param formInstance 表单实例参数DTO
     * @return FormInstanceDTO 表单实例DTO
     */
    FormInstanceDTO getFormInstance(FormInstanceDTO formInstance);

    /**
     * 删除表单实例
     * @author chenyu CN31524
     * @date 20/7/14 10:47
     * @param formInstId 表单实例ID
     * @return Integer 删除成功标志
     */
    Integer deleteFormInstance(String formInstId);

    /**
     * 删除表单实例
     * @author chenyu CN31524
     * @date 20/7/14 10:47
     * @param bizId 业务ID
     * @return Integer 删除成功标志
     */
    Integer deleteFormInstanceByBizId(String bizId);
}
