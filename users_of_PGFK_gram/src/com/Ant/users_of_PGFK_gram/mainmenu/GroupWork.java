package com.Ant.users_of_PGFK_gram.mainmenu;

import com.Ant.users_of_PGFK_gram.persistence.entity.impl.Groups;
import com.Ant.users_of_PGFK_gram.util.LocalDateAdapter;
import com.Ant.users_of_PGFK_gram.util.LocalDateDeserializer;
import com.Ant.users_of_PGFK_gram.util.LocalDateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupWork {
    public void GroupWork(String filePath) {
        Scanner scanner = new Scanner(System.in);
        List<Groups> groups = readGroupsFromFile(filePath);

        try {
            // Input user data
            System.out.print("Введiть iм'я користувачiв: ");
            String username = scanner.nextLine();
            System.out.print("Введiть iм'я групи: ");
            String groupName = scanner.nextLine();

            Groups newGroup = new Groups(groupName, username);
            groups.add(newGroup);

            writeGroupsToFile(groups, filePath);

            System.out.println("Щоб повернутись на головне меню настиснiть Enter");
            scanner.nextLine();

        } catch (Exception e) {
            // Handle errors during creation
            e.printStackTrace();
        }
    }

    public static List<Groups> readGroupsFromFile(String filePath) {
        List<Groups> groupsList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                    .create();

            Type groupListType = new TypeToken<List<Groups>>() {}.getType();

            groupsList = gson.fromJson(reader, groupListType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return groupsList;
    }

    private static void writeGroupsToFile(List<Groups> groups, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                    .setPrettyPrinting().create();

            gson.toJson(groups, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        String filePath = "Data/Group.json";
        /**
         * Завантажує данi про сховища з JSON файлу.
         *
         * @param filePath шлях до JSON файлу
         * @return список груп
         */
        public static List<Groups> loadDataFromJson(String filePath) {
            List<Groups> groups;

            try (FileReader reader = new FileReader(filePath)) {
                // Створюємо iнстанцiю Gson з використанням нашого TypeAdapter для LocalDate
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                        .create();
                // Визначаємо тип для десерiалiзацii
                Type groupsListType = new TypeToken<List<Groups>>() {
                }.getType();

                // Читаємо вмiст JSON файлу та десерiалiзуємо його у список
                groups = gson.fromJson(reader, groupsListType);
            } catch (IOException e) {
                // Обробка виняткiв (наприклад, файл не знайдено, проблеми з форматом JSON)
                System.err.println("Error loading data from JSON: " + e.getMessage());
                groups = List.of(); // Альтернативно, можна iнiцiалiзувати порожнiм списком
            }

            return groups;
        }


        /**
         * Виводить на екран iнформацiю про всi групи.
         */
        public void showgroups() {
            Scanner scanner = new Scanner(System.in);
            List<Groups> groups = loadDataFromJson(filePath);

            for (Groups group : groups) {
                System.out.println("Group Name: " + group.getGroupName());
                System.out.println("Members: " + group.getMembers());
                System.out.println(); // Add a new line after each group
            }

            System.out.println("Щоб повернутись на головне меню настиснiть Enter");
            scanner.nextLine();
        }
}