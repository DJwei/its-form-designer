package cn.hsa.its.form.bo.impl;
import cn.hsa.its.cache.MemoryDb;
import cn.hsa.its.form.dto.CodeTableDTO;
import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.bo.FieldConfigBO;
import cn.hsa.its.form.dao.FieldConfigDAO;
import cn.hsa.its.form.dto.FieldConfigDTO;
import cn.hsa.its.form.dto.FieldConfigParamDTO;
import cn.hsa.its.form.entity.FieldConfigDO;
import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * <h3>字段配置BO</h3>
 * Class Name: FieldConfigBOImpl
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-12-01 16:46
 * @version 1.0.0
 */

@Component
public class FieldConfigBOImpl implements FieldConfigBO {
    /**字段配置DAO*/
    @Resource
    private FieldConfigDAO fieldConfigDAO;

    /** 获取序列符*/
    @Resource
    private MemoryDb memoryDb;

    /**
     * Description: 取得主键ID
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:46
     * @return {@link String}
     */
    @Override
    public String getKeyId(){
        //取得主键ID
        if(null==memoryDb){
            return null;
        }
        //取得主键ID
        return memoryDb.getIncrementId(FieldConfigDTO.KEY_ID);
    }

    /**
     * Description: 取得行ID
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:46
     * @return {@link String}
     */
    @Override
    public String getRowId(){
        //取得行ID
        if(null==memoryDb){
            return null;
        }
        return memoryDb.getRowId();
    }

    /**
     * Description: 查询字段配置列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:45
     * @param param:
     * @return {@link PageResultData< FieldConfigDTO>}
     */
    @Override
    public PageResultData<FieldConfigDTO> listFieldConfig(FieldConfigParamDTO param){
        //启动分页
        Integer iPageNum = param.getPageNum();
        Integer iPageSize = param.getPageSize();
        if(null!=iPageNum && null!=iPageSize && iPageSize>0) {
            PageHelper.startPage(param.getPageNum(), param.getPageSize());
        }
        //获取字段配置列表
        List<FieldConfigDTO> lstFieldConfig = fieldConfigDAO.listFieldConfig(param);
        return PageResultData.trans(lstFieldConfig);
    }

    /**
     * Description: 查询字段配置详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:45
     * @param param:
     * @return {@link FieldConfigDTO}
     */
    @Override
    public FieldConfigDTO getFieldConfig(FieldConfigParamDTO param){
        //查询字段配置详情
        return fieldConfigDAO.getFieldConfig(param);
    }

    /**
     * Description: 保存字段配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:45
     * @param fieldConfig:
     * @return {@link int}
     */
    @Override
    public int saveFieldConfig(FieldConfigDTO fieldConfig){
        //入参检查
        if(null==fieldConfig){
            return 0;
        }
        boolean bInsert = false;
        String fldId = fieldConfig.getFldId();
        if (StringUtils.isAnyBlank(fieldConfig.getFldCode(), fieldConfig.getFldName())){
            throw new IllegalArgumentException("字段代码或字段名称不能为空");
        }
        Date now = new Date();
        if (StringUtils.isBlank(fldId)){
            bInsert = true;
            fieldConfig.setRid(getRowId());
            fieldConfig.setFldId(getKeyId());
            fieldConfig.setCrteTime(now);
        }else {
            fieldConfig.setUpdtTime(now);
        }
        fieldConfig.setOptTime(now);
        FieldConfigDO fieldConfigDO = new FieldConfigDO();
        BeanUtil.copyProperties(fieldConfig, fieldConfigDO, true);
        //新增或修改
        if(bInsert) {
            return fieldConfigDAO.insert(fieldConfigDO);
        }else{
            return fieldConfigDAO.updateById(fieldConfigDO);
        }
    }

    /**
     * Description: 删除字段配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:45
     * @param fldId:
     * @return {@link Integer}
     */
    @Override
    public Integer deleteFieldConfig(String fldId){
        //入参检查
        if(StringUtils.isBlank(fldId)){
            return 0;
        }
        //根据ID删除字段配置数据
        return fieldConfigDAO.deleteFieldConfig(fldId);
    }

    /**
     * Description: 查询字段字典
     * Creator 李磊(cn32040)
     *
     * @return {@link List< CodeTableDTO >}
     * @author 李磊(cn32040)
     * date 2021-12-02 17:49
     */
    @Override
    public List<CodeTableDTO> getFieldDict() {
        return fieldConfigDAO.getFieldDict();
    }
}
