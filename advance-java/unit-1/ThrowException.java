class ThrowException {
    public void divide(int x, int y) throws ArithmeticException {
        int ans = x / y;
        System.out.println("Ans is: " + ans);
    }

    public static void main(String[] args) {
        ThrowException t1 = new ThrowException();
        try {
            t1.divide(4, 2);
            t1.divide(4, 0);
        }
        catch(ArithmeticException e) {
            System.out.println("Error occured: " + e);
        }
    }
}