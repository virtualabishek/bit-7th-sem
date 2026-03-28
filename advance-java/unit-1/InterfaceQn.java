/* Why do we need interface? Define an interface named shape with area ( ) method. Create a class‬
‭named Rectangle with length and breadth circle with radius that implements shape interface.‬
‭Now create the object of both classes and display their area. */

interface Shape {
  double area();
}

class Rectangle implements Shape {
  private double length;
  private double breadth;
  // Using Constructor just to take and set 03/26/2026
  Rectangle (double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
  }
  public double area() {
    return length * breadth;
  }
}

class Circle implements Shape {
  private double radius;
  Circle (double radius) {
    this.radius = radius;
  }

  public double area() {
    return Math.PI * radius * radius;
  }
}




class InterfaceQn {
  public static void main(String[] args) {
    Rectangle r1 = new Rectangle(2.44, 5.55);
    System.out.println("The Area is of Rectangle is: " + r1.area());
    Circle c1 = new Circle(35.5443);
    System.out.println(" The area of the circle is: " + c1.area());
    
  }
}
