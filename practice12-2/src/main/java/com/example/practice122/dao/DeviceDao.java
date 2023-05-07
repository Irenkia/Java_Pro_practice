package com.example.practice122.dao;

import com.example.practice122.entity.Device;
import com.example.practice122.exception.DaoException;
import com.example.practice122.util.ConnectionManager;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Component
public class DeviceDao implements Dao<Integer, Device> {
    private static final DeviceDao INSTANCE_DEVICE_DAO = new DeviceDao();

    private static final String FIND_ALL_SQL = """
             SELECT * FROM device
            """;


    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE device_id = ?
            """;

    private static final String SAVE_SQL = """
            INSERT INTO device (user_id, name, macaddr) 
            VALUES (?, ?, ?);
            """;

    private static final String UPDATE_SQL = """
            UPDATE device
            SET device_id = ?,
                user_id = ?,
                name = ?,
                macaddr = ?,
            WHERE device_id = ?    
            """;

    private static final String DELETE_SQL = """
            DELETE FROM device
            WHERE device_id = ?
            """;

    private DeviceDao() {
    }

    @Override
    public List<Device> findAll() {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Device> devices = (List<Device>)DeviceDao.getInstanceDeviceDao();
            while (resultSet.next()) {
                devices.add(buildDevice(resultSet));
            }
            return devices;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    private Device buildDevice(ResultSet resultSet) throws SQLException {
        return new Device(
                resultSet.getInt("device_id"),
                resultSet.getInt("user_id"),
                resultSet.getString("name"),
                resultSet.getString("macaddr")
        );
    }
    @Override
    public Optional<Device> findById(Integer id) {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Device device = new Device();
            if (resultSet.next()) {
                device = buildDevice(resultSet);
            }
            return Optional.ofNullable(device);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public Device save(Device device) {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(2, device.getUser_id());
            preparedStatement.setString(3, device.getName());
            preparedStatement.setString(4, device.getMacaddr());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                device.setDevice_id(generatedKeys.getInt("device_id"));
            }
            return device;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public void update(Device device) {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setInt(1, device.getDevice_id());
            preparedStatement.setInt(1, device.getUser_id());
            preparedStatement.setString(2, device.getName());
            preparedStatement.setString(3, device.getMacaddr());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }

    }

    @Override
    public boolean delete(Integer id) {
        try (Connection connection = ConnectionManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public static DeviceDao getInstanceDeviceDao() {
        return INSTANCE_DEVICE_DAO;
    }

}
