package ir.maktab.service.interfaces;

import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.Prescription;

import java.util.List;

public interface PatientService {
    boolean addPrescription(Prescription prescription, List<Item> items) throws Exception;

    void deletePrescription(Prescription prescription) throws Exception;

    void deleteItemPrescription(Prescription prescription, String drugName) throws Exception;
}
