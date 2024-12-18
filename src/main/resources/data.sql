-- Insert students
INSERT INTO student (full_name, creation_date) VALUES
                                                 ('Jean Dupont', '2023-01-15'),
                                                 ('Marie Martin', '2023-02-20'),
                                                 ('Pierre Leroy', '2023-03-10'),
                                                 ('Sophie Dubois', '2023-04-05'),
                                                 ('Antoine Blanc', '2023-05-12');

-- Insert notes for students
INSERT INTO Note (student_id, Course_name, note_value) VALUES
                                                        (1, 'Math├®matiques', 15.50),
                                                        (1, 'Physique', 10.25),
                                                        (2, 'Math├®matiques', 12.75),
                                                        (2, 'Chimie', 12.60),
                                                        (3, 'Biologie', 10.00),
                                                        (3, 'Informatique', 20.00),
                                                        (4, 'Langues', 17.50),
                                                        (4, 'Histoire', 06.30),
                                                        (5, 'G├®ographie', 14.90),
                                                        (5, '├ëconomie', 08.25);