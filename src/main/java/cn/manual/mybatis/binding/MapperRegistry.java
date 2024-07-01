package cn.manual.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import cn.manual.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yangkaixuan
 */
public class MapperRegistry {

    private final Map<Class<?>, MapperProxyFactory<?>> knowsMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knowsMappers.get(type);
        if (null == mapperProxyFactory){
            throw new RuntimeException("Type" + type + " is not known to the MapperRegistry");
        }
        try{
            return mapperProxyFactory.newInstance(sqlSession);
        }catch (Exception e){
            throw new RuntimeException("Error getting the mapper instance. Cause: " + e.getMessage());
        }
    }

    public <T> void addMapper(Class<T> type){
        if (type.isInterface()){
            if (hasMapper(type)){
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            knowsMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public void addMappers(String packageName){
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        mapperSet.forEach(this::addMapper);
    }

    private <T> boolean hasMapper(Class<T> type) {
        return knowsMappers.containsKey(type);
    }


}
