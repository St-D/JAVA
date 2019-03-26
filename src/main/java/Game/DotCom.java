package Game;

import java.util.ArrayList;

//местоположение кораблей. Проверяет пользовательский ввод на попадание
public class DotCom {

    private ArrayList<String> locationsCells;
    private String name;

    public void setLocationsCells(ArrayList<String> loc){
        locationsCells = loc;
    }

    public void setName(String n){
        name = n;
    }

    public String checkYouself(String userInput){

        String result = "Мимо!";

        int checkIndex = locationsCells.indexOf(userInput);

        if (checkIndex >= 0){
            locationsCells.remove(checkIndex);

            if (locationsCells.isEmpty()){
                result = "Потопил!";
            }
            else {
                result = "Попал!";
            }
        }

        System.out.println(locationsCells);

        return result;
    }
}
