package test.com.prog1.week6;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.prog1.week6.Attendance;
import java.time.LocalDate;
import java.time.LocalTime;





public class AttendanceTest {

    @Test
    public void testConstructorAndGetters() {
        LocalDate date = LocalDate.of(2023, 3, 15);
        LocalTime logInTime = LocalTime.of(9, 0);
        LocalTime logOutTime = LocalTime.of(17, 0);

        Attendance attendance = new Attendance(101, "Smith", "John", date, logInTime, logOutTime);

        assertEquals(101, attendance.getEmployeeNumber());
        assertEquals("Smith", attendance.getLastName());
        assertEquals("John", attendance.getFirstName());
        assertEquals(date, attendance.getDate());
        assertEquals(logInTime, attendance.getLogInTime());
        assertEquals(logOutTime, attendance.getLogOutTime());
    }

    @Test
    public void testSetters() {
        Attendance attendance = new Attendance(0, "", "", null, null, null);

        LocalDate date = LocalDate.of(2023, 3, 15);
        LocalTime logInTime = LocalTime.of(9, 0);
        LocalTime logOutTime = LocalTime.of(17, 0);

        attendance.setEmployeeNumber(102);
        attendance.setLastName("Doe");
        attendance.setFirstName("Jane");
        attendance.setDate(date);
        attendance.setLogInTime(logInTime);
        attendance.setLogOutTime(logOutTime);

        assertEquals(102, attendance.getEmployeeNumber());
        assertEquals("Doe", attendance.getLastName());
        assertEquals("Jane", attendance.getFirstName());
        assertEquals(date, attendance.getDate());
        assertEquals(logInTime, attendance.getLogInTime());
        assertEquals(logOutTime, attendance.getLogOutTime());
    }

    @Test
    public void testCalculateHoursWorked() {
        LocalTime logInTime = LocalTime.of(9, 0);
        LocalTime logOutTime = LocalTime.of(17, 30);

        Attendance attendance = new Attendance(101, "Smith", "John", LocalDate.now(), logInTime, logOutTime);

        assertEquals(8.5, attendance.calculateHoursWorked(), 0.01);
    }

    @Test
    public void testToString() {
        LocalDate date = LocalDate.of(2023, 3, 15);
        LocalTime logInTime = LocalTime.of(9, 0);
        LocalTime logOutTime = LocalTime.of(17, 0);

        Attendance attendance = new Attendance(101, "Smith", "John", date, logInTime, logOutTime);

        String expected = String.format("%-10d %-10s %-10s %-10s %-10s %-10s", 
            101, "Smith", "John", date, logInTime, logOutTime);

        assertEquals(expected, attendance.toString());
    }

    @Test
    public void testPrintData() {
        LocalDate date = LocalDate.of(2023, 3, 15);
        LocalTime logInTime = LocalTime.of(9, 0);
        LocalTime logOutTime = LocalTime.of(17, 0);

        Attendance attendance = new Attendance(101, "Smith", "John", date, logInTime, logOutTime);

        String expected = String.format("%-10d %-10s %-10s %-10s %-10s %-10s", 
            101, "Smith", "John", date, logInTime, logOutTime);

        assertEquals(expected, attendance.printData());
    }
}