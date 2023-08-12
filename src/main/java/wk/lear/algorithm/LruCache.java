package wk.lear.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache extends LinkedHashMap {

   private int maxCacheSize;
    public LruCache(int maxCacheSize){

        //false 就是FIFO 队列
        super(maxCacheSize,0.75f,true);
        this.maxCacheSize=maxCacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>maxCacheSize;
    }

    public static void main(String[] args) {
        LruCache chche=new LruCache(5);
        for (int i= 0; i< 10; i++) {
            chche.put(i,i);
            System.out.println(chche.get(0));
        }
        System.out.println(chche.get(9));
        System.out.println(chche.values());
    }
}
