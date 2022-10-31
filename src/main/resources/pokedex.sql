CREATE TABLE IF NOT EXIST pokedex (
	id varchar(50) NOT NULL,
	generation varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	type varchar(50),
	ability varchar(50),
	height varchar(50),
	weight varchar(50),
	description varchar(50),
	CONSTRAINT pokedex_pkey PRIMARY KEY (id)
	);
	
	