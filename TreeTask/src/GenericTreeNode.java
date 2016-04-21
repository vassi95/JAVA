import java.util.ArrayList;
import java.util.List;

public class GenericTreeNode<T> {

    public T data;
    public List<GenericTreeNode<T>> children;
    public GenericTreeNode<T> parent;
public int depth;

    public int getDepth() {
	return depth;
}
    public boolean hasParent(){
    	if(this.getParent()!= null){
    		return true;
    	}
    	return false;
    }

public void setDepth(int depth) {
	this.depth = depth;
}

	public GenericTreeNode() {
        super();
        children = new ArrayList<GenericTreeNode<T>>();
        
    }

    public GenericTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(GenericTreeNode<T> parent) {
		this.parent = parent;
	}

	public GenericTreeNode(T data) {
        this();
        setData(data);
    }

    public List<GenericTreeNode<T>> getChildren() {
        return this.children;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }

    public void setChildren(List<GenericTreeNode<T>> children) {
        this.children = children;
    }

    public void addChild(GenericTreeNode<T> child) {
        children.add(child);
    }


    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return getData().toString();
    }

 
    
    
    
}