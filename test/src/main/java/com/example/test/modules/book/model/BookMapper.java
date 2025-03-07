package com.example.test.modules.book.model;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("SELECT * FROM books")
    List<Book> findAll();

    @Select("SELECT * FROM books WHERE id = #{id}")
    Book findById(@Param("id") long id);

    @Insert("INSERT INTO books (title, synopsis, publication_date, authors, publishers, total_stock, current_stock) " +
            "VALUES (#{title}, #{synopsis}, #{publicationDate}, #{authors}, #{publishers}, #{totalStock}, #{currentStock})")
    int save(Book book);

    @Update("UPDATE books SET title = #{title}, synopsis = #{synopsis}, " +
            "publication_date = #{publicationDate}, authors = #{authors}, " +
            "publishers = #{publishers}, total_stock = #{totalStock}, " +
            "current_stock = #{currentStock} WHERE id = #{id}")
    int update(Book book);

    @Delete("DELETE FROM books WHERE id = #{id}")
    int deleteById(@Param("id") long id);

    @Update("UPDATE books SET current_stock = current_stock + 1 WHERE id = #{id}")
    int increaseCurrentStock(@Param("id") long id);

    @Update("UPDATE books SET current_stock = current_stock - 1 WHERE id = #{id}")
    int decreaseCurrentStock(@Param("id") long id);
}
