public class BinaryTree {

    private Node root;


    //insert value takes in an int
    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        insertRec(newNode, root);
    }
    //helper for insert converts to node and puts it in right place
    private void insertRec(Node newNode, Node rootNode) {
        if (newNode.value < rootNode.value) {
            if (rootNode.left == null) {
                rootNode.left = newNode;
                return;
            }
            insertRec(newNode, rootNode.left);
        }
        if (newNode.value > rootNode.value) {
            if (rootNode.right == null) {
                rootNode.right = newNode;
                return;
            }
            insertRec(newNode, rootNode.right);
        }
    }

    //print method calls recursive node print method of the root
    public void print() {
        root.print();
    }


    //method and helper to find max
    public int getMax() {
        return maxHelper(root).value;
    }
    private Node maxHelper(Node root) {
        if (root.right != null) {
            return maxHelper(root.right);
        }
        return root;
    }

    //method and helper to find min
    public int getMin() {
        return minHelper(root).value;
    }
    private Node minHelper(Node root) {
        if (root.left != null) {
            return minHelper(root.left);
        }
        return root;
    }

    //adds one to every value in tree
    public void increment() {
        incHelp(root);
    }
    private void incHelp(Node rootNode) {
        rootNode.value += 1;
        if(rootNode.left != null) {
            incHelp(rootNode.left);
        }
        if (rootNode.right != null) {
            incHelp(rootNode.right);
        }
    }


    public void replaceWithSum(int value) {         //I hope I understood this right
        Node startRoot = findValue(root, value);
        startRoot.value = replaceHelp(startRoot);
    }

    private Node findValue(Node currentRoot, int value) {
        if (currentRoot.value == value) {
            return currentRoot;
        }
        if (value > currentRoot.value) {
            return findValue(currentRoot.right, value);
        } else {
            return findValue(currentRoot.left, value);
        }
    }

    private int replaceHelp(Node currentRoot) {
        int tempVal = 0;
        if (currentRoot.left != null)
            tempVal += replaceHelp(currentRoot.left);
        if (currentRoot.right != null)
            tempVal += replaceHelp(currentRoot.right);
        return tempVal + currentRoot.value;
    }


    public BinaryTree copy() {
        BinaryTree newTree = new BinaryTree();
        newTree.root = new Node(this.root.value);       //pointers are crazy man...
        copy(this.root, newTree.root);
        return newTree;
    }

    private void copy(Node currentRoot, Node newRoot) {
        if (currentRoot.left == null && currentRoot.right == null) {
            return;
        }
        if (currentRoot.left != null) {
            newRoot.left = new Node(currentRoot.left.value);
            copy(currentRoot.left, newRoot.left);
        }
        if (currentRoot.right != null) {
            newRoot.right = new Node(currentRoot.right.value);
            copy(currentRoot.right, newRoot.right);
        }
    }
}
