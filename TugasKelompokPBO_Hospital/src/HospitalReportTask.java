import java.util.ArrayList;
import java.util.function.Predicate;

public class HospitalReportTask implements Runnable {
    private String reportName;
    private DataManager<Patient> patients;
    private Predicate<Patient> filter;

    public HospitalReportTask(String reportName, DataManager<Patient> patients, Predicate<Patient> filter) {
        this.reportName = reportName;
        this.patients = patients;
        this.filter = filter;
    }

    @Override
    public void run() {
        synchronized (patients) {
            System.out.println("Thread " + Thread.currentThread().getName()
                + " menjalankan report: " + reportName);

            ArrayList<Patient> data = patients.getAllData();

            data.stream()
                .filter(filter)
                .forEach(p -> System.out.println("- " + p.getName()
                    + " | Golongan darah: " + p.getBloodType()
                    + " | Riwayat: " + p.getMedicalHistory()));
        }
    }
}