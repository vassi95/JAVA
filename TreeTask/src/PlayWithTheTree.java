
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PlayWithTheTree<T> {

	Queue<GenericTreeNode<T>> queue = new LinkedList<GenericTreeNode<T>>();

	public void bfs(GenericTree<T> tree) {
		GenericTreeNode<T> root = tree.getRoot();
		if (root == null)
			return;
		queue.clear();
		queue.add(root);
		while (!queue.isEmpty()) {

			GenericTreeNode<T> node = queue.remove();

			if (node.getChildren().isEmpty() == false) {
				for (GenericTreeNode<T> t : node.getChildren()) {
					queue.add(t);
				}
			} else {

				int depth = node.getDepth();
				findNodesWithSameDepth(tree, depth);
				break;
			}

		}

	}

	public void printPath(GenericTree<T> tr, GenericTreeNode<T> n) {
		Stack<GenericTreeNode<T>> a = new Stack<GenericTreeNode<T>>();
		GenericTreeNode<T> root = tr.getRoot();

		while (n != root) {
			a.push(n);
			n = n.getParent();

		}
		a.push(root);
		while (!a.isEmpty()) {
			System.out.println(a.pop());
		}
	}

	public void findNodesWithSameDepth(GenericTree<T> tree, int depth) {
		Queue<GenericTreeNode<T>> q = new LinkedList<GenericTreeNode<T>>();
		GenericTreeNode<T> root = tree.getRoot();
		if (root == null)
			return;
		q.clear();
		q.add(root);
		while (!q.isEmpty()) {

			GenericTreeNode<T> node = q.remove();

			if (node.getChildren().isEmpty() == false) {
				//traverses through the children and checks if they have the same deth
				//if so adds them to the queue and then print the paths
				for (GenericTreeNode<T> t : node.getChildren()) {
					if (t.getDepth() != depth) {
						q.add(t);
					} else if (t.getDepth() == depth && t.hasChildren() == false) {
						printPath(tree, t);
					}
				}
			}
		}
	}

	public void findClosestCommonPredecessor(GenericTreeNode<T> A1, GenericTreeNode<T> A2) {
		int depth1 = A1.getDepth();
		int depth2 = A2.getDepth();

		if (depth1 == depth2) {

			equalDepths(A1, A2);

		} else if (depth2 > depth1) {

			while (!(depth2 == depth1)) {
			
				A2 = A2.getParent();
				depth2--;
			}
			equalDepths(A1, A2);

		} else {

			while (!(depth1 == depth2)) {
				A1 = A1.getParent();
				depth1--;
			}
			equalDepths(A1, A2);

		}
	}

	public void equalDepths(GenericTreeNode<T> A1, GenericTreeNode<T> A2) {
		GenericTreeNode<T> a1 = A1.getParent();
		GenericTreeNode<T> a2 = A2.getParent();
		if (a1.data.equals(a2.data)) {
			System.out.println(a1.data);
		} else {
			while (!a1.data.equals(a2.data)) {
				a1 = a1.getParent();
				a2 = a2.getParent();
			}
			System.out.println(a1.data);
		}
	}

	public void findSuccessorsAndPredecessors(GenericTreeNode<T> A1, GenericTreeNode<T> A2) {
		Stack<GenericTreeNode<T>> a = new Stack<GenericTreeNode<T>>();
		try {

			if (A1.hasParent() && A2.hasChildren()) {
				while (A1.getParent() != A2) {

					A1 = A1.getParent();
					a.push(A1);
				}
				if (a.isEmpty())
					System.out.println("There is no path between these nodes!");
				while (!a.isEmpty()) {
					System.out.println(a.pop());
					//prints the path
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("There is no path between these nodes");
		}
	}
	
	
	
	void showTree(GenericTreeNode<T> node, int indent)
	{
	int tabCount = ( indent < tabs.length() ? indent :
	tabs.length() );


	System.out.println(tabs.substring(0, tabCount) + node.getData()+ " (has " + node.getNumberOfChildren() + " children)" );
	List<GenericTreeNode<T>> children = node.getChildren();
	int childCount = ( children != null ? children.size() : 0 );
	for ( int i = 0; i < childCount; ++i )
	showTree(children.get(i), indent+1);
	}

	final String tabs = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
}
