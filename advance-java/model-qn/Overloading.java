class Overloading {
  static int sum (int a, int b) {
    return a + b;
  }
  static float sum (float a, float b) {
    return a + b;
  }
  static int sum (int a, int b, int c) {
    return a + b + c;
  }
  static float sum(float a, float b, float c) {
    return a + b + c;
  }
  public static void main(String[] args) {
    System.out.println(sum(2,3));
    System.out.println(sum(2,4,5));
    System.out.println(sum(2.4f,2.4f,2.1f));
    System.out.println(sum(2.4f,5.3f));
  }
}
