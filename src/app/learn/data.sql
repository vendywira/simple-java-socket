CREATE TABLE nilai (
  id INT NOT NULL AUTO_INCREMENT,
  nim VARCHAR(25) NOT NULL,
  tugas FLOAT NOT NULL,
  uts FLOAT NOT NULL,
  uas FLOAT NOT NULL,
  PRIMARY KEY ( id )
);

INSERT INTO nilai (nim, tugas, uts, uas) values ('23514009', 85, 79, 87);
INSERT INTO nilai (nim, tugas, uts, uas) values ('0907103003', 95, 73, 78);