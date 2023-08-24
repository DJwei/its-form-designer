package cn.hsa.its.cache;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * @Author 医保-刘勇
 * @Date 2020-07-07 8:37
 * @return
 * </pre>
 **/
public interface MemoryDb {

    /**
     * 设置缓存内容
     *
     * @param key
     * @param nSec  缓存时间，单位：秒。 值为0：不设置缓存时间
     * @param value
     */
    void set(String key, int nSec, Object value);

    /**
     * 读取缓存value
     *
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 设置给定key的生存时间
     *
     * @param key
     * @param nSec 秒
     */
    void expire(String key, int nSec);

    /**
     * 判断给定的key是否存在
     *
     * @param key
     * @return
     */
    boolean existKey(String key);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:49
     * @Description 根据key删除缓存
     * @param key
     * @return java.lang.Long
     * </pre>
     **/
    Long delete(String key);

    /**
     * 针对value为Long类型 增加setLong()，getLong()，plusLong()方法
     * 给指定的key增加整数值（并发支持原子操作），如果key第一次调用，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作
     *
     * @param key
     * @param incrNum 整数值，正负都支持
     * @return
     */
    Long plusLong(String key, long incrNum); //基于独立key的plusLong

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:47
     * @Description
     * @param mapName
     * @param key
     * @param incrNum
     * @return java.lang.Long
     * </pre>
     **/
    Long plusMapLong(String mapName, String key, long incrNum); //基于HashMap的PlusLong

    /**
     * 带超时的plus，第一次调用确定了超时，后续调用不会增加生命时间
     *
     * @param key
     * @param nSec
     * @param incrNum
     * @return
     */
    Long plusLong(String key, int nSec, long incrNum);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:48
     * @Description
     * @param key
     * @param nSec
     * @param value
     * @return void
     * </pre>
     **/
    void setLong(String key, int nSec, long value);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:48
     * @Description
     * @param mapName
     * @param key
     * @param value
     * @return void
     * </pre>
     **/
    void setMapLong(String mapName, String key, long value);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:48
     * @Description
     * @param key
     * @return java.lang.Long
     * </pre>
     **/
    Long getLong(String key);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:48
     * @Description
     * @param mapName
     * @param key
     * @return java.lang.Long
     * </pre>
     **/
    Long getMapLong(String mapName, String key);

    /**
     * 针对value为Double类型 增加setDouble()，getDouble()，plusDouble()方法
     * 给指定的key增加整数值（并发支持原子操作），那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作
     *
     * @param key
     * @param incrNum 整数值，正负都支持
     * @return
     */
    Double plusDouble(String key, double incrNum);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:49
     * @Description
     * @param mapName
     * @param key
     * @param incrNum
     * @return java.lang.Double
     * </pre>
     **/
    Double plusMapDouble(String mapName, String key, double incrNum);

    /**
     * 带超时的plus，第一次调用确定了超时，后续调用不会增加生命时间
     *
     * @param key
     * @param nSec
     * @param incrNum
     * @return
     */
    Double plusDouble(String key, int nSec, double incrNum);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:48
     * @Description
     * @param key
     * @param nSec
     * @param value
     * @return void
     * </pre>
     **/
    void setDouble(String key, int nSec, double value);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:48
     * @Description
     * @param mapName
     * @param key
     * @param value
     * @return void
     * </pre>
     **/
    void setMapDouble(String mapName, String key, double value);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:48
     * @Description
     * @param key
     * @return java.lang.Double
     * </pre>
     **/
    Double getDouble(String key);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:48
     * @Description
     * @param mapName
     * @param key
     * @return java.lang.Double
     * </pre>
     **/
    Double getMapDouble(String mapName, String key);

    /**
     * 初始化map缓存
     * 根据mapName缓存 map
     *
     * @param mapName
     * @param nSec    缓存时间，单位：秒。 值为0：不设置缓存时间
     * @param map
     */
    void initMap(String mapName, int nSec, Map map);

    /**
     * 以批处理pipeline的方式，高速将一个map设置到redis的map去合并
     *
     * @param mapName
     * @param map
     */
    void addToMap(String mapName, Map map);

    /**
     * 缓存map设置值
     *
     * @param mapName
     * @param key
     * @param value
     */
    void setMapValue(String mapName, String key, Object value);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:48
     * @Description
     * @param mapName
     * @param key
     * @return boolean
     * </pre>
     **/
    boolean existMapKey(String mapName, String key);

    /**
     * 返回map中所有元素， 默认返回全部元素
     *
     * @param mapName
     * @return
     */
    Map getMap(String mapName);

    /**
     * 如果存在一个键的映射关系，则将其从此映射中的值返回
     *
     * @param mapName
     * @param key
     * @return
     */
    Object getMapValue(String mapName, String key);

    /**
     * <pre>
     * @Author 医保-刘勇
     * @Date 2020-07-07 8:49
     * @Description 如果存在一个键的映射关系，则将其从此映射中移除
     * @param mapName
     * @param key
     * @return java.lang.Long
     * </pre>
     **/
    Long removeMapValue(String mapName, String key);

    /**
     * 返回此映射中的键-值映射关系数
     *
     * @param mapName
     * @return
     */
    int getMapSize(String mapName);

    /**
     * 初始化list缓存
     *
     * @param listName
     * @param nSec     缓存时间，单位：秒。 值为0：不设置缓存时间
     * @param list
     */
    void initList(String listName, int nSec, List list);

    /**
     * 向list列表的头部添加指定的元素
     *
     * @param listName
     * @param value
     */

    long insertListAtBegin(String listName, Object value);

    /**
     * 向list列表的头部添加指定的元素
     *
     * @param listName
     * @param value
     */

    long insertListAtBeginList(String listName, List value);

    /**
     * 向list列表的尾部添加指定的元素
     *
     * @param listName
     * @param value
     */
    long insertListAtEnd(String listName, Object value);


    /**
     * 向list列表的尾部添加指定的元素
     *
     * @param listName
     * @param value
     */
    long insertListAtEndList(String listName, List value);

    /**
     * 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
     * ltrim(0,99)表示保留队列前100个
     *
     * @param listName
     * @param nBegin   开始值
     * @param nEnd     截止
     */
    void ltrim(String listName, int nBegin, int nEnd);

    /**
     * 返回list列表中指定位置元素
     *
     * @param listName
     * @param index
     * @return
     */
    Object getListValue(String listName, int index);

    /**
     * 返回list列表中指定偏移量元素集合，start=0,end=-1认返回全部元素
     *
     * @param listName
     * @param start    0
     * @param end      -1
     * @return
     */
    List getList(String listName, int start, int end);

    /**
     * 返回并移除list第一个元素， 非阻塞式弹出
     *
     * @param listName
     * @return
     */
    Object getAndRemoveListValueAtBegin(String listName);

    /**
     * Description: 从List中去除前面指定长度的值，并返回List
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-11-04 11:26
     * @param listName: List key 值
     * @param size: 要取List的长度
     * @return {@link List}
     */
    List getListAndRemoveListValueAtBegin(String listName, int size);

    /**
     * 返回并移除list第一个元素， 阻塞式弹出
     *
     * @param listName
     * @param nWaitSecond 0表示：阻塞式
     * @return
     */
    Object getAndRemoveListValueAtBegin(String listName, int nWaitSecond);

    /**
     * 返回并移除list最后一个元素， 非阻塞式弹出
     *
     * @param listName
     * @return
     */
    Object getAndRemoveListValueAtEnd(String listName);

    /**
     * Description: 从List中取出后面指定长度的值，并返回List
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-11-04 11:26
     * @param listName: List key 值
     * @param size: 要取List的长度
     * @return {@link List}
     */
    List getListAndRemoveListValueAtEnd(String listName, int size);

    /**
     * 返回并移除list最后一个元素， 阻塞式弹出
     *
     * @param listName
     * @param nWaitSecond 0表示：阻塞式
     * @return
     */
    Object getAndRemoveListValueAtEnd(String listName, int nWaitSecond);

    /**
     * 返回list列表中的元素数
     *
     * @param listName
     * @return
     */
    int getListSize(String listName);

    /**
     * Description: 获取自增ID
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 20:42
     * @param key:
     * @return {@link String}
     */
    String getIncrementId(String key);

    /**
     * Description: 获取随机ID
     * Creator 李磊(cn32040)
     * @author 李磊(cn32040)
     * date 2021-12-01 20:42
     * @return {@link String}
     */
    String getRowId();
}
