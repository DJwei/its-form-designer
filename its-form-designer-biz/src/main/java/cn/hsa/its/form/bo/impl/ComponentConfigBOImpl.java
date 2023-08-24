package cn.hsa.its.form.bo.impl;

import cn.hsa.its.cache.MemoryDb;
import cn.hsa.its.form.dto.ComponentConfigParamDTO;
import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.bo.ComponentConfigBO;
import cn.hsa.its.form.dao.ComponentConfigDAO;
import cn.hsa.its.form.dto.ComponentConfigDTO;
import cn.hsa.its.form.entity.ComponentConfigDO;
import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <h3>组件配置BO</h3>
 * Class Name: ComponentConfigBOImpl
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-12-01 16:46
 * @version 1.0.0
 */
@Component
public class ComponentConfigBOImpl implements ComponentConfigBO {

    /** 表单参数Dao*/
    @Resource
    private ComponentConfigDAO componentConfigDAO;

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
    public String getKeyId() {
        //取得主键ID
        if(null==memoryDb){
            return null;
        }
        //取得主键ID
        return memoryDb.getIncrementId(ComponentConfigDTO.KEY_ID);
    }

    /**
     * Description: 取得行ID
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:47
     * @return {@link String}
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
     * Description: 查询组件配置列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:47
     * @param componentConfigParam:
     * @return {@link PageResultData<  ComponentConfigDTO >}
     */
    @Override
    public PageResultData<ComponentConfigDTO> listComponentConfig(ComponentConfigParamDTO componentConfigParam){
        //启动分页
        Integer iPageNum = componentConfigParam.getPageNum();
        Integer iPageSize = componentConfigParam.getPageSize();
        if(null!=iPageNum && null!=iPageSize && iPageSize>0) {
            PageHelper.startPage(componentConfigParam.getPageNum(), componentConfigParam.getPageSize());
        }
        //获取组件配置列表
        List<ComponentConfigDTO> lstComponentConfig = componentConfigDAO.listComponentConfig(componentConfigParam);
        return PageResultData.trans(lstComponentConfig);
    }

    /**
     * Description: 查询组件配置详情
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:47
     * @param componentConfigParam:
     * @return {@link ComponentConfigDTO}
     */
    @Override
    public ComponentConfigDTO getComponentConfig(ComponentConfigParamDTO componentConfigParam){
        //查询组件配置详情
        return componentConfigDAO.getComponentConfig(componentConfigParam);
    }

    /**
     * Description: 保存组件配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:47
     * @param componentConfig:
     * @return {@link Integer}
     */
    @Override
    public Integer saveComponentConfig(ComponentConfigDTO componentConfig){
        //入参检查
        if(null==componentConfig){
            return 0;
        }
        boolean bInsert = false;
        String fldId = componentConfig.getComtId();
        if (StringUtils.isAnyBlank(componentConfig.getComtFldCode(), componentConfig.getComtFldName())){
            throw new IllegalArgumentException("组件代码或组件名称不能为空");
        }
        Date now = new Date();
        if (StringUtils.isBlank(fldId)){
            bInsert = true;
            componentConfig.setRid(getRowId());
            componentConfig.setComtId(getKeyId());
            componentConfig.setCrteTime(now);
        }else {
            componentConfig.setUpdtTime(now);
        }
        componentConfig.setOptTime(now);
        ComponentConfigDO componentConfigDO = new ComponentConfigDO();
        BeanUtil.copyProperties(componentConfig, componentConfigDO, true);
        //新增或修改
        if(bInsert) {
            return componentConfigDAO.insert(componentConfigDO);
        }else{
            return componentConfigDAO.updateById(componentConfigDO);
        }
    }

    /**
     * Description: 删除组件配置
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:47
     * @param comtId:
     * @return {@link Integer}
     */
    @Override
    public Integer deleteComponentConfig(String comtId){
        //入参检查
        if(StringUtils.isBlank(comtId)){
            return 0;
        }
        //根据ID删除组件配置数据
        return componentConfigDAO.deleteComponentConfig(comtId);
    }
}
