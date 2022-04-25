package com.company;

import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.*;

public class Main extends TextAnalyzer3000{
    public static final String DB_NAME = "wordoccurences.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\databases\\" + DB_NAME;

    public static final String TABLE_WORD = "word";

    public static final String COLUMN_NEW = "new";
    public static final String COLUMN_VALUES = "amount";
    public static final String COLUMN_TEST = "test";

    public static void main(String[] args) throws IOException {

        TextAnalyzer();

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            conn.setAutoCommit(false);   // false - Don't auto commit / true - do
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_WORD);

            //Creating table if it doesn't exist.
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_WORD +
                    " (" + COLUMN_NEW + " text, " +
                    COLUMN_VALUES + " integer, " +
                    COLUMN_TEST + " text" +
                    ")");

            insertContact(statement, "The", 224, "times");
            insertContact(statement, "Test", 0, "times");
            insertContact(statement, "This", 51, "times");
            insertContact(statement, "A", 71, "times");

//
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_WORD);
            while(results.next()) {
                System.out.println(results.getString(COLUMN_NEW) + " " +
                        results.getInt(COLUMN_VALUES) + " " +
                        results.getString(COLUMN_TEST));
            }

            results.close();
            statement.close();
            conn.close();

        } catch(SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void insertContact (Statement statement, String newword, int values, String test) throws SQLException{
        statement.execute("INSERT INTO " + TABLE_WORD +
                " (" + COLUMN_NEW + ", " +
                COLUMN_VALUES + ", " +
                COLUMN_TEST +
                " ) " +
                "VALUES('" + newword + "', " + values + ", '" + test + "')");
    }
}

