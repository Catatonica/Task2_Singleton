package lazy.thread_safe;

/**
 * Double Checked Locking Singleton
 * <p>
 * + The instance is created only when we need it
 * + Is thread-safe (only one thread can execute the synchronized block at a time)
 * + Ensures that only one instance of singleton class is created
 * + Client application can pass parameters
 * + Provides option for exception handler
 * + Synchronization overhead is minimal in comparison with singletons.lazy.thread_safe.SingletonFour
 * + We can change this class and make it not Singleton without changing its API
 * <p>
 * - More complex
 * - Extra if condition
 * - Can be destroyed with setAccessible(true) method
 */
public class SingletonFive {
    private static SingletonFive singleton;

    private SingletonFive() {

    }

    public static SingletonFive getInstance() {
        if (singleton == null) {
            synchronized (SingletonFive.class) {
                if (singleton == null) {
                    singleton = new SingletonFive();
                }
            }
        }
        return singleton;
    }
}
