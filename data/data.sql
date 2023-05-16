CREATE TABLE IF NOT EXISTS CLIENT(
        id uuid NOT NULL,
        name varchar(300) NOT NULL,
        cpf varchar(11) UNIQUE,
        birthdate date NOT NULL,
        address_id uuid UNIQUE NOT NULL,
        created_at timestamp NOT NULL,
        updated_at timestamp NOT NULL,
        PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ADDRESS(
        id uuid NOT NULL,
        zip_code varchar(9) NOT NULL,
        street varchar(256) NOT NULL,
        complement varchar(256),
        neighborhood varchar(100) NOT NULL,
        city varchar(100 NOT NULL,
        state varchar(100) NOT NULL,
        house_number integerNOT NULL,
        created_at timestamp NOT NULL,
        updated_at timestamp NOT NULL,
        PRIMARY KEY (id)
);

ALTER TABLE CLIENT
ADD CONSTRAINT fk_address_id
FOREIGN KEY (address_id) REFERENCES ADDRESS (id);