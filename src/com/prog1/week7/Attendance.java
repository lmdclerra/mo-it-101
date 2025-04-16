package com.prog1.week7;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Attendance {
    
	private int       employeeNumber;
    private String    lastName;
    private String    firstName;
    private LocalDate date;
    private LocalTime logInTime;
    private LocalTime logOutTime;    

    public Attendance(
        int       employeeNumber, 
        String    lastName, 
        String    firstName, 
        LocalDate date, 
        LocalTime logInTime, 
        LocalTime logOutTime
    ) { 
        // reason for using setters here is to validate the data before assigning it to the instance variables
        setEmployeeNumber(employeeNumber);
        setLastName      (lastName      );
        setFirstName     (firstName     );
        setDate          (date          );
        setLogInTime     (logInTime     );
        setLogOutTime    (logOutTime    );
    }

    public int       getEmployeeNumber  () { return employeeNumber; }
    public String    getLastName        () { return lastName;       }
    public String    getFirstName       () { return firstName;      }
    public LocalDate getDate            () { return date;           }
    public LocalTime getLogInTime       () { return logInTime;      }
    public LocalTime getLogOutTime      () { return logOutTime;     }

    public void setEmployeeNumber  (int       employeeNumber) { this.employeeNumber  = employeeNumber;  }
    public void setLastName        (String    lastName      ) { this.lastName        = lastName;        }
    public void setFirstName       (String    firstName     ) { this.firstName       = firstName;       }
    public void setDate            (LocalDate date          ) { this.date            = date;            }   
    public void setLogInTime       (LocalTime logInTime     ) { this.logInTime       = logInTime;       }
    public void setLogOutTime      (LocalTime logOutTime    ) { this.logOutTime      = logOutTime;      }
    
    // Optional setters for String parameters:
    // public void setEmployeeNumber  (String    employeeNumber) { this.employeeNumber  = Integer.parseInt(employeeNumber); }
    // public void setLogInTime       (String    logInTime     ) { this.logInTime       = LocalTime.parse(logInTime);  }
    // public void setLogOutTime      (String    logOutTime    ) { this.logOutTime      = LocalTime.parse(logOutTime); }
    // public void setDate            (String    date          ) { this.date            = LocalDate.parse(date);       }
    // public void setDate            (String    date, String pattern) { this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern)); }

    public double calculateHoursWorked() {                
        // Calculate the hours worked by subtracting logInTime from logOutTime
        /* return (logOutTime.getHour() - logInTime.getHour()) + 
               ((logOutTime.getMinute() - logInTime.getMinute()) / 60.0); */
        // return ChronoUnit.HOURS.between(logInTime, logOutTime); 
        return ChronoUnit.MINUTES.between(logInTime, logOutTime) / 60.0; 
    }
    
    @Override
    public String toString() {
        return String.format("%-10d %-10s %-10s %-10s %-10s %-10s", 
            employeeNumber, lastName, firstName, date, logInTime, logOutTime);
    }

    public String printData() {
        return String.format("%-10d %-10s %-10s %-10s %-10s %-10s", 
            employeeNumber, lastName, firstName, date, logInTime, logOutTime);
    }
}
