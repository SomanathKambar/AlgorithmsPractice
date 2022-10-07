package SearchAlgorithms;

public class BinarySearch {
    //Binary Search Assumes the items in data structure to be sorted in Ascending order
    // if elements are not ordered need to sort them in An Ascending order
    //Complexity for Sorted DataStructure is O(log(n))
    //Complexity for unSorted DataStructure includes the time complexity of the Sorting algorithm used

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(hasElement(array, 79));
        System.out.println(hasElement2(array, 79));
    }

    public static boolean hasElement(int[] array, int key){
        int min = 0;
        int max = array.length -1;
        int mid = (min + max) / 2;
        for(int i= 0; i < max ; i++) {
            if(array[mid]  == key) {
                return true;
            } else if(array[mid] < key) {
                if(mid +1 > max) return false;
                mid = mid +1;
                System.out.println("iteration" + i);
            } else if(array[mid] > key) {
                if(mid + -1 < 0) return false;
                mid = mid -1;
                System.out.println("iteration" + i);
            }
        }
        return false;
    }

    public static boolean hasElement2(int[] array, int key){
        int min = 0;
        int max = array.length -1;
            int counter = 0;
        while(min<=max) {
            int mid = (min + max) / 2;
            if(array[mid] == key) {
                return true;
            } else if(key < array[mid]) {
                max = mid -1;
            } else {
                min = mid +1;
            }
            System.out.println("Iteration" +counter++);
        }
        return false;
    }
}
