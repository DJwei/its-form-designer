package cn.hsa.its.cache.impl;

import cn.hsa.its.cache.MemoryDb;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 医保-刘勇
 * @date 2020-12-22 16:35
 **/
@Component
public class MemoryDbImpl implements MemoryDb {

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public void set(String key, int nSec, Object value) {
        getValueOperations().set(key, value);
        if (nSec > 0) {
            expire(key, nSec);
        }
    }

    @Override
    public Object get(String key) {
        return getValueOperations().get(key);
    }

    @Override
    public void expire(String key, int nSec) {
        if (nSec == 0) {
            return;
        }
        if (key == null || key.trim().length() == 0) {
            return;
        }
        redisTemplate.expire(key, nSec, TimeUnit.SECONDS);
    }

    @Override
    public boolean existKey(String key) {
        Boolean flag = redisTemplate.hasKey(key);
        if (flag == null){
            flag = false;
        }
        return flag;
    }

    @Override
    public Long delete(String key) {
        if (key == null || key.trim().length() == 0) {
            return 0L;
        }
        Boolean isDelete = redisTemplate.delete(key);
        if (isDelete == null || !isDelete) {
            return 0L;
        }
        return 1L;
    }

    @Override
    public Long plusLong(String key, long incrNum) {
        return getValueOperations().increment(key, incrNum);
    }

    @Override
    public Long plusMapLong(String mapName, String key, long incrNum) {
        return getHashOperations().increment(mapName, key, incrNum);
    }

    @Override
    public Long plusLong(String key, int nSec, long incrNum) {
        Long nRet = plusLong(key, incrNum);
        expire(key, nSec);
        return nRet;
    }

    @Override
    public void setLong(String key, int nSec, long value) {
        getValueOperations().set(key, value);
        expire(key, nSec);
    }

    @Override
    public void setMapLong(String mapName, String key, long value) {
        getHashOperations().put(mapName, key, value);
    }

    @Override
    public Long getLong(String key) {
        return (Long) getValueOperations().get(key);
    }

    @Override
    public Long getMapLong(String mapName, String key) {
        return (Long) getHashOperations().get(mapName, key);
    }

    @Override
    public Double plusDouble(String key, double incrNum) {
        return getValueOperations().increment(key, incrNum);
    }

    @Override
    public Double plusMapDouble(String mapName, String key, double incrNum) {
        return getHashOperations().increment(mapName, key, incrNum);
    }

    @Override
    public Double plusDouble(String key, int nSec, double incrNum) {
        expire(key, nSec);
        return plusDouble(key, incrNum);
    }

    @Override
    public void setDouble(String key, int nSec, double value) {
        set(key, nSec, value);
    }

    @Override
    public void setMapDouble(String mapName, String key, double value) {
        setMapValue(mapName, key, value);
    }

    @Override
    public Double getDouble(String key) {
        return (Double) get(key);
    }

    @Override
    public Double getMapDouble(String mapName, String key) {
        return (Double) getMapValue(mapName, key);
    }

    @Override
    public void initMap(String mapName, int nSec, Map map) {
        delete(mapName);
        getHashOperations().putAll(mapName, map);
        expire(mapName, nSec);
    }

    @Override
    public void addToMap(String mapName, Map map) {
        getHashOperations().putAll(mapName, map);
    }

    @Override
    public void setMapValue(String mapName, String key, Object value) {
        getHashOperations().put(mapName, key, value);
    }

    @Override
    public boolean existMapKey(String mapName, String key) {
        return getHashOperations().hasKey(mapName, key);
    }

    @Override
    public Map getMap(String mapName) {
        return getHashOperations().entries(mapName);
    }

    @Override
    public Object getMapValue(String mapName, String key) {
        return getHashOperations().get(mapName, key);
    }

    @Override
    public Long removeMapValue(String mapName, String key) {
        return getHashOperations().delete(mapName, key);
    }

    @Override
    public int getMapSize(String mapName) {
        return getHashOperations().size(mapName).intValue();
    }

    @Override
    public void initList(String listName, int nSec, List list) {
        delete(listName);
        getListOperations().leftPushAll(listName, list);
        expire(listName, nSec);
    }

    @Override
    public long insertListAtBegin(String listName, Object value) {
        Long l = getListOperations().leftPush(listName, value);
        if (l == null){
            l = 0L;
        }
        return l;
    }

    /**
     * 向list列表的头部添加指定的元素
     *
     * @param listName
     * @param value
     */
    @Override
    public long insertListAtBeginList(String listName, List value) {
        Long l = getListOperations().leftPushAll(listName, value);
        if (l == null){
            l = 0L;
        }
        return l;
    }

    @Override
    public long insertListAtEnd(String listName, Object value) {
        Long l = getListOperations().rightPush(listName, value);
        if (l == null){
            l = 0L;
        }
        return l;
    }

    /**
     * 向list列表的尾部添加指定的元素
     *
     * @param listName
     * @param value
     */
    @Override
    public long insertListAtEndList(String listName, List value) {
        Long l = getListOperations().rightPushAll(listName, value);
        if (l == null){
            l = 0L;
        }
        return l;
    }

    @Override
    public void ltrim(String listName, int nBegin, int nEnd) {
        getListOperations().trim(listName, nBegin, nEnd);
    }

    @Override
    public Object getListValue(String listName, int index) {
        return getListOperations().index(listName, index);
    }

    @Override
    public List getList(String listName, int start, int end) {
        return getListOperations().range(listName, start, end);
    }

    @Override
    public Object getAndRemoveListValueAtBegin(String listName) {
        return getListOperations().leftPop(listName);
    }

    /**
     * Description: 从List中去除前面指定长度的值，并返回List
     * Creator 李磊(cn32040)
     *
     * @param listName : List key 值
     * @param size     : 要取List的长度
     * @return {@link List}
     * @author 李磊(cn32040)
     * date 2021-11-04 11:26
     */
    @Override
    public List getListAndRemoveListValueAtBegin(String listName, int size) {
        List list;
        //获取当前list的长度
        int currentSize = getListSize(listName);
        //如果当前list长度为0，则返回空list
        if (currentSize == 0){
            return Collections.emptyList();
        }
        //如果当前list长度小于等于size，则返回整个list,并删除list缓存。否则取出指定长度的list，并裁剪掉取出的长度
        if (currentSize <= size){
            list = getList(listName, 0, -1);
            delete(listName);
        }else {
            int end = size - 1;
            list = getList(listName, 0, end);
            ltrim(listName, size, currentSize - 1);
        }
        return list;
    }

    @Override
    public Object getAndRemoveListValueAtBegin(String listName, int nWaitSecond) {
        return getListOperations().leftPop(listName, nWaitSecond, TimeUnit.SECONDS);
    }

    @Override
    public Object getAndRemoveListValueAtEnd(String listName) {
        return getListOperations().rightPop(listName);
    }

    /**
     * Description: 从List中取出后面指定长度的值，并返回List
     * Creator 李磊(cn32040)
     *
     * @param listName : List key 值
     * @param size     : 要取List的长度
     * @return {@link List}
     * @author 李磊(cn32040)
     * date 2021-11-04 11:26
     */
    @Override
    public List getListAndRemoveListValueAtEnd(String listName, int size) {
        List list;
        //获取当前list的长度
        int currentSize = getListSize(listName);
        //如果当前list长度为0，则返回空list
        if (currentSize == 0){
            return Collections.emptyList();
        }
        //如果当前list长度小于等于size，则返回整个list,并删除list缓存。否则取出指定长度的list，并裁剪掉取出的长度
        if (currentSize <= size){
            list = getList(listName, 0, -1);
            delete(listName);
        }else {
            int start = currentSize - size;
            int end = currentSize - 1;
            list = getList(listName, start, end);
            ltrim(listName, 0, start - 1);
        }
        return list;
    }

    @Override
    public Object getAndRemoveListValueAtEnd(String listName, int nWaitSecond) {
        return getListOperations().rightPop(listName, nWaitSecond, TimeUnit.SECONDS);
    }

    @Override
    public int getListSize(String listName) {
        Long size = getListOperations().size(listName);
        if (size == null){
            size = 0L;
        }
        return size.intValue();
    }

    /**
     * Description: 获取自增ID
     * Creator 李磊(cn32040)
     *
     * @param key :
     * @return {@link String}
     * @author 李磊(cn32040)
     * date 2021-12-01 20:42
     */
    @Override
    public String getIncrementId(String key) {
        if (StringUtils.isBlank(key)) {
            return "";
        }
        key = key.toUpperCase();
        String dateStr = DateUtil.format(new Date(), "yyyyMMdd");
        return dateStr + plusLong(key, 1);
    }

    /**
     * Description: 获取随机ID
     * Creator 李磊(cn32040)
     *
     * @return {@link String}
     * @author 李磊(cn32040)
     * date 2021-12-01 20:42
     */
    @Override
    public String getRowId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private ValueOperations<Object, Object> getValueOperations() {
        return redisTemplate.opsForValue();
    }

    private HashOperations<Object, Object, Object> getHashOperations() {
        return redisTemplate.opsForHash();
    }

    private ListOperations<Object, Object> getListOperations() {
        return redisTemplate.opsForList();
    }
}
