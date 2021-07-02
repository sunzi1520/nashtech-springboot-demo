# nashtech-springboot-demo
A demo project using Spring Boot to create RESTful APIs to manipulate data of employees from a Postgres database.

# Sample database

The database name is "nashtech-springboot".

The default URL to the database is "jdbc:postgresql://localhost:5432/nashtech-springboot". Additional information related to the database is in the following directory: src/main/resources/application.properties

The SQL script to create the table 'Employees' and populate data into it is in the directory: src/main/resources/sample-script.sql

# RESTful APIs
**GET /api/employees**

Get all employees

*Response Body*

Content-Type: application/json

[Employee{id, name, email, role}]

**GET /api/employees/{employeeId}**

Get information of an employee with a given id

*Response Body*

Content-Type: application/json

Employee{id, name, email, role}

**POST /api/employees**

Create a new employee

*Request Body*

Content-Type: application/json

Employee{name, email, role}

*Response Body*

Content-Type: application/json

Employee{id, name, email, role}

**PUT /api/employees/{employeeId}**

Update information of an employee with a given id

*Request Body*

Content-Type: application/json

Employee{name, email, role}

*Response Body*

Empty

**DELETE /api/employees/{employeeId}**

Remove an employee with a given id from the database

*Response Body*

Empty
