/*
 * FileName: linkedHashMapForLRU.java
 * Author:   bm
 * Date:     2021-06-23 00:40:29
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2021-06-23 00:40:29> <version> <desc> <source>
 *
 */

package wk.algorithm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class linkedHashMapForLRU {


    public static void main(String[] args) {
        testCachLru();
    }
    public static  void testCachLru() {
        LinkedHashMap<Integer, Integer> cach = new LinkedHashMap(5, 0.75f, true){

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if(this.size()>5) return true;
                else return false;
            }
        };
        for (int i = 0; i < 5; i++) {
            cach.put(i, i);


        }

        System.out.println("test"+ cach.get(0));
        cach.put(5, 5);
        for (Iterator<Map.Entry<Integer, Integer>> it = cach.entrySet().iterator(); it.hasNext(); ) {
            System.out.println(it.next().getKey());

        }
    }


}
