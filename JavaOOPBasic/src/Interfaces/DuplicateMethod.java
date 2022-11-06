package Interfaces;

/**
 * Interfaces can not have constructor
 * Interfaces can not have implemented public methods without default keyword
 */
public interface DuplicateMethod {
    void doSomething();

    default void callPrivate() {
        iAmPrivate();
    }
    private void iAmPrivate() {
        System.out.println("I am Private method inside Interface");
    }


}
