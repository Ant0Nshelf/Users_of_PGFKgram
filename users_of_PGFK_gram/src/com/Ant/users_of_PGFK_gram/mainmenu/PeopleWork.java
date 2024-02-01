package com.Ant.users_of_PGFK_gram.mainmenu;

import com.Ant.users_of_PGFK_gram.persistence.entity.impl.People;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.Ant.users_of_PGFK_gram.util.LocalDateAdapter;
public class PeopleWork {
    String filePath = "Data/people.json";
    /**
     * Завантажує данi про сховища з JSON файлу.
     *
     * @param filePath шлях до JSON файлу
     * @return список користувачiв
     */
    public static List<People> loadDataFromJson(String filePath) {
        List<People> peoples;

        try (FileReader reader = new FileReader(filePath)) {
            // Створюємо iнстанцiю Gson з використанням нашого TypeAdapter для LocalDate
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();
            // Визначаємо тип для десерiалiзацii
            Type peopleListType = new TypeToken<List<People>>() {
            }.getType();

            // Читаємо вмiст JSON файлу та десерiалiзуємо його у список
            peoples = gson.fromJson(reader, peopleListType);
        } catch (IOException e) {
            // Обробка виняткiв (наприклад, файл не знайдено, проблеми з форматом JSON)
            System.err.println("Error loading data from JSON: " + e.getMessage());
            peoples = List.of(); // Альтернативно, можна iнiцiалiзувати порожнiм списком
        }

        return peoples;
    }


    /**
     * Виводить на екран iнформацiю про всiх користувачiв.
     */
    public void showpeoples() {
        Scanner scanner = new Scanner(System.in);
        List<People> peoples = loadDataFromJson(filePath);

        for (People people : peoples) {
            System.out.println("Name: " + people.getUsername());
            System.out.println("Username: " + people.getUsername());
            System.out.println("Birthdate: " + people.getBirthday());
            System.out.println(); // Add a new line after each person
        }

        System.out.println("Щоб повернутись на головне меню настиснiть Enter");
        scanner.nextLine();
    }
}
