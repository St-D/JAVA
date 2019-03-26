package Game;

import java.util.ArrayList;

//создает объекты DotCom. Получает пользовательский ввод. Следит пока все корабли не потоплены.
public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuess = 0;

    public static void main (String[] args){

        DotComBust theGame = new DotComBust();
        theGame.setUpGame();
        theGame.startPlaying();

    }

    private void setUpGame(){

        DotCom shipOne = new DotCom();
        shipOne.setName("smal_ship");
        DotCom shipTwo = new DotCom();
        shipTwo.setName("mini_ship");
        DotCom shipThree = new DotCom();
        shipThree.setName("shipIK");

        dotComList.add(shipOne);
        dotComList.add(shipTwo);
        dotComList.add(shipThree);

        System.out.println(dotComList);

        // для каждого корабля:
        for(DotCom chip: dotComList){
            ArrayList<String> newLocation = helper.placeDotCom(3); // список с координатами местоположения
            chip.setLocationsCells(newLocation); // установка местоположения для каждого корабля
        }

        System.out.println((char)27 + "[34m\nНеобходимо потопить три корабля \n" +
                "Постарайтесь это сделать за минимальное кол-во ходов\n");

    }

    private void startPlaying(){

        // пока список не станет пустым:
        while (!dotComList.isEmpty()){

            String userGuess = helper.getUserInput("Сделайте ход!");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuess++;               // кол-во попыток пользователя

        String result = "Мимо!";    // первоначально записываем "Мимо"

        for(DotCom chip: dotComList){

            result = chip.checkYouself(userGuess);  // проверка на попадание или потопление

            if (result.equals("Попал!")){
                break;                              // если попал, то другие корабли на этот ход не проверяем
            }
            if (result.equals("Потопил!")){
                dotComList.remove(chip);
                break;
            }
        }

        System.out.println(result);
    }

    private void finishGame(){

        System.out.println((char)27 + "[32m\nВсе корабли ушли ко дну!\nЭто заняло у вас " + numOfGuess + " ходов.");

    }
}

