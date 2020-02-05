package HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

    public static void main(String[] args) {
        int arr[] ={13,7,8,3,29,6,1};
        Node node = createHuffmanTree(arr);
        System.out.println(node);
        preOrder(node);
    }

    private static Node createHuffmanTree(int arr[]) {

        List<Node> nodes = new ArrayList<>();
        for(int a:arr){
            Node node = new Node(a);
            nodes.add(node);
        }
        while(nodes.size()>1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.getValue() + rightNode.getValue());
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    private static void preOrder(Node root){
        if(root!=null)
             root.preOrder();
       else {
            System.out.println("链表为空");
        }
    }
}

class Node implements Comparable<Node>{
    Node left;
    Node right;
    private int value;

    public Node(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node{" + "value=" + value + "}";
    }

    public int getValue(){
        return value;
    }

    @Override
    public int compareTo(Node o) {
        //如此默认从小到大   return -(this.value-o.getValue());
        return this.value-o.value;
    }

    /**
     * 另类遍历
     */
    public void preOrder(){
        if(this!=null)
            System.out.println(this.value);
        if(this.left!=null)
            this.left.preOrder();
        if(this.right!=null)
            this.right.preOrder();
    }

}
