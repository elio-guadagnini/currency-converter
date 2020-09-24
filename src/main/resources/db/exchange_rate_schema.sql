DROP TABLE IF EXISTS exchange_rate;

-- Table: test_schema.exchange_rate

-- DROP TABLE test_schema.exchange_rate;

CREATE TABLE test_schema.exchange_rate
(
    id SERIAL,
    btc double precision,
    eur double precision,
    usd double precision,
    CONSTRAINT exchanges_pkey PRIMARY KEY (id)
)
