package b_KnightsTour;

import java.util.ArrayList;


public class Knight {

    private int stepCounter = 0;                                // подсчет кол-ва ходов
    private int[] shiftX = {2,      1,      -1,     -2,     -2,     -1,     1,      2};
    private int[] shiftY = {-1,     -2,     -2,     -1,     1,      2,      2,      1};
    private int [] availableStep = new int[2];                  // возвращаемый методом ход (пустой, если ход не найден)

    // возвращает координаты клетки на доске доступной для хода (случайно из возможных).
    /**
     *
     *
     * @param board
     * @param currentPosition
     * @return
     */
    public int[] makeStep (int[][] board, int[] currentPosition){

        int currentPositionX = currentPosition[1];
        int currentPositionY = currentPosition[0];

        ArrayList<Integer> availableStepList = new ArrayList<Integer>(); // список индекесов валидных ходов
        for(int i = 0; i < shiftX.length; i++){
            int x = currentPositionX + shiftX[i];
            int y = currentPositionY + shiftY[i];

            try {
                // проверка, что на клетку ещё не было хода:
                if (board[y][x] == 0){
                    availableStepList.add(i);
                }
                else continue;
            }
            catch (IndexOutOfBoundsException e){
                System.out.println((char)27 + "[32mЗа пределами доски: X=" + x + "   Y=" + y);
//                e.printStackTrace();
            }
            }

//        случайный ход из массива возможных:
        if (availableStepList.size() != 0) {
            System.out.println(availableStepList);
            int rndInd = (int) (Math.random() * availableStepList.size());
            int randomStepIndex = availableStepList.get(rndInd);
            System.out.println(randomStepIndex);
            System.out.println("Y: " + shiftY[randomStepIndex]);
            System.out.println("X: " + shiftX[randomStepIndex]);
            System.out.println("********************************");

            availableStep[0] = currentPositionY + shiftY[randomStepIndex];
            availableStep[1] = currentPositionX + shiftX[randomStepIndex];

        }
        else {
            availableStep = null;
            System.out.println((char)27 + "[34m Дальнейшие ходы не найдены.");
//            System.out.println(availableStepList.size());
        }


        return availableStep;
    }
}
