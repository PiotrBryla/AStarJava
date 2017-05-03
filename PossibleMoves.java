import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by piotr on 29/04/2017.
 * This class contains method that returns all possible moves(states) from the current state.
 */


public class PossibleMoves {

    public static List<String> getPossibleMoves(String state) {
        String workingState;
        List<String> possibleMoves = new ArrayList<>();

        //Empty tile in 0,0 (left corner)
        if (state.indexOf('0') == 0) {
            char bufor;
            char bufor2;
            workingState = state;

            //Move Right
            bufor = workingState.charAt(0);
            workingState = workingState.replace(workingState.charAt(0), 'x');
            bufor2 = workingState.charAt(1);
            workingState = workingState.replace(workingState.charAt(1), bufor);
            workingState = workingState.replace(workingState.charAt(0), bufor2);
            possibleMoves.add(workingState);

            //Move Down
            workingState = state;
            bufor = workingState.charAt(0);
            workingState = workingState.replace(workingState.charAt(0), 'x');
            bufor2 = workingState.charAt(3);
            workingState = workingState.replace(workingState.charAt(3), bufor);
            workingState = workingState.replace(workingState.charAt(0), bufor2);
            possibleMoves.add(workingState);
        }

        //Empty tile in 0,1
        if (state.indexOf('0') == 1) {
            char bufor;
            char bufor2;
            workingState = state;

            //Move Left
            bufor = workingState.charAt(1);
            workingState = workingState.replace(workingState.charAt(1), 'x');
            bufor2 = workingState.charAt(0);
            workingState = workingState.replace(workingState.charAt(0), bufor);
            workingState = workingState.replace(workingState.charAt(1), bufor2);
            possibleMoves.add(workingState);

            //Move Right
            workingState = state;
            bufor = workingState.charAt(1);
            workingState = workingState.replace(workingState.charAt(1), 'x');
            bufor2 = workingState.charAt(2);
            workingState = workingState.replace(workingState.charAt(2), bufor);
            workingState = workingState.replace(workingState.charAt(1), bufor2);
            possibleMoves.add(workingState);

            //Move Down
            workingState = state;
            bufor = workingState.charAt(1);
            workingState = workingState.replace(workingState.charAt(1), 'x');
            bufor2 = workingState.charAt(4);
            workingState = workingState.replace(workingState.charAt(4), bufor);
            workingState = workingState.replace(workingState.charAt(1), bufor2);
            possibleMoves.add(workingState);
        }

        //Empty tile in 0,2 (Right Upper Corner)
        if (state.indexOf('0') == 2) {
            char bufor;
            char bufor2;
            workingState = state;

            //Move Left
            bufor = workingState.charAt(2);
            workingState = workingState.replace(workingState.charAt(2), 'x');
            bufor2 = workingState.charAt(1);
            workingState = workingState.replace(workingState.charAt(1), bufor);
            workingState = workingState.replace(workingState.charAt(2), bufor2);
            possibleMoves.add(workingState);

            //Move Down
            workingState = state;
            bufor = workingState.charAt(2);
            workingState = workingState.replace(workingState.charAt(2), 'x');
            bufor2 = workingState.charAt(5);
            workingState = workingState.replace(workingState.charAt(5), bufor);
            workingState = workingState.replace(workingState.charAt(2), bufor2);
            possibleMoves.add(workingState);
        }

        //Empty tile in 1,0
        if (state.indexOf('0') == 3) {
            char bufor;
            char bufor2;
            workingState = state;

            //Move UP
            bufor = workingState.charAt(3);
            workingState = workingState.replace(workingState.charAt(3), 'x');
            bufor2 = workingState.charAt(0);
            workingState = workingState.replace(workingState.charAt(0), bufor);
            workingState = workingState.replace(workingState.charAt(3), bufor2);
            possibleMoves.add(workingState);

            //Move Right
            workingState = state;
            bufor = workingState.charAt(3);
            workingState = workingState.replace(workingState.charAt(3), 'x');
            bufor2 = workingState.charAt(4);
            workingState = workingState.replace(workingState.charAt(4), bufor);
            workingState = workingState.replace(workingState.charAt(3), bufor2);
            possibleMoves.add(workingState);

            //Move Down
            workingState = state;
            bufor = workingState.charAt(3);
            workingState = workingState.replace(workingState.charAt(3), 'x');
            bufor2 = workingState.charAt(6);
            workingState = workingState.replace(workingState.charAt(6), bufor);
            workingState = workingState.replace(workingState.charAt(3), bufor2);
            possibleMoves.add(workingState);
        }

        //Empty tile in 1,1 (Middle Of the board)
        if (state.indexOf('0') == 4) {
            char bufor;
            char bufor2;
            workingState = state;

            //Move UP
            bufor = workingState.charAt(4);
            workingState = workingState.replace(workingState.charAt(4), 'x');
            bufor2 = workingState.charAt(1);
            workingState = workingState.replace(workingState.charAt(1), bufor);
            workingState = workingState.replace(workingState.charAt(4), bufor2);
            possibleMoves.add(workingState);

            //Move Left
            workingState = state;
            bufor = workingState.charAt(4);
            workingState = workingState.replace(workingState.charAt(4), 'x');
            bufor2 = workingState.charAt(3);
            workingState = workingState.replace(workingState.charAt(3), bufor);
            workingState = workingState.replace(workingState.charAt(4), bufor2);
            possibleMoves.add(workingState);

            //Move Right
            workingState = state;
            bufor = workingState.charAt(4);
            workingState = workingState.replace(workingState.charAt(4), 'x');
            bufor2 = workingState.charAt(5);
            workingState = workingState.replace(workingState.charAt(5), bufor);
            workingState = workingState.replace(workingState.charAt(4), bufor2);
            possibleMoves.add(workingState);

            //Move Down
            workingState = state;
            bufor = workingState.charAt(4);
            workingState = workingState.replace(workingState.charAt(4), 'x');
            bufor2 = workingState.charAt(7);
            workingState = workingState.replace(workingState.charAt(7), bufor);
            workingState = workingState.replace(workingState.charAt(4), bufor2);
            possibleMoves.add(workingState);
        }

        //Empty tile in 1,2
        if (state.indexOf('0') == 5) {
            char bufor;
            char bufor2;
            workingState = state;

            //Move UP
            bufor = workingState.charAt(5);
            workingState = workingState.replace(workingState.charAt(5), 'x');
            bufor2 = workingState.charAt(2);
            workingState = workingState.replace(workingState.charAt(2), bufor);
            workingState = workingState.replace(workingState.charAt(5), bufor2);
            possibleMoves.add(workingState);

            //Move Left
            workingState = state;
            bufor = workingState.charAt(5);
            workingState = workingState.replace(workingState.charAt(5), 'x');
            bufor2 = workingState.charAt(4);
            workingState = workingState.replace(workingState.charAt(4), bufor);
            workingState = workingState.replace(workingState.charAt(5), bufor2);
            possibleMoves.add(workingState);

            //Move Down
            workingState = state;
            bufor = workingState.charAt(5);
            workingState = workingState.replace(workingState.charAt(5), 'x');
            bufor2 = workingState.charAt(8);
            workingState = workingState.replace(workingState.charAt(8), bufor);
            workingState = workingState.replace(workingState.charAt(5), bufor2);
            possibleMoves.add(workingState);
        }

        if (state.indexOf('0') == 6){// (2,0) Left Bottom Corner
            char bufor;
            char bufor2;
            workingState = state;

            //Move UP
            bufor = workingState.charAt(6);
            workingState = workingState.replace(workingState.charAt(6), 'x');
            bufor2 = workingState.charAt(3);
            workingState = workingState.replace(workingState.charAt(3), bufor);
            workingState = workingState.replace(workingState.charAt(6), bufor2);
            possibleMoves.add(workingState);

            //Move Right
            workingState = state;
            bufor = workingState.charAt(6);
            workingState = workingState.replace(workingState.charAt(6), 'x');
            bufor2 = workingState.charAt(7);
            workingState = workingState.replace(workingState.charAt(7), bufor);
            workingState = workingState.replace(workingState.charAt(6), bufor2);
            possibleMoves.add(workingState);
        }

        if (state.indexOf('0') == 7)// (2,1) Left Bottom Corner
        {
            char bufor;
            char bufor2;
            workingState = state;

            //Move UP
            bufor = workingState.charAt(6);
            workingState = workingState.replace(workingState.charAt(6), 'x');
            bufor2 = workingState.charAt(3);
            workingState = workingState.replace(workingState.charAt(3), bufor);
            workingState = workingState.replace(workingState.charAt(6), bufor2);
            possibleMoves.add(workingState);

            //Move Right
            workingState = state;
            bufor = workingState.charAt(6);
            workingState = workingState.replace(workingState.charAt(6), 'x');
            bufor2 = workingState.charAt(7);
            workingState = workingState.replace(workingState.charAt(7), bufor);
            workingState = workingState.replace(workingState.charAt(6), bufor2);
            possibleMoves.add(workingState);
        }

        if (state.indexOf('0') == 7)// (2,1)
        {
            char bufor;
            char bufor2;
            workingState = state;

            //Move UP
            bufor = workingState.charAt(7);
            workingState = workingState.replace(workingState.charAt(7), 'x');
            bufor2 = workingState.charAt(4);
            workingState = workingState.replace(workingState.charAt(4), bufor);
            workingState = workingState.replace(workingState.charAt(7), bufor2);
            possibleMoves.add(workingState);

            //Move Right
            workingState = state;
            bufor = workingState.charAt(7);
            workingState = workingState.replace(workingState.charAt(7), 'x');
            bufor2 = workingState.charAt(8);
            workingState = workingState.replace(workingState.charAt(8), bufor);
            workingState = workingState.replace(workingState.charAt(7), bufor2);
            possibleMoves.add(workingState);

            //Move Left
            workingState = state;
            bufor = workingState.charAt(7);
            workingState = workingState.replace(workingState.charAt(7), 'x');
            bufor2 = workingState.charAt(6);
            workingState = workingState.replace(workingState.charAt(6), bufor);
            workingState = workingState.replace(workingState.charAt(7), bufor2);
            possibleMoves.add(workingState);
        }

        if (state.indexOf('0') == 8)// (2,2) Right Bottom Corner
        {
            char bufor;
            char bufor2;
            workingState = state;

            //Move UP
            bufor = workingState.charAt(8);
            workingState = workingState.replace(workingState.charAt(8), 'x');
            bufor2 = workingState.charAt(5);
            workingState = workingState.replace(workingState.charAt(5), bufor);
            workingState = workingState.replace(workingState.charAt(8), bufor2);
            possibleMoves.add(workingState);

            //Move Left
            workingState = state;
            bufor = workingState.charAt(8);
            workingState = workingState.replace(workingState.charAt(8), 'x');
            bufor2 = workingState.charAt(7);
            workingState = workingState.replace(workingState.charAt(7), bufor);
            workingState = workingState.replace(workingState.charAt(8), bufor2);
            possibleMoves.add(workingState);
        }
        return possibleMoves;
    }
}
