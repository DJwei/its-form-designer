package cn.hsa.its.form.bo.impl;

import cn.hsa.its.cache.MemoryDb;
import cn.hsa.its.form.dto.PageResultData;
import cn.hsa.its.form.bo.FormInstanceBO;
import cn.hsa.its.form.bo.FormInstanceParaBO;
import cn.hsa.its.form.dao.FormInstanceDAO;
import cn.hsa.its.form.dao.FormInstanceParaDAO;
import cn.hsa.its.form.dto.FormInstanceDTO;
import cn.hsa.its.form.dto.FormInstanceParaDTO;
import cn.hsa.its.form.entity.FormInstanceDO;
import cn.hsa.its.form.entity.FormInstanceParaDO;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.StrSpliter;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <h3>表单实例BO</h3>
 * Class Name: FormInstanceBOImpl
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @date 2021-12-01 16:49
 * @version 1.0.0
 */
@Component
public class FormInstanceBOImpl implements FormInstanceBO {

    /** 实例DAO*/
    @Resource
    private FormInstanceDAO formInstanceDAO;

    /** 实例参数DAO*/
    @Resource
    private FormInstanceParaDAO formInstanceParaDAO;

    /** 实例参数BO*/
    @Resource
    private FormInstanceParaBO formInstanceParaBO;

    /** 获取序列符*/
    @Resource
    private MemoryDb memoryDb;

    /**
     * Description: 取得主键ID
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:17
     * @return {@link String}
     */
    @Override
    public String getKeyId(){
        //取得主键ID
        if(null==memoryDb){
            return null;
        }
        //取得主键ID
        return memoryDb.getIncrementId(FormInstanceDTO.KEY_ID);
    }

    /**
     * Description: 取得行ID
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:17
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
     * Description: 查询表单实例列表
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 16:57
     * @param formInstanceParam:
     * @return {@link PageResultData< FormInstanceDTO>}
     */
    @Override
    public PageResultData<FormInstanceDTO> listFormInstance(FormInstanceDTO formInstanceParam) {
        //启动分页
        Integer iPageNum = formInstanceParam.getPageNum();
        Integer iPageSize = formInstanceParam.getPageSize();
        boolean isPage = "1".equals(formInstanceParam.getIsPage());
        //参数校验
        if(null!=iPageNum && null!=iPageSize && isPage) {
            PageHelper.startPage(formInstanceParam.getPageNum(), formInstanceParam.getPageSize());
        }
        //查询表单实例列表
        List<FormInstanceDTO> listFormInstance = formInstanceDAO.listFormInstance(formInstanceParam);
        if (CollUtil.isNotEmpty(listFormInstance)){
            listFormInstance.forEach(formInstance -> {
                String formInstId = formInstance.getFormInstId();
                FormInstanceParaDTO formInstanceParaParam = new FormInstanceParaDTO();
                formInstanceParaParam.setFormInstId(formInstId);
                //查询表单配置参数，拼装表单
                List<FormInstanceParaDTO> formInstanceParaList = formInstanceParaDAO.listFormInstancePara(formInstanceParaParam);
                if (CollUtil.isNotEmpty(formInstanceParaList)){
                    StringBuilder content = new StringBuilder();
                    for (FormInstanceParaDTO formInstancePara : formInstanceParaList){
                        content.append(formInstancePara.getParaval());
                    }
                    formInstance.setFormInstanceContent(content.toString());
                }
            });
        }
        return PageResultData.trans(listFormInstance);
    }

    /**
     * Description: 获取表单实例信息
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:08
     * @param formInstance:
     * @return {@link FormInstanceDTO}
     */
    @Override
    public FormInstanceDTO getFormInstance(FormInstanceDTO formInstance) {
        if (formInstance == null){
            throw new IllegalArgumentException("表单实例查询参数不能为空");
        }
        String formInstId = formInstance.getFormInstId();
        if (StringUtils.isBlank(formInstId)){
            throw new IllegalArgumentException("表单实例ID不能为空");
        }
        formInstance = new FormInstanceDTO();
        formInstance.setFormInstId(formInstId);
        //查询表单实例
        formInstance = formInstanceDAO.getFormInstance(formInstance);
        if (formInstance != null){
            FormInstanceParaDTO formInstanceParaParam = new FormInstanceParaDTO();
            formInstanceParaParam.setFormInstId(formInstId);
            //查询表单配置参数，拼装表单
            List<FormInstanceParaDTO> formInstanceParaList = formInstanceParaDAO.listFormInstancePara(formInstanceParaParam);
            if (CollUtil.isNotEmpty(formInstanceParaList)){
                StringBuilder content = new StringBuilder();
                for (FormInstanceParaDTO formInstancePara : formInstanceParaList){
                    content.append(formInstancePara.getParaval());
                }
                formInstance.setFormInstanceContent(content.toString());
            }
        }
        return formInstance;
    }

    /**
     * Description: 保存表单实例信息
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:17
     * @param formInstance:
     * @return {@link String}
     */
    @Override
    public String saveFormInstance(FormInstanceDTO formInstance) {
        //参数检查
        if(null == formInstance){
            throw new IllegalArgumentException("保存表单实例失败,参数不能为空!");
        }
        String bizId = formInstance.getBizId();
        String formId = formInstance.getFormId();
        String formInstId = formInstance.getFormInstId();
        String formInstanceContent = formInstance.getFormInstanceContent();
        if(StringUtils.isBlank(bizId)){
            throw new IllegalArgumentException("保存表单实例失败,业务主键[bizId]不能为空!");
        }
        if (StringUtils.isBlank(formId)){
            throw new IllegalArgumentException("保存表单实例失败,表单ID[formId]不能为空!");
        }
        if (StringUtils.isBlank(formInstanceContent)){
            throw new IllegalArgumentException("保存表单实例失败,表单实例内容不能为空!");
        }
        boolean bInsert = false;
        Date now = new Date();
        if (StringUtils.isBlank(formInstId)){
            bInsert = true;
            formInstId = getKeyId();
            formInstance.setRid(getRowId());
            formInstance.setFormInstId(formInstId);
            formInstance.setCrteTime(now);
        }else {
            formInstance.setUpdtTime(now);
        }
        formInstance.setOptTime(now);
        FormInstanceDO formInstanceDO = new FormInstanceDO();
        BeanUtil.copyProperties(formInstance, formInstanceDO, true);
        //新增或修改
        int ret = 0;
        if(bInsert) {
            ret = formInstanceDAO.insert(formInstanceDO);
        }else{
            ret = formInstanceDAO.updateById(formInstanceDO);
        }
        if (ret > 0 && StringUtils.isNotBlank(formInstanceContent)){
            if (!bInsert){
                //删除原来的表单配置参数
                formInstanceParaDAO.deleteFormInstanceParaByFormInstId(formInstId);
            }
            FormInstanceParaDO formInstancePara;
            //按2000长度切分
            String[] fromArr = StrSpliter.splitByLength(formInstanceContent, 2000);
            for (int i = 0 ; i < fromArr.length; i++){
                formInstancePara = new FormInstanceParaDO();
                //设置参数Id、受理Id、参数序号、参数名称、参数值、有效标志
                formInstancePara.setRid(formInstanceParaBO.getRowId());
                formInstancePara.setFormInstParaId(formInstanceParaBO.getKeyId());
                formInstancePara.setFormInstId(formInstId);
                formInstancePara.setBizId(bizId);
                formInstancePara.setFormId(formId);
                formInstancePara.setParaSeq(i);
                formInstancePara.setParaName("" + i);
                formInstancePara.setParaval(fromArr[i]);
                formInstancePara.setValiFlag("1");
                formInstancePara.setCrteTime(now);
                formInstanceParaDAO.insert(formInstancePara);
            }
        }
        return formInstId;
    }

    /**
     * Description: 删除表单实例
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 17:17
     * @param formInstance:
     * @return {@link Integer}
     */
    @Override
    public Integer deleteFormInstance(FormInstanceDTO formInstance) {
        //参数检查
        if (formInstance == null){
            return 0;
        }
        String formInstId = formInstance.getFormInstId();
        if (StringUtils.isBlank(formInstId)){
            return 0;
        }
        //删除表单实例
        int ret = formInstanceDAO.deleteFormInstance(formInstId);
        if (ret > 0){
            //删除表单实例参数
            formInstanceParaDAO.deleteFormInstanceParaByFormInstId(formInstId);
        }
        return ret;
    }
}
