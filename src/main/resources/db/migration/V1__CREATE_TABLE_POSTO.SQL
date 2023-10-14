CREATE TABLE public.postos (
	id serial NOT NULL,
	nome_posto varchar NOT NULL,
	cnpj_posto varchar NOT NULL,
	CONSTRAINT postos_pk PRIMARY KEY (id),
	CONSTRAINT postos_un UNIQUE (cnpj_posto)
);