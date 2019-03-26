package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//принимает пользовательский ввод из консоли. Размещает корабли на поле.
public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String promt){

        String inputLine = null;
        System.out.print(promt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0){
                return null;
            }
        }
        catch (IOException e){
            System.out.print("IOException: " + e);
        }

        return inputLine.toLowerCase();
    }


    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String [] alphacoords = new String[comSize];// хранит координаты тыипа f6
        String temp = null;                         // временная строка для склеивания
        int[] coord = new int[comSize];             // координаты текущего коробля
        int attempts = 0;                           // счетчик текущих попыток поиска местоположения
        boolean success = false;                    // нашли подходящее местоположение?
        int location = 0;                           // начальное местоположение

        comCount++;                                 // порядковый номер размещаемого корабля
        int incr = 1;                               // устанавливаем горизонтальный инкр
        if ((comCount % 2) == 1){                   // если корабль нечетный , то размещаем вертикально
            incr = gridLength;                      // утсанавливаем вертикальный инкр
        }

        while (!success & attempts++<200){
            location = (int) (Math.random()*gridSize);  //случайная старотовая точка
            System.out.println("пробуем\n" + location);

            int x = 0;                              // начальное поле корабля, который нужно разместить
            success = true;                         // предполагаем успешный исход

            while (success && x < comSize){         // поиск соседней неиспользованной ячейки
                if (grid[location] == 0){           // если клетка ещё не используется, то
                    coord[x++] = location;          //          сохраняем
                    location += incr;               // пробуем следующую соседнюю ячейку

                    if (location >= gridSize){      // выход за рамки низа
                        success = false;            // неудача выбора ячейки
                    }
                    if (x>0 && (location % gridLength == 0)){   // вышли за рамки - правый край
                        success = false;            // неудачный выбор ячейки
                    }
                }
                else {                              // нашли уже использующееся местоположене
                    System.out.print("используется" + location);
                    success = false;                // неудачный выбор ячейи
                }
            }
        }

        int x = 0;                                  // перевод местоположения в символьные координаты.
        int row = 0;
        int column = 0;

        while (x < comSize){
            grid[coord[x]] = 1;                     // помечаем ячейки на сетке как использованные
            row = (int) (coord[x] / gridLength);    // получаем значение строки
            column = coord[x] % gridLength;         // получаем числовое значение столбца
            temp = String.valueOf(alphabet.charAt(column)); // преобразование в строковый символ

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;

            System.out.print(" coord" + x + "=" + alphaCells.get(x-1) + "; \n");
        }

        return alphaCells; // возвращает ArrayList, например: [d2, d3, d4]
    }
}
