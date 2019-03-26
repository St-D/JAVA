package b_KnightsTour;

import java.util.Arrays;
import java.util.List;

public class ChessBoard {

    private int gridLength = 8;
    private int gridWidth = 8;
    private int[][] board = new int[gridLength][gridWidth];
    private int locationX = (int) (Math.random()*gridLength); //случайная старотовая точка по X
    private int locationY = (int) (Math.random()*gridWidth);  //случайная старотовая точка по Y
    List<Integer> validVal =  Arrays.asList(0, 1, 2, 3);      //список валидных значений для ячеек доски


    // устанавливает значения на доске (0-пустая клетка,
    //                                  1-посещена,
    //                                  2-начало отсчета ходов,
    //                                  3-окончание ходов.)
//    public void setChessBoardValue(int val, int x, int y){
    public void setChessBoardValue(int val, int [] pos){
        int y = pos[0];
        int x = pos[1];

        if (validVal.contains(val)){
            board[y][x] = val;
        }
        else {
            System.out.println((char)27 + "[31m Для записи состояния ячейки подано невалидное значение: " + val);
        }
    }


    // создает двумерный массив 8х8 заполненый 0 и 2(начало отсчета ходов)
    public void createChessBoard(){
        int[] pos = {locationY, locationX};
        setChessBoardValue(2, pos);
    }


    // возвращает доску
    public int[][] getChessBoard(){
        return board;
    }


    // возвращает начальную позицию
    public int[] getStartPosition(){
        int[] pos = {locationY, locationX};
        return pos;
    }


    // вывод в консоль доски
    public void printChessBoard(int[][] arg){
        System.out.println("\t _  _  _  _  _  _  _  _");
        for (int[] ar : arg){
            System.out.print("\t|");
            for (int element : ar){
                System.out.print(element + "  ");
            }
            System.out.print("\n");
        }
    }

}
