import java.util.*;

public class ArrayExample {
    void printArray(int[] a) {
        for(int i=0; i<a.length; i++)
        System.out.println(a[i]);
        
    }
    public static void main(String[] args) {
        // int a[] = {1,2,3,4,5};
        ArrayExample arr = new ArrayExample();
        // System.out.println("Passing array name ");
        // arr.printArray(a);
        System.out.println("Input from user");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = sc.nextInt();
        int a[] = new int[size];
        for(int i=0;i<size;i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Printing your values");
        arr.printArray(a);
    }
}