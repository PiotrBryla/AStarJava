import java.util.ArrayList;

/**
 * Created by piotr on 02/05/2017.
 */
public class Node {
    private String value;
    private ArrayList<Node> children;
    private Node parent;
    private int totalCost = 0;

    public Node getParent() {
        return parent;
    }
    public void setTotalCost(int cost, int estimatedCost) {
        this.totalCost = cost + estimatedCost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    public Node(String value){
        this.value = value;
        children = new ArrayList<Node>();
    }
    public String getValue() {
        return value;
    }
    public void addChildNode(Node child){
        children.add(child);
    }

}
