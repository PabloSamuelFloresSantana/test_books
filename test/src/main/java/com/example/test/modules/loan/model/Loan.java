package com.example.test.modules.loan.model;

import java.util.Date;

public class Loan {
    private long id;
    private long bookId;
    private String bookName;
    private String studentName;
    private Date loanDate;
    private Date returnDate;
    private Date dueDate;

    public Loan(long id, long bookId, String bookName, String studentName, Date loanDate, Date returnDate, Date dueDate) {
        this.id = id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentName = studentName;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
    }

    public Loan() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
