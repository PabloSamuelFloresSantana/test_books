-- Tabla books
CREATE TABLE books
(
    id               NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title            VARCHAR2(255) NOT NULL,
    synopsis         CLOB,
    publication_date DATE   NOT NULL,
    authors          VARCHAR2(255) NOT NULL,
    publishers       VARCHAR2(255) NOT NULL,
    total_stock      NUMBER NOT NULL,
    current_stock    NUMBER NOT NULL
);

-- Tabla loans
CREATE TABLE loans
(
    id           NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    book_id      NUMBER NOT NULL,
    student_name VARCHAR2(255) NOT NULL,
    loan_date    DATE   NOT NULL,
    return_date  DATE   NOT NULL,
    due_date     DATE   NOT NULL,
    CONSTRAINT fk_loans_inventory FOREIGN KEY (book_id) REFERENCES books (id) ON DELETE CASCADE
);