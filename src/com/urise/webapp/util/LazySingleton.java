package com.urise.webapp.util;

/**
 * Created by OK on 12.06.2017.
 */
public class LazySingleton {
    int i;
    volatile private static LazySingleton INSTANCE = new LazySingleton();

    double sin = Math.sin(13.);

    private LazySingleton() {
    }

    private static class LazySingletonHolder{
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
    public static LazySingleton getInstance()
   {
       return LazySingletonHolder.INSTANCE;
//        if(INSTANCE==null){
//            synchronized (LazySingleton.class) {
//                if(INSTANCE==null) {
//                    int i = 13;
//                    INSTANCE = new LazySingleton();
//                }
//            }
//        }
//        return INSTANCE;
    }


}
