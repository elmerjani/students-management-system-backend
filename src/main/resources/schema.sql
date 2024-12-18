--Drop Note schema
DROP TABLE IF EXISTS note;

--Drop student schema
DROP TABLE IF EXISTS student;

-----------------------------------------------------------------------------
-- Create the Student schema
CREATE TABLE student (
                         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         full_name VARCHAR(255) NOT NULL,
                         creation_date DATE NOT NULL
);

-- Create the Note schema
CREATE TABLE note (
                      id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                      student_id BIGINT REFERENCES student(id) NOT NULL ,
                      course_name VARCHAR(255) NOT NULL,
                      note_value NUMERIC(4,2) NOT NULL
);
