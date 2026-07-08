-- Hands on 1: seed data for the H2 in-memory database.
-- For MySQL, run these statements manually against the 'ormlearn' schema instead
-- (see README.md), since ddl-auto=validate does not auto-populate data.
insert into country (code, name) values ('IN', 'India');
insert into country (code, name) values ('US', 'United States of America');
