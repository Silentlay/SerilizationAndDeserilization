package org;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Program {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("person_persistence");
        EntityManager em = emf.createEntityManager();

        // Создание объекта
        em.getTransaction().begin();
        PersonJPA person = new PersonJPA("Наталия", 42);
        em.persist(person);
        em.getTransaction().commit();
        System.out.println("Объект сохранён в базе данных: " + person.getId());

        // Обновление объекта
        em.getTransaction().begin();
        person.setAge(20);
        em.merge(person);
        em.getTransaction().commit();
        System.out.println("Объект обновлён.");

        // Удаление объекта
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
        System.out.println("Объект удалён.");

        em.close();
        emf.close();
    }
}
