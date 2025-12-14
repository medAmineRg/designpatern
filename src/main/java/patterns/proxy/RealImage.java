package patterns.proxy;

public class RealImage implements Image {
    public RealImage(String filename) {
        System.out.println("Loading image " + filename);
    }

    public void display() {
        System.out.println("Displaying image");
    }
}