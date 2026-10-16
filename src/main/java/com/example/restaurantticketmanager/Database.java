package com.example.restaurantticketmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class Database {
    private static final String URL = "jdbc:sqlite:database/pos.db";

    private Database() {
        // Utility class; do not instantiate.
    }

    // Open a database connection and enable foreign keys
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL);
        try (Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON");
        } catch (SQLException exception) {
            connection.close();
            throw exception;
        }
        return connection;
    }

    // Initializes the tables
    public static void initialize() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS menus (
                        id INTEGER PRIMARY KEY,
                        name TEXT NOT NULL UNIQUE
                    )
                    """);

            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS categories (
                        id INTEGER PRIMARY KEY,
                        menu_id INTEGER NOT NULL,
                        name TEXT NOT NULL,
                        UNIQUE (menu_id, name),
                        FOREIGN KEY (menu_id) REFERENCES menus(id) ON DELETE CASCADE
                    )
                    """);

            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS sides (
                        id INTEGER PRIMARY KEY,
                        menu_id INTEGER NOT NULL,
                        name TEXT NOT NULL,
                        UNIQUE (menu_id, name),
                        FOREIGN KEY (menu_id) REFERENCES menus(id) ON DELETE CASCADE
                    )
                    """);

            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS menu_items (
                        id INTEGER PRIMARY KEY,
                        menu_id INTEGER NOT NULL,
                        category_id INTEGER,
                        name TEXT NOT NULL,
                        is_appetizer INTEGER NOT NULL DEFAULT 0
                            CHECK (is_appetizer IN (0, 1)),
                        description TEXT NOT NULL DEFAULT '',
                        FOREIGN KEY (menu_id) REFERENCES menus(id) ON DELETE CASCADE,
                        FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL
                    )
                    """);

            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS menu_item_sides (
                        menu_item_id INTEGER NOT NULL,
                        side_id INTEGER NOT NULL,
                        PRIMARY KEY (menu_item_id, side_id),
                        FOREIGN KEY (menu_item_id) REFERENCES menu_items(id) ON DELETE CASCADE,
                        FOREIGN KEY (side_id) REFERENCES sides(id) ON DELETE CASCADE
                    )
                    """);
        }
    }
}
