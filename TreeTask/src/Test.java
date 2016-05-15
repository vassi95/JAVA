

public class Test {
public static void main(String args[]){


	GenericTree<String> tree = new GenericTree<String>();
	GenericTreeNode<String> root = new GenericTreeNode<String>("ROOT");
	GenericTreeNode<String> childA = new GenericTreeNode<String>("A");
	GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
	GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
	GenericTreeNode<String> childD = new GenericTreeNode<String>("D");
	GenericTreeNode<String> childE = new GenericTreeNode<String>("E");
	GenericTreeNode<String> childF = new GenericTreeNode<String>("F");
	GenericTreeNode<String> childG = new GenericTreeNode<String>("G");
	GenericTreeNode<String> childH = new GenericTreeNode<String>("H");
	GenericTreeNode<String> childI = new GenericTreeNode<String>("I");
	GenericTreeNode<String> childJ = new GenericTreeNode<String>("J");
	GenericTreeNode<String> childK = new GenericTreeNode<String>("K");
	GenericTreeNode<String> childL = new GenericTreeNode<String>("L");
	GenericTreeNode<String> childM = new GenericTreeNode<String>("M");

	
	childA.setParent(root);
	childA.setDepth(1);
	childB.setParent(root);
	childB.setDepth(1);
	childC.setParent(root);
	childC.setDepth(1);
	
	childD.setParent(childA);
	childD.setDepth(2);
	childF.setParent(childD);
	childF.setDepth(3);
	childE.setParent(childA);
	childE.setDepth(2);
	
	childG.setParent(childE);
	childG.setDepth(3);
	childH.setParent(childG);
	childH.setDepth(4);
	childI.setParent(childG);
	childI.setDepth(4);
	childJ.setParent(childI);
	childJ.setDepth(5);
	
	
	childK.setParent(childC);
	childK.setDepth(2);
	childL.setParent(childC);
	childL.setDepth(2);
	
	childM.setParent(childL);
	childM.setDepth(3);
	
	root.addChild(childA);
	root.addChild(childB);
	root.addChild(childC);
	
	childA.addChild(childD);
	childA.addChild(childE);
	
	childD.addChild(childF);
	childE.addChild(childG);
	childG.addChild(childH);
	childG.addChild(childI);
	childI.addChild(childJ);
	
	childC.addChild(childK);
	childC.addChild(childL);
	childL.addChild(childM);
	
/*
	GenericTreeNode<String> root = new GenericTreeNode<String>("ROOT");
	GenericTreeNode<String> childA = new GenericTreeNode<String>("A");
	childA.setParent(root);
	childA.setDepth(1);
	GenericTreeNode<String> childB = new GenericTreeNode<String>("B");
	childB.setParent(root);
	childB.setDepth(1);
	GenericTreeNode<String> childC = new GenericTreeNode<String>("C");
	childC.setParent(childB);
	childC.setDepth(2);
	GenericTreeNode<String> childD = new GenericTreeNode<String>("D");
	childD.setParent(childB);
	childD.setDepth(2);
	GenericTreeNode<String> childE = new GenericTreeNode<String>("E");
	childE.setParent(childD);
	childE.setDepth(3);
	GenericTreeNode<String> childX = new GenericTreeNode<String>("X");
	childX.setParent(childA);
	childX.setDepth(2);

	childD.addChild(childE);

	childB.addChild(childC);
	childB.addChild(childD);

	root.addChild(childA);
	root.addChild(childB);
	childA.addChild(childX);
*/
	tree.setRoot(root);
	PlayWithTheTree p = new PlayWithTheTree();
	
	p.bfs(tree);
	System.out.println();
	p.findClosestCommonPredecessor(childD, childL);
	
	System.out.println();
	
		p.findSuccessorsAndPredecessors( childJ, childA);
		System.out.println();
p.showTree(tree.getRoot(), 0);

p.printPath(tree, childF);
}
}
