-- Created By Can Demirhan, Elif Yýldýrým and Veysel Karani Yazýcý which of members of Grup 3 of Marathon 3

BEGIN;


CREATE TABLE IF NOT EXISTS public.customers
(
    customer_id bigserial NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    PRIMARY KEY (customer_id)
);

CREATE TABLE IF NOT EXISTS public.accounts
(
    account_id serial NOT NULL,
    no character varying NOT NULL,
    PRIMARY KEY (account_id)
);

CREATE TABLE IF NOT EXISTS public.office
(
    office_id serial NOT NULL,
    no integer NOT NULL,
    name character NOT NULL,
    PRIMARY KEY (office_id)
);

CREATE TABLE IF NOT EXISTS public.account_types
(
    account_type_id serial NOT NULL,
    no smallint NOT NULL,
    name character varying NOT NULL,
    PRIMARY KEY (account_type_id)
);

CREATE TABLE IF NOT EXISTS public.operations
(
    operation_id serial NOT NULL,
    name character varying NOT NULL,
    PRIMARY KEY (operation_id)
);

CREATE TABLE IF NOT EXISTS public.platforms
(
    platform_id serial NOT NULL,
    name character varying NOT NULL,
    PRIMARY KEY (platform_id)
);

CREATE TABLE IF NOT EXISTS public.operational_submittions
(
    oid bigserial NOT NULL,
    operation_no bigint NOT NULL,
    amount integer NOT NULL,
    operation_date date NOT NULL,
    account_id integer NOT NULL,
    operation_id integer NOT NULL,
    platform_id integer NOT NULL,
    PRIMARY KEY (oid)
);

ALTER TABLE IF EXISTS public.accounts
    ADD FOREIGN KEY (account_id)
    REFERENCES public.customers (customer_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.accounts
    ADD FOREIGN KEY (account_id)
    REFERENCES public.office (office_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.accounts
    ADD FOREIGN KEY (account_id)
    REFERENCES public.account_types (account_type_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.operations
    ADD FOREIGN KEY (operation_id)
    REFERENCES public.platforms (platform_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.operational_submittions
    ADD FOREIGN KEY (account_id)
    REFERENCES public.accounts (account_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.operational_submittions
    ADD FOREIGN KEY (operation_id)
    REFERENCES public.operations (operation_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.operational_submittions
    ADD FOREIGN KEY (platform_id)
    REFERENCES public.platforms (platform_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;