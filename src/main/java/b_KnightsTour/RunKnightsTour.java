package b_KnightsTour;


/**
 * This class knight's tour
 */
public class RunKnightsTour {

    public static void main(String[] args){

        ChessBoard khightTourBoard = new ChessBoard(8,8);   // create new chessboard
        Knight knight = new Knight((int) (Math.random()*khightTourBoard.getBoardLength()),
                (int) (Math.random()*khightTourBoard.getBoardWidth()),
                khightTourBoard);                                               // create new knight on random square
        knight.startKnightTour();                                               // run knight's tour
    }
}
