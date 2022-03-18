package service;

import dao.BookDao;

public class DetailService {
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public Object selectView(Long num) {
		Object view = bookDao.selectView(num);
		return view;

	}

}
