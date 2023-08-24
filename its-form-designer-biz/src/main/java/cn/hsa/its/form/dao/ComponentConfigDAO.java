package cn.hsa.its.form.dao;

import cn.hsa.its.form.dto.ComponentConfigDTO;
import cn.hsa.its.form.dto.ComponentConfigParamDTO;
import cn.hsa.its.form.entity.ComponentConfigDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <h3>组件配置DAO</h3>
 * Class Name: ComponentConfigDAO
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-11-30 20:56
 * @version 1.0.0
 */
public interface ComponentConfigDAO extends BaseMapper<ComponentConfigDO> {

    /**
     * 查询组件配置列表
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 20:04:09 
     * @param componentConfigParam 组件配置查询参数
     * @return PageResultData<ComponentConfigDTO> 组件配置列表
     */
    List<ComponentConfigDTO> listComponentConfig(ComponentConfigParamDTO componentConfigParam);

    /**
     * 查询组件配置详情
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 20:04:09 
     * @param componentConfigParam 组件配置查询参数
     * @return ComponentConfigDTO 组件配置详情
     */
    ComponentConfigDTO getComponentConfig(ComponentConfigParamDTO componentConfigParam);

    /**
     * 删除组件配置
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 20:04:09 
     * @param comtId 组件配置ID
     * @return Integer 删除组件配置数量
     */
    Integer deleteComponentConfig(String comtId);
}
