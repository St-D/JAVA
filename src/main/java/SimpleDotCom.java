import java.util.ArrayList;

public class SimpleDotCom {

    ArrayList<Integer> locationsCells;
    int numOfHits = 0;

//    public void setLocationCells(ArrayList<Integer> locs){
    public void setLocationCells(ArrayList locs){

        locationsCells = locs;
    }

    //
    public String checkYouself(String stringGuess){

        int guess = Integer.parseInt(stringGuess);

        String result = "Мимо!";

        for (int cell : locationsCells){

            if (guess == cell) {
                result = "!Попал";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationsCells.size()){

            result = "Потопил";
        }

        System.out.println(result);

        return result;
    }
}
