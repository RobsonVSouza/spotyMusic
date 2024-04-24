
CREATE TABLE record_company (
    id int8 PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    document VARCHAR(255) NOT NULL
);

CREATE TABLE singer (
    id int8 PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE song (
    id int8 PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    music VARCHAR(255) NOT NULL,
    singer_id BIGINT,
    record_company_id BIGINT,
    FOREIGN KEY (singer_id) REFERENCES singer(id),
    FOREIGN KEY (record_company_id) REFERENCES record_company(id)
);

