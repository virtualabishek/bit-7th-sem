class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String s) {
        super(s);
    }
}
class Program {
    static void validate(int amount) throws InsufficientBalanceException {
        int balance = 20000;
        if (amount < balance) {
            throw new InsufficientBalanceException("Ops. It seems you had insufficient balance. "); 
        }else {
            System.out.println("You can do transaction.");   
        }
    }
    public static void main(String[] args) {
        try {
            validate(10000);
        } catch (Exception e) {
            System.err.println("Exception occured: " + e);
        }
    }
}