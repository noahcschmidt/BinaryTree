public class Main {
    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();

        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(2);
        myTree.insert(3);
        myTree.insert(22);
        myTree.insert(6);

        myTree.print();

        BinaryTree secondTree = myTree.copy();
        secondTree.increment();
        System.out.println();
        secondTree.print();
        myTree.print();

    }
}
