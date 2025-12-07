package patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite Pattern Example
 * 
 * The Composite pattern composes objects into tree structures to represent
 * part-whole hierarchies.
 * Composite lets clients treat individual objects and compositions of objects
 * uniformly.
 */

// Component Interface
interface FileSystemComponent {
    void showDetails(String indent);

    long getSize();

    String getName();
}

// Leaf - represents individual files
class File implements FileSystemComponent {
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "📄 " + name + " (" + size + " KB)");
    }
}

// Composite - represents folders that can contain files or other folders
class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "📁 " + name + " (" + getSize() + " KB total)");
        for (FileSystemComponent component : components) {
            component.showDetails(indent + "    ");
        }
    }
}

// Demo class
public class CompositePatternDemo {
    public static void main(String[] args) {
        // Create files
        File file1 = new File("document.txt", 10);
        File file2 = new File("image.png", 250);
        File file3 = new File("video.mp4", 1500);
        File file4 = new File("music.mp3", 5);
        File file5 = new File("notes.txt", 2);

        // Create folders
        Folder documents = new Folder("Documents");
        Folder media = new Folder("Media");
        Folder images = new Folder("Images");
        Folder videos = new Folder("Videos");
        Folder root = new Folder("Root");

        // Build the tree structure
        documents.add(file1);
        documents.add(file5);

        images.add(file2);
        videos.add(file3);

        media.add(images);
        media.add(videos);
        media.add(file4);

        root.add(documents);
        root.add(media);

        // Display the entire structure
        System.out.println("=== File System Structure ===\n");
        root.showDetails("");

        // Get size of specific folders
        System.out.println("\n=== Folder Sizes ===");
        System.out.println("Documents folder size: " + documents.getSize() + " KB");
        System.out.println("Media folder size: " + media.getSize() + " KB");
        System.out.println("Total root size: " + root.getSize() + " KB");
    }
}
