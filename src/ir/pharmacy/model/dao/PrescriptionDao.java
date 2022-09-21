package ir.pharmacy.model.dao;

import ir.pharmacy.model.entity.Item;
import ir.pharmacy.model.entity.Prescription;

import java.sql.*;

import static ir.maktab.model.dao.DBConnection.getConnection;

public class PrescriptionDao {
    private static PrescriptionDao instance;

    private PrescriptionDao() {
    }

    public static PrescriptionDao getInstance() {
        if (instance == null)
            return new PrescriptionDao();
        return instance;
    }

    public int insertPrescription(Prescription prescription) throws Exception {
        String insertQuery = "INSERT INTO prescription (patient_name, doctor_name, prescription_date) VALUES (?, ?, ?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertQuery);
        prepareStatement.setString(1, prescription.getPatient().getUsername());
        prepareStatement.setString(2, prescription.getDoctorName());
        prepareStatement.setDate(3, (Date) prescription.getDate());
        prepareStatement.executeUpdate();

        ResultSet resultSet = prepareStatement.getGeneratedKeys();
        int generatedKey = 0;
        if (resultSet.next())
            generatedKey = resultSet.getInt(1);
        getConnection().close();
        return generatedKey;
    }

    public void deletePrescription(int id) throws SQLException {
        String deleteQuery = "DELETE FROM prescription WHERE id =  '" + id + "'";
        Statement statement = getConnection().createStatement();
        statement.executeUpdate(deleteQuery);
        getConnection().close();
    }

    public Prescription selectPrescriptionByPatient(String patient) throws SQLException {
        String selectQuery = "SELECT * FROM prescription WHERE patient = '" + patient + "'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        Prescription prescription = null;
        if (resultSet.next()) {
            prescription = new Prescription();
        }
        getConnection().close();
        return prescription;
    }

    public Prescription selectPrescriptionById(int id) throws SQLException {
        String selectQuery = "SELECT * FROM prescription WHERE id = '" + id + "'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        Prescription prescription = null;
        if (resultSet.next()) {
            prescription = new Prescription();
        }
        getConnection().close();
        return prescription;
    }

    public boolean updateCheckStatusPrescription(Prescription prescription) throws Exception {
        String updateQuery = "UPDATE prescription Set (check_status = '" + prescription.isCheckStatus() +
                "' WHERE id = '" + prescription.getId() + "'";
        Statement statement = getConnection().createStatement();
        int flag = statement.executeUpdate(updateQuery);
        getConnection().close();
        return flag > 0;
    }

    public boolean updateApprovalStatusPrescription(Prescription prescription) throws Exception {
        String updateQuery = "UPDATE prescription Set approval_status = '" + prescription.isApprovalStatus() +
                "' WHERE id = '" + prescription.getId() + "'";
        Statement statement = getConnection().createStatement();
        int flag = statement.executeUpdate(updateQuery);
        getConnection().close();
        return flag > 0;
    }

}
