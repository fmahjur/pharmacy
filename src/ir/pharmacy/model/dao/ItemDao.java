package ir.pharmacy.model.dao;

import ir.pharmacy.model.entity.Item;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static ir.maktab.model.dao.DBConnection.getConnection;

public class ItemDao {
    public void insertItem(Item item) throws Exception {
        String insertQuery = "INSERT INTO item (prescription_id, drug_name, price, does_exist) VALUES (?, ?, ?, ?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertQuery);
        prepareStatement.setInt(1, item.getPrescriptionId());
        prepareStatement.setString(2, item.getName());
        prepareStatement.setDouble(3, item.getPrice());
        prepareStatement.setBoolean(4, item.isDoesExist());
        prepareStatement.executeUpdate();
        getConnection().close();
    }

    public void deletePrescription(int prescriptionId, String drugName) throws SQLException {
        String deleteQuery = "DELETE FROM item WHERE prescription_id =  '" + prescriptionId + "' drug_name = '" + drugName + "'";
        Statement statement = getConnection().createStatement();
        statement.executeUpdate(deleteQuery);
        getConnection().close();
    }
}
