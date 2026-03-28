class InvalidAgeException extends Exception {

    InvalidAgeException(String s) {
        super(s);
    } 
}


class TestException {
    static void validate(int age) throws InvalidAgeException {
        if(age<18) {
            throw new InvalidAgeException("not Valid.");
        } else {
            System.out.println("You can vote.");
        }
    }

    public static void main(String[] args) {
        try {
            validate(4);
        } catch (Exception e)  {
            System.out.println("Exception occured: " + e);
        }
        System.out.println("This always works by the way");
    }
}