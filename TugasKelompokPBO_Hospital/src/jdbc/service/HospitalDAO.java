package jdbc.service;

import jdbc.model.*;

public interface HospitalDAO {
    public void savePerson(Person p) throws Exception;
    public void saveRoom(Room r) throws Exception;
    public void saveAppointment(Appointment a) throws Exception;
}