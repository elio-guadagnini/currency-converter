-- Table: test_schema.account

-- DROP TABLE test_schema.account;

CREATE TABLE test_schema.account (
	user_id serial PRIMARY KEY,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 250 ) NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	created_on TIMESTAMP NOT NULL,
        last_login TIMESTAMP 
);

ALTER TABLE test_schema.account
    OWNER to postgres;