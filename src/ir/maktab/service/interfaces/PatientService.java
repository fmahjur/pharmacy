package ir.maktab.service.interfaces;

import ir.maktab.model.entity.Item;
import ir.maktab.model.entity.Prescription;

import java.util.List;

public interface PatientService {
    int addPrescription(Prescription prescription) throws Exception;

    void deletePrescription(Prescription prescription) throws Exception;

    void addItemsPrescription(int prescriptionId, String drugName) throws Exception;

    void deleteItemPrescription(int prescriptionId, String drugName) throws Exception;
}
