package cn.hsa.its.form.dao;

import cn.hsa.its.form.dto.FormConfigDTO;
import cn.hsa.its.form.dto.FormConfigParamDTO;
import cn.hsa.its.form.entity.FormConfigDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description: 表单配置DAO
 * ClassName: FormConfigDAO
 * Creator 李光明
 * @author 陈瑜 CN31524
 * date: 2020-04-17 16:45:35
 * Copyright: http://www.powersi.com.cn  2019  创智和宇
 */
public interface FormConfigDAO extends BaseMapper<FormConfigDO> {

	/**
	 * 查询表单配置列表
	* Creator 李光明
	* @author 陈瑜 CN31524
	 * date 2020-04-17 16:45:35
	 * @param formConfigParam 表单配置查询参数
	 * @return PageResultData<FormConfigDTO> 表单配置列表
	 */
	List<FormConfigDTO> listFormConfig(FormConfigParamDTO formConfigParam);

	/**
	* 查询表单配置详情
	* Creator 李光明
	* @author 陈瑜 CN31524
	* date 2020-04-17 16:45:35
	* @param formConfigParam 表单配置查询参数
	* @return FormConfigDTO 表单配置详情
	*/
	FormConfigDTO getFormConfig(FormConfigParamDTO formConfigParam);

	FormConfigDTO getFormConfigByCode(@Param("vo") FormConfigParamDTO formConfigParam);

	/**
	* 删除表单配置
	* Creator 李光明
	* @author 陈瑜 CN31524
	* date 2020-04-17 16:45:35
	* @param fldId 表单配置ID
	* @return int 删除表单配置数量
	*/
	Integer deleteFormConfig(String formId);

}
