package com.tools;
import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * @author gx
 * @ClassName: GroupByUtil
 * @Description: groupBy工具类
 * @date 2018/12/17 14:32
 * @Version: 1.0
 * @since
 */
public class GroupByUtil {
	public static <T> Map groupBy(String sumFiled,List<T> list,String ...groupByFileds) throws Exception{
		List<T> resultList=new ArrayList<>();
		Map<String,Integer> map=new HashMap<>(16);
		for(T t:list){
			StringBuilder keyBuilder=new StringBuilder();
			for (String k:groupByFileds) {
				PropertyDescriptor pd = new PropertyDescriptor(k, t.getClass());
				keyBuilder.append(pd.getReadMethod().invoke(t)+"#");
			}

			String key = keyBuilder.substring(0, keyBuilder.length() - 1);
			PropertyDescriptor pd = new PropertyDescriptor(sumFiled, t.getClass());
			if (map.get(key)!=null) {
				Integer sum = map.get(key);
				int total = sum + (int) pd.getReadMethod().invoke(t);
				map.put(key,total);
			}else {
				map.put(key, (int)pd.getReadMethod().invoke(t));
			}
		}
		return  map;
       /* Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
	        try {
		        T t = kind.newInstance();
		        Map.Entry entry = (Map.Entry) iter.next();
		        String key = (String) entry.getKey();
		        Integer val = (Integer) entry.getValue();
		        String[] values = key.split("#");
		        for (int i=0;i<values.length;i++) {
			        ReflectUtil.dynamicSetValue(t,groupByFileds[i],values[i]);
		        }
		        ReflectUtil.dynamicSetValue(t,sumFiled,val);
		        resultList.add(t);
	        } catch (InstantiationException e) {
		        e.printStackTrace();
	        } catch (IllegalAccessException e) {
		        e.printStackTrace();
	        }
        }
		return resultList;*/
	}

}
