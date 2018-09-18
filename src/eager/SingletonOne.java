package eager;

/**
 * Eager initialized Singleton
 * <p>
 * + The very simple realization
 * + Thread safety without synchronization
 * + We can change this class and make it not Singleton without changing its API
 * <p>
 * - The instance is created at the time of class loading (whether we're going to use it or not)
 * - Doesn't provide any options for errors handling
 * - The client app can't pass any arguments
 * - Can be destroyed with setAccessible(true) method
 * <p>
 * It's not recommended to create any other static methods there if we use this Singleton pattern,
 * cause when we invoke any of them, the singleton instance will be created.
 */
public class SingletonOne {
    private static final SingletonOne singleton = new SingletonOne();

    public static void test() {
        System.out.println("- Test");
    }

    /**
     * Message is used for testing
     */
    private SingletonOne() {
        System.out.println("- SingletonOne is created");
    }

    public static SingletonOne getInstance() {
        return singleton;
    }
}
