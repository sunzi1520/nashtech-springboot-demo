# nashtech-springboot-demo
A demo project using Spring Boot to create RESTful APIs to manipulate data of employees from a Postgres database.

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
