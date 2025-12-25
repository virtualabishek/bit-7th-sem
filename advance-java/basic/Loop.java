class Loop {
    public static void main(String[] args) {
        int n = 5;
        for ( int i=0; i<n; i++) {
            System.out.println("I am prininting " + i + " times");
        }
        int[] arr = {1,2,3,4,6};
        // demonstrating the for loop on array
        for (int i = 0; i<arr.length; i++) {
            System.out.println("Values are: " + arr[i] + ".");
        }

        // The Java for loop has an alternative syntax that makes 
        // it easy to iterate through arrays and collections. For example,

        System.out.println("Using for each and prininting from the array.");
        for (int num : arr) {

            System.out.println(num);
        }
    }
}