package Seminar4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;

/**
 * Перенести структуру дз третьего урока на ЈРА:
 * * 1. Описать сущности Student u Group
 * 2. Написать запросы: Find, Persist, Remove
 * 3. ... поупражняться с разными запросами*
 */

public class Homework {
  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:students", "sa", "")) {
//      prepareTableStudent(connection);
      run(connection);
    } catch (SQLException e) {
      System.err.println("Не удалось подключится к дб: " + e.getMessage());
    }
  }

  private static void prepareTableStudent(Connection connection) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      statement.execute("""
              create table students(
                  id bigint,
                  first_name varchar(256),
                  second_name varchar(256),
                  group_name varchar(128)
              );        
              """);
    }
    try (Statement statement = connection.createStatement()) {
      statement.execute("""
              insert into students(id, first_name, second_name, group_name) values
                    (1, 'Max','Sidov','A'),
                    (2, 'Den','Pokor','A'),
                    (3, 'Elena','Givora','C'),
                    (4, 'Sasha','Sinia','B'),
                    (5, 'Siga','Lowor','B')
              """);
    }
  }


  private static void run(Connection connection) throws SQLException {
    Configuration configuration = new Configuration().configure();
    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
      try (Session session = sessionFactory.openSession()) {
        Student student = new Student();
        student.setId(2L);
        student.setFirst_name("Aaaaa");
        student.setSecond_name("bbbb");
        student.setGroup_name("A");


        Group group = new Group();
        group.setId(3L);
        group.setGroupName("A");

        Transaction ts = session.beginTransaction();
        session.persist(student);
        session.persist(group);
        ts.commit();
      }

      try (Session session = sessionFactory.openSession()) {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Student student = session.find(Student.class, 2L);
        System.out.println(student);
        System.out.println("");
        System.out.println("");
        System.out.println("");

      }

      try (Session session = sessionFactory.openSession()) {
        Student student = session.find(Student.class, 1);
        System.out.println(student);
      }

      Student student = new Student();
      student.setId(12L);
      student.setFirst_name("Oleg");
      student.setSecond_name("Mikhail");
      student.setGroup_name("E");
      try (Session session = sessionFactory.openSession()) {
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();
      }

      try (Session session = sessionFactory.openSession()) {
        Transaction transaction = session.beginTransaction();
        session.remove(student);
        transaction.commit();
      }

      try (Session session = sessionFactory.openSession()) {
        Student newstudent = session.find(Student.class, 12L);
        System.out.println(newstudent);
      }
    }
  }
}
