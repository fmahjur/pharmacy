package ir.pharmacy.model.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Prescription {
    private int id;
    private Patient patient;
    private String doctorName;
    private Date date;
    private List<item> items;
    private boolean checkStatus;
    private boolean approvalStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<item> getItems() {
        return items;
    }

    public void setItems(List<item> items) {
        this.items = items;
    }

    public boolean isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    public boolean isApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return id == that.id && checkStatus == that.checkStatus && approvalStatus == that.approvalStatus && Objects.equals(patient, that.patient) && Objects.equals(doctorName, that.doctorName) && Objects.equals(date, that.date) && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctorName, date, items, checkStatus, approvalStatus);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "patient=" + patient +
                ", doctorName='" + doctorName + '\'' +
                ", date=" + date +
                ", items=" + items +
                ", checkStatus=" + checkStatus +
                ", approvalStatus=" + approvalStatus +
                '}';
    }
}
