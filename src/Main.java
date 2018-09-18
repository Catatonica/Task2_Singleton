import java.io.IOException;

/**
 * Testing various singleton classes you can:
 * <p>
 * - notice the difference between eager and lazy initialization
 * (compare SingletonOne and SingletonTwo, 11-12 lines );
 * - see how we can destroy Singleton pattern using Reflection
 * (on the example of SingletonSix, 17 line);
 * - test Serialization with Singleton pattern
 * (on the example of SingletonEleven, 22 line)
 *
 * @author Lizaveta Havina
 * @version 18.09.2018
 */
class Main {
    public static void main(String[] args) {
        SingletonsTest test = new SingletonsTest();

        test.simpleTestSingletonOne();
        test.simpleTestSingletonThree();

        test.destroySingletonSixPattern();

        try {
            test.testSerializingOnSingletonEleven();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
