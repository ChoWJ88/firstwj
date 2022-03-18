package service;

import java.util.List;

import dao.BookDao;
import dto.BookDto;

public class ListService {

	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<BookDto> viewList() {
		return bookDao.selectAll();
	}
}
