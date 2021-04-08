package com.zoerAleksandr.lesson9;

import java.sql.*;
import java.util.ArrayList;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 02.04.2021 8:28
 */
class AddCats {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;

    // подключение
    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:cats.db");
        statement = connection.createStatement();
    }

    // отключение
    private static void disconnect() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // создание таблицы
    private static void create() throws SQLException {
        statement.execute("create table if not exists cats (id integer primary key autoincrement, name text, color text, age integer);");
    }

    // добавление котов в таблицу
    static void addCats(Cat[] cats) throws SQLException, ClassNotFoundException {
        connect();
        create();
        prepareStatement();
        connection.setAutoCommit(false);
        for (Cat cat : cats) {
            ps.setString(1, cat.getName());
            ps.setString(2, cat.getColor());
            ps.setInt(3, cat.getAge());
            ps.execute();
        }
        connection.commit();
        disconnect();
    }

    // создание ps
    private static void prepareStatement() throws SQLException {
        ps = connection.prepareStatement("insert into cats (name, color, age) values (?, ?, ?);");
    }

    // очистка БД
    static void clear() throws SQLException, ClassNotFoundException {
        connect();
        statement.execute("drop table if exists cats;");
        disconnect();
    }

    // чтение всех имен
    static ArrayList<String> readName() throws SQLException, ClassNotFoundException {
        connect();
        // выбрал ArrayList, потому что в нем не нужно указывать размер при инициализации.
        // А как получить количество строк из таблицы в БД ???
        ArrayList<String> list = new ArrayList<String>();
        try (ResultSet rs = statement.executeQuery("select name from cats")) {
            while (rs.next()) {
                list.add(rs.getString("name"));
            }
        }
        disconnect();
        return list;
    }

    // чтение всех цветов
    static ArrayList<String> readColor() throws SQLException, ClassNotFoundException {
        connect();
        ArrayList<String> list = new ArrayList<String>();
        try (ResultSet rs = statement.executeQuery("select color from cats")) {
            while (rs.next()) {
                list.add(rs.getString("color"));
            }
        }
        disconnect();
        return list;
    }

    // чтение всех возрастов
    static ArrayList<Integer> readAge() throws SQLException, ClassNotFoundException {
        connect();
        ArrayList<Integer> list = new ArrayList<Integer>();
        try (ResultSet rs = statement.executeQuery("select age from cats")) {
            while (rs.next()) {
                list.add(rs.getInt("age"));
            }
        }
        disconnect();
        return list;
    }

    // полная информация про кота
    static void dataCat(int i) throws SQLException, ClassNotFoundException {
        if (i < readName().size()) {
            System.out.printf("Имя кота - %s, цвет - %s, возраст - %d\n", readName().get(i), readColor().get(i), readAge().get(i));
        } else System.out.println("Кота с таким порядковым номкром не существует");
    }

    // изменение имени кота
    static void updateName() throws SQLException, ClassNotFoundException {
        connect();
        statement.executeUpdate("update cats set name = 'Новое имя' where id = 1");
        disconnect();
    }


}
