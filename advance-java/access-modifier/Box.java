class Box {
  private double width;
  private double height;
  private double depth;
  // Constructor For Object
  Box (Box ob) {
      width = ob.width;
      height = ob.height;
      depth = ob.depth;
    }
  // Constructor for all dimension
  Box(double w, double h, double d) {
    width=w;
    height=h;
    depth=d;
  }
  // to do

  Box(double len) {
      width = height = depth = len;
    }

  double volume() {
    return height*width*depth;
  }
  
  public static void main(String args[]) {
    BoxWeight mybox1 = new BoxWeight(10, 20, 15, 34.3);
    System.out.println(mybox1.volume());
    System.out.println(mybox1.weight);
  }
}


class BoxWeight extends Box {
  double weight;
  // Constructor for Object
  BoxWeight(BoxWeight ob) {
    super(ob);
    weight=ob.weight;
  }
  // Constructor for all parameters
  BoxWeight(double w, double h, double d, double m) {
  super(w,h,d);
  weight=m;
  }
}


class DemoSuper {
  public static void main(String args[]) {
    BoxWeight mybox1 = new BoxWeight(10, 20, 15, 34.3);
    System.out.println(mybox1.volume());
    System.out.println(mybox1.weight);
  }
}
