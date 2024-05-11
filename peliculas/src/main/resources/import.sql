INSERT INTO GENEROS(NOMBRE) VALUES ('Acción');
INSERT INTO GENEROS(NOMBRE) VALUES ('Comedia');
INSERT INTO GENEROS(NOMBRE) VALUES ('Drama');
INSERT INTO GENEROS(NOMBRE) VALUES ('Ciencia Ficción');
INSERT INTO GENEROS(NOMBRE) VALUES ('Fantasia');
INSERT INTO GENEROS(NOMBRE) VALUES ('Terror');

INSERT INTO ACTORES(NOMBRE, URL_IMAGEN) VALUES('Hugh Jackman', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Logan_Japan_Premiere_Red_Carpet-_Hugh_Jackman_%2838445328406%29_%28rotated%29.jpg/220px-Logan_Japan_Premiere_Red_Carpet-_Hugh_Jackman_%2838445328406%29_%28rotated%29.jpg');
INSERT INTO ACTORES(NOMBRE, URL_IMAGEN) VALUES('Keanu Reeves', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Reuni%C3%A3o_com_o_ator_norte-americano_Keanu_Reeves_%2846806576944%29_%28cropped%29.jpg/330px-Reuni%C3%A3o_com_o_ator_norte-americano_Keanu_Reeves_%2846806576944%29_%28cropped%29.jpg');
INSERT INTO ACTORES(NOMBRE, URL_IMAGEN) VALUES('Patrick Stewart', 'https://media.ambito.com/p/d5c1807c0a638b9cbf6a9b654da6842b/adjuntos/239/imagenes/040/360/0040360285/messi-stewart-1jpg.jpg');

INSERT INTO PELICULAS(NOMBRE, GENERO_ID, FECHA_ESTRENO) VALUES ('Pelicula Test', 1, '2022-01-01');