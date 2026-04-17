import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

class Main
{
    private static final int CONFIG_CARS_COUNT = 3;
    private static final int CONFIG_MIN_SPEED = 1;
    private static final int CONFIG_MAX_SPEED = 250;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        Set<String> usedNames = new HashSet<>();

        for (int i = 1; i <= CONFIG_CARS_COUNT; i++)
        {
            String carName = readCarName(scanner, i, usedNames);
            int carSpeed = readCarSpeed(scanner, carName);

            Car car = new Car(carName, carSpeed);
            race.addCarLead(car);
        }

        List<Car> winners = race.getLeaders();

        if (winners.size() == 1)
        {
            System.out.println("Самая быстрая машина: " + winners.get(0).getNameCar());
        } else
        {
            System.out.println("Самые быстрые машины:");
            for (Car winner : winners)
            {
                System.out.println(winner.getNameCar());
            }
        }
    }

    private static String readCarName(Scanner scanner, int carNumber, Set<String> usedNames)
    {
        while (true)
        {
            System.out.print("Введите название автомобиля №" + carNumber + ": ");
            String inputName = scanner.nextLine().trim();

            if (inputName.isEmpty())
            {
                System.out.println("Ошибка: название автомобиля не может быть пустым.");
                continue;
            }

            String tryCarName = inputName.toLowerCase();

            if (usedNames.contains(tryCarName))
            {
                System.out.println("Ошибка: такое название уже введено. Введите уникальное название.");
                continue;
            }

            usedNames.add(tryCarName);
            return inputName;
        }
    }

    private static int readCarSpeed(Scanner scanner, String carName)
    {
        while (true)
        {
            System.out.print("Введите скорость автомобиля \"" + carName + "\" (от "
                    + CONFIG_MIN_SPEED + " до " + CONFIG_MAX_SPEED + "): ");
            String inputSpeed = scanner.nextLine().trim();

            if (inputSpeed.isEmpty())
            {
                System.out.println("Ошибка: скорость не может быть пустой.");
                continue;
            }

            try
            {
                int speed = Integer.parseInt(inputSpeed);

                if (speed < CONFIG_MIN_SPEED || speed > CONFIG_MAX_SPEED)
                {
                    System.out.println("Ошибка: скорость должна быть в диапазоне от "
                            + CONFIG_MIN_SPEED + " до " + CONFIG_MAX_SPEED + ".");
                    continue;
                }

                return speed;
            } catch (NumberFormatException e)

            {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

}