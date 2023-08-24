package cn.hsa.its.form.bo.impl;

import cn.hsa.its.cache.MemoryDb;
import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.bo.FormConfigBO;
import cn.hsa.its.form.bo.FormConfigParaBO;
import cn.hsa.its.form.dao.FormConfigDAO;
import cn.hsa.its.form.dao.FormConfigParaDAO;
import cn.hsa.its.form.dto.FormConfigDTO;
import cn.hsa.its.form.dto.FormConfigParaDTO;
import cn.hsa.its.form.dto.FormConfigParamDTO;
import cn.hsa.its.form.entity.FormConfigDO;
import cn.hsa.its.form.entity.FormConfigParaDO;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.StrSpliter;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.*;

/**
 * <h3>表单配置BO</h3>
 * Class Name: FormConfigBOImpl
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-12-01 9:29
 * @version 1.0.0
 */
@Component
public class FormConfigBOImpl implements FormConfigBO {

	@Resource
	private FormConfigDAO formConfigDAO;

	@Resource
	private FormConfigParaDAO formConfigParaDAO;

	@Resource
	private FormConfigParaBO formConfigParaBO;

	/** 获取序列符*/
	@Resource
	private MemoryDb memoryDb;

	/**
	 * Description: 取得主键ID
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 16:44
	 * @return {@link String}
	 */
	@Override
	public String getKeyId(){
		//取得主键ID
		if(null==memoryDb){
			return null;
		}
		//取得主键ID
		return memoryDb.getIncrementId(FormConfigDTO.KEY_ID);
	}

	/**
	 * Description: 取得行ID
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 16:44
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
	 * Description: 查询表单配置列表
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 16:44
	 * @param formConfigParam:
	 * @return {@link PageResultData< FormConfigDTO>}
	 */
	@Override
	public PageResultData<FormConfigDTO> listFormConfig(FormConfigParamDTO formConfigParam){
		//启动分页
		Integer iPageNum = formConfigParam.getPageNum();
		Integer iPageSize = formConfigParam.getPageSize();
		if(null!=iPageNum && null!=iPageSize && iPageSize>0) {
			PageHelper.startPage(formConfigParam.getPageNum(), formConfigParam.getPageSize());
		}
		//获取表单配置列表
		List<FormConfigDTO> listFormConfig = formConfigDAO.listFormConfig(formConfigParam);
		listFormConfig.forEach(formConfig -> {
			String formId = formConfig.getFormId();
			FormConfigParaDTO formConfigParaParam = new FormConfigParaDTO();
			formConfigParaParam.setFormId(formId);
			//查询表单配置参数，拼装表单
			List<FormConfigParaDTO> formConfigParaList = formConfigParaDAO.listFormConfigPara(formConfigParaParam);
			if (CollUtil.isNotEmpty(formConfigParaList)){
				StringBuilder content = new StringBuilder();
				for (FormConfigParaDTO formConfigPara : formConfigParaList){
					content.append(formConfigPara.getParaval());
				}
				formConfig.setFormContent(content.toString());
			}
		});
		return PageResultData.trans(listFormConfig);
	}

	/**
	 * Description: 查询表单配置详情
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 16:44
	 * @param formConfigParam:
	 * @return {@link FormConfigDTO}
	 */
	@Override
	public FormConfigDTO getFormConfig(FormConfigParamDTO formConfigParam){
		if (formConfigParam == null){
			throw new IllegalArgumentException("表单配置查询参数不能为空");
		}
		String formId = formConfigParam.getFormId();
		if (StringUtils.isBlank(formId)){
			throw new IllegalArgumentException("表单配置查询参数表单ID不能为空");
		}
		//查询表单配置详情
		FormConfigDTO formConfig = formConfigDAO.getFormConfig(formConfigParam);
		if (formConfig != null){
			FormConfigParaDTO formConfigParaParam = new FormConfigParaDTO();
			formConfigParaParam.setFormId(formId);
			//查询表单配置参数，拼装表单
			List<FormConfigParaDTO> formConfigParaList = formConfigParaDAO.listFormConfigPara(formConfigParaParam);
			if (CollUtil.isNotEmpty(formConfigParaList)){
				StringBuilder content = new StringBuilder();
				for (FormConfigParaDTO formConfigPara : formConfigParaList){
					content.append(formConfigPara.getParaval());
				}
				formConfig.setFormContent(content.toString());
			}
		}
		return formConfig;
	}
	@Override
	public FormConfigDTO getFormConfigByCode(FormConfigParamDTO formConfigParam){
		if (formConfigParam == null){
			throw new IllegalArgumentException("表单配置查询参数不能为空");
		}
		//查询表单配置详情
		FormConfigDTO formConfig = formConfigDAO.getFormConfigByCode(formConfigParam);
		if (formConfig != null){
			FormConfigParaDTO formConfigParaParam = new FormConfigParaDTO();
			formConfigParaParam.setFormId(formConfig.getFormId());
			//查询表单配置参数，拼装表单
			List<FormConfigParaDTO> formConfigParaList = formConfigParaDAO.listFormConfigPara(formConfigParaParam);
			if (CollUtil.isNotEmpty(formConfigParaList)){
				StringBuilder content = new StringBuilder();
				for (FormConfigParaDTO formConfigPara : formConfigParaList){
					content.append(formConfigPara.getParaval());
				}
				formConfig.setFormContent(content.toString());
			}
		}
		return formConfig;
	}

	/**
	 * Description: 保存表单配置
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 16:45
	 * @param formConfig:
	 * @return {@link int}
	 */
	@Override
	public int saveFormConfig(FormConfigDTO formConfig){
		//入参检查
		if(null==formConfig){
			return 0;
		}
		boolean bInsert = false;
		String formId = formConfig.getFormId();
		String formContent = formConfig.getFormContent();
		if (StringUtils.isAnyBlank(formConfig.getFormCode(), formConfig.getFormName())){
			throw new IllegalArgumentException("表单编码或表单名称不能为空");
		}
		Date now = new Date();
		if (StringUtils.isBlank(formId)){
			FormConfigParamDTO dto  = new FormConfigParamDTO();
			dto.setFormCode(formConfig.getFormCode());
			FormConfigDTO formConfigDTO = formConfigDAO.getFormConfigByCode(dto);
			if(!ObjectUtil.isEmpty(formConfigDTO)){
				throw new IllegalArgumentException("已存在该表单编码的数据");
			}
			bInsert = true;
			formId = getKeyId();
			formConfig.setRid(getRowId());
			formConfig.setFormId(formId);
			formConfig.setCrteTime(now);
		}else {
			formConfig.setUpdtTime(now);
		}
		formConfig.setOptTime(now);
		FormConfigDO formConfigDO = new FormConfigDO();
		BeanUtil.copyProperties(formConfig, formConfigDO, true);
		//新增或修改
		int ret = 0;
		if(bInsert) {
			ret = formConfigDAO.insert(formConfigDO);
		}else{
			ret = formConfigDAO.updateById(formConfigDO);
		}
		if (ret > 0 && StringUtils.isNotBlank(formContent)){
			//删除原来的表单配置参数
			if (!bInsert){
				formConfigParaDAO.deleteFormConfigPara(formId);
			}
			FormConfigParaDO formConfigPara;
			//按2000长度切分
			String[] fromArr = StrSpliter.splitByLength(formContent, 2000);
			for (int i = 0 ; i < fromArr.length; i++){
				formConfigPara = new FormConfigParaDO();
				//设置参数Id、受理Id、参数序号、参数名称、参数值、有效标志
				formConfigPara.setRid(formConfigParaBO.getRowId());
				formConfigPara.setParaId(formConfigParaBO.getKeyId());
				formConfigPara.setFormId(formId);
				formConfigPara.setParaSeq(i);
				formConfigPara.setParaName("" + i);
				formConfigPara.setParaval(fromArr[i]);
				formConfigPara.setValiFlag("1");
				formConfigPara.setCrteTime(now);
				formConfigParaDAO.insert(formConfigPara);
			}
		}
		return ret;
	}

	/**
	 * Description: 删除表单配置
	 * Creator 李磊(cn32040)
	 * @author 李磊(cn32040)
	 * date 2021-12-01 16:45
	 * @param formId:
	 * @return {@link Integer}
	 */
	@Override
	public Integer deleteFormConfig(String formId) {
		//入参检查
		if(StringUtils.isBlank(formId)){
			return 0;
		}
		//根据ID删除表单配置数据
		int ret = formConfigDAO.deleteFormConfig(formId);
		if (ret > 0){
			//删除表单配置参数
			formConfigParaDAO.deleteFormConfigPara(formId);
		}
		return ret;
	}
}
