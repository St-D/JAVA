import java.util.ArrayList;

public class SimpleDotComTestDrive {
    public static void main (String[] args){

//        SimpleDotCom dot = new SimpleDotCom();
        SimpleDotCom dot = new SimpleDotCom();

        ArrayList<Integer> locations = new ArrayList<Integer>();    // расположение корабля
//        ArrayList<Integer> locations = {2, 3, 6};
        locations.add(2);
        locations.add(3);
        locations.add(4);

        dot.setLocationCells(locations);

        String userGuess = "2"; // ход пользователя

        String result = dot.checkYouself(userGuess);

        String testResult = "Неудача";

        if (result.equals("Попал!")){

            testResult = "Пройден!";

        }

//        System.out.println(testResult);

    }
}
