package ir.maktab.model.dao;

import ir.maktab.model.entity.Patient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static ir.maktab.model.dao.DBConnection.getConnection;

public class PatientDao {
    private static PatientDao instance = new PatientDao();

    private PatientDao() {
    }

    public static PatientDao getInstance() {
        return instance;
    }

    public void insertPatient(Patient patient) throws Exception {
        String insertQuery = "INSERT INTO patient (firstname, lastname, national_code, mobile_number) VALUES (?, ?, ?, ?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertQuery);
        prepareStatement.setString(1, patient.getFirstname());
        prepareStatement.setString(2, patient.getLastname());
        prepareStatement.setString(3, patient.getNationalCode());
        prepareStatement.setString(4, patient.getMobilePhone());
        prepareStatement.executeUpdate();
        getConnection().close();
    }

    public void deletePatient(String username) throws SQLException {
        String deleteQuery = "DELETE FROM patient WHERE lastname =  '" + username + "'";
        Statement statement = getConnection().createStatement();
        statement.executeUpdate(deleteQuery);
        getConnection().close();
    }

    public Patient selectPatient(String username) throws SQLException {
        String selectQuery = "SELECT * FROM patient WHERE lastname = '" + username + "'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        Patient patient = null;
        if (resultSet.next()) {
            patient = new Patient(resultSet.getInt("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("national_code"),
                    resultSet.getString("mobile_number"));
        }
        getConnection().close();
        return patient;
    }

    public Patient patientValidation(Patient patient) throws Exception {
        String selectQuery = "SELECT * FROM patient " +
                "WHERE lastname = '" + patient.getUsername() + "' AND national_code = '" + patient.getPassword() + "'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        if (resultSet.next()) {
            patient.setId(resultSet.getInt("id"));
            patient.setFirstname(resultSet.getString("firstname"));
            patient.setLastname(resultSet.getString("lastname"));
            patient.setNationalCode(resultSet.getString("national_code"));
            patient.setMobilePhone(resultSet.getString("mobile_number"));
        }
        getConnection().close();
        return patient;
    }
}
