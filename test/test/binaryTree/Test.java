package test.binaryTree;



public class Test {
	
	
	TreeNode root = null;
	
	public Test(){
		root = new TreeNode(1, "rootNode(A)");
	}
	
	
	
	public static void main(String[] args) {
		
		Test test=new Test();
		
		test.createBinTree(test.root);
		
		System.out.println(test.height());
		
	}
	
	public int height(){
		return height(root);
	};
	 
	
	public int height(TreeNode treeNode){
		
		if(treeNode==null){
			return 0;
		}
		else {
			int j=height(treeNode.leftChild);
			int i=height(treeNode.rightChild);
			
			System.out.println("j="+j);
			System.out.println("i="+i);

			return  (i<j)?(j+1):(i+1);  
		}
	
		
	};
	
	
	public void createBinTree(TreeNode root) {
		TreeNode newNodeB = new TreeNode(2, "B");
		TreeNode newNodeC = new TreeNode(3, "C");
		TreeNode newNodeD = new TreeNode(4, "D");
		TreeNode newNodeE = new TreeNode(5, "E");
		TreeNode newNodeF = new TreeNode(6, "F");
		root.leftChild = newNodeB;
		root.rightChild = newNodeC;
		root.leftChild.leftChild = newNodeD;
		root.leftChild.rightChild = newNodeE;
		root.rightChild.rightChild = newNodeF;
	}
	

	/**
	 * 二叉树的节点数据结构
	 * 
	 * @author WWX
	 */
	private class TreeNode {
		private int key = 0;
		private String data = null;
		private boolean isVisted = false;
		private TreeNode leftChild = null;
		private TreeNode rightChild = null;

		public TreeNode() {}

		/**
		 * @param key
		 *            层序编码
		 * @param data
		 *            数据域
		 */
		public TreeNode(int key, String data) {
			this.key = key;
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

}
