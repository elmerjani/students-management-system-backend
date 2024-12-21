-- Insert students
INSERT INTO student (full_name, creation_date) VALUES
                                                 ('Jean Dupont', '2023-01-15'),
                                                 ('Marie Martin', '2023-02-20'),
                                                 ('Pierre Leroy', '2023-03-10'),
                                                 ('Sophie Dubois', '2023-04-05'),
                                                 ('Antoine Blanc', '2023-05-12'),
                                                 ('Luc Besson', '2023-12-21');

INSERT INTO Note (student_id, Course_name, note_value) VALUES
                                                           (1, 'Mathematiques', 15.50),
                                                           (1, 'Physique', 10.25),
                                                           (2, 'Mathematiques', 12.75),
                                                           (2, 'Chimie', 12.60),
                                                           (3, 'Biologie', 10.00),
                                                           (3, 'Informatique', 20.00),
                                                           (4, 'Langues', 17.50),
                                                           (4, 'Histoire', 06.30),
                                                           (5, 'Geographie', 14.90),
                                                           (5, 'Economie', 08.25),
                                                           (6, 'Philosophie', 8.00),
                                                           (6, 'Sociologie', 7.50),
                                                           (6, 'Art', 9.20),
                                                           (6, 'Musique', 6.80);
