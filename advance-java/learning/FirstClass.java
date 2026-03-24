class FirstClass {
  public static void main (String[] args) {
    Shape f = new Shape();
    f.SetData(2,4,2);
    System.out.println(f.FindArea());
    System.out.println(f.findVolume());
  }
}
class Shape {
  private int l;
  private int br;
  private int h;
  public void SetData(int a, int b, int c) {
    l=a;
    br=b;
    h=c;
  }
  public int FindArea() {
    return l * br;
  }
  public int findVolume() {
    return l*br*h;
  }
}
