/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjasperlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Fornisce metodi di accesso al DB in lettura e scrittura.
 */
public class DbHelper {

    private Connection connection;

    /**
     * Costuttore
     */
    public DbHelper() {
        try {
            Class.forName(Constants.DB_JDBC_DRIVER);
            this.setConnection(DriverManager.getConnection(Constants.DB_SQL_URL));
        } catch (ClassNotFoundException cnfe) {
            System.err.println("[DBHELPER] \t" + cnfe.toString());
        } catch (SQLException sqle) {
            System.err.println("[DBHELPER] \t" + sqle.toString());
        }
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    private void setConnection(Connection connection) {
        this.connection = connection;
    }
}
