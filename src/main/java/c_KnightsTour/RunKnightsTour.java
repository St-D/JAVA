package c_KnightsTour;


/**
 * This class run knight's tour
 */
public class RunKnightsTour {

    public static void main(String[] args) {

        ChessBoard knightTourBoard = new ChessBoard(8, 8);   // create new chessboard
        Knight knight = new Knight((int) (Math.random() * knightTourBoard.getLength()),
                (int) (Math.random() * knightTourBoard.getWidth()),
                knightTourBoard);                                               // create new knight on random square
        knight.startKnightTour();                                               // run knight's tour
    }
}
