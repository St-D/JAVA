package c_KnightsTour;

import java.util.ArrayList;

/**
 * This class controls the behavior of knight
 */
public class Knight {

    // available shifts for knight:
    private int[] shiftY = {-1, -2, -2, -1, 1, 2, 2, 1};
    private int[] shiftX = {2, 1, -1, -2, -2, -1, 1, 2};

    private int[][] stepPriority = {
            {2, 3, 4, 4, 4, 4, 3, 2},
            {3, 4, 6, 6, 6, 6, 4, 3},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {3, 4, 6, 6, 6, 6, 4, 3},
            {2, 3, 4, 4, 4, 4, 3, 2}};

    private int stepCounter = 0;                            // step counter

    private ChessBoard board;                               // instant of chessboard

    int positionY;
    int positionX;

    /**
     * Class's constructor with parameters
     *
     * @param startPositionY vertical start position
     * @param startPositionX horizontal start position
     * @param board          current chessboard
     */
    public Knight(int startPositionY, int startPositionX, ChessBoard board) {

        board.setChessBoardValue(-1, startPositionY, startPositionX);
        this.board = board;

        positionY = startPositionY;
        positionX = startPositionX;
    }

    /**
     * This method calculates the coordinates of a possible code
     *
     * @param currentPositionY coordinates by Y
     * @param currentPositionX coordinates by X
     * @return coordinates on the Board {Y, X}
     */
    private int[] calcStep(int currentPositionY, int currentPositionX) {

        int[] availableStep = new int[2];                               // returned step (null - if step not found)

        ArrayList<Integer> availableStepList = new ArrayList<Integer>();      // valid steps ArrayList
        for (int i = 0; i < shiftX.length; i++) {
            int x = currentPositionX + shiftX[i];
            int y = currentPositionY + shiftY[i];

            try {
                // check that the cell is empty:
                if (board.getChessBoard()[y][x] == 0) {
                    availableStepList.add(i);
                } else {
                    continue;
                }
            } catch (IndexOutOfBoundsException e) {
                continue;
            }
        }

        // choosing a step from possible:
        if (availableStepList.size() != 0) {
            int randomStepIndex = chooseStep(availableStepList);

            availableStep[0] = currentPositionY + shiftY[randomStepIndex];
            availableStep[1] = currentPositionX + shiftX[randomStepIndex];
        } else {
            availableStep = null;
        }

        return availableStep;
    }

    /**
     * This method choose a step (step index) from the list of possible
     *
     * @param availableStepListArg valid steps ArrayList
     * @return index of ArrayList steps
     */
    private int chooseStep(ArrayList<Integer> availableStepListArg) {

        int minimumPriority = 8; //all eight possible moves in terms of its horizontal and vertical components
        int searchIndex = 0;
        for (int arIndex : availableStepListArg) {
            int nextStepPriority = stepPriority[positionY + shiftY[arIndex]][positionX + shiftX[arIndex]];

            if (minimumPriority >= nextStepPriority) {
                minimumPriority = nextStepPriority;
                searchIndex = arIndex;
            }
        }
        return searchIndex;
    }

    /**
     * This method run Knight’s Tour
     */
    public void startKnightTour() {
        int[] stepBuf = new int[2];           // buffer. Coordinates of the last successful step
        int[] stepCoord = new int[2];         // current coordinates

        while (stepCoord != null) {

            stepCoord = calcStep(positionY, positionX);

            if (stepCoord == null) {
                board.setChessBoardValue(-2, stepBuf[0], stepBuf[1]);
                break;                                  // exit the cycle
            }

            stepCounter++;
            positionY = stepCoord[0];
            positionX = stepCoord[1];

            board.setChessBoardValue(stepCounter, positionY, positionX);

            stepBuf[0] = positionY;
            stepBuf[1] = positionX;
        }

        board.printChessBoard();
        System.out.println((char) 27 + "[33m \nSuccessful steps have been made: " + stepCounter);
    }
}
