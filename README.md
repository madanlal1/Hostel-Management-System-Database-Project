# Hostel-Management-System-Database-Project

# Hostel-Management_System-DBMS-Project-Using-MySQL

-------------------------------------------------------------------------------------
Description and Details About DBMS Hostel Management System Semester Project in MySQL
-------------------------------------------------------------------------------------
DBMS Semester Project
Developed by: Madan Lal (SE-IV-A) & Safdar Hussain (CS-IV-A)
-------------------------------------------------------------------------------------
The Project is consist of 2 sections:
1> Java Coding
2> MySQL Database
This project is developed on Windows 10 OS.
Xampp Localhost is used for this project.
Eclipse IDE is ued for this project.

To run this project on your system, you must have Windows 10 OS, eclipse IDE, and xampp localhost database server.

-------------------------------------------------------------------------------------
Introduction to Project:
--------------------------------------------------------------------------------------
● Hostel Management system is a java-based application which aims at
computerization of current procedure of allocating hostel rooms.
● Currently the process involves students filling up the forms and submitting
them in respective hostel offices which involves a lot of paperwork, hence
less efficient!

Types of Users
1. Student (can only view his/her room allotment details such as which room is allocated to him/her and payment updates)
2. Admin (can allocate room, cancel allotment, update room, and so on)

Login Page
-To open project, admin and student must enter userid, username and password to login in respective account.
-Only Admin can register a student and allocate a room and data of student is stored in database.
-When student is registed, he/she is assigned a userid, username and password to log in his/her account.
-When a user wants to check his/her status, student must login using his/her userid, userame and password.

-If and only if the user exists in DB and password entered is correct, he/she will be able to
login, otherwise appropriate error message is displayed.

- When admin open his.her account, ADD, UPDATE, SEARCH, DELETE buttons will be enable. Whenever, a user login,ADD, UPDATE, SEARCH, DELETE buttons
will be disable becasue student is not given access to add, update or delete data. 
- When a student login, he/she can view his/her data on profile. 

-----------------------------------------------------------------------------------
Admin Page
Possible Error Checks
● Once a hostel becomes full the admin won’t be able to allocate a room
for student. So he/she will be asked to select another room.
● If a student is already allocated a room, he can’t apply to any other hostel.
