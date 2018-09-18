

import eager.SingletonOne;
import lazy.SingletonThree;
import lazy.thread_safe.SingletonEleven;
import lazy.thread_safe.SingletonSix;

import java.io.*;
import java.lang.reflect.Constructor;

class SingletonsTest {
    /**
     * We see that SingletonOne's instance is created when we firstly do some stuff with its class,
     * whether we have plans for using it or not.
     * <p>
     * ( The same behavior has SingletonTwo )
     */
    void simpleTestSingletonOne() {
        System.out.println("\n Testing SingletonOne (Simple testing)...");
        System.out.println(" Doing some other stuff...");
        SingletonOne.test();
        System.out.println(" Getting instance...");
        SingletonOne instanceOne = SingletonOne.getInstance();
        int hashCodeVerOne = instanceOne.hashCode();
        System.out.println(" Instance1 hashCode = " + hashCodeVerOne);
        System.out.println(" Getting instance...");
        SingletonOne instanceTwo = SingletonOne.getInstance();
        int hashCodeVerTwo = instanceTwo.hashCode();
        System.out.println(" Instance2 hashCode = " + instanceTwo.hashCode());
        if (hashCodeVerOne == hashCodeVerTwo) {
            System.out.println(" Success! :)");
        } else {
            System.out.println(" Failed! :(");
        }
    }

    /**
     * In comparison with eager initialization in the lazy one the instance is created at the moment
     * we really need it.
     * <p>
     * ( The same behavior have all singletons under the 'lazy' folder )
     */
    void simpleTestSingletonThree() {
        System.out.println("\n Testing SingletonThree (Simple testing)...");
        System.out.println(" Doing some other stuff...");
        SingletonThree.test();
        System.out.println(" Getting instance...");
        SingletonThree instanceOne = SingletonThree.getInstance();
        int hashCodeVerOne = instanceOne.hashCode();
        System.out.println(" Instance1 hashCode = " + hashCodeVerOne);
        System.out.println(" Getting instance...");
        SingletonThree instanceTwo = SingletonThree.getInstance();
        int hashCodeVerTwo = instanceTwo.hashCode();
        System.out.println(" Instance2 hashCode = " + instanceTwo.hashCode());
        if (hashCodeVerOne == hashCodeVerTwo) {
            System.out.println(" Success! :)");
        } else {
            System.out.println(" Failed! :(");
        }
    }

    /**
     * Using Reflection we can destroy SingletonSix pattern by force setting its constructor accessible.
     * <p>
     * ( The same thing happens to all SingletonX under 'eager' and 'lazy' folders)
     */
    void destroySingletonSixPattern() {
        System.out.println("\n Destroying SingletonSix pattern...");
        SingletonSix instanceOne = SingletonSix.getInstance();
        System.out.println(" Instance1 hashCode = " + instanceOne.hashCode());
        SingletonSix instanceTwo = null;
        try {
            Constructor[] constructors = SingletonSix.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (SingletonSix) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert instanceTwo != null;
        System.out.println(" Instance2 hashCode = " + instanceTwo.hashCode());
    }

    // The same behavior has SingletonTwelve
    void testSerializingOnSingletonEleven() throws IOException, ClassNotFoundException {
        System.out.println("\n Testing serialized SingletonEleven...");
        SingletonEleven instanceOne = SingletonEleven.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton_eleven.ser"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("singleton_eleven.ser"));
        SingletonEleven instanceTwo = (SingletonEleven) in.readObject();
        in.close();

        System.out.println(" Instance1 hashCode=" + instanceOne.hashCode());
        System.out.println(" Instance2 hashCode=" + instanceTwo.hashCode());
    }
}
