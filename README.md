Kata Assignment
-----
This kata simulates a babysitter working and getting paid for one night. The rules are pretty straight forward.

Feature
-----------
As a babysitter
In order to get paid for 1 night of work
I want to calculate my nightly charge

Requirements
--------
The babysitter:
starts no earlier than 5:00PM
leaves no later than 4:00AM
only babysits for one family per night
gets paid for full hours (no fractional hours)
should be prevented from mistakes when entering times (e.g. end time before start time, or outside of allowable work hours)

The job:
------
Pays different rates for each family (based on bedtimes, kids and pets, etc...)
Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night
Family B pays $12 per hour before 10pm, $8 between 10 and 12, and $16 the rest of the night
Family C pays $21 per hour before 9pm, then $15 the rest of the night
The time ranges are the same as the babysitter (5pm through 4am)

Deliverable:
----
Calculate total pay, based on babysitter start and end time, and a family.

i) Application Details 
-------
The application is Java maven build. I used the Jetbrains IntelliJ IDE to develop this project. The application is broken up in two sections in the src folder: main and test folders. The main contains the MainApp.java which contains the main class to run the application. I isolated the functional classes in a package called HelperClasses. There are two files: FamilyTypes.java and SitterScheduleTime.java. The test folder contains two test classes 

ii) Dependencies
------
Java 13 
Maven Build
Junit 4.12
Hamcrest-core 1.3

iii) Setup & Configuration 
-------
IntelliJ IDE 
Java 13 JDK Installed 
Refresh Maven Build to install dependent web jars 
Build Project
Run MainApp.main()

iv) Algorithmic Approach/Solution
-----
For this solution, I compartilized two models: FamilyTypes and SitterScheduleTime. These classes are being called to the MainApp where we will be running the application and the user will be asked a series of questions to calculate their total time sitting. After calculating the time worked, we give options of different Family Types (A, B, and C) to calculate the earnings for the hours worked for that family. 

The FamilyTypes was to create calculation methods for the earning rates for each family type. Since each family has their own time requirements and rates associated with the times, I calculated the total number of minutes the sitter has worked at what incremented time slots, add the earnings from each slot, and then give a total minutes and earnings for the given babysitting session. 

Next was the SitterScheduleTime which was to initialize parameters on the babysitter’s availability for specified time. We are given some conditionals like: Sitter can work from 5PM to 4AM, Sitter must work at least 1 hour, No partial hour payments, Work for a single family a night, and users should be prevented from making mistakes while entering times.   

