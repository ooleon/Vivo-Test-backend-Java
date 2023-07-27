 -- rodar uma vez so.

/*


-- public.pedido definition

-- Drop table

-- DROP TABLE public.pedido;

CREATE TABLE public.pedido (
	id uuid NOT NULL DEFAULT gen_random_uuid(),
	usuarioid int4 NULL,
	estado varchar(255) NULL DEFAULT 'PENDIENTE'::character varying,
	CONSTRAINT pedidouuid_pk PRIMARY KEY (id)
);



-- public.pedido_detalhe definition

-- Drop table

-- DROP TABLE public.pedido_detalhe;

CREATE TABLE public.pedido_detalhe (
	id serial4 NOT NULL,
	pedido_id uuid NULL,
	produtoid int4 NULL,
	quantidade numeric NULL,
	precounidade numeric NULL DEFAULT 0.0,
	CONSTRAINT pedido_detalhe_pk PRIMARY KEY (id)
);

*/
