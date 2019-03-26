import java.util.ArrayList;
import java.util.List;

public class SimpleDotComGame {
    public static void main (String[] args){

        SimpleDotCom dot = new SimpleDotCom();

        ArrayList<Integer> locations = new ArrayList<Integer>();
//        ArrayList locations = new ArrayList();
        int a = 0; // Начальное значение диапазона - "от"
        int b = 4; // Конечное значение диапазона - "до"
        int random_number = a + (int) (Math.random() * b);

        for (int i=0; i<3; i++){

            locations.add(random_number + i);

        }

        dot.setLocationCells(locations);

        System.out.println(locations);





    }
}
