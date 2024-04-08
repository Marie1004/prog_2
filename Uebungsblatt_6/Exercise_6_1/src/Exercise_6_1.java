public class Exercise_6_1 {
    public static void main(String[] args) {
        testCode();
    }

    public static void testCode() {
        Sphere sphere = new Sphere(4.5);
        System.out.println("\nVolume of Sphere: " + sphere.volume);
        Cylinder cylinder = new Cylinder(2, 2);
        System.out.println("\nVolume of Cylinder: " + cylinder.volume);
        Pyramid pyramid = new Pyramid(100, 100);
        System.out.println("\nVolume of Pyramid: " + pyramid.volume);
        Box box = new Box(1000);
        System.out.println("\nVolume of Box: " + box.volume);
        System.out.println(box.add(sphere)); // true
        System.out.println(box.add(cylinder)); // true
        System.out.println(box.add(pyramid)); // false
    }
}