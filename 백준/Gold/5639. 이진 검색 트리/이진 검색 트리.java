
import java.util.*;
import java.io.*;
public class Main {
    static int root;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        root = Integer.parseInt(br.readLine());
        Node node = new Node(root);

        while (true) {
            String N = br.readLine();
            if(N==null||N.equals(""))break;
            int n = Integer.parseInt(N);
            node.insert(n);
        }

        preOrder(node);

    }
    static void preOrder(Node node) {
        if(node==null)return;

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.value);
    }

}
class Node{
    Node left;
    Node right;
    Integer value;

    public Node(int value) {
        this.value = value;
    }
    void insert(int n) {
        if (n < value) {
            if (this.left == null) this.left = new Node(n);
            else left.insert(n);
        } else {
            if(this.right == null) this.right = new Node(n);
            else right.insert(n);
        }
    }
}
