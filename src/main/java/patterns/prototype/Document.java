package patterns.prototype;

public class Document implements Cloneable {

    private String content;

    public Document(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        Document original = new Document("This is the original document.");
        Document copy = original.clone();

        System.out.println("Original Document Content: " + original.getContent());
        System.out.println("Cloned Document Content: " + copy.getContent());

        copy.setContent("This is the modified cloned document.");

        System.out.println("After modifying the cloned document:");
        System.out.println("Original Document Content: " + original.getContent());
        System.out.println("Cloned Document Content: " + copy.getContent());
    }
}