CREATE TABLE IF NOT EXISTS teachers (
  id INT PRIMARY KEY,
  last_name VARCHAR(255),
  first_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS class_entity (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  teacher_id INT,
  FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);

CREATE TABLE IF NOT EXISTS student (
  id INT PRIMARY KEY,
  last_name VARCHAR(255),
  first_name VARCHAR(255),
  class_id INT,
  FOREIGN KEY (class_id) REFERENCES class_entity(id)
);
-- Insert teachers
INSERT INTO Teachers (id, last_name, first_name) VALUES (1, 'Doe', 'John');
INSERT INTO Teachers (id, last_name, first_name) VALUES (2, 'Smith', 'Jane');

-- Insert classes
INSERT INTO class_entity (id, name, teacher_id) VALUES (1, 'Math', 1);
INSERT INTO class_entity (id, name, teacher_id) VALUES (2, 'Science', 2);

-- Insert students
INSERT INTO student (id, last_name, first_name, class_id) VALUES (1, 'Alice','john', 1);
INSERT INTO student (id, last_name, first_name, class_id) VALUES (2, 'Bob','Marly', 2);