package ru.gb.lesson_4.jdbc;
import java.sql.*;

/*
Задача про кинотеатр.
У фильма, который идет в кинотеатре, есть название, длительность (пусть будет 60, 90 или
120 минут), цена билета (в разное время и дни может быть разной), время начала сеанса
(один фильм может быть показан несколько раз в разное время и с разной ценой билета).
Есть информация о купленных билетах (номер билета, на какой сеанс).
*/

public class MainJDBC {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;


    public static void main(String[] args) {
        try {
            connect();
            createTableFilm();
            createTableSession();
            createTableTicket();
            createTableScheduleForTheDay();

            prepareStatementsNewFilm("Duna",60);
            prepareStatementsNewFilm("Terminator",90);
            prepareStatementsNewFilm("Rembo",60);
            prepareStatementsNewFilm("Avatar",120);

            prepareStatementsNewSession("9:00",100);
            prepareStatementsNewSession("10:00",200);
            prepareStatementsNewSession("11:00",300);
            prepareStatementsNewSession("12:00",400);
            prepareStatementsNewSession("13:00",500);
            prepareStatementsNewSession("14:00",600);
            prepareStatementsNewSession("15:00",700);
            prepareStatementsNewSession("16:00",800);

            prepareStatementsTicket(1,1);
            prepareStatementsTicket(1,1);
            prepareStatementsTicket(1,1);
            prepareStatementsTicket(2,4);
            prepareStatementsTicket(3,5);

            prepareStatementsTheDay("20.05.1990",1);
            prepareStatementsTheDay("20.05.1990",2);
            prepareStatementsTheDay("20.05.1990",3);
            prepareStatementsTheDay("20.05.1990",4);
            prepareStatementsTheDay("20.05.1990",5);










        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    // Составить грамотную нормализованную схему хранения этих данных в БД.

    private static void createTableFilm() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS filmTab (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " name TEXT,\n" +
                " duration INTEGER\n" +
                " );");
    }

    private static void createTableSession() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS sessionTab (\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "start_time TEXT,\n" +
                "price INTEGER\n" +
                " );");
    }

    private static void createTableTicket() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tiketTab (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " film_id INTEGER references filmTab (id),\n" +
                " session_id INTEGER references sessionTab (id)\n" +
                " );");
    }

    private static void createTableScheduleForTheDay() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS scheduleForTheDay (\n" +
                " day_data TEXT NOT NULL,\n" +
                " ticket_id INTEGER references tiketTab (id)\n" +
                "" +
                ");");
    }

    // Внести в нее 4–5 фильмов
    private static void prepareStatementsNewFilm(String name,int duration) throws SQLException {
        psInsert = connection.prepareStatement("insert into filmTab (name, duration) values (?, ?);");
        psInsert.setString(1,name);
        psInsert.setInt(2, duration);
        psInsert.executeUpdate();
    }

    // расписание на один день
    private static void prepareStatementsTheDay(String dayDate,int idTicket) throws SQLException {
        psInsert = connection.prepareStatement("insert into scheduleForTheDay (day_data, ticket_id) values (?, ?);");
        psInsert.setString(1,dayDate);
        psInsert.setInt(2, idTicket);
        psInsert.executeUpdate();
    }

    private static void prepareStatementsNewSession(String startTime,int price) throws SQLException {
        psInsert = connection.prepareStatement("insert into sessionTab (start_time, price) values (?, ?);");
        psInsert.setString(1,startTime);
        psInsert.setInt(2, price);
        psInsert.executeUpdate();
    }
    //  несколько проданных билетов
    private static void prepareStatementsTicket(int idFilm,int idSession) throws SQLException {
        psInsert = connection.prepareStatement("insert into tiketTab (film_id, session_id) values (?, ?);");
        psInsert.setInt(1,idFilm);
        psInsert.setInt(2, idSession);
        psInsert.executeUpdate();
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:db_kinohall.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Невозможно подключиться к БД");
        }
    }

    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
