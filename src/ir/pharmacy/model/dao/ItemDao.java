package ir.pharmacy.model.dao;

import ir.pharmacy.model.entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static ir.maktab.model.dao.DBConnection.getConnection;

public class ItemDao {
    private static ItemDao instance;

    private ItemDao() {
    }

    public static ItemDao getInstance() {
        if (instance == null)
            return new ItemDao();
        return instance;
    }

    public void insertItem(Item item) throws Exception {
        String insertQuery = "INSERT INTO item (prescription_id, drug_name, price, does_exist) VALUES (?, ?, ?, ?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertQuery);
        prepareStatement.setInt(1, item.getPrescriptionId());
        prepareStatement.setString(2, item.getDrugName());
        prepareStatement.setDouble(3, item.getPrice());
        prepareStatement.setBoolean(4, item.isDoesExist());
        prepareStatement.executeUpdate();
        getConnection().close();
    }

    public void deleteItem(int prescriptionId, String drugName) throws SQLException {
        String deleteQuery = "DELETE FROM item WHERE prescription_id =  '" + prescriptionId + "' drug_name = '" + drugName + "'";
        Statement statement = getConnection().createStatement();
        statement.executeUpdate(deleteQuery);
        getConnection().close();
    }

    public List<Item> selectItems(int prescriptionId) throws Exception {
        String selectQuery = "SELECT * FROM item WHERE prescription_id =  '" + prescriptionId + "\'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        List<Item> items = null;
        Item item = null;
        while (resultSet.next()) {
            item = new Item(resultSet.getString("prescription_id"),
                    resultSet.getString("drug_name"),
                    resultSet.getDouble("price"),
                    resultSet.getBoolean("does_exist"));
            items.add(item);
        }
        getConnection().close();
        return items;
    }

    public boolean updateItem(Item item) throws Exception {
        String updateQuery = "UPDATE item Set (price = '" + item.getPrice() + "', does_exist = '" + item.isDoesExist() +
                "' WHERE medicine_name = '" + item.getDrugName() + "'";
        Statement statement = getConnection().createStatement();
        int flag = statement.executeUpdate(updateQuery);
        getConnection().close();
        return flag > 0;
    }
}
