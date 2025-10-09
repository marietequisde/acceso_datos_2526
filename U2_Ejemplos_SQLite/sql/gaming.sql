CREATE TABLE "desarrollador" (
	"codigo"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"sede_central"	TEXT NOT NULL,
	"anio_fundacion"	INTEGER NOT NULL,
	PRIMARY KEY("codigo" AUTOINCREMENT)
)

CREATE TABLE "videojuego" (
	"codigo"	INTEGER NOT NULL,
	"titulo"	TEXT NOT NULL,
	"anio_lanzamiento"	INTEGER NOT NULL,
	"precio"	REAL NOT NULL,
	"codigo_desarrollador"	INTEGER NOT NULL,
	PRIMARY KEY("codigo" AUTOINCREMENT),
	FOREIGN KEY("codigo_desarrollador") REFERENCES "desarrollador"("codigo")
)

-- Inserts para la tabla desarrollador
INSERT INTO desarrollador (codigo, nombre, sede_central, anio_fundacion) VALUES (1, 'Nintendo', 'Kioto, Japón', 1889);
INSERT INTO desarrollador (codigo, nombre, sede_central, anio_fundacion) VALUES (2, 'Valve', 'Bellevue, EE.UU.', 1996);
INSERT INTO desarrollador (codigo, nombre, sede_central, anio_fundacion) VALUES (3, 'CD Projekt Red', 'Varsovia, Polonia', 2002);
INSERT INTO desarrollador (codigo, nombre, sede_central, anio_fundacion) VALUES (4, 'Rockstar Games', 'Nueva York, EE.UU.', 1998);
INSERT INTO desarrollador (codigo, nombre, sede_central, anio_fundacion) VALUES (5, 'FromSoftware', 'Tokio, Japón', 1986);

-- Inserts para la tabla videojuego (2 por cada desarrollador)
INSERT INTO videojuego (codigo, titulo, anio_lanzamiento, precio, codigo_desarrollador) VALUES (1, 'The Legend of Zelda: Breath of the Wild', 2017, 59.99, 1);
INSERT INTO videojuego (codigo, titulo, anio_lanzamiento, precio, codigo_desarrollador) VALUES (2, 'Super Mario Odyssey', 2017, 59.99, 1);

INSERT INTO videojuego (codigo, titulo, anio_lanzamiento, precio, codigo_desarrollador) VALUES (3, 'Half-Life: Alyx', 2020, 49.99, 2);
INSERT INTO videojuego (codigo, titulo, anio_lanzamiento, precio, codigo_desarrollador) VALUES (4, 'Portal 2', 2011, 19.99, 2);

INSERT INTO videojuego (codigo, titulo, anio_lanzamiento, precio, codigo_desarrollador) VALUES (5, 'The Witcher 3: Wild Hunt', 2015, 39.99, 3);
INSERT INTO videojuego (codigo, titulo, anio_lanzamiento, precio, codigo_desarrollador) VALUES (6, 'Cyberpunk 2077', 2020, 59.99, 3);

INSERT INTO videojuego (codigo, titulo, anio_lanzamiento, precio, codigo_desarrollador) VALUES (7, 'Grand Theft Auto V', 2013, 29.99, 4);
INSERT INTO videojuego (codigo, titulo, anio_lanzamiento, precio, codigo_desarrollador) VALUES (8, 'Red Dead Redemption 2', 2018, 59.99, 4);

INSERT INTO videojuego (codigo, titulo, anio_lanzamiento, precio, codigo_desarrollador) VALUES (9, 'Elden Ring', 2022, 59.99, 5);
INSERT INTO videojuego (codigo, titulo, anio_lanzamiento, precio, codigo_desarrollador) VALUES (10, 'Dark Souls III', 2016, 49.99, 5);
