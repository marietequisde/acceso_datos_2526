-- ESQUEMA para BD-R SQLite gaming

create table desarrollador (
    codigo         integer not null,
    nombre         text    not null,
    anio_fundacion integer not null,
    sede_central   text    not null,
    sitio_web      text    not null,
    primary key (codigo autoincrement),
    unique (nombre)
);

create table videojuego (
    codigo               integer not null,
    codigo_desarrollador integer not null,
    titulo               text    not null,
    anio_lanzamiento     integer not null,
    genero               text    not null,
    precio               real    not null, -- euros
    primary key (codigo autoincrement),
    foreign key (codigo_desarrollador) references desarrollador(codigo)
);

-- DATOS para BD-R SQLite gaming

insert into desarrollador 
values (1, 'Nintendo', 1889, 'Kioto, Japon', 'http://www.nintendo.com');
insert into desarrollador 
values (2, 'Game Freak', 1989, 'Tokio, Japon', 'http://www.gamefreak.co.jp');
insert into desarrollador 
values (3, 'Monolith Soft', 1999, 'Tokio, Japon', 'http://www.monolithsoft.co.jp');
insert into desarrollador 
values (4, 'Retro Studios', 1998, 'Austin, Estados Unidos', 'http://www.retrostudios.com');
insert into desarrollador 
values (5, 'Hal Laboratory', 1980, 'Tokio, Japon', 'http://www.hallab.co.jp');
insert into desarrollador 
values (6, 'Next Level Games', 2002, 'Vancouver, Canada', 'http://www.nextlevelgames.com');
insert into desarrollador 
values (7, 'Platinum Games', 2006, 'Osaka, Japon', 'http://www.platinumgames.co.jp');

insert into videojuego 
values (1, 1, 'The Legend of Zelda: Breath of the Wild', 2017, 'Accion Aventura', 59.99);
insert into videojuego 
values (2, 1, 'Super Mario Odyssey', 2017, 'Accion Plataformas', 59.99);
insert into videojuego 
values (3, 2, 'Pokemon Sword', 2019, 'Rol', 49.99);
insert into videojuego 
values (4, 2, 'Pokemon Scarlet', 2022, 'Rol', 49.99);
insert into videojuego 
values (5, 3, 'Xenoblade Chronicles 2', 2017, 'Rol', 49.99);
insert into videojuego 
values (6, 3, 'Xenoblade Chronicles 3', 2022, 'Rol', 49.99);
insert into videojuego 
values (7, 4, 'Metroid Prime', 2023, 'Accion Tirador', 39.99);
insert into videojuego 
values (8, 4, 'Donkey Kong Country: Tropical Freeze', 2018, 'Accion Plataformas', 49.99);
insert into videojuego 
values (9, 5, 'Kirby and the Forgotten Land', 2022, 'Accion Plataformas', 49.99);
insert into videojuego 
values (10, 5, 'Super Kirby Clash', 2019, 'Rol', 0.00);
insert into videojuego 
values (11, 6, 'Luigi’s Mansion 3', 2019, 'Accion Aventura', 49.99);
insert into videojuego 
values (12, 6, 'Punch-Out', 2024, 'Deporte', 39.99);
insert into videojuego 
values (13, 7, 'Astral Chain', 2019, 'Accion Hack and Slash', 49.99);
insert into videojuego 
values (14, 7, 'Bayonetta 3', 2022, 'Accion Hack and Slash', 49.99);

