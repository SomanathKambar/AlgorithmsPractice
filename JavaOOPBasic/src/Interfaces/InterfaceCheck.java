package Interfaces;

public class InterfaceCheck implements DuplicateMethod {

    //We can not have private
    public void doSomething() {
        System.out.println("dong something");
    }

    public static void main(String[] args) {
        DuplicateMethod duplicateMethod = new InterfaceCheck();

        duplicateMethod.callPrivate();
    }

    @Override
    public void callPrivate() {
        System.out.println("call Private inside implemented class");
        DuplicateMethod.super.callPrivate();
    }
}
