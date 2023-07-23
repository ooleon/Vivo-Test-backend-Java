-- public.orders definition

-- Drop table

-- DROP TABLE public.orders;

CREATE TABLE  if not exists public.orders (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	userid numeric NULL,
	CONSTRAINT uuidtable_pk PRIMARY KEY (id)
);