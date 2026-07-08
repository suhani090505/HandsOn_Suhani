INSERT INTO department (dp_id, dp_name) VALUES (1, 'Engineering');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'Database Administration');
INSERT INTO department (dp_id, dp_name) VALUES (3, 'Human Resources');

INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'SQL');
INSERT INTO skill (sk_id, sk_name) VALUES (3, 'Angular');
INSERT INTO skill (sk_id, sk_name) VALUES (4, 'Spring Boot');

INSERT INTO employee (em_id, em_name, em_date_of_birth, em_salary, em_permanent, em_dp_id) VALUES (1, 'Alice Johnson', '1990-04-12', 75000, true, 1);
INSERT INTO employee (em_id, em_name, em_date_of_birth, em_salary, em_permanent, em_dp_id) VALUES (2, 'Bob Williams', '1988-09-23', 68000, true, 1);
INSERT INTO employee (em_id, em_name, em_date_of_birth, em_salary, em_permanent, em_dp_id) VALUES (3, 'Carla Mendes', '1993-01-05', 72000, false, 2);
INSERT INTO employee (em_id, em_name, em_date_of_birth, em_salary, em_permanent, em_dp_id) VALUES (4, 'David Kim', '1985-11-30', 81000, true, 2);
INSERT INTO employee (em_id, em_name, em_date_of_birth, em_salary, em_permanent, em_dp_id) VALUES (5, 'Emma Clarke', '1995-06-17', 60000, false, 3);

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 4);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (4, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (4, 1);
