package com.Ant.users_of_PGFK_gram.persistence.entity.impl;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Клас, що представляє сутнiсть "People" iз властивостями такими, як дата народження, електронна пошта та iм'я користувача.
 */
public class People {

    /** Дата народження користувача. */
    private final LocalDate birthday;

    /** Електронна пошта користувача. */
    private String email;

    /** iм'я користувача. */
    private String username;

    /**
     * Конструктор класу People.
     *
     * @param birthday Дата народження користувача.
     * @param email Електронна пошта користувача.
     * @param username iм'я користувача.
     */
    public People(LocalDate birthday, String email, String username) {
        this.birthday = birthday;
        this.email = email;
        this.username = username;
    }

    /**
     * Отримати дату народження користувача.
     *
     * @return Дата народження користувача.
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Отримати електронну пошту користувача.
     *
     * @return Електронна пошта користувача.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Отримати iм'я користувача.
     *
     * @return iм'я користувача.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Встановити нову електронну пошту користувача.
     *
     * @param email Нова електронна пошта користувача.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Встановити нове iм'я користувача.
     *
     * @param username Нове iм'я користувача.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Перевизначений метод toString() для отримання рядкового представлення об'єкта People.
     *
     * @return Рядкове представлення об'єкта People.
     */
    @Override
    public String toString() {
        return "People{" +
                "birthday=" + birthday +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    /**
     * Перевизначений метод equals() для порiвняння об'єктiв People.
     *
     * @param o Об'єкт для порiвняння.
     * @return true, якщо об'єкти рiвнi; false, якщо об'єкти вiдрiзняються.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(birthday, people.birthday) && Objects.equals(email, people.email) && Objects.equals(username, people.username);
    }

    /**
     * Перевизначений метод hashCode() для генерацii хеш-коду об'єкта People.
     *
     * @return Хеш-код об'єкта People.
     */
    @Override
    public int hashCode() {
        return Objects.hash(birthday, email, username);
    }
}
