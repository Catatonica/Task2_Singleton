package lazy.thread_safe;

import java.io.Serializable;

/**
 * Serialized Singleton with nested Helper class example
 */
public class SingletonEleven implements Serializable{

    private SingletonEleven() {

    }

    private static class Helper {
        private static final SingletonEleven singleton = new SingletonEleven();
    }

    public static SingletonEleven getInstance() {
        return Helper.singleton;
    }

    private Object readResolve(){
        return Helper.singleton;
    }
}
