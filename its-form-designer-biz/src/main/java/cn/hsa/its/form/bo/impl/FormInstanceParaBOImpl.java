package cn.hsa.its.form.bo.impl;

import cn.hsa.its.cache.MemoryDb;
import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.bo.FormInstanceParaBO;
import cn.hsa.its.form.dto.FormInstanceParaDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <h3>表单配置参数BO</h3>
 * Class Name: FormInstanceParaBOImpl
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-12-01 17:18
 * @version 1.0.0
 */
@Component
public class FormInstanceParaBOImpl implements FormInstanceParaBO {

    /** 获取序列符*/
    @Resource
    private MemoryDb memoryDb;

    /**
     * 取得主键ID
     * Creator 李光明
     *
     * @return String  主键ID
     * @author 卢云祥 CN31831
     * date 2020年8月8日 10:57:01
     */
    @Override
    public String getKeyId() {
        //取得主键ID
        if(null==memoryDb){
            return null;
        }
        //取得主键ID
        return memoryDb.getIncrementId(FormInstanceParaDTO.KEY_ID);
    }

    /**
     * 取得行ID
     * Creator 李光明
     *
     * @return String 行ID
     * @author 卢云祥 CN31831
     * date 2020年8月8日 10:57:01
     */
    @Override
    public String getRowId() {
        //取得行ID
        if(null==memoryDb){
            return null;
        }
        return memoryDb.getRowId();
    }

    /**
     * 查询表单实例列表
     *
     * @param formInstancePara 实例查询参数
     * @return PageResultData<FormInstanceDTO> 表单实例列表
     * @author chenyu CN31524
     * @date 20/7/14 10:43
     */
    @Override
    public PageResultData<FormInstanceParaDTO> listFormInstancePara(FormInstanceParaDTO formInstancePara) {
        return null;
    }

    /**
     * 查询表单参数配置详情
     * Creator 陈瑜
     *
     * @param formInstancePara 表单参数配置查询参数
     * @return MatterFieldDTO 表单参数配置详情
     * @author 陈瑜  CN31524
     * date 2020年5月25日
     */
    @Override
    public FormInstanceParaDTO getFormInstancePara(FormInstanceParaDTO formInstancePara) {
        return null;
    }

    /**
     * 保存表单参数配置信息
     * Creator 陈瑜
     *
     * @param formInstancePara 表单参数配置查询参数
     * @return int 保存表单参数配置信息记录数
     * @author 陈瑜  CN31524
     * date 2020年5月25日
     */
    @Override
    public Integer saveFormInstancePara(FormInstanceParaDTO formInstancePara) {
        return null;
    }

    /**
     * 删除表单参数配置
     *
     * @param formInstancePara 表单参数配置参数DTO
     * @return Integer 删除表单参数配置数量
     * @author 陈瑜  CN31524
     * date 2020年5月25日
     */
    @Override
    public Integer deleteFormInstancePara(FormInstanceParaDTO formInstancePara) {
        return null;
    }
}
