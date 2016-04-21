import java.util.*;

public class GenericTree<T> {
    
    private GenericTreeNode<T> root;

    public GenericTree() {
        super();
    }

    public GenericTreeNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(GenericTreeNode<T> root) {
        this.root = root;
        root.setDepth(0);
    }

   
    public boolean isEmpty() {
        return (root == null);
    }

    
}