package lazy;

/**
 * Singleton with lazy initialization
 * <p>
 * + The simple one
 * + The instance is created only when we need it
 * + Client's app can pass parameters
 * + Provides option for exception handler
 * + We can change this class and make it not Singleton without changing its API
 * <p>
 * - Isn't thread-safe (multiple threads can get different instances of lazy.SingletonThree)
 * - Can be destroyed with setAccessible(true) method
 */
public class SingletonThree {
    private static SingletonThree singleton;

    /**
     * Message is used for testing
     */
    private SingletonThree() {
        System.out.println("- SingletonThree is created");
    }

    public static SingletonThree getInstance() {
        if (singleton == null) {
            singleton = new SingletonThree();
        }
        return singleton;
    }

    public static void test(){
        System.out.println("- Test");
    }
}
