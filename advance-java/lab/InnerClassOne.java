class A {
    public int i;
    class B {
        public int j;
    }
    public int sum(B b) {
        return i + b.j;
    }
}


public class InnerClassOne {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        a.i = 2;
        b.j = 3;
        int ans = a.sum(b);
        System.out.println("Answer is: " + ans);
    }
}