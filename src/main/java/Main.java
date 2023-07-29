
import java.util.Scanner;
import java.util.InputMismatchException; // для исключений
/*
В программе используется два класса

- стандартный main
    с методом priceTrue для отработки ввода цены

- basket
    с методом  division  для определения доли на 1 гостя

По логике программы, создается объект yaTest класа Basket, для отработки в
цикле while количества гостей
в цикле while для накомления товаров и общей суммы
    в switch    case завершить происходит расчет доли и обработка окончания рубль
                case дальше происходит накопление товаров и цены
*/


public class Main {
    public static void main(String[] args) {
        Basket yaTest = new Basket(); // применение класса

        yaTest.numPeople = 0;
        yaTest.itemAll = "";
        yaTest.priceAll = 0;

        System.out.println("Добрый день, на сколько человек разделить счет? ");
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            try // запрет ввода текста
            {
                yaTest.numPeople = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неправильный ввод, перезапустите программу");
                return;
            }

            // проверка количества гостей
            if (yaTest.numPeople < 1) System.out.println("Некорректное значение");
            else if (yaTest.numPeople == 1) System.out.println("Один гость, расчёт не нужен");
            else if (yaTest.numPeople > 1) break;
        }

        System.out.println("Гостей " + yaTest.numPeople + " человек");
        System.out.println("Для ввода товара введите <Дальше> или <Завершить>");

        while (true) // цикл для накопления товаров и цены
        {
            String inputUser = scanner.nextLine().toLowerCase();
            //System.out.println(priceAll);
            switch (inputUser) {
                case "завершить":
                {
                    System.out.println(yaTest.itemAll);
                    System.out.println("Общая сумма " + String.format("%.2f",yaTest.priceAll)+ " на " + yaTest.numPeople + " гостей");

                    yaTest.division(); // обращение для вычисления доли гостя


                    String rubEnd = null;
                    int integer = (int)yaTest.divisionAll ;
                    if (integer%100 > 10 && integer%100 < 15) rubEnd = "рублей"; // отрботка окончания руб с 10 до 15 исключение

                    else // отработка окончания руб с 0 до 9
                    {
                        integer = (integer) % 10;

                        if (integer == 1)
                        {
                            rubEnd = "рубль"; // System.out.println ("1");
                        }
                        else if (integer == 2 || integer == 3 || integer == 4)
                        {
                            rubEnd = "рубля"; //System.out.println ("2-4");
                        }
                        else if (integer == 5 || integer == 6 || integer == 7)
                        {
                            rubEnd = "рублей"; // System.out.println ("5-0");
                        }
                        else if (integer == 8 || integer == 9 || integer == 0)
                        {
                            rubEnd = "рублей"; // System.out.println ("5-0");
                        }
                    }
                    System.out.println("Каждый должен заплатить по " + String.format("%.2f",yaTest.divisionAll) + " " + rubEnd);

                    scanner.close();
                    System.exit(0);
                    break;
                } // case "завершить":

                case "check": // использовал для отладки и проверок, в теле программы не нужен
                {
                    System.out.println(yaTest.itemAll);
                    System.out.println(yaTest.priceAll);
                    break;
                }

                case "дальше":
                {
                    System.out.println("Введите название товара");
                    String item = scanner.nextLine();

                    System.out.println("Введите стоимость товара");
                    float price = 0;

                    price = priceTrue(scanner); // проверка на ввод текста

                    if (price > 0) {
                        System.out.println("Товар добавлен");
                        yaTest.itemAll += item;
                        yaTest.itemAll += " ";
                        yaTest.itemAll += price;
                        yaTest.itemAll += "\n";

                        yaTest.priceAll += price;
                        System.out.println("<Дальше> или <Завершить>");

                    } else {
                        System.out.println("Не корректный ввод цены");
                    }
                } // от case "дальше":
            } // от switch (inputUser)
        } // от while (true) цикл для накопления товаров и цены
    } // от public static void main(String[] args)

    public static float priceTrue(Scanner scanner) {
        try {
            float price = scanner.nextFloat();
            return price;
        } catch (InputMismatchException e) {
            System.out.println("Не корректный ввод цены");
            return 0;
        }
    } //от public static float truePrice (Scanner scanner)
}// от public class Main
