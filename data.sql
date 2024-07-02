-- Rolleri ekleyin
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- Kullanıcıları ekleyin
INSERT INTO users (username, password, email) VALUES ('user1', '$2a$10$wHjhFjyOny7jJrc.nB4ysuFfsRHvl/J6.Z1NsnP0x.6TX2vFErLFe', 'user1@example.com'); -- password: userpassword
INSERT INTO users (username, password, email) VALUES ('admin1', '$2a$10$2BtE.0J/h9FR1eGzp/CJSe8XGJ/ht1NHEDesA50xQdWc.tlHMRHni', 'admin1@example.com'); -- password: adminpassword

-- Kullanıcı-rol ilişkilerini ekleyin
INSERT INTO user_roles (user_id, role_id)
VALUES (
           (SELECT id FROM users WHERE username = 'user1'),
           (SELECT id FROM roles WHERE name = 'ROLE_USER')
       );

INSERT INTO user_roles (user_id, role_id)
VALUES (
           (SELECT id FROM users WHERE username = 'admin1'),
           (SELECT id FROM roles WHERE name = 'ROLE_ADMIN')
       );
