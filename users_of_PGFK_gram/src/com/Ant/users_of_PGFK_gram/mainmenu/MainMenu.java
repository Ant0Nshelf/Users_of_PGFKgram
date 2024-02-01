package com.Ant.users_of_PGFK_gram.mainmenu;

import com.Ant.users_of_PGFK_gram.util.Search;

import java.util.Scanner;

/**
 * Головне меню додатку PGFK-gram, яке керує взаємодiєю користувача з рiзними функцiональними опцiями.
 */
public class MainMenu {

    /**
     * Запускає головне меню та надає користувачу доступ до рiзних опцiй, таких як перегляд користувачiв, груп,
     * створення груп, пошук тощо.
     *
     * @param scanner Об'єкт Scanner для зчитування введення користувача.
     */
    public void runProgram(Scanner scanner) {
        String DATA_PATH = "Data/";

        while (true) {
            System.out.println("Головне меню: ");
            System.out.println("1. Перегляд користувачiв ");
            System.out.println("2. Перегляд груп ");
            System.out.println("3. Створення груп ");
            System.out.println("4. Пошук ");
            System.out.println("5. Вихiд ");

            String userChoice = scanner.nextLine();

            PeopleWork peopleWork = new PeopleWork();
            GroupWork groupWork = new GroupWork();

            switch (userChoice) {
                case "1":
                    peopleWork.showpeoples();
                    break;
                case "2":
                    groupWork.showgroups();
                    break;
                case "3":
                    groupWork.GroupWork("Data/group.json");
                    break;
                case "4":
                    System.out.println("Введiть ключове слово або цифру, за якою ви бажаєте здiйснити пошук ");
                    String searchTerm = scanner.nextLine();
                    Search.searchInFiles(searchTerm, DATA_PATH + "people.json", DATA_PATH + "people.json", DATA_PATH + "group.json");
                    returnToMainMenu(scanner);
                    break;

                case "5":
                    System.out.println("Дякуємо за використання додатка. До побачення! ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Невiрний вибiр. Будь ласка, введiть коректний номер опцiї ");
            }
        }
    }

    /**
     * Запитує користувача, чи вiн хоче повернутися до головного меню, та повертає вiдповiдний результат.
     *
     * @param scanner Об'єкт Scanner для зчитування введення користувача.
     * @return true, якщо користувач хоче повернутися до головного меню; false, якщо користувач вибрав вихiд з програми.
     */
    private boolean returnToMainMenu(Scanner scanner) {
        System.out.println("Щоб повернутися на головне меню, натиснiть Enter");
        String returnToMainMenuChoice = scanner.nextLine().trim();

        return returnToMainMenuChoice.equalsIgnoreCase("Так");
    }

    /**
     * Точка входу для запуску програми та головного меню.
     *
     * @param args Аргументи командного рядка (не використовуються в даному випадку).
     */
    public static void main(String[] args) {
        MainMenu yourObject = new MainMenu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Додатковий код, якщо потрiбно виконувати дiї пiсля виклику returnToMainMenu.
            if (!yourObject.returnToMainMenu(scanner)) {
                System.out.println("Дякуємо за використання додатка. До побачення! ");
                return;
            }
        }
    }
}