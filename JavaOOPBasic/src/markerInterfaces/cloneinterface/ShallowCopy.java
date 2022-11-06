package markerInterfaces.cloneinterface;

import java.util.Arrays;

/**
 * this is default clone behavior
 * shares data between original & clone Object
 * Change in one object reflects in other
 */
public class ShallowCopy implements Cloneable{
    int[] values = {5, 7, 9};
    StringBuilder stringBuilder = new StringBuilder("Hello ");

    public ShallowCopy() {
    }

    public void displayValues() {
        System.out.println(stringBuilder + "values are :"  + Arrays.toString(values));
    }

    public static void main(String[] args) {

        ShallowCopy copy = new ShallowCopy();

        try {
            ShallowCopy copy1 = (ShallowCopy) copy.clone();
            //this will update in both clone & local
            copy1.values[0] = 2;
            copy1.stringBuilder.append("Somanath,");
            copy1.displayValues();
            copy.displayValues();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
