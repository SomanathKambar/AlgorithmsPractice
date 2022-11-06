package abstracts;

public class AbstractUser {

    public static void main(String[] args) {
        AbstractClass abstractCheck = new AbstractClass() {
            @Override
            void doSomething() {
                System.out.println("Abstract class");
            }
        };

        abstractCheck.sayHello();
    }
}
