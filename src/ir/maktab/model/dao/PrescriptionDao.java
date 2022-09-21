package ir.maktab.model.dao;

import ir.maktab.model.entity.Medicine;
import ir.maktab.model.entity.Patient;
import ir.maktab.model.entity.Prescription;

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
        String insertQuery = "INSERT INTO prescription (id, patient, doctor, prescription_date, medicine) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertQuery);
        for (Medicine medicine : prescription.getMedicineList()) {
            prepareStatement.setInt(1, prescription.getId());
            prepareStatement.setString(2, prescription.getPatient().getUsername());
            prepareStatement.setString(3, prescription.getDoctorName());
            prepareStatement.setDate(4, (Date) prescription.getDate());
            prepareStatement.setString(5, medicine.getName());
            prepareStatement.executeUpdate();
        }
        getConnection().close();
    }

    public void deleteMedicineFromPrescription(String medicineName) throws SQLException {
        String deleteQuery = "DELETE FROM prescription WHERE medicine =  '" + medicineName + "'";
        Statement statement = getConnection().createStatement();
        statement.executeUpdate(deleteQuery);
        getConnection().close();
    }

    public Prescription selectPrescription(String patient, int id) throws SQLException {
        String selectQuery = "SELECT * FROM prescription WHERE patient = '" + patient + "' AND id = '" + id + "'";
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
