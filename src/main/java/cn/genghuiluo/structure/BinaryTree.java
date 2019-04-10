package cn.genghuiluo.structure;

/*
* 二叉树
*
* https://juejin.im/entry/592e936944d90400645f1398
* */

public class BinaryTree {

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();

        int height = binaryTree.getHeight();
        System.out.println("treeHeihgt: " + height);
        int size = binaryTree.getSize();
        System.out.println("treeSize: " + size);

        System.out.print("beforeOrderTraversal: ");
        binaryTree.beforeOrder(binaryTree.root);
        System.out.println("");
        System.out.print("midOrderTraversal: ");
        binaryTree.midOrder(binaryTree.root);
        System.out.println("");
        System.out.print("afterOrderTraversal: ");
        binaryTree.afterOrder(binaryTree.root);
    }

    //二叉树的构建首先需要跟节点，一般在构造方法里面创建
    public TreeNode root = null;
    public BinaryTree() {
        root = new TreeNode(1, "A");
    }
    public void createBinaryTree() {
        TreeNode nodeB = new TreeNode(1, "B");
        TreeNode nodeC = new TreeNode(1, "C");
        TreeNode nodeD = new TreeNode(1, "D");
        TreeNode nodeE = new TreeNode(1, "E");
        TreeNode nodeF = new TreeNode(1, "F");
        TreeNode nodeG = new TreeNode(1, "G");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.leftChild = nodeF;
        nodeC.rightChild = nodeG;
    }


    public int getHeight() {
        return getHeight(root);
    }
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.leftChild);
        int rightHeight = getHeight(node.rightChild);
        return leftHeight > rightHeight ? (leftHeight + 1) : (rightHeight + 1);
    }

    public int getSize() {
        return getSize(root);
    }
    public int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSize = getSize(node.leftChild);
        int rightSize = getSize(node.rightChild);
        return leftSize + rightSize + 1;
    }

    // 遍历, Traversal
    // 先序便利
    public void beforeOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        beforeOrder(node.leftChild);
        beforeOrder(node.rightChild);
    }

    // 中序遍历
    public void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrder(node.leftChild);
        System.out.print(node.getData() + " ");
        midOrder(node.rightChild);
    }

    // 后序遍历
    public void afterOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        afterOrder(node.leftChild);
        afterOrder(node.rightChild);
        System.out.print(node.getData() + " ");
    }
}

class TreeNode {
    private int index;
    private String data;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(int index, String data) {
        this.index = index;
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    //getter and setter
    public String getData() { return  data; }

}
