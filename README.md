# simple-java-socket
simple case for java socket

simple interaction between server and client for calculate score and get score grade
based on search by id (nim).

adjust field on ConnectDB.java
```java
  private static final String DB_NAME = "mahasiswa";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "";
```

execute data.sql for initialize data
```sql
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
```
