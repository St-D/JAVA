package b_KnightsTour;

import java.util.ArrayList;

/**
 * This class controls the behavior of knight
 */
public class Knight {

    // available shifts for knight:
    private int[] shiftX = {2,      1,      -1,     -2,     -2,     -1,     1,      2};
    private int[] shiftY = {-1,     -2,     -2,     -1,     1,      2,      2,      1};

    private int [] availableStep = new int[2];              // returned step (null - if step not found)
    private int stepCounter = 0;                            // step counter

    private int currentX;
    private int currentY;
    private ChessBoard board;

    /**
     * Class's constructor with parameters
     * @param startPositionY vertical start position
     * @param startPositionX horizontal start position
     * @param board current chessboard
     */
    public Knight(int startPositionY, int startPositionX, ChessBoard board){

        currentX = startPositionX;
        currentY = startPositionY;

        int[] startPos = {startPositionY, startPositionX};

        board.setChessBoardValue(-1, startPos);
        this.board = board;
    }

    /**
     * This method calculates the coordinates of a possible code
     *
     * @param currentPosition coordinates {Y, X}
     * @return coordinates on the Board {Y, X}
     */
    public int[] calcStep (int[] currentPosition){

        int currentPositionX = currentPosition[1];
        int currentPositionY = currentPosition[0];

        ArrayList<Integer> availableStepList = new ArrayList<Integer>(); // valid steps ArrayList
        for(int i = 0; i < shiftX.length; i++){
            int x = currentPositionX + shiftX[i];
            int y = currentPositionY + shiftY[i];

            try {
                // check that the cell is empty:
                int[][] currentSquare = board.getChessBoard();
                if (currentSquare[y][x] == 0){
                    availableStepList.add(i);
                }
                else continue;
            }
            catch (IndexOutOfBoundsException e){
                continue;
            }
            }

        // choosing a step from possible:
        if (availableStepList.size() != 0) {

            int rndInd = chooseStep(availableStepList);

            int randomStepIndex = availableStepList.get(rndInd);

            availableStep[0] = currentPositionY + shiftY[randomStepIndex];
            availableStep[1] = currentPositionX + shiftX[randomStepIndex];
        }
        else {
            availableStep = null;
        }

        return availableStep;
    }

    /**
     * This method choose a step (step index) from the list of possible
     * @param availableStepListArg valid steps ArrayList
     * @return index of ArrayList steps
     */
    public int chooseStep(ArrayList availableStepListArg){

        int rndIndex = (int) (Math.random() * availableStepListArg.size());

        return rndIndex;
    }

    /**
     * This method run Knight’s Tour
     */
    public void startKnightTour(){
        int [] stepBuf = new int[2];                    // buffer. Coordinates of the last successful step
        int [] stepCoord = {currentY, currentX};        // current coordinates

        while (stepCoord != null){

            stepCoord = calcStep(stepCoord);

            if (stepCoord == null){
                board.setChessBoardValue(-2, stepBuf);
                break;                                  // exit the cycle
            }

            stepCounter++;
            board.setChessBoardValue(stepCounter, stepCoord);

            stepBuf = stepCoord;
        }

        board.printChessBoard();
        System.out.println((char)27 + "[33m \nSuccessful steps have been made: " + stepCounter);
    }
}
