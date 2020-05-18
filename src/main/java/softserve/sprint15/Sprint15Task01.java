package softserve.sprint15;

// Develop a database with tables Roles, Employee, Directions and Projects.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class MyUtils1501 {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        statement = createStatement();
        String sql = "CREATE SCHEMA " + schemaName;
        statement.executeUpdate(sql);
    }

    public void dropSchema() throws SQLException {
        String sql = "DROP SCHEMA " + schemaName;
        statement.executeUpdate(sql);
    }

    public void createTableRoles() throws SQLException {
        String sql = "CREATE TABLE ROLES " +
                "(id INTEGER not NULL, " +
                "roleName VARCHAR(255), " +
                "PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
    }

    public void createTableDirections() throws SQLException {
        String sql = "CREATE TABLE DIRECTIONS " +
                "(id INTEGER not NULL, " +
                "directionName VARCHAR(255), " +
                "PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
    }

    public void createTableProjects() throws SQLException {
        String sql = "CREATE TABLE PROJECTS " +
                "(id INTEGER not NULL, " +
                "projectName VARCHAR(255), " +
                "FOREIGN KEY (directionId)" +
                "PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
    }

    public void createTableEmployee() throws SQLException {
        String sql = "CREATE TABLE EMPLOYEE " +
                "(id INTEGER not NULL, " +
                "firstName VARCHAR(255), " +
                "FOREIGN KEY (roleId)" +
                "FOREIGN KEY (projectId)" +
                "PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = "DROP TABLE " + tableName;
        statement.executeUpdate(sql);
    }

    public void insertTableRoles(String roleName) throws SQLException {
        String sql = "INSERT INTO ROLES (roleName) VALUES (" + roleName + ")";
        statement.executeUpdate(sql);
    }
}