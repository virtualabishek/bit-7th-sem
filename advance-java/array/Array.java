import java.util.ArrayList;

class Java {

    public static void main(String[] args) {
        // Syntax DataType[] ArrayName = new DataType[Size];
        int[] age = new int[5];
        age[0] = 10;
        age[1] = 20;
        age[2] = 30;
        for (int a : age) {
            System.out.println(a);
        }
        // Example caculate sum of avergae.
        double[] salary = new double[5];
        // assigning values
        salary = new double[] { 100000.33, 324000.323, 42000.33, 31340.22 };
        double sum = 0;
        for (double i : salary) {
            sum = sum + i;
        }
        System.out.println("Sum is: " + sum + ".");
        double averageSalary = sum / salary.length;
        System.out.println("The avarage salary is:" + averageSalary);
        // Multidimension salary

        int[][] numbers = { { 1, 3, 5, 7 }, { 2, 4, 6, 8 } };
        System.out.println("The length of first array:" + numbers[0].length);
        System.out.println("The length of second array:" + numbers[1].length);
        // Print all elements from the multudimesion arrarays
        // using for loop
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.println(numbers[i][j]);
            }
        }
        System.out.println("Implementing multidimension array usinh foreach ");
        // second multidimension array
        String[][] collections = {
            { "dKathmandu", "Chitwan", "Lalipur" },
            { "Basantapur", "Maulakalika", "PatanDhoka" },
        };
        // for each loop access the individual array for first
        for (String[] innerArray : collections) {
            for (String data : innerArray) {
                System.out.println(data);
            }
        }
        // Multidimension third
        int[][] myNumbers = { { 6, 12, 18, 24 }, { 5, 10, 15, 20 } };
        System.out.println("24 will be: " + myNumbers[0][3]);
        System.out.println("15 will be: " + myNumbers[1][2]);
        // overwrite
        myNumbers[0][3] = 36;
        // ArrayList - manipulation with array
        // ArrayList<String> list = new ArrayList<>();
        // adding elements
        // list.add("Apple");
        // System.out.print(list);
        // adding at specific index
        // list.add(3, "Mango");
        // System.out.println(list);
        ArrayList<String> names = new ArrayList<>();
        names.add("Abishek");
        names.add("Ram");
        names.add("Shyam");
        System.out.println("Adding 3: " + names);
        // accessing using get
        System.out.println("Element at 2:" + names.get(2));
        // replacing
        names.set(1, "Hari");
        System.out.println();
    }
}
