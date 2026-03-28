class ExceptionalQn {
    public static void main(String[] args) {
        try {
            int[] a = new int[2];
            a[20] = 20;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index: " + e);
        } 
        System.err.println("Running Well");
    }
}