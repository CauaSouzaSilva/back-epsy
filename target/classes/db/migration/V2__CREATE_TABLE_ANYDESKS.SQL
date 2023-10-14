CREATE TABLE public.anydesks (
	id serial NOT NULL,
	tipo_maquina varchar NOT NULL,
	endereco_anydesk varchar NOT NULL,
	senha_any varchar NULL,
	senha_win varchar NULL,
	observacao text NULL,
	posto_id serial NOT NULL,
	CONSTRAINT anydesks_pk PRIMARY KEY (id),
	CONSTRAINT anydesks_un UNIQUE (endereco_anydesk)
);