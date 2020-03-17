import java.util.Date;

public class itemOfBase {
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

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public void setPatientMiddleName(String patientMiddleName) {
        this.patientMiddleName = patientMiddleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    public void setDoctorMiddleName(String doctorMiddleName) {
        this.doctorMiddleName = doctorMiddleName;
    }

    public void setReport(String report) {
        this.report = report;
    }


}
