package lazy.thread_safe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Singleton with ReentrantLock
 * <p>
 * + The instance is created only when we need it
 * + Is thread-safe
 * + Is more efficiently than with synchronization
 * + Provides option for exception handler
 * + We can change this class and make it not Singleton without changing its API
 * <p>
 * - Is more complex
 * - Needs extra 'lock' object
 * - Can be destroyed with setAccessible(true) method
 */
public class SingletonEight {
    private static SingletonEight singleton;
    private static ReentrantLock lock = new ReentrantLock();

    private SingletonEight() {

    }

    public static SingletonEight getInstance() {
        lock.lock();
        try {
            if (singleton == null) {
                singleton = new SingletonEight();
            }
        } finally {
            lock.unlock();
        }
        return singleton;
    }
}
