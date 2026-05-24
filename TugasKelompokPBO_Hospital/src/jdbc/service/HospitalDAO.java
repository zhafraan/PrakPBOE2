package jdbc.service;

import jdbc.model.Hospital;
import jdbc.model.Doctor;
import jdbc.model.Nurse;
import jdbc.model.Patient;
import jdbc.model.Appointment;
import jdbc.model.Room;
import jdbc.model.Bill;
import jdbc.model.MedicalRecord; 

public interface HospitalDAO {
    void saveHospital(Hospital hospital);
    void saveDoctor(Doctor doctor);
    void saveNurse(Nurse nurse);
    void savePatient(Patient patient);
    void saveAppointment(Appointment appointment);
    void saveRoom(Room room);
    void saveBill(Bill bill);
    void saveMedicalRecord(Patient patient); 
}