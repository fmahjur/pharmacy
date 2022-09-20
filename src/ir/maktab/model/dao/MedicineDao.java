package ir.maktab.model.dao;

import ir.maktab.model.entity.Medicine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static ir.maktab.model.dao.DBConnection.getConnection;

public class MedicineDao {
    private static MedicineDao instance;

    private MedicineDao() {
    }

    public static MedicineDao getInstance() {
        if (instance == null)
            return new MedicineDao();
        return instance;
    }

    public void insertMedicine(Medicine medicine) throws Exception {
        String insertQuery = "INSERT INTO medicine (medicine_name, price)" +
                " VALUES (?, ?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertQuery);
        prepareStatement.setString(1, medicine.getName());
        prepareStatement.setDouble(2, medicine.getPrice());
        prepareStatement.executeUpdate();
        getConnection().close();
    }

    public void deleteMedicine(String medicineName) throws Exception {
        String deleteQuery = "DELETE FROM medicine WHERE medicine_name =  \'" + medicineName + "\'";
        Statement statement = getConnection().createStatement();
        statement.executeUpdate(deleteQuery);
        getConnection().close();
    }

    public Medicine selectMedicine(String medicineName) throws Exception {
        String selectQuery = "SELECT * FROM patient WHERE medicine_name = \'" + medicineName + "\'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        Medicine medicine = null;
        if (resultSet.next()) {
            medicine = new Medicine(resultSet.getString("medicine_name"),
                    resultSet.getDouble("price"));
        }
        getConnection().close();
        return medicine;
    }

    public boolean updateMedicinePrice(String medicineName, double medicinePrice) throws Exception {
        String updateQuery = "UPDATE medicine Set price = \'" + medicinePrice + "\' WHERE medicine_name = \'" + medicineName + "\'";
        Statement statement = getConnection().createStatement();
        int flag = statement.executeUpdate(updateQuery);
        getConnection().close();
        return flag > 0;
    }
}
