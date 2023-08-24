package cn.hsa.its.form.bo;

import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.dto.FormConfigDTO;
import cn.hsa.its.form.dto.FormConfigParamDTO;

/**
 * 表单BO
 * Creator 李光明
 * @author 陈瑜  CN31524
 * date 2020-04-17 16:45:35
 */
public interface FormConfigBO {

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
	* 查询表单配置列表
	* Creator 李光明
	* @author 陈瑜  CN31524
	* date 2020-04-17 16:45:35
	* @param param 表单配置查询参数
	* @return PageResultData<FormConfigDTO> 表单配置列表
	*/
	PageResultData<FormConfigDTO> listFormConfig(FormConfigParamDTO param);

	/**
	* 查询表单配置详情
	* Creator 李光明
	* @author 陈瑜  CN31524
	* date 2020-04-17 16:45:35
	* @param param 表单配置查询参数
	* @return FormConfigDTO 表单配置详情
	*/
	FormConfigDTO getFormConfig(FormConfigParamDTO param);

	/**
	 * 查询表单配置详情
	 * Creator 李光明
	 * @author 陈瑜  CN31524
	 * date 2020-04-17 16:45:35
	 * @param param 表单配置查询参数
	 * @return FormConfigDTO 表单配置详情
	 */
	FormConfigDTO getFormConfigByCode(FormConfigParamDTO param);

	/**
	* 保存表单配置信息
	* Creator 李光明
	* @author 陈瑜  CN31524
	* date 2020-04-17 16:45:35
	* @param matterField 表单配置查询参数
	* @return int 保存表单配置信息记录数
	*/
	int saveFormConfig(FormConfigDTO matterField);

	/**
	 * 删除表单配置
	 * @author 李光明 CN31418
	 * date 2020-04-17 16:45:35
	 * @param formId 表单配置参数DTO
	 * @return Integer 删除表单配置数量
	 */
	Integer deleteFormConfig(String formId);
}
