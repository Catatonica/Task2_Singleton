package lazy.thread_safe;

/**
 * Simple thread-safe Singleton
 * <p>
 * + The simple one
 * + The instance is created only when we need it
 * + Is thread-safe (only one thread can execute this method at a time)
 * + Client application can pass parameters
 * + Provides option for exception handler
 * + We can change this class and make it not Singleton without changing its API
 * <p>
 * - Reduces the performance ( when some thread gets access to static synchronized method, it locks the Class,
 * which means that we cannot get access to any field or method from another thread at the same time)
 * - Unnecessary synchronization that is not required once the instance variable is already initialized
 * - Can be destroyed with setAccessible(true) method
 */
public class SingletonFour {
    private static SingletonFour singleton;

    private SingletonFour() {

    }

    public static synchronized SingletonFour getInstance() {
        if (singleton == null) {
            singleton = new SingletonFour();
        }
        return singleton;
    }
}
