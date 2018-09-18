package lazy.thread_safe;

import java.io.Serializable;

/**
 * Serialized class with transient final singleton field example
 */
public class SingletonTwelve implements Serializable {
    private static transient final SingletonTwelve singleton = new SingletonTwelve();

    private SingletonTwelve() {
    }

    public static SingletonTwelve getInstance() {
        return singleton;
    }

    private Object readResolve() {
        return singleton;
    }
}
