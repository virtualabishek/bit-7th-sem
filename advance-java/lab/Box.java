public class Box {
    double length;
    double height;
    double breadth;

    Box() {
        length = breadth = height = -1;
    }

    Box(double len) {
        length = breadth = height = len;
    }

    Box(double len, double br, double hg) {
        length = len;
        breadth = br;
        height = hg;
    }

    double volume() {
        return length * breadth * height;
    }

    public static void main(String[] args) {
        Box b1 = new Box();
        Box b2 = new Box(20.3);
        Box b3 = new Box(20.3, 30.42, 40.4);

        System.out.println(b1.volume());
        System.out.println(b2.volume());
        System.out.println(b3.volume());
    }
}
