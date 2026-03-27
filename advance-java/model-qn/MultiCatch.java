class MultiCatch {
    public static void main(String[] args) {
        try {
            int[] a = new int[2];
            a[3] = 30/0;
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array out of index. " + e);
        } 
        catch (ArithmeticException e) {
            System.out.println("Number cant be divide by 0" + e);
        }
        System.out.println("Better luck next time.");
    }
}