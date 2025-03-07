TRUNCATE TABLE books;
TRUNCATE TABLE loans;

-- books
INSERT INTO books (title, synopsis, publication_date, authors, publishers, total_stock, current_stock)
VALUES ('Cien años de soledad', 'La historia de la familia Buendía en el pueblo de Macondo.', TO_DATE('1967-05-30', 'YYYY-MM-DD'), 'Gabriel García Márquez', 'Editorial Sudamericana', 10, 8);

INSERT INTO books (title, synopsis, publication_date, authors, publishers, total_stock, current_stock)
VALUES ('1984', 'Una distopía sobre un régimen totalitario que controla cada aspecto de la vida.', TO_DATE('1949-06-08', 'YYYY-MM-DD'), 'George Orwell', 'Secker & Warburg', 5, 3);

INSERT INTO books (title, synopsis, publication_date, authors, publishers, total_stock, current_stock)
VALUES ('El principito', 'Un niño viaja por diferentes planetas aprendiendo sobre la vida y la amistad.', TO_DATE('1943-04-06', 'YYYY-MM-DD'), 'Antoine de Saint-Exupéry', 'Reynal & Hitchcock', 15, 15);

INSERT INTO books (title, synopsis, publication_date, authors, publishers, total_stock, current_stock)
VALUES ('Don Quijote de la Mancha', 'Las aventuras de un hidalgo que cree ser un caballero andante.', TO_DATE('1605-01-16', 'YYYY-MM-DD'), 'Miguel de Cervantes', 'Francisco de Robles', 7, 6);

INSERT INTO books (title, synopsis, publication_date, authors, publishers, total_stock, current_stock)
VALUES ('Orgullo y prejuicio', 'La historia de Elizabeth Bennet y su relación con el señor Darcy.', TO_DATE('1813-01-28', 'YYYY-MM-DD'), 'Jane Austen', 'T. Egerton', 12, 10);

-- loans
INSERT INTO loans (book_id, student_name, loan_date, return_date, due_date)
VALUES (1, 'Juan Pérez', TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2023-10-15', 'YYYY-MM-DD'), TO_DATE('2023-10-15', 'YYYY-MM-DD'));

INSERT INTO loans (book_id, student_name, loan_date, return_date, due_date)
VALUES (2, 'María Gómez', TO_DATE('2023-10-05', 'YYYY-MM-DD'), TO_DATE('2023-10-20', 'YYYY-MM-DD'), TO_DATE('2023-10-20', 'YYYY-MM-DD'));

INSERT INTO loans (book_id, student_name, loan_date, return_date, due_date)
VALUES (3, 'Carlos Ruiz', TO_DATE('2023-10-10', 'YYYY-MM-DD'), TO_DATE('2023-10-25', 'YYYY-MM-DD'), TO_DATE('2023-10-25', 'YYYY-MM-DD'));

INSERT INTO loans (book_id, student_name, loan_date, return_date, due_date)
VALUES (4, 'Ana López', TO_DATE('2023-10-12', 'YYYY-MM-DD'), TO_DATE('2023-10-27', 'YYYY-MM-DD'), TO_DATE('2023-10-27', 'YYYY-MM-DD'));

INSERT INTO loans (book_id, student_name, loan_date, return_date, due_date)
VALUES (5, 'Pedro Sánchez', TO_DATE('2023-10-15', 'YYYY-MM-DD'), TO_DATE('2023-10-30', 'YYYY-MM-DD'), TO_DATE('2023-10-30', 'YYYY-MM-DD'));