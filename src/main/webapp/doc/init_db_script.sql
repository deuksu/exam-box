DROP TABLE IF EXISTS fd_user_roles;
DROP TABLE IF EXISTS fd_users;

DROP TABLE IF EXISTS fd_user_role;
DROP TABLE IF EXISTS fd_user;


CREATE TABLE fd_user (
	user_id int(11) unsigned NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(45) NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(60) NOT NULL ,
	enabled TINYINT NOT NULL DEFAULT 1,
	PRIMARY KEY (user_id)
) ENGINE=InnoDB;

CREATE TABLE fd_user_role (
	role_id int(11) unsigned NOT NULL AUTO_INCREMENT,
	user_id int(11) unsigned NOT NULL,
	role varchar(45) NOT NULL,
	PRIMARY KEY (role_id),
	UNIQUE KEY fd_user_role_uk01 (role,user_id),
	CONSTRAINT fd_user_role_fk01 FOREIGN KEY (user_id) REFERENCES fd_user (user_id)
) ENGINE=InnoDB;



INSERT INTO fd_user(user_name,email,password,enabled)
VALUES ('abc','abc@abc.com','$2a$04$CO93CT2ObgMiSnMAWwoBkeFObJlMYi/wzzOnPlsTP44r7qVq0Jln2', true);
INSERT INTO fd_user(user_name,email,password,enabled)
VALUES ('def','def@def.com','$2a$04$j3JpPUp6CTAe.kMWmdRNC.Wie58xDNPfcYz0DBJxWkucJ6ekJuiJm', true);
 
INSERT INTO fd_user_role (user_id, role)
VALUES (1, 'ROLE_USER');
INSERT INTO fd_user_role (user_id, role)
VALUES (2, 'ROLE_ADMIN');
INSERT INTO fd_user_role (user_id, role)
VALUES (2, 'ROLE_USER');