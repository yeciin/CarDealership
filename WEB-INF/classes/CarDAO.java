package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private String jdbcurl = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private String username = "root";
    private String password = "password";

    private static final String INSERT_CARS_SQL = "INSERT INTO cars" + " (make, model, year, mileage, price) VALUES" + "(?,?,?,?,?);";
    private static final String SELECT_CARS_SQL = "SELECT * FROM cars WHERE id =?;";
    private static final String SELECT_ALL_CARS_SQL = "SELECT * FROM cars;";
    private static final String DELETE_CARS_SQL = "DELETE FROM cars WHERE id =?;";
    private static final String UPDATE_CARS_SQL = "UPDATE cars SET make =?, model=?, year=?, mileage=?, price=? where id=?;";

    public CarDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcurl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void insertCar(Car car) throws SQLException {
        System.out.println(INSERT_CARS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CARS_SQL)) {
            preparedStatement.setString(1, car.getMake());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setInt(4, car.getMileage());
            preparedStatement.setInt(5, car.getPrice());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car selectCar(int id) {
        Car car = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CARS_SQL);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String make = rs.getString("make");
                String model = rs.getString("model");
                int year = rs.getInt("year");
                int mileage = rs.getInt("mileage");
                int price = rs.getInt("price");
                car = new Car(id, make,model,year,mileage,price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public List< Car > selectAllCars() {
        List < Car > cars = new ArrayList< >();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARS_SQL);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String make = rs.getString("make");
                String model = rs.getString("model");
                int year = rs.getInt("year");
                int mileage = rs.getInt("mileage");
                int price = rs.getInt("price");
                cars.add(new Car(id, make,model,year,mileage,price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public boolean deleteCar(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CARS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateCar(Car car) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CARS_SQL);) {
            preparedStatement.setString(1, car.getMake());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setInt(4, car.getMileage());
            preparedStatement.setInt(5, car.getPrice());
            preparedStatement.setInt(6,car.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}
