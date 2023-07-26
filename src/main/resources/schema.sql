 -- rodar uma vez so.

/*
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


-- public.pedido_artigo_id_seq definition

-- DROP SEQUENCE public.pedido_artigo_id_seq;

CREATE SEQUENCE if not exists public.pedido_artigo_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- public.pedido definition

-- Drop table

-- DROP TABLE public.pedido;

CREATE TABLE if not exists  public.pedido (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	usuarioid varchar(255) NULL,
	estado varchar(255) NULL DEFAULT 'PENDIENTE'::character varying,
	CONSTRAINT uuidpedido_pk PRIMARY KEY (id)
);


-- public.pedido_produtos definition

-- Drop table

-- DROP TABLE public.pedido_produtos;

CREATE TABLE if not exists public.pedido_produtos (
	id varchar(255) NOT NULL DEFAULT nextval('pedido_artigo_id_seq'::regclass),
	pedidoid_fk uuid NULL,
	produtoid int4 NULL,
	quantidade numeric NULL,
	precounidade numeric NULL DEFAULT 0.0,
	CONSTRAINT pedido_produtos_pk PRIMARY KEY (id)
);

-- Table Triggers

create trigger if not exists trigger_pedido_produtos_insert after
insert
    on
    public.pedido_produtos for each row execute function ins2orders();
create trigger if not exists trigger_pedido_produtos_update after
update
    on
    public.pedido_produtos for each row execute function ins2pedido();
/*
*/
