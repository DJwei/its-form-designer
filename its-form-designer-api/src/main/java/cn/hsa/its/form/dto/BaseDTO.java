package cn.hsa.its.form.dto;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Objects;

/**
 * <h3>Description</h3>
 * Class Name: BaseDTO
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @version 1.0.0
 * @date 2021-12-01 19:48
 */
public class BaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer pageNum;

    /**
     * 页数（多少条一页）
     */
    private Integer pageSize = 20;

    /**
     * 是否分页标志
     * 1：分页
     * 0：不分页
     */
    private String isPage;

    private String menuId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPageNum() {
        if(pageNum == null || pageNum <= 0){
            return 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if(pageSize == null || pageSize <= 0){
            return 20;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getIsPage() {
        if("".equals(isPage) || isPage == null){
            return "1";
        }
        return isPage;
    }

    public void setIsPage(String isPage) {
        this.isPage = isPage;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString()
    {
        return toJson();
    }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        return JSONObject.toJSONString(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        BaseDTO baseDTO = (BaseDTO) o;
        return Objects.equals(pageNum, baseDTO.pageNum) &&
                Objects.equals(pageSize, baseDTO.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNum, pageSize);
    }
}
