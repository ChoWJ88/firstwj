package service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import command.RegCommand;
import dao.BookDao;
import dto.BookDto;
import error.AlreadyExistingBookException;
import error.NoImageException;

public class RegService {
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void register(RegCommand rc) {
		String path = "C:\\test\\upload";
		BookDto hasBook = (BookDto) bookDao.selectByIsbn(rc.getIsbn());
		if (hasBook != null) {
		
			throw new AlreadyExistingBookException();
		}
		try {
			MultipartFile imgFile = rc.getImgFile();
			String orifile = imgFile.getOriginalFilename();

			String savedfile = UUID.randomUUID().toString() + orifile;

			File file = null;
			if (savedfile != null) {
				if (savedfile.endsWith("jpg") || savedfile.endsWith("png")) {
					file = new File(path, savedfile);
					imgFile.transferTo(file); // 파일 저장

				} else {
					throw new NoImageException();
				}
			}
			BookDto newBook = new BookDto();
			newBook.setIsbn(rc.getIsbn());
			newBook.setBookname(rc.getBookname());
			newBook.setWriter(rc.getWriter());
			newBook.setSavedfile(savedfile);
			newBook.setOrifile(orifile);
			newBook.setPrice(rc.getPrice());
			newBook.setInfo(rc.getInfo());
			newBook.setPub(rc.getPub());

			bookDao.insert(newBook);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
