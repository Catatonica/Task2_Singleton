package eager;

/**
 * Singleton with static block initialization
 * <p>
 * + The simple one
 * + Provides option for exception handler
 * + Thread safety without synchronization
 * + We can change this class and make it not Singleton without changing its API
 * <p>
 * - The instance is created at the time of class loading (whether we're going to use it or not)
 * - The client app can't pass any arguments
 * - Can be destroyed with setAccessible(true) method
 * <p>
 * It's not recommended to create any other static methods there if we use this Singleton pattern,
 * cause when we invoke any of them, the singleton instance will be created.
 */
public class SingletonTwo {
    private static SingletonTwo singleton;

    private SingletonTwo() {

    }

    static {
        try {
            singleton = new SingletonTwo();
        } catch (Exception ex) {
            throw new RuntimeException("Exception during singleton initialization");
        }
    }

    public SingletonTwo getInstance() {
        return singleton;
    }
}
