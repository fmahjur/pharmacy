package ir.maktab.model.entity;

import java.util.List;
import java.util.Objects;

public class Patient {

    private int id;
    private String firstname;
    private String lastname;
    private String nationalCode;
    private String mobilePhone;
    private String username;
    private String password;

    public Patient() {
    }

    public Patient(int patientId) {
        this.id = patientId;
    }

    public Patient(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Patient(int id, String firstname, String lastname, String nationalCode, String mobilePhone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCode = nationalCode;
        this.mobilePhone = mobilePhone;
        this.username = lastname;
        this.password = nationalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && Objects.equals(firstname, patient.firstname) && Objects.equals(lastname, patient.lastname) && Objects.equals(nationalCode, patient.nationalCode) && Objects.equals(mobilePhone, patient.mobilePhone) && Objects.equals(username, patient.username) && Objects.equals(password, patient.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, nationalCode, mobilePhone, username, password);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
