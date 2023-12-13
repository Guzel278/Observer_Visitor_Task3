import java.io.File;
import java.util.Arrays;
import java.util.List;

class MyDirectory implements Element {
    private final String name;
    private final File file;
    private final Element[] children;

    public MyDirectory(String name, File file) {
        this.name = name;
        this.file = file;
        this.children = buildChildren();
    }

    private Element[] buildChildren() {
        File[] files = file.listFiles();
        if (files != null) {
            Element[] children = new Element[files.length];
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    children[i] = new MyDirectory(files[i].getName(), files[i]);
                } else {
                    children[i] = new MyFile(files[i].getName(), files[i].length());
                }
            }
            return children;
        }
        return new Element[0];
    }

    public String getName() {
        return name;
    }

    public Element[] getChildren() {
        return children;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element child : children) {
            child.accept(visitor);
        }
    }
}
