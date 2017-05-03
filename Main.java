import java.util.List;

/**
 * Created by piotr on 02/05/2017.
 */
public class Main {
    private static String initial_node = "023164875";
    private static String set_22 = "860473251";
    private static String easy = "123840765";

    private static String goal_node = "123804765";

    public static void main(String[] args) {
        AStar aStar_search = new AStar(new Node(initial_node), new Node(goal_node));
        aStar_search.search();

    }
}
