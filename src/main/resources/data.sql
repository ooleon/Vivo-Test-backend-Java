
delete from public.pedido;
INSERT INTO public.pedido (id, usuarioid) VALUES('11111111-7222-7333-7444-111111111111'::uuid, 4);
INSERT INTO public.pedido (id, usuarioid) VALUES('00000000-5555-7777-1dcd-300020001000'::uuid, 9);
INSERT INTO public.pedido (id, usuarioid) VALUES('00000000-5555-7777-1dcd-300020001001'::uuid, 9);
delete from public.pedido_detalhe;
INSERT INTO public.pedido_detalhe (pedido_id, produtoid, quantidade, precounidade)
	VALUES('00000000-5555-7777-1dcd-300020001000'::uuid, 1, 2, 10);
INSERT INTO public.pedido_detalhe (pedido_id, produtoid, quantidade, precounidade)
	VALUES('00000000-5555-7777-1dcd-300020001000'::uuid, 2, 2, 10);
INSERT INTO public.pedido_detalhe (pedido_id, produtoid, quantidade, precounidade)
	VALUES('00000000-a324-a123-a123-111111111111'::uuid, 1, 2, 10);
	

/*
INSERT INTO public.pedido (usuarioid) VALUES  (1);
INSERT INTO public.pedido (usuarioid) VALUES  (2);
INSERT INTO public.pedido (usuarioid) VALUES  (3);

INSERT INTO public.pedido (id, usuarioid) VALUES('88888888-ccbb-7777-9d8d-5b23b288838b'::uuid, 4);

INSERT INTO public.pedido_detalhe (id, pedido_id, produtoid, quantidade, precounidade)
	VALUES(2, '00000000-5555-7777-1dcd-300020001000'::uuid, 1, 2, 10);
INSERT INTO public.pedido_detalhe (id, pedido_id, produtoid, quantidade, precounidade)
	VALUES(3, '00000000-5555-7777-1dcd-300020001000'::uuid, 2, 3.3, 10);
INSERT INTO public.pedido_detalhe (id, pedido_id, produtoid, quantidade, precounidade)
	VALUES(4, '00000000-5555-7777-1dcd-300020001000'::uuid, 3, 2, 10);

*/
