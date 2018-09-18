package bloch;

/**
 * Joshua Bloch Singleton
 * <p>
 * + Very simple
 * + Enum guaranties that any enum value is instantiated only once
 * + Can't be destroyed with setAccessible(true) method
 * + Offers serialization
 * <p>
 * - It's inflexible
 * - It doesn't allow lazy initialization
 * - We can't change this class and make it not Singleton without changing its API
 */
public enum SingletonSeven {
    INSTANCE;
}
