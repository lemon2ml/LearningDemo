package com.lei.blogtemp;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        // WeakHashMap w = new WeakHashMap();
        // // 三个key-value中的key 都是匿名对象，没有强引用指向该实际对象
        // w.put(new String("语文"), new String("优秀"));
        // w.put(new String("数学"), new String("及格"));
        // w.put(new String("英语"), new String("中等"));
        // // 增加一个字符串的强引用
        // w.put("java", new String("特别优秀"));
        // System.out.println(w);
        // // 通知垃圾回收机制来进行回收
        // System.gc();
        // System.runFinalization();
        // // 再次输出w
        // System.out.println("第二次输出:" + w);
        ////
        String res = test2();
        System.out.println(res);
    }

    private static String test() {
        String a = new String("a");
        WeakReference<String> b = new WeakReference<String>(a);
        WeakHashMap<String, Integer> weakMap = new WeakHashMap<String, Integer>();
        weakMap.put(b.get(), 1);
        a = null;
        System.gc();
        String c = "";
        try {
            c = b.get().replace("a", "b");
            return c;
        } catch (Exception e) {
            c = "c";
            return c;
        } finally {
            c += "d";
            return c + "e";
        }
    }

    private static String test2() {
        String a = new String("a");
        // System.out.println(a);
        WeakReference<String> b = new WeakReference<String>(a);
        // System.out.println(b.get());
        WeakHashMap<String, Integer> weakMap = new WeakHashMap<String, Integer>();
        weakMap.put(b.get(), 1);
        a = null;
        System.out.println("GC前b.get()：" + b.get());
        System.out.println("GC前weakMap：" + weakMap);
        System.gc();
        System.out.println("GC后" + b.get());
        System.out.println("GC后" + weakMap);
        String c = "";
        try {
            c = b.get().replace("a", "b");
            System.out.println("C:" + c);
            return c;
        } catch (Exception e) {
            c = "c";
            System.out.println("Exception");
            return c;
        } finally {
            c += "d";
            return c + "e";
        }
    }
}
