DROP DATABASE IF EXISTS superhero;
CREATE DATABASE superhero;
USE superhero;

CREATE TABLE superhero (
	superheroID int NOT NULL AUTO_INCREMENT,
	superheroName VARCHAR(255) NOT NULL,
	realName VARCHAR(255) NOT NULL,
	creationYear int,
    cityName VARCHAR(255) NOT NULL,
	superpower VARCHAR(255),
	IsHuman BOOLEAN,
	primary key(superheroID)
);

CREATE TABLE superPower (
    superPowerID int NOT NULL AUTO_INCREMENT,
    Powername VARCHAR(255),
    PRIMARY KEY(superPowerID)
);


CREATE TABLE city (
	cityName VARCHAR (255),
	cityID int NOT NULL,
    primary key (cityID),
    foreign key(cityID) references superhero(superheroID)
    );
    
CREATE TABLE superheroPower (
	id int NOT NULL AUTO_INCREMENT,
	heroID int NOT NULL,
	superpowerID int,
	PRIMARY KEY (id),
	FOREIGN KEY (heroID) REFERENCES superhero(superheroID),
	FOREIGN KEY (superPowerID) REFERENCES superpower(superpowerID)
);

INSERT INTO superhero(superheroName, realName, creationYear, cityName, superpower, isHuman) VALUES
('Superman', 'Clark Kent', 1990, 'Metropolis', 'Strength', true),
('Spider-Man', 'Peter Parker', 1962, 'New York', 'Spider', true),
('Wonder Woman', 'Diana Prince', 1941, 'Themyscira', 'Superhuman', false),
('Iron Man', 'Tony Stark', 1963, 'Malibu', 'Power suit', true),
('The Flash', 'Barry Allen', 1956, 'Central City', 'Fast', true);

INSERT INTO city(cityName, cityID) VALUES
('Metropolis', 1),
('New York City', 2),
('Themyscira', 3),
('Malibu', 4),
('Central City', 5);

INSERT INTO superPower(Powername, superPowerID) VALUES
('Strength', 1),
('Spider', 2),
('Superhuman', 3),
('Power suit', 4),
('Fast', 5),
('martial artist', 6);

INSERT INTO superheroPower(id, heroID, superpowerID) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);






    
    





