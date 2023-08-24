package cn.hsa.its.form.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * <h3>Description</h3>
 * Class Name: PageResultData
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @version 1.0.0
 * @date 2021-12-01 19:42
 */
public class PageResultData<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int pageNum = 0;
    private int pageSize = 0;
    private int size = 0;
    private int startRow = 0;
    private int endRow = 0;
    private int pages = 0;
    private int recordCounts = 0;
    private int prePage = 0;
    private int nextPage = 0;
    private boolean isFirstPage = false;
    private boolean isLastPage = false;
    private String orderField;
    private String orderType;
    private List<T> Data = Collections.EMPTY_LIST;

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-19 21:14
     * @Description
     * </pre>
     **/
    public PageResultData() {
        pageNum = 1;
        pageSize = 20;
        size = 0;
        startRow = 0;
        endRow = 0;
        pages = 0;
        recordCounts = 0;
        prePage = 0;
        nextPage = 0;
        isFirstPage = false;
        isLastPage = false;
        orderField = "";
        orderType = "";
        Data = Collections.EMPTY_LIST;
    }

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-17 16:16
     * @Description
     * @param data
     * @return
     * </pre>
     **/
    public PageResultData(List<T> data) {
        com.github.pagehelper.PageInfo pageHelper = new com.github.pagehelper.PageInfo(data);
        this.Data = pageHelper.getList();
        this.pageNum = pageHelper.getPageNum();
        this.pageSize = pageHelper.getPageSize();
        this.size = pageHelper.getSize();
        this.startRow = pageHelper.getStartRow();
        this.endRow = pageHelper.getEndRow();
        this.pages = pageHelper.getPages();
        this.recordCounts = (int) pageHelper.getTotal();
        this.prePage = pageHelper.getPrePage();
        this.nextPage = pageHelper.getNextPage();
        this.isFirstPage = pageHelper.isIsFirstPage();
        this.isLastPage = pageHelper.isIsLastPage();

        //分页信息记录行号及分页结束记录行号校验修正
        checkSetPageStartEndRow();
    }

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-17 16:15
     * @Description
     * @param dataAndPage
     * @param data
     * @return
     * </pre>
     **/
    public PageResultData(List<?> dataAndPage, List<T> data) {
        com.github.pagehelper.PageInfo pageHelper = new com.github.pagehelper.PageInfo(dataAndPage);
        this.Data = data;
        this.pageNum = pageHelper.getPageNum();
        this.pageSize = pageHelper.getPageSize();
        this.size = pageHelper.getSize();
        this.startRow = pageHelper.getStartRow();
        this.endRow = pageHelper.getEndRow();
        this.pages = pageHelper.getPages();
        this.recordCounts = (int) pageHelper.getTotal();
        this.prePage = pageHelper.getPrePage();
        this.nextPage = pageHelper.getNextPage();
        this.isFirstPage = pageHelper.isIsFirstPage();
        this.isLastPage = pageHelper.isIsLastPage();

        //分页信息记录行号及分页结束记录行号校验修正
        checkSetPageStartEndRow();
    }

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-17 16:42
     * @Description
     * @param data
     * @return
     * </pre>
     **/
    public PageResultData(PageResult<T> data) {
        this.Data = data.getData();
        this.pageNum = data.getPageNum();
        this.pageSize = data.getPageSize();
        this.size = data.getSize();
        this.startRow = data.getStartRow();
        this.endRow = data.getEndRow();
        this.pages = data.getPages();
        this.recordCounts = data.getRecordCounts();
        this.isFirstPage = data.isFirstPage();
        this.isLastPage = data.isLastPage();

        //分页信息记录行号及分页结束记录行号校验修正
        checkSetPageStartEndRow();
    }

    /**
     * <pre> 分页信息记录行号及分页结束记录行号校验修正
     * @Author litao.yi
     * @Date 2020-10-18 16:36
     * @Description 分页信息记录行号及分页结束记录行号校验修正
     * @return>
     * </pre>
     **/
    private void checkSetPageStartEndRow(){
        //分页存在记录
        if (size > 0) {
            //分页开始记录行号及分页结束记录行号（修正）
            if (startRow == 0) {
                startRow = 1;
                endRow = endRow + 1;
            } else {
                int newStartRow = (pageNum - 1) * pageSize;
                if (startRow == newStartRow) {
                    startRow = startRow + 1;
                    endRow = endRow + 1;
                }
            }
        }
    }

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-17 16:39
     * @Description
     * @param data
     * @return PageResultData<T>
     * </pre>
     **/
    public static <T> PageResultData<T> trans(PageResult<T> data) {
        return new PageResultData(data);
    }

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-17 16:14
     * @Description
     * @param data
     * @return PageResultData<T>
     * </pre>
     **/
    public static <T> PageResultData<T> trans(List<T> data) {
        return new PageResultData(data);
    }

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-17 16:14
     * @Description
     * @param dataAndPage
     * @param data
     * @return PageResultData<T>
     * </pre>
     **/
    public static <T> PageResultData<T> trans(List<?> dataAndPage, List<T> data) {
        return new PageResultData(dataAndPage, data);
    }

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-23 9:46
     * @Description
     * @param pageResultData
     * @return cn.hsa.hsaf.core.framework.util.PageResult<T>
     * </pre>
     **/
    public static PageResult trans(PageResultData pageResultData) {
        PageResult pageResult = new PageResult();
        pageResult.setData(pageResultData.getData());
        pageResult.setPageNum(pageResultData.getPageNum());
        pageResult.setPageSize(pageResultData.getPageSize());
        pageResult.setSize(pageResultData.getSize());
        pageResult.setStartRow(pageResultData.getStartRow());
        pageResult.setEndRow(pageResultData.getEndRow());
        pageResult.setPages(pageResultData.getPages());
        pageResult.setRecordCounts(pageResultData.getRecordCounts());
        pageResult.setFirstPage(pageResultData.isFirstPage());
        pageResult.setLastPage(pageResultData.isLastPage());
        return pageResult;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getRecordCounts() {
        return recordCounts;
    }

    public void setRecordCounts(int recordCounts) {
        this.recordCounts = recordCounts;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> data) {
        Data = data;
    }
}
