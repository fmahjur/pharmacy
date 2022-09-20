package ir.maktab.model.dao;

public class PatientDao {
    private static PatientDao instance;

    private PatientDao() {
    }

    public static PatientDao getInstance() {
        if(instance == null)
            return new PatientDao();
        return instance;
    }
}
