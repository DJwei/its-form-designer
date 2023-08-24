package cn.hsa.its.form.bo;

import cn.hsa.its.form.dto.ComponentConfigParamDTO;
import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.ComponentConfigDTO;

/**
 * @ClassName ComponentConfigBO
 * @Creator 李光明
 * @author 卢云祥 CN31831
 * @date 2020/9/24 17:01
 */


public interface ComponentConfigBO {

    /**
     * 取得主键ID
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 19:23:29
     * @return String  主键ID
     */
    String getKeyId();

    /**
     * 取得行ID
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 19:23:29
     * @return String 行ID
     */
    String getRowId();

    /**
     * 查询表单字段配置列表
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 19:24:44
     * @param componentConfigParam 表单字段配置查询参数
     * @return PageResultData<ComponentConfigDTO> 表单字段配置列表
     */
    PageResultData<ComponentConfigDTO> listComponentConfig(ComponentConfigParamDTO componentConfigParam);

    /**
     * 查询表单字段配置详情
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 19:24:39
     * @param componentConfigParam 表单字段配置查询参数
     * @return ComponentConfigDTO 表单字段配置详情
     */
    ComponentConfigDTO getComponentConfig(ComponentConfigParamDTO componentConfigParam);

    /**
     * 保存表单字段配置信息
     * Creator 李光明
     * @author 卢云祥 CN31831
     * date 2020年9月24日 19:24:35
     * @param componentConfig 表单字段配置查询参数
     * @return int 保存表单字段配置信息记录数
     */
    Integer saveComponentConfig(ComponentConfigDTO componentConfig);

    /**
     * 删除表单字段配置
     * @author 李光明 CN31418
     * date 2020年9月24日 19:24:30
     * @param comtId 表单字段配置ID
     * @return Integer 删除表单字段配置数量
     */
    Integer deleteComponentConfig(String comtId);

}

