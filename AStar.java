import java.util.*;
import java.util.logging.XMLFormatter;

/**
 * Created by piotr on 02/05/2017.
 */

public class AStar {
    Node initial_node;
    Node goal_node;
    LinkedList<Node> open_list = new LinkedList<>();
    LinkedList<Node> closed_list = new LinkedList<>();
    int step = 0;
    Set<String> states = new HashSet<>();

    public AStar(Node initial_node, Node goal_node) {
        this.initial_node = initial_node;
        this.goal_node = goal_node;
    }

    private int missplacedTiles(String current_node, String goal_node) {
        int difference = 0;
        for (int i = 0; i < current_node.length(); i += 1)
            if (current_node.charAt(i) != goal_node.charAt(i))
                difference += 1;
        return difference;
    }


    public void search() {
        open_list.add(initial_node); // The initial node to the open list
        NodePriorityComparator getCheapestNode = new NodePriorityComparator();
        Node considering_node;
        Boolean found = false;
        Boolean better_on_open = false;
        Boolean better_on_closed = false;

        while (!open_list.isEmpty() && !found) {
            open_list.sort(getCheapestNode); // Put cheapest node on the top
            considering_node = open_list.pollFirst();// Poll first node from the open list
            states.add(considering_node.getValue());

            //Generate all possible moves for current node
            List<String> possible_moves = PossibleMoves.getPossibleMoves(considering_node.getValue());

            for (String node : possible_moves) {
                // System.out.println("Visited:" + node);
                Node possible_move = new Node(node);
                possible_move.setParent(considering_node); // Set parent for possible move
                considering_node.addChildNode(possible_move); // Set child for considering node

                // Calculate and set cost for the child node
                possible_move.setTotalCost(considering_node.getTotalCost() +
                                Character.getNumericValue(possible_move.getValue().
                                        charAt(possible_move.getParent().getValue().indexOf('0'))),
                        missplacedTiles(possible_move.getValue(), goal_node.getValue()));


                // if open list contains the same node with lower cost, skip this possible move
                better_on_open = false;
                for (Node node_on_open : open_list) {
                    if (node_on_open.getValue().equals(possible_move.getValue())) {
                        if (node_on_open.getTotalCost() < possible_move.getTotalCost()) {
                            better_on_open = true;
                        }
                    }
                }

                better_on_closed = false;
                for (Node node_on_closed : closed_list) {
                    if (node_on_closed.getValue().equals(possible_move.getValue())) {
                        if (node_on_closed.getTotalCost() < possible_move.getTotalCost()) {
                            // System.out.println("Node on closed cost vs current:" + node_on_closed.getTotalCost() + " || " +possible_move.getTotalCost());
                            better_on_closed = true;
                        }
                    }
                }
                // Otherwise add possible node to the open list
                if (!better_on_closed && !better_on_open ) {
                    states.add(possible_move.getValue());
                    open_list.add(possible_move);
                }

                // If found
                if (possible_move.getValue().equals(goal_node.getValue())) {
                    System.out.println("Founded:" + possible_move.getValue() + " Cost:"+ possible_move.getTotalCost());
                    printSolution(possible_move, states, initial_node);
                    found = true;
                    break;
                }
            } // End for loop
           closed_list.add(considering_node);
        }//End while loop

    }

    void printSolution(Node goalNode, Set<String> visitedNodes, Node root) {

        int totalCost = 0;

        Stack<Node> solutionStack = new Stack<Node>();
        solutionStack.push(goalNode);
        while (!goalNode.getValue().equals(root.getValue())) {
            solutionStack.push(goalNode.getParent());
            goalNode = goalNode.getParent();
        }
        String sourceState = root.getValue();
        String destinationState;
        int cost = 0;
        for (int i = solutionStack.size() - 1; i >= 0; i--) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            destinationState = solutionStack.get(i).getValue();
            if (!sourceState.equals(destinationState)) {
                System.out.println("Move " + destinationState.charAt(sourceState.indexOf('0')) + " " + findTransition(sourceState, destinationState));
                cost = Character.getNumericValue(destinationState.charAt(sourceState.indexOf('0')));
                totalCost += cost;
            }

            sourceState = destinationState;
            System.out.println("Cost of the movement: " + cost);
            System.out.println("*******");
            System.out.println("* " + solutionStack.get(i).getValue().substring(0, 3) + " *");
            System.out.println("* " + solutionStack.get(i).getValue().substring(3, 6) + " *");
            System.out.println("* " + solutionStack.get(i).getValue().substring(6, 9) + " *");
            System.out.println("*******");

        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("** Number of transitions to get to the goal state from the initial state:  " + (solutionStack.size() - 1));
        System.out.println("** Number of visited states:  " + (visitedNodes.size()));
        System.out.println("** Total cost for this solution: " + totalCost);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

    }

    public static MovementType findTransition(String source, String destination) {
        int zero_position_difference = destination.indexOf('0') - source.indexOf('0');
        switch (zero_position_difference) {
            case -3:
                return MovementType.DOWN;
            case 3:
                return MovementType.UP;
            case 1:
                return MovementType.LEFT;
            case -1:
                return MovementType.RIGHT;
        }
        return null;
    }

}


