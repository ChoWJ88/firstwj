package dao;

import java.util.List;

import dto.BookDto;

public interface BookDao {


	public List<BookDto> selectAll();
	public List<BookDto> selectByPub(String pub);
	public List<BookDto> selectByWriter(String writer);
	public List<BookDto> selectByBookName(String bookname);
	public Object selectView(Long num);
	public Object selectByIsbn(String isbn);
	public void insert(BookDto bookDto);



}
