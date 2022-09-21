package ir.pharmacy.service.interfaces;

import ir.pharmacy.model.entity.Item;
import ir.pharmacy.model.entity.Prescription;

import java.sql.SQLException;
import java.util.List;

public interface PatientService {
    boolean addPrescription(Prescription prescription, List<Item> items) throws Exception;

    void deletePrescription(Prescription prescription) throws Exception;

    void deleteItemPrescription(Prescription prescription, String drugName) throws Exception;
}
