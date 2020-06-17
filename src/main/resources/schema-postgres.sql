DROP TABLE IF EXISTS TestTable;
DROP TABLE IF EXISTS exchanges;
CREATE TABLE exchanges(id serial PRIMARY KEY, first_currency VARCHAR(255), second_currency VARCHAR(255), exchange_value double precision);