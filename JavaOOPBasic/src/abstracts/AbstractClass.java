package abstracts;

/**
 * Abstract class can have multiple constructors
 * Abstract class can have zero abstract methods
 * Abstract class can have multiple abstract and implemented methods
 * Abstract Class can not have private abstract methods
 * Abstract class can have private implemented methods
 */
public abstract class AbstractClass {

    public AbstractClass() {

    }

    public AbstractClass(String something) {

    }
    public static void main(String[] args) {
        System.out.println("Abstract class");
    }
    abstract void doSomething();

    public void sayHello() {
        say();
    }

    private void say() {
        System.out.println(" Hello, this Abstract class");
    }
}
