package com.prog1.week8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
Task 9: Apply Government Deductions

1.  Update your code to deduct standard government deductions after calculating an employee’s net wage. 
    Apply your learnings on methods to complete your task.
2.  Use the guide in MotorPH’s requirement site to identify how to compute deductions for your selected employee. 
3.  Your code should enable the calculation of SSS, Pag-ibig, Philhealth, and Income tax deductions.
4.  Add comments as necessary. Practice unit testing.
*/
public class Task9ApplyGovernmentDeductions {

    // Static data to simulate employee records from the database
    private static Employee[] employees = {

        new Employee(10001, "Garcia", "Manuel III", LocalDate.of(1983, 10, 11),
                "Valero Carpark Building Valero Street 1227, Makati City", "966-860-270",
                "44-4506057-3", "820126853951", "442-605-657-000", "691295330870",
                "Regular", "Chief Executive Officer", "N/A", 90000.00, 1500.00, 2000.00,
                1000.00, 45000.00, 535.71),

        new Employee(10002, "Lim", "Antonio", LocalDate.of(1988, 6, 19),
                "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite", "171-867-411",
                "52-2061274-9", "331735646338", "683-102-776-000", "663904995411",
                "Regular", "Chief Operating Officer", "Garcia, Manuel III", 60000.00,
                1500.00, 2000.00, 1000.00, 30000.00, 357.14),

        new Employee(10003, "Aquino", "Bianca Sofia", LocalDate.parse("08/04/1989", 
                DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City", "966-889-370",
                "30-8870406-2", "177451189665", "971-711-280-000", "171519773969",
                "Regular", "Chief Finance Officer", "Garcia, Manuel III", 60000.00,
                1500.00, 2000.00, 1000.00, 30000.00, 357.14),

        // Additional employees can be added here as needed
    };

    // row data as string to simulate the attendance records
    private static String attendanceData = 
        // day 1
        "10001,Garcia,Manuel III,06/03/2024,8:59,18:31\r\n" + //
        "10002,Lim,Antonio,06/03/2024,10:35,19:44\r\n" + //
        "10003,Aquino,Bianca Sofia,06/03/2024,10:23,18:32\r\n" + //
        "10004,Reyes,Isabella,06/03/2024,10:57,18:14\r\n" + //
        "10005,Hernandez,Eduard,06/03/2024,9:48,17:13\r\n" + //
        "10006,Villanueva,Andrea Mae,06/03/2024,9:31,19:29\r\n" + //
        "10007,San Jose,Brad,06/03/2024,9:09,16:30\r\n" + //
        "10008,Romualdez,Alice,06/03/2024,9:02,18:06\r\n" + //
        "10009,Atienza,Rosie,06/03/2024,8:18,17:40\r\n" + //
        "10010,Alvaro,Roderick,06/03/2024,8:10,15:13\r\n" + //
        "10011,Salcedo,Anthony,06/03/2024,9:08,19:36\r\n" + //
        "10012,Lopez,Josie,06/03/2024,9:47,18:43\r\n" + //
        "10013,Farala,Martha,06/03/2024,9:48,19:21\r\n" + //
        "10014,Martinez,Leila,06/03/2024,9:23,18:09\r\n" + //
        "10015,Romualdez,Fredrick,06/03/2024,8:41,19:27\r\n" + //
        "10016,Mata,Christian,06/03/2024,8:41,16:45\r\n" + //
        "10017,De Leon,Selena,06/03/2024,9:40,17:24\r\n" + //
        "10018,San Jose,Allison,06/03/2024,8:22,16:46\r\n" + //
        "10019,Rosario,Cydney,06/03/2024,9:53,17:24\r\n" + //
        "10020,Bautista,Mark,06/03/2024,8:47,16:27\r\n" + //
        "10021,Lazaro,Darlene,06/03/2024,9:37,18:45\r\n" + //
        "10022,Delos Santos,Kolby,06/03/2024,10:54,20:10\r\n" + //
        "10023,Santos,Vella,06/03/2024,10:27,20:10\r\n" + //
        "10024,Del Rosario,Tomas,06/03/2024,9:16,17:57\r\n" + //
        "10025,Tolentino,Jacklyn,06/03/2024,10:18,18:07\r\n" + //
        "10026,Gutierrez,Percival,06/03/2024,8:17,18:31\r\n" + //
        "10027,Manalaysay,Garfield,06/03/2024,9:05,19:14\r\n" + //
        "10028,Villegas,Lizeth,06/03/2024,8:52,17:23\r\n" + //
        "10029,Ramos,Carol,06/03/2024,10:57,21:44\r\n" + //
        "10030,Maceda,Emelia,06/03/2024,9:04,16:39\r\n" + //
        "10031,Aguilar,Delia,06/03/2024,10:07,20:51\r\n" + //
        "10032,Castro,John Rafael,06/03/2024,8:29,16:46\r\n" + //
        "10033,Martinez,Carlos Ian,06/03/2024,10:02,19:39\r\n" + //
        "10034,Santos,Beatriz,06/03/2024,10:05,18:12\r\n" + //
        // day 2
        "10001,Garcia,Manuel III,06/04/2024,9:47,19:07\r\n" + //
        "10002,Lim,Antonio,06/04/2024,10:11,20:16\r\n" + //
        "10003,Aquino,Bianca Sofia,06/04/2024,10:45,20:37\r\n" + //
        "10004,Reyes,Isabella,06/04/2024,9:45,16:54\r\n" + //
        "10005,Hernandez,Eduard,06/04/2024,9:50,20:20\r\n" + //
        "10006,Villanueva,Andrea Mae,06/04/2024,10:00,20:12\r\n" + //
        "10007,San Jose,Brad,06/04/2024,9:16,16:18\r\n" + //
        "10008,Romualdez,Alice,06/04/2024,9:36,18:56\r\n" + //
        "10009,Atienza,Rosie,06/04/2024,10:41,19:21\r\n" + //
        "10010,Alvaro,Roderick,06/04/2024,8:05,18:36\r\n" + //
        "10011,Salcedo,Anthony,06/04/2024,9:58,17:04\r\n" + //
        "10012,Lopez,Josie,06/04/2024,8:41,16:55\r\n" + //
        "10013,Farala,Martha,06/04/2024,8:13,17:58\r\n" + //
        "10014,Martinez,Leila,06/04/2024,9:11,17:10\r\n" + //
        "10015,Romualdez,Fredrick,06/04/2024,10:35,18:43\r\n" + //
        "10016,Mata,Christian,06/04/2024,10:15,18:12\r\n" + //
        "10017,De Leon,Selena,06/04/2024,9:04,17:32\r\n" + //
        "10018,San Jose,Allison,06/04/2024,10:40,21:01\r\n" + //
        "10019,Rosario,Cydney,06/04/2024,8:05,18:10\r\n" + //
        "10020,Bautista,Mark,06/04/2024,9:05,18:27\r\n" + //
        "10021,Lazaro,Darlene,06/04/2024,8:59,19:50\r\n" + //
        "10022,Delos Santos,Kolby,06/04/2024,10:58,18:51\r\n" + //
        "10023,Santos,Vella,06/04/2024,10:06,20:32\r\n" + //
        "10024,Del Rosario,Tomas,06/04/2024,8:35,18:14\r\n" + //
        "10025,Tolentino,Jacklyn,06/04/2024,8:01,15:39\r\n" + //
        "10026,Gutierrez,Percival,06/04/2024,8:25,16:41\r\n" + //
        "10027,Manalaysay,Garfield,06/04/2024,10:47,20:39\r\n" + //
        "10028,Villegas,Lizeth,06/04/2024,10:05,19:33\r\n" + //
        "10029,Ramos,Carol,06/04/2024,10:38,20:56\r\n" + //
        "10030,Maceda,Emelia,06/04/2024,8:20,16:30\r\n" + //
        "10031,Aguilar,Delia,06/04/2024,10:13,17:52\r\n" + //
        "10032,Castro,John Rafael,06/04/2024,8:48,16:36\r\n" + //
        "10033,Martinez,Carlos Ian,06/04/2024,10:10,18:54\r\n" + //
        "10034,Santos,Beatriz,06/04/2024,9:35,19:15\r\n" + //
        // day 3
        "10001,Garcia,Manuel III,06/05/2024,10:57,21:32\r\n" + //
        "10002,Lim,Antonio,06/05/2024,9:24,19:19\r\n" + //
        "10003,Aquino,Bianca Sofia,06/05/2024,9:18,18:46\r\n" + //
        "10004,Reyes,Isabella,06/05/2024,8:44,18:31\r\n" + //
        "10005,Hernandez,Eduard,06/05/2024,9:10,17:17\r\n" + //
        "10006,Villanueva,Andrea Mae,06/05/2024,8:28,16:52\r\n" + //
        "10007,San Jose,Brad,06/05/2024,9:25,17:45\r\n" + //
        "10008,Romualdez,Alice,06/05/2024,10:44,18:51\r\n" + //
        "10009,Atienza,Rosie,06/05/2024,10:46,17:54\r\n" + //
        "10010,Alvaro,Roderick,06/05/2024,9:48,19:19\r\n" + //
        "10011,Salcedo,Anthony,06/05/2024,10:50,20:28\r\n" + //
        "10012,Lopez,Josie,06/05/2024,8:52,19:40\r\n" + //
        "10013,Farala,Martha,06/05/2024,8:49,16:12\r\n" + //
        "10014,Martinez,Leila,06/05/2024,8:50,18:10\r\n" + //
        "10015,Romualdez,Fredrick,06/05/2024,8:06,17:06\r\n" + //
        "10016,Mata,Christian,06/05/2024,9:29,19:25\r\n" + //
        "10017,De Leon,Selena,06/05/2024,8:08,17:06\r\n" + //
        "10018,San Jose,Allison,06/05/2024,9:09,19:20\r\n" + //
        "10019,Rosario,Cydney,06/05/2024,9:14,19:40\r\n" + //
        "10020,Bautista,Mark,06/05/2024,10:42,21:00\r\n" + //
        "10021,Lazaro,Darlene,06/05/2024,10:18,18:05\r\n" + //
        "10022,Delos Santos,Kolby,06/05/2024,10:55,21:26\r\n" + //
        "10023,Santos,Vella,06/05/2024,10:01,20:19\r\n" + //
        "10024,Del Rosario,Tomas,06/05/2024,9:19,19:00\r\n" + //
        "10025,Tolentino,Jacklyn,06/05/2024,10:50,18:44\r\n" + //
        "10026,Gutierrez,Percival,06/05/2024,10:11,19:17\r\n" + //
        "10027,Manalaysay,Garfield,06/05/2024,8:57,17:35\r\n" + //
        "10028,Villegas,Lizeth,06/05/2024,10:14,19:01\r\n" + //
        "10029,Ramos,Carol,06/05/2024,8:02,15:06\r\n" + //
        "10030,Maceda,Emelia,06/05/2024,9:24,17:30\r\n" + //
        "10031,Aguilar,Delia,06/05/2024,9:24,18:09\r\n" + //
        "10032,Castro,John Rafael,06/05/2024,10:33,19:11\r\n" + //
        "10033,Martinez,Carlos Ian,06/05/2024,9:59,18:34\r\n" + //
        "10034,Santos,Beatriz,06/05/2024,10:38,18:12\r\n" + //
        // day 4
        "10001,Garcia,Manuel III,06/06/2024,9:32,19:15\r\n" + //
        "10002,Lim,Antonio,06/06/2024,10:47,20:43\r\n" + //
        "10003,Aquino,Bianca Sofia,06/06/2024,10:10,18:01\r\n" + //
        "10004,Reyes,Isabella,06/06/2024,10:09,18:01\r\n" + //
        "10005,Hernandez,Eduard,06/06/2024,10:47,19:28\r\n" + //
        "10006,Villanueva,Andrea Mae,06/06/2024,10:11,17:27\r\n" + //
        "10007,San Jose,Brad,06/06/2024,9:51,19:58\r\n" + //
        "10008,Romualdez,Alice,06/06/2024,9:21,16:49\r\n" + //
        "10009,Atienza,Rosie,06/06/2024,8:47,17:44\r\n" + //
        "10010,Alvaro,Roderick,06/06/2024,10:51,19:37\r\n" + //
        "10011,Salcedo,Anthony,06/06/2024,10:31,20:05\r\n" + //
        "10012,Lopez,Josie,06/06/2024,8:55,15:56\r\n" + //
        "10013,Farala,Martha,06/06/2024,10:55,21:18\r\n" + //
        "10014,Martinez,Leila,06/06/2024,9:08,17:30\r\n" + //
        "10015,Romualdez,Fredrick,06/06/2024,8:12,18:22\r\n" + //
        "10016,Mata,Christian,06/06/2024,9:11,18:56\r\n" + //
        "10017,De Leon,Selena,06/06/2024,10:10,19:33\r\n" + //
        "10018,San Jose,Allison,06/06/2024,8:25,15:51\r\n" + //
        "10019,Rosario,Cydney,06/06/2024,9:08,17:46\r\n" + //
        "10020,Bautista,Mark,06/06/2024,8:39,17:39\r\n" + //
        "10021,Lazaro,Darlene,06/06/2024,8:03,16:44\r\n" + //
        "10022,Delos Santos,Kolby,06/06/2024,8:09,18:21\r\n" + //
        "10023,Santos,Vella,06/06/2024,10:55,19:53\r\n" + //
        "10024,Del Rosario,Tomas,06/06/2024,10:00,19:11\r\n" + //
        "10025,Tolentino,Jacklyn,06/06/2024,10:05,17:32\r\n" + //
        "10026,Gutierrez,Percival,06/06/2024,8:13,15:42\r\n" + //
        "10027,Manalaysay,Garfield,06/06/2024,9:01,18:33\r\n" + //
        "10028,Villegas,Lizeth,06/06/2024,8:02,17:46\r\n" + //
        "10029,Ramos,Carol,06/06/2024,8:56,17:22\r\n" + //
        "10030,Maceda,Emelia,06/06/2024,9:59,20:54\r\n" + //
        "10031,Aguilar,Delia,06/06/2024,9:23,16:24\r\n" + //
        "10032,Castro,John Rafael,06/06/2024,10:24,20:21\r\n" + //
        "10033,Martinez,Carlos Ian,06/06/2024,10:55,21:16\r\n" + //
        "10034,Santos,Beatriz,06/06/2024,9:49,19:09\r\n" + //
        // day 5
        "10001,Garcia,Manuel III,06/07/2024,9:46,19:15\r\n" + //
        "10002,Lim,Antonio,06/07/2024,9:41,20:01\r\n" + //
        "10003,Aquino,Bianca Sofia,06/07/2024,10:22,20:15\r\n" + //
        "10004,Reyes,Isabella,06/07/2024,9:28,18:11\r\n" + //
        "10005,Hernandez,Eduard,06/07/2024,8:14,16:58\r\n" + //
        "10006,Villanueva,Andrea Mae,06/07/2024,8:18,18:23\r\n" + //
        "10007,San Jose,Brad,06/07/2024,8:12,15:12\r\n" + //
        "10008,Romualdez,Alice,06/07/2024,8:19,16:22\r\n" + //
        "10009,Atienza,Rosie,06/07/2024,10:09,20:58\r\n" + //
        "10010,Alvaro,Roderick,06/07/2024,9:08,17:12\r\n" + //
        "10011,Salcedo,Anthony,06/07/2024,8:05,18:24\r\n" + //
        "10012,Lopez,Josie,06/07/2024,10:26,19:03\r\n" + //
        "10013,Farala,Martha,06/07/2024,8:37,16:15\r\n" + //
        "10014,Martinez,Leila,06/07/2024,8:30,17:31\r\n" + //
        "10015,Romualdez,Fredrick,06/07/2024,9:56,20:26\r\n" + //
        "10016,Mata,Christian,06/07/2024,9:41,16:51\r\n" + //
        "10017,De Leon,Selena,06/07/2024,9:50,18:23\r\n" + //
        "10018,San Jose,Allison,06/07/2024,9:19,17:38\r\n" + //
        "10019,Rosario,Cydney,06/07/2024,10:04,17:34\r\n" + //
        "10020,Bautista,Mark,06/07/2024,8:45,17:21\r\n" + //
        "10021,Lazaro,Darlene,06/07/2024,9:52,19:04\r\n" + //
        "10022,Delos Santos,Kolby,06/07/2024,9:02,16:29\r\n" + //
        "10023,Santos,Vella,06/07/2024,10:13,18:01\r\n" + //
        "10024,Del Rosario,Tomas,06/07/2024,9:56,16:59\r\n" + //
        "10025,Tolentino,Jacklyn,06/07/2024,10:23,20:19\r\n" + //
        "10026,Gutierrez,Percival,06/07/2024,8:04,17:41\r\n" + //
        "10027,Manalaysay,Garfield,06/07/2024,9:36,17:22\r\n" + //
        "10028,Villegas,Lizeth,06/07/2024,8:29,19:24\r\n" + //
        "10029,Ramos,Carol,06/07/2024,9:56,20:35\r\n" + //
        "10030,Maceda,Emelia,06/07/2024,8:33,19:10\r\n" + //
        "10031,Aguilar,Delia,06/07/2024,9:18,18:25\r\n" + //
        "10032,Castro,John Rafael,06/07/2024,8:52,19:40\r\n" + //
        "10033,Martinez,Carlos Ian,06/07/2024,8:02,15:02\r\n" + //
        "10034,Santos,Beatriz,06/07/2024,10:38,21:21\r\n" + //
        // day 6
        "10001,Garcia,Manuel III,06/10/2024,9:10,18:36\r\n" + //
        "10002,Lim,Antonio,06/10/2024,8:02,18:40\r\n" + //
        "10003,Aquino,Bianca Sofia,06/10/2024,8:58,17:52\r\n" + //
        "10004,Reyes,Isabella,06/10/2024,10:10,18:58\r\n" + //
        "10005,Hernandez,Eduard,06/10/2024,8:05,18:04\r\n" + //
        "10006,Villanueva,Andrea Mae,06/10/2024,8:10,16:39\r\n" + //
        "10007,San Jose,Brad,06/10/2024,10:03,17:48\r\n" + //
        "10008,Romualdez,Alice,06/10/2024,10:06,19:18\r\n" + //
        "10009,Atienza,Rosie,06/10/2024,8:21,17:52\r\n" + //
        "10010,Alvaro,Roderick,06/10/2024,10:55,19:46\r\n" + //
        "10011,Salcedo,Anthony,06/10/2024,8:34,18:32\r\n" + //
        "10012,Lopez,Josie,06/10/2024,8:58,17:00\r\n" + //
        "10013,Farala,Martha,06/10/2024,8:06,15:55\r\n" + //
        "10014,Martinez,Leila,06/10/2024,9:43,19:52\r\n" + //
        "10015,Romualdez,Fredrick,06/10/2024,10:27,20:11\r\n" + //
        "10016,Mata,Christian,06/10/2024,9:58,20:46\r\n" + //
        "10017,De Leon,Selena,06/10/2024,9:52,18:35\r\n" + //
        "10018,San Jose,Allison,06/10/2024,10:51,20:16\r\n" + //
        "10019,Rosario,Cydney,06/10/2024,9:10,17:11\r\n" + //
        "10020,Bautista,Mark,06/10/2024,10:10,18:23\r\n" + //
        "10021,Lazaro,Darlene,06/10/2024,9:03,16:45\r\n" + //
        "10022,Delos Santos,Kolby,06/10/2024,10:26,17:58\r\n" + //
        "10023,Santos,Vella,06/10/2024,9:25,16:34\r\n" + //
        "10024,Del Rosario,Tomas,06/10/2024,10:08,19:10\r\n" + //
        "10025,Tolentino,Jacklyn,06/10/2024,8:18,18:17\r\n" + //
        "10026,Gutierrez,Percival,06/10/2024,8:42,17:01\r\n" + //
        "10027,Manalaysay,Garfield,06/10/2024,8:06,15:36\r\n" + //
        "10028,Villegas,Lizeth,06/10/2024,9:28,16:52\r\n" + //
        "10029,Ramos,Carol,06/10/2024,9:09,17:05\r\n" + //
        "10030,Maceda,Emelia,06/10/2024,8:21,17:24\r\n" + //
        "10031,Aguilar,Delia,06/10/2024,10:24,20:26\r\n" + //
        "10032,Castro,John Rafael,06/10/2024,10:13,20:59\r\n" + //
        "10033,Martinez,Carlos Ian,06/10/2024,8:14,17:40\r\n" + //
        "10034,Santos,Beatriz,06/10/2024,8:01,17:28\r\n" + //
        // day 7
        "10001,Garcia,Manuel III,06/11/2024,10:30,20:53\r\n" + //
        "10002,Lim,Antonio,06/11/2024,9:55,19:49\r\n" + //
        "10003,Aquino,Bianca Sofia,06/11/2024,9:35,17:06\r\n" + //
        "10004,Reyes,Isabella,06/11/2024,9:28,20:26\r\n" + //
        "10005,Hernandez,Eduard,06/11/2024,8:48,16:10\r\n" + //
        "10006,Villanueva,Andrea Mae,06/11/2024,9:26,18:47\r\n" + //
        "10007,San Jose,Brad,06/11/2024,9:18,17:50\r\n" + //
        "10008,Romualdez,Alice,06/11/2024,8:09,17:46\r\n" + //
        "10009,Atienza,Rosie,06/11/2024,8:28,18:03\r\n" + //
        "10010,Alvaro,Roderick,06/11/2024,8:23,15:46\r\n" + //
        "10011,Salcedo,Anthony,06/11/2024,10:09,17:16\r\n" + //
        "10012,Lopez,Josie,06/11/2024,10:11,18:50\r\n" + //
        "10013,Farala,Martha,06/11/2024,8:40,19:20\r\n" + //
        "10014,Martinez,Leila,06/11/2024,10:46,20:44\r\n" + //
        "10015,Romualdez,Fredrick,06/11/2024,8:51,17:19\r\n" + //
        "10016,Mata,Christian,06/11/2024,9:10,16:26\r\n" + //
        "10017,De Leon,Selena,06/11/2024,9:47,19:03\r\n" + //
        "10018,San Jose,Allison,06/11/2024,9:32,17:59\r\n" + //
        "10019,Rosario,Cydney,06/11/2024,9:49,19:35\r\n" + //
        "10020,Bautista,Mark,06/11/2024,9:59,17:53\r\n" + //
        "10021,Lazaro,Darlene,06/11/2024,9:33,18:51\r\n" + //
        "10022,Delos Santos,Kolby,06/11/2024,9:28,18:33\r\n" + //
        "10023,Santos,Vella,06/11/2024,8:48,19:10\r\n" + //
        "10024,Del Rosario,Tomas,06/11/2024,9:49,17:56\r\n" + //
        "10025,Tolentino,Jacklyn,06/11/2024,8:21,17:48\r\n" + //
        "10026,Gutierrez,Percival,06/11/2024,10:35,20:15\r\n" + //
        "10027,Manalaysay,Garfield,06/11/2024,10:18,19:33\r\n" + //
        "10028,Villegas,Lizeth,06/11/2024,8:56,18:11\r\n" + //
        "10029,Ramos,Carol,06/11/2024,9:43,19:23\r\n" + //
        "10030,Maceda,Emelia,06/11/2024,8:20,18:18\r\n" + //
        "10031,Aguilar,Delia,06/11/2024,9:04,17:38\r\n" + //
        "10032,Castro,John Rafael,06/11/2024,9:11,17:52\r\n" + //
        "10033,Martinez,Carlos Ian,06/11/2024,10:15,20:21\r\n" + //
        "10034,Santos,Beatriz,06/11/2024,10:39,17:46" ;

        private static Map<Integer, Double> employeeSalaries;
        
    public static void main(String[] args) {
        displayEmployeeInformation();
        processingAttendanceLogs();
        calculateSalaryBasedOnHoursWorked();
        applyGovernmentDeductions();
    }
    
    // apply deductions for each (e.i., 3) employee with 7 days of attendance
    private static void applyGovernmentDeductions() {
        double sssDeduction         = 0.0; // total SSS deduction
        double philHealthDeduction  = 0.0; // total PhilHealth deduction
        double pagIbigDeduction     = 0.0; // total Pag-IBIG deduction
        double withholdingTax       = 0.0; // total tax deduction
        double totalDeduction       = 0.0; // total tax deduction
        
        // iterate through the employeeSalaries map to calculate deductions for each employee
        System.out.printf("| Employee ID | %-10s | %-10s | %-10s | %-10s |%n", "SSS", "PhilHealth", "Pag-IBIG", "Tax");        
        System.out.println("+-------------+--------- Government Deductions ------+------------+");
        for (Entry<Integer, Double> employee : employeeSalaries.entrySet()) {
            int employeeNumber    = employee.getKey(); // get the employee number
            double basicSalary    = employee.getValue(); // get the salary of the employee
            sssDeduction          += calculateSssDeduction(basicSalary); 
            philHealthDeduction   += calculatePhilHealthDeduction(basicSalary);
            pagIbigDeduction      += calculatePagIbigDeduction(basicSalary); 
            withholdingTax        += calculateWitholdingTaxDeduction(basicSalary);
            System.out.printf("| %11d | %,10.2f | %,10.2f | %,10.2f | %,10.2f |%n",             
            employeeNumber  , sssDeduction , philHealthDeduction , pagIbigDeduction , withholdingTax);
            totalDeduction += sssDeduction + philHealthDeduction + pagIbigDeduction + withholdingTax;
        }
                
        System.out.printf("Total Government Deductions: %,.2f%n", totalDeduction);
    }

    // basic salary as monthly rate
    private static double calculateWitholdingTaxDeduction(double monthlyRate) {
        double tax = 0.0; 
               if (monthlyRate <= 20_832) { tax = /* .......... No withholding tax ......... */ 0.00; 
        } else if (monthlyRate <  33_333) { tax =              (monthlyRate -  20_833) * 0.20; //                 20% in excess of  20,833
        } else if (monthlyRate <  66_667) { tax =   2_500.00 + (monthlyRate -  33_333) * 0.25; //   2,500.00 plus 25% in excess of  33,333
        } else if (monthlyRate < 166_667) { tax =  10_833.00 + (monthlyRate -  66_667) * 0.30; //  10,833.00 plus 30% in excess of  66,667
        } else if (monthlyRate < 666_667) { tax =  40_833.33 + (monthlyRate - 166_667) * 0.32; //  40,833.33 plus 32% in excess of 166,667
        } else /* (666,667 and above...*/ { tax = 200_833.33 + (monthlyRate - 666_667) * 0.35; // 200,833.33 plus 35% in excess of 666,667
        }
        return tax; // return the calculated tax
    }

    private static double calculatePagIbigDeduction(double monthlyBasicSalary) {
        final double maxContribution = 100.0; // pag-ibig contribution        
        double minSalary = 1000; // minimum salary for Pag-ibig contribution
        double maxSalary = 1500; // maximum salary for Pag-ibig contribution
        double contributionAmount = 0.0; // contribution amount

        // tes if the monthly basic salary is within the range of minimum and maximum salary
        if (monthlyBasicSalary >= minSalary && monthlyBasicSalary <= maxSalary) {
            contributionAmount = monthlyBasicSalary * (0.01 + 0.02); // employee and employer contribution            
        } else {
            contributionAmount = monthlyBasicSalary * (0.02 + 0.02); // employee and employer contribution            
        }        

        // contribution amount is at most 100.00
        return contributionAmount > maxContribution ? 100.0 : contributionAmount; 
    }

    private static double calculatePhilHealthDeduction(double monthlyBasicSalary) {
        double premiumRate = 0.03; // 3% of the basic salary
        double minSalary = 10000; // minimum salary for PhilHealth contribution
        double maxSalary = 60000; // maximum salary for PhilHealth contribution
        double monthlyPremium = 0.0; // monthly premium contribution        

        if (monthlyBasicSalary <= minSalary) {
            // 10,000.00 and below
            monthlyPremium = minSalary * premiumRate; // minimum contribution
        } 
        else 
        if (monthlyBasicSalary >= maxSalary) {
            // 60,000.00 and above
            monthlyPremium = maxSalary * premiumRate; // maximum contribution
        } 
        else {            
            // 10,000.01 to 59,999.99
            monthlyPremium = monthlyBasicSalary * premiumRate; // regular contribution
        }

        return monthlyPremium * 0.50; // contribution equally shared by employer and employee
    }

    // synonymous of compensation are remuneration, salary, wages, pay, and earnings
    private static double calculateSssDeduction(double monthlyBasicSalary) {
        // define a 2D array for compensation ranges and contributions
        double[][] compensationContributionTable = {
            {3250, 135.00},
            {3750, 157.50},
            {4250, 180.00},
            {4750, 202.50},
            {5250, 225.00},
            {5750, 247.50},
            {6250, 270.00},
            {6750, 292.50},
            {7250, 315.00},
            {7750, 337.50},
            {8250, 360.00},
            {8750, 382.50},
            {9250, 405.00},
            {9750, 427.50},
            {10250, 450.00},
            {10750, 472.50},
            {11250, 495.00},
            {11750, 517.50},
            {12250, 540.00},
            {12750, 562.50},
            {13250, 585.00},
            {13750, 607.50},
            {14250, 630.00},
            {14750, 652.50},
            {15250, 675.00},
            {15750, 697.50},
            {16250, 720.00},
            {16750, 742.50},
            {17250, 765.00},
            {17750, 787.50},
            {18250, 810.00},
            {18750, 832.50},
            {19250, 855.00},
            {19750, 877.50},
            {20250, 900.00},
            {20750, 922.50},
            {21250, 945.00},
            {21750, 967.50},
            {22250, 990.00},
            {22750, 1012.50},
            {23250, 1035.00},
            {23750, 1057.50},
            {24250, 1080.00},
            {24750, 1102.50}
        };

        // iterate through the 2D array to find the corresponding contribution
        for (double[] range : compensationContributionTable) {
            double compensationUpperLimit = range[0]; // compensation upper limit
            double sssContribution = range[1]; // contribution for the range of salary
            if (monthlyBasicSalary <= compensationUpperLimit) {
                return sssContribution; // return the contribution for the range
            }
        }
        
        return 1125.00; // default contribution for compensation above the highest range
    }

    private static void processingAttendanceLogs() {
        // Split the attendance data into rows
        String[] rowsOfData = attendanceData.split("\r\n");
        double[] totalHoursWorkedById = new double[rowsOfData.length]; // Array to store total hours worked for each employee

        for (int i = 0; i < totalHoursWorkedById.length; i++) {
            totalHoursWorkedById[i] = 0; // Initialize each employee's total hours worked to 0
        }

        // Process each row of attendance data
        for (String row : rowsOfData) {
            String[]    columns         = row.split(","); // split the rows into columns
        
            // Check if the row has the correct number of columns
            if (columns.length != 6) {
                System.out.println("Invalid data format: " + row);
                continue; // skip invalid rows
            }

            String strLogIn  = String.format("%02d:%02d", Integer.parseInt(columns[4].split(":")[0]), Integer.parseInt(columns[4].split(":")[1]));
            String strLogOut = String.format("%02d:%02d", Integer.parseInt(columns[5].split(":")[0]), Integer.parseInt(columns[5].split(":")[1]));

            int         employeeNumber  = Integer.parseInt(columns[0]);
            String      lastName        = columns[1];
            String      firstName       = columns[2];
            LocalDate   date            = LocalDate.parse(columns[3], DateTimeFormatter.ofPattern("MM/dd/yyyy"));            
            LocalTime   logInTime       = LocalTime.parse(strLogIn);
            LocalTime   logOutTime      = LocalTime.parse(strLogOut);
            
            // Create an Attendance object and calculate hours worked
            Attendance attendance = new Attendance(employeeNumber, lastName, firstName, date, logInTime, logOutTime);
            double hoursWorked = attendance.calculateHoursWorked();

            // Display the calculated hours worked
            System.out.printf("Employee [%-12s %-12s] worked %5.2f hours on %s%n", 
                firstName, lastName, hoursWorked, date.format(DateTimeFormatter.ofPattern("MMMM/dd/yyyy"))
            );

            int empIdx = attendance.getEmployeeNumber() - 10001; // Calculate the index for the employee in the array
            totalHoursWorkedById[empIdx] += hoursWorked; // accumulate the total hours worked for each employee
        }                
        
        // Display the total hours worked by each employee over the week
        for (int i = 0; i < totalHoursWorkedById.length; i++) {
            if (totalHoursWorkedById[i] == 0) continue; // Skip if no hours worked
            System.out.printf("Total hours worked by %s in 7 days: %.2f hours%n",
                (i + 10001), totalHoursWorkedById[i]);
        }
    }

    private static void calculateSalaryBasedOnHoursWorked() {
        
        // Split the attendance data into rows
        String[] rowsOfData = attendanceData.split("\r\n");
        double[] totalHoursWorkedById = new double[rowsOfData.length]; // Array to store total hours worked for each employee

        for (int i = 0; i < totalHoursWorkedById.length; i++) {
            totalHoursWorkedById[i] = 0; // Initialize each employee's total hours worked to 0
        }

        // Process each row of attendance data
        for (String row : rowsOfData) {
            String[]    columns         = row.split(","); // split the rows into columns
        
            // Check if the row has the correct number of columns
            if (columns.length != 6) {
                System.out.println("Invalid data format: " + row);
                continue; // skip invalid rows
            }

            String strLogIn  = String.format("%02d:%02d", Integer.parseInt(columns[4].split(":")[0]), Integer.parseInt(columns[4].split(":")[1]));
            String strLogOut = String.format("%02d:%02d", Integer.parseInt(columns[5].split(":")[0]), Integer.parseInt(columns[5].split(":")[1]));

            int         employeeNumber  = Integer.parseInt(columns[0]);
            String      lastName        = columns[1];
            String      firstName       = columns[2];
            LocalDate   date            = LocalDate.parse(columns[3], DateTimeFormatter.ofPattern("MM/dd/yyyy"));            
            LocalTime   logInTime       = LocalTime.parse(strLogIn);
            LocalTime   logOutTime      = LocalTime.parse(strLogOut);
            
            // Create an Attendance object and calculate hours worked
            Attendance attendance = new Attendance(employeeNumber, lastName, firstName, date, logInTime, logOutTime);
            double hoursWorked = attendance.calculateHoursWorked();

            // Display the calculated hours worked
            System.out.printf("Employee [%-12s %-12s] worked %5.2f hours on %s%n", 
                firstName, lastName, hoursWorked, date.format(DateTimeFormatter.ofPattern("MMMM/dd/yyyy"))
            );

            int empIdx = attendance.getEmployeeNumber() - 10001; // Calculate the index for the employee in the array
            totalHoursWorkedById[empIdx] += hoursWorked; // accumulate the total hours worked for each employee
        }                
        
        // Display the total hours worked by each employee over the week
        for (int i = 0; i < totalHoursWorkedById.length; i++) {
            if (totalHoursWorkedById[i] == 0) continue; // Skip if no hours worked
            System.out.printf("Total hours worked by %s in 7 days: %.2f hours%n",
                (i + 10001), totalHoursWorkedById[i]);
        }

        // Calculate and display the salary for each employee based on hours worked
        employeeSalaries = new HashMap<>(); // Initialize the map to store employee salaries
        Arrays.stream(employees).forEach(
            emp -> {
                int empIdx = emp.getEmployeeNumber() - 10001; // Calculate the index for the employee in the array
                double totalHoursWorked = Math.round(totalHoursWorkedById[empIdx] * 100.0) / 100.0; // Round to 2 decimal places
                double hourlyRate = emp.getHourlyRate();
                double oneWeekSalary =  totalHoursWorked * hourlyRate;
                System.out.printf("%d: One week salary of [%-12s %-6s] for %5.2f hours of worked x %.2f/hour: Php%,.2f%n", 
                    emp.getEmployeeNumber(), emp.getFirstName(), emp.getLastName(), totalHoursWorked, hourlyRate, oneWeekSalary
                );    
                // add to collection of employee salary for later's computation of government deductions
                employeeSalaries.put(emp.getEmployeeNumber(), oneWeekSalary); // Store the salary in the map                
            }
        );
    }

    // Method to display employee information
    private static void displayEmployeeInformation() {
        // Employee.printHeading();            
        // Arrays.stream(employees).forEach(emp -> {System.out.println(emp.printData());});
        System.out.println("Motor PH Employee Database");
        Arrays.stream(employees).forEach(System.out::println);
    }
}
