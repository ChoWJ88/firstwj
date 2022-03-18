package service;

import java.util.List;

import command.SearchCommand;
import dao.BookDao;
import dto.BookDto;

public class SearchService {
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<BookDto> search(SearchCommand searchCommand) {
		List<BookDto> sbook = null;
		if(searchCommand.getSearchType().equals("bookname")) {
			sbook = bookDao.selectByBookName(searchCommand.getSearchValue());
		}else if(searchCommand.getSearchType().equals("writer")) {
			sbook = bookDao.selectByWriter(searchCommand.getSearchValue());
		}else if(searchCommand.getSearchType().equals("pub")){
			sbook = bookDao.selectByPub(searchCommand.getSearchValue());
		}
		
		return sbook;
	}
	
}
