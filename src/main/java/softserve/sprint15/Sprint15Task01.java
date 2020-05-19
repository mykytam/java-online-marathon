package softserve.sprint15;

// Develop a database with tables Roles, Employee, Directions and Projects.

import java.sql.*;

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
        this.schemaName = schemaName;
        String sql = "CREATE SCHEMA " + this.schemaName;
        statement.executeUpdate(sql);
    }
    public void dropSchema() throws SQLException {
        statement = createStatement();
        String sql = "DROP SCHEMA " + schemaName;
        statement.executeUpdate(sql);
    }
    public void useSchema() throws SQLException {
        statement = createStatement();
        String sql = "USE " + schemaName;
        statement.executeUpdate(sql);
    }
    public void createTableRoles() throws SQLException {
        statement = createStatement();
        String sql = "CREATE TABLE ROLES " +
                "(`id` INTEGER not NULL AUTO_INCREMENT, " +
                "`roleName` VARCHAR(255), " +
                "PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
    }
    public void createTableDirections() throws SQLException {
        statement = createStatement();
        String sql = "CREATE TABLE DIRECTIONS " +
                "(`id` INTEGER not NULL AUTO_INCREMENT, " +
                "`directionName` VARCHAR(255), " +
                "PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
    }
    public void createTableProjects() throws SQLException {
        statement = createStatement();
        String sql = "CREATE TABLE PROJECTS " +
                "(`id` INTEGER not NULL AUTO_INCREMENT, " +
                "`projectName` VARCHAR(255), " +
                "`directionId` INTEGER not NULL," +
                "PRIMARY KEY ( `id` )," +
                "FOREIGN KEY (`directionId`) REFERENCES DIRECTIONS (`id`))";
        statement.executeUpdate(sql);
    }
    public void createTableEmployee() throws SQLException {
        statement = createStatement();
        String sql = "CREATE TABLE EMPLOYEE " +
                "(`id` INTEGER not NULL AUTO_INCREMENT, " +
                "`firstName` VARCHAR(255), " +
                "`roleId` INTEGER not NULL," +
                "`projectId` INTEGER not NULL," +
                "PRIMARY KEY ( `id` )," +
                "FOREIGN KEY (`roleId`) REFERENCES ROLES (`id`)," +
                "FOREIGN KEY (`projectId`) REFERENCES PROJECTS (`id`))";
        statement.executeUpdate(sql);
    }
    public void dropTable(String tableName) throws SQLException {
        statement = createStatement();
        String sql = "DROP TABLE " + tableName;
        statement.executeUpdate(sql);
    }
    public void insertTableRoles(String roleName) throws SQLException {
        statement = createStatement();
        String sql = "INSERT INTO ROLES (`roleName`) VALUES ('" + roleName + "');";
        statement.execute(sql);
    }
    public void insertTableDirections(String directionName) throws SQLException {
        statement = createStatement();
        String sql = "INSERT INTO DIRECTIONS (`directionName`) VALUES ('" + directionName + "');";
        statement.execute(sql);
    }
    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        statement = createStatement();
        int directionId = getDirectionId(directionName);
        statement.execute("INSERT INTO PROJECTS (projectName, directionId) VALUES ('" + projectName + "', " + directionId + ");");
    }
    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        statement = createStatement();
        int roleId = getRoleId(roleName);
        int projectId = getProjectId(projectName);
        String sql = "INSERT INTO EMPLOYEE (`firstName`, `roleId`, `projectId`) VALUES ('" + firstName + "', " + roleId + ", " + projectId + ");";
        statement.execute(sql);
    }
    public int getRoleId(String roleName) throws SQLException {
        statement = createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id FROM ROLES WHERE roleName='" + roleName + "';");
        int role = -1;
        if (resultSet.next()) {
            role = resultSet.getInt(1);
        }
        resultSet.close();
        return role;
    }
    public int getDirectionId(String directionName) throws SQLException {
        statement = createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id FROM DIRECTIONS WHERE directionName='" + directionName + "';");
        int direction = -1;
        if (resultSet.next()) {
            direction = resultSet.getInt(1);
        }
        resultSet.close();
        return direction;
    }
    public int getProjectId(String projectName) throws SQLException {
        statement = createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id FROM PROJECTS WHERE projectName='" + projectName + "';");
        int res = -1;
        if (resultSet.next()) {
            res = resultSet.getInt(1);
        }
        return res;
    }
    public int getEmployeeId(String firstName) throws SQLException {
        statement = createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id FROM EMPLOYEE WHERE firstName='" + firstName + "';");
        int res = -1;
        if (resultSet.next()) {
            res = resultSet.getInt(1);
        }
        return res;
    }
//    }
//    public List<String> getAllRoles() throws SQLException {
//        // code
//    }
//    public List<String> getAllDirestion() throws SQLException {
//        // code
//    }
//    public List<String> getAllProjects() throws SQLException {
//        // code
//    }
//    public List<String> getAllEmployee() throws SQLException {
//        // code
//    }
//    public List<String> getAllDevelopers() throws SQLException {
//        // code
//    }
//    public List<String> getAllJavaProjects() throws SQLException {
//        // code
//    }
//    public List<String> getAllJavaDevelopers() throws SQLException {
//        // code
//    }
}