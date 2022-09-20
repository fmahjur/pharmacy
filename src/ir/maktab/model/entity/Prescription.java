package ir.maktab.model.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Prescription {
    private Patient patient;
    private String doctorName;
    private Date date;
    private List<Medicine> medicineList;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(patient, that.patient) && Objects.equals(doctorName, that.doctorName) && Objects.equals(date, that.date) && Objects.equals(medicineList, that.medicineList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, doctorName, date, medicineList);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "patient=" + patient +
                ", doctorName='" + doctorName + '\'' +
                ", date=" + date +
                ", medicineList=" + medicineList +
                '}';
    }
}
