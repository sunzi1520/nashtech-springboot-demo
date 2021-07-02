--CLEAN DATABASE
drop table if exists employees;
drop sequence if exists employees_seq;

--CREATE TABLE EMPLOYEES
create table employees(
	employee_id INTEGER
		constraint employee_id_nn not null,
	employee_name VARCHAR(50)
		constraint employee_name_nn not null,
	employee_email VARCHAR(25)
		constraint employee_email_nn not null,
	employee_role VARCHAR(25)
		constraint employee_role_nn not null
);

alter table employees
	add constraint employee_id_pk
		primary key(employee_id);

create sequence employees_seq
	start with 1
	increment by 1;

--INSERT SAMPLE DATA
insert into employees values
	(nextval('employees_seq'),
	 'Nhi Mai',
	 'maihoangnhind@gmail.com',
	 'Manager'
	 );

insert into employees values
	(nextval('employees_seq'),
	 'Duy Thai',
	 'duytdbgcs18108@fpt.edu.vn',
	 'Staff'
	);

insert into employees values
	(nextval('employees_seq'),
	 'Nhat Nguyen',
	 'nhattan.fleex@gmail.com',
	 'Staff'
	);