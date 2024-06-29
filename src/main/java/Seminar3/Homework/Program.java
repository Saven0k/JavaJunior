package Seminar3.Homework;

import java.sql.*;

/** Повторить все, что было на семниаре на таблице Student с полями
 * 1. id bigint
 * 2. first_name varchar(256)
 * 3. second_name varchar(256)
 * 4. group varchar(128)
 * Написать запросы:
 * 1. Создать таблицу
 * 2. Наполнить таблицу данными (insert)
 * 3. Поиск всех студентов
 * 4. Поиск всех студентов по имени группы
 * */
public class Program {
    public static void main(String[] args){
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb, root,root")){
            acceptConnection(connection);
        } catch (SQLException e) {
            System.err.println("Не удалось подключится к дб: " + e.getMessage());
        }
    }

    static void acceptConnection(Connection connection) throws SQLException {
//        * 1. Создать таблицу
        try (Statement statement = connection.createStatement()) {
            boolean execute = statement.execute("""
                    create table student(
                        id bigint,
                        first_name varchar(256),
                        second_name varchar(256),
                        group_name varchar(128)
                    );        
                    """);
            System.out.println(execute);
        }


//      * 2. Наполнить таблицу данными (insert)
        try (Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate("""
                insert into student(id,first_name,second_name, group_name) values
                                    (1, 'Max','Sidov','A'),
                                    (2, 'Den','Pokor','A'),
                                    (3, 'Elena','Givora','C'),
                                    (4, 'Sasha','Sinia','B'),
                                    (5, 'Siga','Lowor','B')
            """);
            System.out.println("Колличество вставленных строк: " + count);
        }


//      * 3. Поиск всех студентов
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("""
            select id,first_name,second_name,group_name
            from student
            """);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String second_name = resultSet.getString("second_name");
                String group_name = resultSet.getString("group_name");
                System.out.println(String.format("Прочиатана строка: %s, %s, %s, %s", id, first_name,second_name,group_name ));
            }
        }
        System.out.println();
        System.out.println();

//      * 4. Поиск всех студентов по имени группы
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("""
            select id,first_name,second_name,group_name
            from student
            where group_name = 'A';
            """);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String second_name = resultSet.getString("second_name");
                String group_name = resultSet.getString("group_name");
                System.out.println(String.format("Прочиатана строка: %s, %s, %s, %s", id, first_name,second_name,group_name ));
            }
        }
    }
}
