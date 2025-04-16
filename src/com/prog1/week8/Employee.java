package com.prog1.week8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {    // Employee class definition

    private int employeeNumber;
    private String lastName;
    private String firstName;
    private LocalDate birthday;
    private String address;
    private String phoneNumber;
    private String sssNumber;
    private String philhealthNumber;
    private String tinNumber;
    private String pagIbigNumber;
    private String status;
    private String position;
    private String iSupervisor; // immediate supervisor
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;
    

    public Employee(    // Constructor to initialize the Employee object with provided parameters        
        int employeeNumber,
        String lastName,    
        String firstName,       
        LocalDate birthday, 
        String address,     
        String phoneNumber,     
        String sssNumber,   
        String philhealthNumber,    
        String tinNumber,   
        String pagIbigNumber,   
        String status,      
        String position,            
        String immediateSupervisor, 
        double basicSalary, 
        double riceSubsidy,         
        double phoneAllowance, 
        double clothingAllowance, 
        double grossSemiMonthlyRate, 
        double hourlyRate
    ) {
        setEmployeeNumber       (employeeNumber         );
        setLastName             (lastName               );
        setFirstName            (firstName              );
        setBirthday             (birthday               );
        setAddress              (address                );
        setPhoneNumber          (phoneNumber            );
        setSssNumber            (sssNumber              );
        setPhilhealthNumber     (philhealthNumber       );
        setTinNumber            (tinNumber              );
        setPagIbigNumber        (pagIbigNumber          );
        setStatus               (status                 );
        setPosition             (position               );
        setISupervisor          (immediateSupervisor    );
        setBasicSalary          (basicSalary            );
        setRiceSubsidy          (riceSubsidy            );
        setPhoneAllowance       (phoneAllowance         );
        setClothingAllowance    (clothingAllowance      );
        setGrossSemiMonthlyRate (grossSemiMonthlyRate   );
        setHourlyRate           (hourlyRate             );
    }


    // Getters for accessing private fields
    public int       getEmployeeNumber      () { return employeeNumber;         } // 1
    public String    getLastName            () { return lastName;               } // 2
    public String    getFirstName           () { return firstName;              } // 3
    public LocalDate getBirthday            () { return birthday;               } // 4
    public String    getAddress             () { return address;                } // 5
    public String    getPhoneNumber         () { return phoneNumber;            } // 6
    public String    getSssNumber           () { return sssNumber;              } // 7
    public String    getPhilhealthNumber    () { return philhealthNumber;       } // 8
    public String    getTinNumber           () { return tinNumber;              } // 9
    public String    getPagIbigNumber       () { return pagIbigNumber;          } // 10
    public String    getStatus              () { return status;                 } // 11
    public String    getPosition            () { return position;               } // 12
    public String    getISupervisor         () { return iSupervisor;            } // 13
    public double    getBasicSalary         () { return basicSalary;            } // 14
    public double    getRiceSubsidy         () { return riceSubsidy;            } // 15
    public double    getPhoneAllowance      () { return phoneAllowance;         } // 16
    public double    getClothingAllowance   () { return clothingAllowance;      } // 17
    public double    getGrossSemiMonthlyRate() { return grossSemiMonthlyRate;   } // 18
    public double    getHourlyRate          () { return hourlyRate;             } // 19


    // Setters for modifying private fields
    public void setEmployeeNumber      (int employeeNumber)        { this.employeeNumber      = employeeNumber;       } // 1
    public void setLastName            (String lastName)           { this.lastName            = lastName;             } // 2
    public void setFirstName           (String firstName)          { this.firstName           = firstName;            } // 3
    public void setBirthday            (LocalDate birthday)        { this.birthday            = birthday;             } // 4
    public void setAddress             (String address)            { this.address             = address;              } // 5
    public void setPhoneNumber         (String phoneNumber)        { this.phoneNumber         = phoneNumber;          } // 6
    public void setSssNumber           (String sssNumber)          { this.sssNumber           = sssNumber;            } // 7
    public void setPhilhealthNumber    (String philhealthNumber)   { this.philhealthNumber    = philhealthNumber;     } // 8
    public void setTinNumber           (String tinNumber)          { this.tinNumber           = tinNumber;            } // 9
    public void setPagIbigNumber       (String pagIbigNumber)      { this.pagIbigNumber       = pagIbigNumber;        } // 10
    public void setStatus              (String status)             { this.status              = status;               } // 11
    public void setPosition            (String position)           { this.position            = position;             } // 12
    public void setISupervisor         (String iSupervisor)        { this.iSupervisor         = iSupervisor;          } // 13
    public void setBasicSalary         (double basicSalary)        { this.basicSalary         = basicSalary;          } // 14
    public void setRiceSubsidy         (double riceSubsidy)        { this.riceSubsidy         = riceSubsidy;          } // 15
    public void setPhoneAllowance      (double phoneAllowance)     { this.phoneAllowance      = phoneAllowance;       } // 16
    public void setClothingAllowance   (double clothingAllowance)  { this.clothingAllowance   = clothingAllowance;    } // 17
    public void setGrossSemiMonthlyRate(double grossSemiMonthlyRate) { this.grossSemiMonthlyRate = grossSemiMonthlyRate; } // 18
    public void setHourlyRate          (double hourlyRate)         { this.hourlyRate          = hourlyRate;           } // 19
    

    // Method to print the heading of the employee data table
    public static void printHeading() {
        String line = 
        "+-----+---------------+---------------+------------+---------------------------------------------------------------------------+------------+------------" +
        "+------------+---------------+------------+------------+------------------------------+----------------------+------------+------------+---------------" +
        "+------------------+-----------------------+-----------+";
        System.out.printf(
            //            1     2     3     4     5     6     7     8     9    10    11    12    13   14   15   16   17   18   19 
            "%s%n|%5s|%-15s|%-15s|%-12s|%-75s|%-12s|%-12s|%-12s|%-15s|%-12s|%-12s|%-30s|%-22s|%12s|%12s|%15s|%18s|%23s|%11s|%n%s%n", 
            line,
            "Emp #", "Last Name", "First Name", "Birthday", "Address", "Phone Number", 
            "SSS Number", "Philhealth #", "TIN Number", "Pag-Ibig #", "Status", "Position", "Immediate Supervisor",
            "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Gross Semi-Monthly Rate", "Hourly Rate",
            line
        );
    } // end of printHeading method
    

    // Method to print employee data in a formatted string
    public String printData() {                
        return String.format(
            //         1      2      3      4      5      6      7      8      9     10     11     12     13       14       15       16       17       18      19             
            "|%5d|%-15s|%-15s|%-12s|%-75s|%-12s|%-12s|%-12s|%-15s|%-12s|%-12s|%-30s|%-22s|%,12.0f|%,12.0f|%,15.0f|%,18.0f|%,23.0f|%11.2f|",  // aligned with header
            getEmployeeNumber(), getLastName(), getFirstName(), getBirthday().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), getAddress(), getPhoneNumber(), 
            getSssNumber(), getPhilhealthNumber(), getTinNumber(), getPagIbigNumber(), getStatus(), getPosition(), getISupervisor(), 
            getBasicSalary(), getRiceSubsidy(), getPhoneAllowance(), getClothingAllowance(), getGrossSemiMonthlyRate(), getHourlyRate()            
        );
    } // end of printData method


    @Override
    public String toString() {
        return String.format(
            "------------------------------------------------------------------------------------------------------\n" +
            "Employee Number .........: %5d\n" +
            "Last Name ...............: %-15s\n" + 
            "First Name ..............: %-15s\n" + 
            "Birthday ................: %-12s\n" + 
            "Address .................: %-75s\n" + 
            "Phone Number ............: %-12s\n" + 
            "SSS Number ..............: %-12s\n" + 
            "Philhealth ..............: %-12s\n" + 
            "TIN Number ..............: %-15s\n" + 
            "Pag-ibig # ..............: %-12s\n" + 
            "Status ..................: %-12s\n" + 
            "Position ................: %-30s\n" + 
            "Immediate Supervisor ....: %-22s\n" + 
            "Basic Salary ............: %,6.0f\n" + 
            "Rice Subsidy ............: %,6.0f\n" + 
            "Phone Allowance .........: %,6.0f\n" + 
            "Clothing Allowance ......: %,6.0f\n" + 
            "Gross Semi-monthly Rate .: %,6.0f\n" + 
            "Hourly Rate .............: %,9.2f\n", 
            getEmployeeNumber(), getLastName(), getFirstName(), getBirthday().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), getAddress(), getPhoneNumber(), 
            getSssNumber(), getPhilhealthNumber(), getTinNumber(), getPagIbigNumber(), getStatus(), getPosition(), getISupervisor(), 
            getBasicSalary(), getRiceSubsidy(), getPhoneAllowance(), getClothingAllowance(), getGrossSemiMonthlyRate(), getHourlyRate()            
        );
    } // end of toString method
} // end of Employee class
