DROP TABLE IF EXISTS Category;
CREATE TABLE Category (
  category_id INT NOT NULL,
  category_name VARCHAR(120) NOT NULL,
  category_description VARCHAR(250) NULL,
  PRIMARY KEY (category_id)
);

DROP TABLE IF EXISTS Theme;
CREATE TABLE Theme (
  theme_id INT NOT NULL,
  theme_name VARCHAR(120) NOT NULL,
  theme_description VARCHAR(250) NULL,
  category_id INT NOT NULL,
  PRIMARY KEY (theme_id),
  FOREIGN KEY (category_id) REFERENCES Category (category_id) ON DELETE NO ACTION ON UPDATE CASCADE
);

DROP TABLE IF EXISTS User_data;
CREATE TABLE User_data (
  user_id VARCHAR(10) NOT NULL,
  user_surname VARCHAR(50) NOT NULL,
  user_name VARCHAR(50) NOT NULL,
  user_patronymic VARCHAR(50) NULL,
  user_email VARCHAR(320) NOT NULL,
  user_password VARCHAR(72) NOT NULL,
  category_id INT NOT NULL,
  PRIMARY KEY(user_id),
  FOREIGN KEY (category_id) REFERENCES Category (category_id) ON DELETE NO ACTION ON UPDATE CASCADE
);

DROP TABLE IF EXISTS Question;
CREATE TABLE Question (
  question_id INT NOT NULL,
  theme_id INT NOT NULL,
  text VARCHAR(450) NOT NULL,
  tips VARCHAR(650) NOT NULL,
  year DATE NOT NULL,
  picture VARCHAR(255) NULL,
  answer VARCHAR(450) NOT NULL,
  var1 VARCHAR(450) NOT NULL,
  var2 VARCHAR(450) NULL,
  var3 VARCHAR(450) NULL,
  complexity INT NOT NULL,
  PRIMARY KEY(question_id),
  FOREIGN KEY (theme_id) REFERENCES Theme (theme_id) ON DELETE NO ACTION ON UPDATE CASCADE
);

DROP TABLE IF EXISTS Solved_Question;
CREATE TABLE Solved_Question (
  question_id INT NOT NULL,
  user_id VARCHAR(10) NOT NULL,
  correct BOOLEAN NOT NULL,
  PRIMARY KEY(question_id, user_id),
  FOREIGN KEY(question_id) REFERENCES Question (question_id) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY(user_id) REFERENCES User_data (user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS Saved_Question;
CREATE TABLE Saved_Question (
  question_id INT NOT NULL,
  user_id VARCHAR(10) NOT NULL,
  PRIMARY KEY(question_id, user_id),
  FOREIGN KEY(question_id) REFERENCES Question (question_id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY(user_id) REFERENCES User_data (user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS Info_theme;
CREATE TABLE Info_theme (
  info_theme_id SERIAL NOT NULL,
  parent_theme_id INT NULL,
  info_theme_name VARCHAR (70) NOT NULL,
  PRIMARY KEY(info_theme_id),
  FOREIGN KEY(parent_theme_id) REFERENCES Info_theme (info_theme_id) ON DELETE NO ACTION ON UPDATE CASCADE
);

DROP TABLE IF EXISTS Rule;
CREATE TABLE Rule (
  rule_id VARCHAR(20) NOT NULL,
  info_theme_id INT NOT NULL,
  rule_text VARCHAR (800) NOT NULL,
  rule_picture VARCHAR (160) NULL,
  PRIMARY KEY(rule_id),
  FOREIGN KEY(info_theme_id) REFERENCES Info_theme (info_theme_id) ON DELETE NO ACTION ON UPDATE CASCADE
);

DROP TABLE IF EXISTS Sign;
CREATE TABLE Sign (
  sign_id VARCHAR(20) NOT NULL,
  info_theme_id INT NOT NULL,
  sign_name VARCHAR (260) NOT NULL,
  sign_text VARCHAR (800) NOT NULL,
  sign_picture VARCHAR (160) NOT NULL,
  PRIMARY KEY(sign_id),
  FOREIGN KEY(info_theme_id) REFERENCES Info_theme (info_theme_id) ON DELETE NO ACTION ON UPDATE CASCADE
);

DROP TABLE IF EXISTS Law;
CREATE TABLE Law (
  law_id SERIAL NOT NULL,
  info_theme_id INT NOT NULL,
  law_name VARCHAR (360) NOT NULL,
  law_text VARCHAR (1300) NULL,
  law_url VARCHAR (160) NOT NULL,
  PRIMARY KEY(law_id),
  FOREIGN KEY(info_theme_id) REFERENCES Info_theme (info_theme_id) ON DELETE NO ACTION ON UPDATE CASCADE
);
