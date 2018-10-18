# simple-java-socket
simple case for java socket

simple interaction between server and client for calculate score and get score grade
based on search by id (nim).

## import lib jdbc mysql-connector to your project.

- [Netbean] 
  1. Right click in the project.
  2. Select Properties and click in Libraries (in the left side). 
  3. Click the button "Add Jar/Folder".
  4. Browse lib and add mysql-connector.jar

- [Intellij] 
  1. Click File from the toolbar
  2. Project Structure (CTRL + SHIFT + ALT + S on Windows/Linux, ⌘ + ; on Mac OS X)
  3. Select Modules at the left panel
  4. Dependencies tab
  5. '+' → JARs or directories (lib/mysql-connector.jar)
  
- [Eclipse]
  1. Project
  2. Properties
  3. Java Build Path
  4. Libraries
  5. Add JAR on lib/mysql-connector.jar

- adjust field on ConnectDB.java
```java
  private static final String DB_NAME = "mahasiswa";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "";
```

- execute data.sql for initialize data
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
