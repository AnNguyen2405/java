package clothe_management.database;

import clothe_management.controller.entity.Employee;
import clothe_management.controller.enumVar.*;
import clothe_management.database.customException.DatabaseConnectionException;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO extends abstractGenericDAO<Employee>{
    public Employee findByID(String id){
        Connection connection = null;
        Employee employee = null;
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            connection = dbconnection.connectDatabase();
            String sql = "SELECT * FROM employee WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String current_employeeID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_sex = resultSet.getString("sex");
                String current_phone = resultSet.getString("phone");
                String current_address = resultSet.getString("address");
                int current_hour = resultSet.getInt("num_of_hours");
                String current_role = resultSet.getString("role");
                int current_salary = resultSet.getInt("salary");
                employee = new Employee(current_employeeID, current_name, Sex.StringToEnum(current_sex),
                        current_phone, current_address, current_hour,
                        Role.StringToEnum(current_role), current_salary);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        finally {
            closeConnection(connection);
        }
        return employee;
    };

    public ArrayList<Employee> findByName(String name){
        Connection connection = null;
        ArrayList<Employee> employee_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            connection = dbconnection.connectDatabase();
            String sql = "SELECT * FROM employee WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_employeeID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_sex = resultSet.getString("sex");
                String current_phone = resultSet.getString("phone");
                String current_address = resultSet.getString("address");
                int current_hour = resultSet.getInt("num_of_hours");
                String current_role = resultSet.getString("role");
                int current_salary = resultSet.getInt("salary");
                Employee employee = new Employee(current_employeeID, current_name, Sex.StringToEnum(current_sex),
                        current_phone, current_address, current_hour,
                        Role.StringToEnum(current_role), current_salary);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        finally {
            closeConnection(connection);
        }
        return employee_list;
    };

    public ArrayList<Employee> getAll(){
        Connection connection = null;
        ArrayList<Employee> employee_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            connection = dbconnection.connectDatabase();
            String sql = "SELECT * FROM Product";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_employeeID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_sex = resultSet.getString("sex");
                String current_phone = resultSet.getString("phone");
                String current_address = resultSet.getString("address");
                int current_hour = resultSet.getInt("num_of_hours");
                String current_role = resultSet.getString("role");
                int current_salary = resultSet.getInt("salary");
                Employee employee = new Employee(current_employeeID, current_name, Sex.StringToEnum(current_sex),
                        current_phone, current_address, current_hour,
                        Role.StringToEnum(current_role), current_salary);
                employee_list.add(employee);
            }
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        finally {
            closeConnection(connection);
        }
        return employee_list;
    };

    public int insert(Employee entity){
        Connection connection = null;
        String message = "0 row(s) added. ";
        int addedRow = 0;
        try {
            connection = dbconnection.connectDatabase();
            String sql = "INSERT INTO employee(ID, name, sex, phone, address, num_of_hours, role, salary) " +
                    "VALUES (?,?,?,?,?,?,?,?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getEmployeeID());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSex().name());
            preparedStatement.setString(4, entity.getPhone());
            preparedStatement.setString(5, entity.getAddress());
            preparedStatement.setInt(6, entity.getHours());
            preparedStatement.setString(7, entity.getRole().name());
            preparedStatement.setInt(8, entity.getSalary());
            addedRow = preparedStatement.executeUpdate();
            message = Integer.toString(addedRow) + " row(s) added. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        finally {
            closeConnection(connection);
        }
        return addedRow;
    };

    public int update(Employee entity){
        Connection connection = null;
        String message = "0 rows updated";
        int updatedRow = 0;
        try {
            connection = dbconnection.connectDatabase();
            String sql = "UPDATE employee SET name = ?, sex = ?, phone = ?, address = ?, num_of_hours = ?, " +
                    "role = ?, salary = ?  WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSex().name());
            preparedStatement.setString(3, entity.getPhone());
            preparedStatement.setString(4, entity.getAddress());
            preparedStatement.setInt(5, entity.getHours());
            preparedStatement.setString(6, entity.getRole().name());
            preparedStatement.setInt(7, entity.getSalary());
            preparedStatement.setString(8, entity.getEmployeeID());
            updatedRow = preparedStatement.executeUpdate();
            message = Integer.toString(updatedRow) + " row(s) updated.";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        finally {
            closeConnection(connection);
        }
        return updatedRow;
    };

    public int delete(String id){
        Connection connection = null;
        String message = "0 rows affected";
        int deletedRow = 0;
        try {
            connection = dbconnection.connectDatabase();
            String sql = "DELETE FROM employee where ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            deletedRow = preparedStatement.executeUpdate();
            message = Integer.toString(deletedRow) + " row(s) deleted.";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        }catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        finally {
            closeConnection(connection);
        }
        return deletedRow;
    };

    public int calculateSalary(Employee entity) {
        return 0;
    }
}
