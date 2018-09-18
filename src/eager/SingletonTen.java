package eager;

/**
 *  Singleton with public final field
 *
 * + The very simple and clear realization
 * + Thread safety without synchronization
 * <p>
 * - The instance is created at the time of class loading (whether we're going to use it or not)
 * - Doesn't provide any options for errors handling
 * - The client app can't pass any arguments
 * - Can be destroyed with setAccessible(true) method
 * - We can't change this class and make it not Singleton without changing its API
 */
public class SingletonTen {
    public static final SingletonTen singleton = new SingletonTen();

    private SingletonTen() {

    }
}
