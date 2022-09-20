package ir.maktab.model.dao;

public class PrescriptionDao {
    private static PrescriptionDao instance;

    private PrescriptionDao() {
    }

    public static PrescriptionDao getInstance() {
        if (instance == null)
            return new PrescriptionDao();
        return instance;
    }
}
