package b_KnightsTour;

import java.util.Arrays;

/**
 * This class controls the behavior of chessboard
 */
public class ChessBoard {

    private int boardLength;
    private int boardWidth;
    private int[][] board;

    /**
     * Class's constructor with parameters
     * @param boardLength board size vertical
     * @param boardWidth board size horizontal
     */
    public ChessBoard(int boardLength, int boardWidth) {

        this.boardLength = boardLength;
        this.boardWidth = boardWidth;

        board = new int[this.boardLength][this.boardWidth];
        for (int[] ar : board){
            Arrays.fill(ar, 0);
        }
    }

    /**
     * This method set a value on chessboard square
     * @param val square value
     * @param pos square position on board
     */
    public void setChessBoardValue(int val, int [] pos){
        int y = pos[0];
        int x = pos[1];

        board[y][x] = val;
    }

    /**
     * This method get the chessboard length
     * @return length of the board
     */
    public int getBoardLength(){
        return boardLength;
    }

    /**
     * This method get the chessboard width
     * @return width of the board
     */
    public int getBoardWidth(){
        return boardWidth;
    }

    /**
     * This method get the chessboard as two-dimensional array
     * @return width-by-lenght two-dimensional array board
     */
    public int[][] getChessBoard(){
        return board;
    }

    /**
     * This method print the board in console
     */
    public void printChessBoard(){
        System.out.println((char)27 + "[31m\t _\t_\t_\t_\t_\t_\t_\t_");
        for (int[] ar : board){
            System.out.print((char)27 + "[31m\t|");
            for (int element : ar){
                if (element == -1){
                    System.out.print((char)27 + "[31m" + element + "\t");
                }
                else if (element == -2){
                    System.out.print((char)27 + "[32m" + element + "\t");
                }
                else {
                    System.out.print((char)27 + "[34m" + element + "\t");
                }
            }
            System.out.print("\n");
        }
    }
}
