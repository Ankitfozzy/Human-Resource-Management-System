<h1 align="center">Human Resource Management System</h1>
<p align="center">
  <img src="https://img.freepik.com/free-vector/recruit-agent-analyzing-candidates_74855-4565.jpg?w=900&t=st=1683576646~exp=1683577246~hmac=8630b0664f8799085a6d8b2b8b0b3b301cde2a7c1ea11840fc02dc964df5c782" alt="HRMS Logo">
</p>
<h3 align="center">A Java-based application to efficiently manage employee and department data.</h3>

<h3>Features :</h3>

<h2>Admin</h2>

Login with admin credentials (username: 'admin', password: 'admin')

Add new departments with department name and ID

View all departments

Update department names

Register a new employee with username, default password, department, and salary

Change department of an employee

Approve or deny employee leave requests with remarks

Fire an employee (delete employee account)

Logout

<h2>Employee</h2>

Login with employee credentials

Update account details and change password

Apply for leave

Check the status of leave requests

View leave history

View total monthly salary

View annual salary for the financial year

Delete account

Logout

<h3>Tech Stack</h3>
Java
MySQL
Hibernate
JPA
JDBC

<h2>Database</h2>

The application uses a relational database to store employee and department data. The following fields are included:

Departments table: department_id (primary key, auto_increment), department_name, is_deleted

Employees table: employee_id (primary key, auto_increment), username (email), password, department_id (foreign key), salary, date_of_joining, is_deleted

Leave table: leave_id (primary key, auto_increment), employee_id (foreign key), start_date, end_date, status, remarks, is_deleted
Please refer to the ER-Diagram for the complete structure and relationships of the database.

             +-------------------+
             |   Departments    |
             +-------------------+
             | department_id    |
             | department_name  |
             | is_deleted       |
             +-------------------+
                    |     ^
                    |     |
                    |     |
              1     |     |    N
             +------+-+---+------+
             |  Employees        |
             +-------------------+
             | employee_id       |
             | username (email)  |
             | password          |
             | department_id (FK)|
             | salary            |
             | date_of_joining   |
             | is_deleted        |
             +-------------------+
                    |     |
                    |     |
                    |     |
              N     |     |    1
             +------+-+---+------+
             |   Leave            |
             +-------------------+
             | leave_id           |
             | employee_id (FK)   |
             | start_date         |
             | end_date           |
             | status             |
             | remarks            |
             | is_deleted         |
             +-------------------+


<h2>Usage</h2>

Access the application through a web browser or localhost.

Login as an admin using the provided credentials.

Use the admin functionalities to manage departments, employees, leave requests, etc.

Login as an employee using their username and default password.

Use the employee functionalities to update account details, apply for leave, view salary, etc.

Logout when finished.
