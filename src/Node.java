public class Node {
    int value;
    Node left;
    Node right;


    public Node(int val) {
        value = val;
    }

    public void print() {
        System.out.println(value);

        if (left != null) {
            left.print();
        }
        if (right != null) {
            right.print();
        }
    }
}
