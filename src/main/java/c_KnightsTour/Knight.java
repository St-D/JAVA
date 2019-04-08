package c_KnightsTour;

import java.util.ArrayList;
import java.util.Collections;

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

    private int stepCounter = 1;                            // step counter

    private ChessBoard board;                               // instant of chessboard

    private int positionY;
    private int positionX;

    /**
     * Class's constructor with parameters
     *
     * @param startPositionY vertical start position
     * @param startPositionX horizontal start position
     * @param board          current chessboard
     */
    public Knight(int startPositionY, int startPositionX, ChessBoard board) {

        board.setChessBoardValue(stepCounter, startPositionY, startPositionX);
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
    private ArrayList<Integer> calcStep(int currentPositionY, int currentPositionX) {

        ArrayList<Integer> availableStepList = new ArrayList<Integer>();      // valid steps ArrayList
        for (int i = 0; i < shiftX.length; i++) {
            int y = currentPositionY + shiftY[i];
            int x = currentPositionX + shiftX[i];

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
        return availableStepList;
    }

    /**
     * This method choose a step (step index) from the list of possible
     *
     * @param availableStepListArg valid steps ArrayList
     * @return shift-index List
     */
    private int chooseStep(ArrayList<Integer> availableStepListArg) {

        ArrayList<Integer> lowPriorityIndexList = getLowPriorityIndexList(availableStepListArg);

        if (lowPriorityIndexList.size() == 1) {                 // if priority equal for all squares:
            return availableStepListArg.get(lowPriorityIndexList.get(0));
        } else if (lowPriorityIndexList.size() == 0) {          // if end of Knight’s Tour
            return -1;
        } else {
            ArrayList<Integer> oneStepLaterAvailable;
            ArrayList<Integer> stepPrioritySumList = new ArrayList<Integer>();
            int stepLaterPosY;
            int stepLaterPosX;

            for (int stepIndex : lowPriorityIndexList) {
                stepLaterPosY = positionY + shiftY[availableStepListArg.get(stepIndex)];
                stepLaterPosX = positionX + shiftX[availableStepListArg.get(stepIndex)];
                oneStepLaterAvailable = calcStep(stepLaterPosY, stepLaterPosX);

                int stepPrioritySum = 0;                        //sum of the squares priorities for the next step
                for (int prorityValIndex : oneStepLaterAvailable) {
                    stepPrioritySum += stepPriority[stepLaterPosY + shiftY[prorityValIndex]][stepLaterPosX + shiftX[prorityValIndex]];
                }
                stepPrioritySumList.add(stepPrioritySum);
            }
            int minSumPriorityIndex = stepPrioritySumList.indexOf(Collections.min(stepPrioritySumList));
            return availableStepListArg.get(lowPriorityIndexList.get(minSumPriorityIndex));
        }
    }


    /**
     * This method search shift index with low priority
     *
     * @param availableStepListArg valid steps ArrayList
     * @return list with low-priority shift index
     */
    private ArrayList<Integer> getLowPriorityIndexList(ArrayList<Integer> availableStepListArg) {

        ArrayList<Integer> lowPriorityIndexList = new ArrayList<Integer>(); //low-priority shift-index step list
        ArrayList<Integer> priorityList = new ArrayList<Integer>();         //priority list

        for (int shiftIndex : availableStepListArg) {
            priorityList.add(stepPriority[positionY + shiftY[shiftIndex]][positionX + shiftX[shiftIndex]]);
        }

        try {
            int minElem = Collections.min(priorityList);
            for (int i = 0; i < priorityList.size(); i++) {
                // for each element with low-priority
                if (priorityList.get(i) == minElem) {
                    lowPriorityIndexList.add(i);
                }
            }
        } catch (java.util.NoSuchElementException e) {
            lowPriorityIndexList.clear();
            return lowPriorityIndexList;
        }

        return lowPriorityIndexList;
    }


    /**
     * This method run Knight’s Tour
     */
    public void startKnightTour() {
        ArrayList<Integer> stepCoordinate = calcStep(positionY, positionX);  // current coordinates (Start tour coordinates)
        int shiftIndex;

        while (stepCoordinate.size() != 0) {

            stepCoordinate = calcStep(positionY, positionX);
            shiftIndex = chooseStep(stepCoordinate);

            if (stepCoordinate.size() == 0) {
                break;                                  // exit the cycle
            }

            stepCounter++;
            positionY += shiftY[shiftIndex];
            positionX += shiftX[shiftIndex];

            board.setChessBoardValue(stepCounter, positionY, positionX);

        }

        board.printChessBoard();
        System.out.println((char) 27 + "[33m \nSuccessful steps have been made: " + stepCounter);
    }
}
