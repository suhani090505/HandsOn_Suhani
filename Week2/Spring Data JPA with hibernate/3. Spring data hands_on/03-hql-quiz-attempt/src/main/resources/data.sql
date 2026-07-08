INSERT INTO app_user (us_id, us_username) VALUES (1, 'john');

INSERT INTO question (qu_id, qu_text) VALUES (1, 'What is the extension of the hyper text markup language file?');
INSERT INTO question (qu_id, qu_text) VALUES (2, 'What is the maximum level of heading tag can be used in a HTML page?');
INSERT INTO question (qu_id, qu_text) VALUES (3, 'The HTML document itself begins with <html> and ends </html>. State True of False');
INSERT INTO question (qu_id, qu_text) VALUES (4, 'Choose the right option to store text value value in a variable');

-- Question 1 options
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (1, '.xhtm', 0.0, 1);
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (2, '.ht', 0.0, 1);
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (3, '.html', 1.0, 1);
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (4, '.htmx', 0.0, 1);

-- Question 2 options
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (5, '5', 0.0, 2);
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (6, '3', 0.0, 2);
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (7, '4', 0.0, 2);
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (8, '6', 1.0, 2);

-- Question 3 options
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (9, 'false', 0.0, 3);
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (10, 'true', 1.0, 3);

-- Question 4 options
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (11, '''John''', 0.5, 4);
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (12, 'John', 0.0, 4);
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (13, '"John"', 0.5, 4);
INSERT INTO options (op_id, op_text, op_score, op_qu_id) VALUES (14, '/John/', 0.0, 4);

INSERT INTO attempt (at_id, at_us_id, at_date) VALUES (1, 1, '2026-07-08 10:00:00');

INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (1, 1, 1);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (2, 1, 2);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (3, 1, 3);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (4, 1, 4);

-- The options the user actually selected for each question in this attempt
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id) VALUES (1, 1, 3);   -- Q1: .html  (correct)
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id) VALUES (2, 2, 6);   -- Q2: 3      (incorrect)
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id) VALUES (3, 3, 10);  -- Q3: true   (correct)
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id) VALUES (4, 4, 11);  -- Q4: 'John' (correct, partial credit)
