package ru.gb.lesson_5;

/*
1. Создать базу данных Student с полями id, name, mark.
2. Создать сущность Student и добавить в нее аннотации. Поле id должно заполняться автоматически.
3. Создать конфигурационный файл hibernate.cfg.xml, в котором указать свойства для подключения к БД и список классов с аннотациями Entity.
4. Создать класс со статическим методом, который возвращает объект SessionFactory.
5. Создать DAO-слой с операциями добавления, удаления, изменения сущности, выборки записи по ID и всех записей.
6. Добавить 1000 записей в таблицу Student.
7. Проверить работоспособность приложения, выполнить методы по удалению, изменению,
добавлению записей, а также выборки одной и всех записей.
*/

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DAOHibernate {

    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager entityManager = factory.createEntityManager();
//        Student student1 = new Student("Bob",100);
//        Student student2 = new Student("Rey",50);
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(student1);
//        entityManager.persist(student2);
//
//        entityManager.getTransaction().commit();
//
        entityManager.getTransaction().begin();
        Student s1 = entityManager.find(Student.class, 2L);
        entityManager.getTransaction().commit();
        s1.setName("Art212322322");


        entityManager.getTransaction().begin();
        entityManager.merge(s1);
        entityManager.getTransaction().commit();

//        entityManager.getTransaction().begin();
//        for (int i = 0; i <1000 ; i++) {
//            entityManager.persist(new Student("Bobi"+i,i));
//        }
//        entityManager.getTransaction().commit();


    }
}
