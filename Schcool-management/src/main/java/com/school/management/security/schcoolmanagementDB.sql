CREATE TABLE IF NOT EXISTS teacher (
  id INT PRIMARY KEY,
  full_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS class_entity (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  teacher_id INT,
  FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);

CREATE TABLE IF NOT EXISTS student (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  class_id INT,
  FOREIGN KEY (class_id) REFERENCES class_entity(id)
);




