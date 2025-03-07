package com.example.test.modules.loan.model;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoanMapper {
    @Select("SELECT * FROM loans")
    List<Loan> findAll();

    @Select("SELECT * FROM loans WHERE id = #{id}")
    Loan findById(@Param("id") long id);

    @Insert("INSERT INTO loans (book_id, student_name, loan_date, return_date, due_date) " +
            "VALUES (#{bookId}, #{studentName}, #{loanDate}, #{returnDate}, #{dueDate})")
    int save(Loan loan);

    @Delete("DELETE FROM loans WHERE id = #{id}")
    int deleteById(@Param("id") long id);

    @Select("SELECT * FROM loans WHERE book_id = #{bookId}")
    List<Loan> findByBookId(@Param("bookId") long bookId);
}
