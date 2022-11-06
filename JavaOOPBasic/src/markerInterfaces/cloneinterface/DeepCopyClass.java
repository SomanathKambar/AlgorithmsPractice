package markerInterfaces.cloneinterface;

import java.util.Arrays;

/**
 * Deep copy needs custom Implementation
 * Deep copy will create new instance or member variables
 * Change in clone will not affect original and vice versa
 */
public class DeepCopyClass implements Cloneable {
    int[] values = {1, 3, 5};
    StringBuilder stringBuilder = new StringBuilder("Hello ");

    public DeepCopyClass() {

    }

    public void displayData() {
        System.out.println(stringBuilder + "values are :"  + Arrays.toString(values));
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        DeepCopyClass deepCopy = new DeepCopyClass();
        DeepCopyClass deepCopy1 = (DeepCopyClass) deepCopy.clone();
        //This will update in both objects
        deepCopy1.values[0] = 2;
        deepCopy1.stringBuilder.append("Somanath,");
        deepCopy.displayData();
        deepCopy1.displayData();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCopyClass clone = (DeepCopyClass) super.clone();
        clone.values = new int[this.values.length];
        System.arraycopy(values, 0, clone.values, 0, values.length);
        clone.stringBuilder = new StringBuilder(stringBuilder);
        return clone;
    }
}
