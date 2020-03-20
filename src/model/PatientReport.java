package model;

import java.util.Date;

public class PatientReport {
    private String patientName;
    private String patientSurname;
    private String patientMiddleName;
    private String address;
    private Date date;

    private String doctorName;
    private String doctorSurname;
    private String doctorMiddleName;

    private String report;

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientMiddleName(String patientMiddleName) {
        this.patientMiddleName = patientMiddleName;
    }

    public String getPatientMiddleName() {
        return patientMiddleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorMiddleName(String doctorMiddleName) {
        this.doctorMiddleName = doctorMiddleName;
    }

    public String getDoctorMiddleName() {
        return doctorMiddleName;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }
}
