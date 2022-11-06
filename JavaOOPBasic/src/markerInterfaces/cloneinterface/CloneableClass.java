package markerInterfaces.cloneinterface;

public class CloneableClass implements Cloneable{

    int id = 1;
    public static void main(String[] args) {
        CloneableClass cloneable = new CloneableClass();
        CloneableClass clone1 = null;
        try {
          clone1 =  (CloneableClass) cloneable.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(cloneable);

        System.out.println(clone1);
        // this will not change original object value
        clone1.id = 2;
        System.out.println(cloneable.id);
        System.out.println(clone1.id);
        // even though clone1 is copy of cloneable  both are 2 different objects
        System.out.println(clone1.equals(cloneable));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
