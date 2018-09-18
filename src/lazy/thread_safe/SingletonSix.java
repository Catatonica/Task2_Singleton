package lazy.thread_safe;

/**
 * Bill Pugh Singleton
 * <p>
 * + The instance is created only when we need it
 * (the class 'Helper' with Singleton's instance is created only when we call getInstance() method)
 * + Is thread-safe
 * + Doesn't require synchronization
 * + We can change this class and make it not Singleton without changing its API
 * <p>
 * - The client app can't pass any arguments
 * - Doesn't provide any options for errors handling
 * - Needs extra class
 * - Can be destroyed with setAccessible(true) method
 */
public class SingletonSix {
    private SingletonSix() {
        System.out.println(" SingletonSix is created");
    }

    private static class Helper {
        private static final SingletonSix INSTANCE = new SingletonSix();
    }

    public static SingletonSix getInstance() {
        return Helper.INSTANCE;
    }
}
