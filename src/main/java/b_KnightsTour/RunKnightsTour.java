package b_KnightsTour;

public class RunKnightsTour {

    private static int stepCounter = 0;                 // счетчик кол-ва ходов


    public static void main(String[] args){

        ChessBoard khightTourBoard = new ChessBoard();  // новая доска
        khightTourBoard.createChessBoard();             // инициализация начальной позиции на доске
        int[][] b = khightTourBoard.getChessBoard();    // двумерный массив координат доски со значениями
        khightTourBoard.printChessBoard(b);             // вывод в консоль доски
        int[] startPos = khightTourBoard.getStartPosition();    // координаты начальной позиции

        Knight knight = new Knight();                   // создает Рыцаря

        int [] stepCoord = startPos;                    // начнем делать ходы со стартовой позиции

        int [] stepBuf = new int[2];                    // буфер. координаты последнего удачного хода

        while (stepCoord != null){

            b = khightTourBoard.getChessBoard();
            stepCoord = knight.makeStep(b, stepCoord);

            if (stepCoord == null){                     // если ходов больше нет, то записываем 3 - "конец хода"
                khightTourBoard.setChessBoardValue(3, stepBuf);
                break;                                  // счетчик более не наращиваем, буфер не пишем
            }

            khightTourBoard.setChessBoardValue(1, stepCoord);

            stepBuf = stepCoord;
            stepCounter++;

    }

        khightTourBoard.printChessBoard(b);
        System.out.println((char)27 + "[32m \nКол-во ходов: " + stepCounter);

}
}
