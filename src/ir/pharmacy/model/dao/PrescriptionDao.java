package ir.pharmacy.model.dao;

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

    public void insertPrescription(Prescription prescription) throws Exception {
        String insertQuery = "INSERT INTO prescription (patient_name, doctor_name, prescription_date, checke_status, approval_status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertQuery);
        prepareStatement.setString(1, prescription.getPatient().getUsername());
        prepareStatement.setString(2, prescription.getDoctorName());
        prepareStatement.setDate(3, (Date) prescription.getDate());
        prepareStatement.setBoolean(4, prescription.isCheckStatus());
        prepareStatement.setBoolean(5, prescription.isApprovalStatus());
        prepareStatement.executeUpdate();
        getConnection().close();
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

}
