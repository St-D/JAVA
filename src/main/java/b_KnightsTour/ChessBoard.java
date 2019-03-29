package b_KnightsTour;

import java.util.Arrays;

/**
 * This class controls the behavior of chessboard
 */
public class ChessBoard {

    private int[][] board;
    private int length;
    private int width;

    /**
     * Class's constructor with parameters
     *
     * @param length board size vertical
     * @param width  board size horizontal
     */
    public ChessBoard(int length, int width) {

        this.length = length;
        this.width = width;

        board = new int[this.length][this.width];
        for (int[] ar : board) {
            Arrays.fill(ar, 0);
        }
    }

    /**
     * This method set a value on chessboard square
     *
     * @param val       square value
     * @param positionY horizontal square position on board
     * @param positionX vertical square position on board
     */
    public void setChessBoardValue(int val, int positionY, int positionX) {

        board[positionY][positionX] = val;
    }

    /**
     * This method get the chessboard length
     *
     * @return length of the board
     */
    public int getLength() {
        return length;
    }

    /**
     * This method get the chessboard width
     *
     * @return width of the board
     */
    public int getWidth() {
        return width;
    }

    /**
     * This method get the chessboard as two-dimensional array
     *
     * @return width-by-lenght two-dimensional array board
     */
    public int[][] getChessBoard() {
        return board;
    }

    /**
     * This method print the board in console
     */
    public void printChessBoard() {
        System.out.println((char) 27 + "[31m\t _\t_\t_\t_\t_\t_\t_\t_");
        for (int[] ar : board) {
            System.out.print((char) 27 + "[31m\t|");
            for (int element : ar) {
                if (element == -1) {
                    System.out.print((char) 27 + "[31m" + element + "\t");
                } else if (element == -2) {
                    System.out.print((char) 27 + "[32m" + element + "\t");
                } else {
                    System.out.print((char) 27 + "[34m" + element + "\t");
                }
            }
            System.out.print("\n");
        }
        System.out.println((char) 27 + "[33m\n'-1' - Knight’s Tour start square\n'-2' - Knight’s Tour end square");

    }
}
