package markerInterfaces.cloneinterface;

/**
 * Copy constructor creates a new object using existing object
 * Change in original object will not affect clone and vice versa
 * no need to TypeCast object and handle class cast exception
 * Final variables can also be re-assigned
 */
public class CopyConstructorTest {

   final String firstName;
    String lastName;
    public CopyConstructorTest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CopyConstructorTest(CopyConstructorTest copyConstructorTest) {
        this.firstName = copyConstructorTest.firstName;
        this.lastName = copyConstructorTest.lastName;
    }

    public void displayName() {
        System.out.println(firstName + " " + lastName);
    }
    public static void main(String[] args) {
        CopyConstructorTest copyConstructorTest = new CopyConstructorTest("FirstName", "Lastname");
        CopyConstructorTest copyConstructorTest1 = new CopyConstructorTest(copyConstructorTest);
        copyConstructorTest1.lastName = "new Lastname";
        copyConstructorTest.displayName();
        copyConstructorTest1.displayName();
        System.out.println(copyConstructorTest);
        System.out.println(copyConstructorTest1);
    }
}
