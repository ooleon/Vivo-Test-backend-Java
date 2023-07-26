-- public.orders definition

-- Drop table

-- DROP TABLE public.orders;

CREATE TABLE  if not exists public.orders (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	usuarioid numeric NULL,
	estado varchar NULL DEFAULT 'PENDIENTE'::character varying,
	preçototal numeric NULL DEFAULT 0.0,
	CONSTRAINT uuidorders_pk PRIMARY KEY (id)
);

