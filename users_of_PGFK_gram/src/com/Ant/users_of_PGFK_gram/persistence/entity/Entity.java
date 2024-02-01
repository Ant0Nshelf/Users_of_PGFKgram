package com.Ant.users_of_PGFK_gram.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Абстрактний клас, що представляє базову сутнiсть у системi "PGFK-gram".
 * Кожна сутнiсть має унiкальний iдентифiкатор (UUID), список помилок та прапорець, що вказує на валiднiсть сутностi.
 */
public abstract class Entity {

    /** Унiкальний iдентифiкатор сутностi. */
    protected final UUID id;

    /** Список помилок, пов'язаних з валiдацiєю сутностi. */
    protected List<String> errors;

    /** Прапорець, що вказує на валiднiсть сутностi. */
    protected boolean isValid;

    /**
     * Конструктор класу Entity.
     *
     * @param id Унiкальний iдентифiкатор сутностi.
     */
    protected Entity(UUID id) {
        errors = new ArrayList<>();
        this.id = id;
    }

    /**
     * Отримати унiкальний iдентифiкатор сутностi.
     *
     * @return Унiкальний iдентифiкатор сутностi.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Перевiрити валiднiсть сутностi.
     *
     * @return true, якщо сутнiсть валiдна; false, якщо є помилки валiдацii.
     */
    public boolean isValid() {
        return errors.isEmpty();
    }

    /**
     * Отримати список помилок валiдацii сутностi.
     *
     * @return Список помилок валiдацii.
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * Перевiрка рiвностi об'єктiв за iхнiм унiкальним iдентифiкатором.
     *
     * @param o Об'єкт для порiвняння.
     * @return true, якщо об'єкти рiвнi; false, якщо об'єкти вiдрiзняються.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id);
    }

    /**
     * Генерацiя хеш-коду на основi унiкального iдентифiкатора сутностi.
     *
     * @return Хеш-код сутностi.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
