package lazy.thread_safe;

/**
 * Singleton with volatile
 * <p>
 * The same advantages and disadvantages as in SingletonFive, but thank to 'volatile'
 * there's no chance to get outdated data in multithreaded app
 */
public class SingletonNine {
    private static SingletonNine singleton;
    private volatile static boolean instanceCreated;

    private SingletonNine() {

    }

    public static SingletonNine getInstance() {
        if (!instanceCreated) {
            synchronized (SingletonNine.class) {
                if (!instanceCreated) {
                    singleton = new SingletonNine();
                    instanceCreated = true;
                }
            }
        }
        return singleton;
    }
}
