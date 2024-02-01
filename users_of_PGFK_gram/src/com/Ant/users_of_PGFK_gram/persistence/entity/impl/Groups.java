package com.Ant.users_of_PGFK_gram.persistence.entity.impl;

import java.util.Objects;

/**
 * Клас, що представляє сутнiсть "Groups" iз властивостями, такими як назва групи та список учасникiв.
 */
public class Groups {

    /** Назва групи. */
    private final String groupName;

    /** Список учасникiв групи. */
    private String members;

    /**
     * Конструктор класу Groups.
     *
     * @param groupName Назва групи.
     * @param members Список учасникiв групи.
     */
    public Groups(String groupName, String members) {
        this.groupName = groupName;
        this.members = members;
    }

    /**
     * Отримати назву групи.
     *
     * @return Назва групи.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Отримати список учасникiв групи.
     *
     * @return Список учасникiв групи.
     */
    public String getMembers() {
        return members;
    }

    /**
     * Встановити новий список учасникiв групи.
     *
     * @param members Новий список учасникiв групи.
     */
    public void setMembers(String members) {
        this.members = members;
    }

    /**
     * Перевизначений метод equals() для порiвняння об'єктiв Groups.
     *
     * @param o Об'єкт для порiвняння.
     * @return true, якщо об'єкти рiвнi; false, якщо об'єкти вiдрiзняються.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groups groups = (Groups) o;
        return Objects.equals(groupName, groups.groupName) && Objects.equals(members, groups.members);
    }

    /**
     * Перевизначений метод hashCode() для генерацii хеш-коду об'єкта Groups.
     *
     * @return Хеш-код об'єкта Groups.
     */
    @Override
    public int hashCode() {
        return Objects.hash(groupName, members);
    }

    /**
     * Перевизначений метод toString() для отримання рядкового представлення об'єкта Groups.
     *
     * @return Рядкове представлення об'єкта Groups.
     */
    @Override
    public String toString() {
        return "Groups{" +
                "groupName='" + groupName + '\'' +
                ", members='" + members + '\'' +
                '}';
    }
}
