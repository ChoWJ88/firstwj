package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BookDto;

public class BookDaoImpl implements BookDao {

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public BookDto selectView(Long num) {

		return sqlSessionTemplate.selectOne("selectByNum", num);

	}

	@Override
	public List<BookDto> selectAll() {
		return sqlSessionTemplate.selectList("selectAll");

	}

	@Override
	public void insert(BookDto bookDto) {
		sqlSessionTemplate.insert("insert", bookDto);
	}

	@Override
	public BookDto selectByIsbn(String isbn) {
		return sqlSessionTemplate.selectOne("selectByIsbn", isbn);
	}

	@Override
	public List<BookDto> selectByBookName(String bookname) {
		return sqlSessionTemplate.selectList("selectByBookName", bookname);
	}

	@Override
	public List<BookDto> selectByWriter(String writer) {
		return sqlSessionTemplate.selectList("selectByWriter", writer);
	}

	@Override
	public List<BookDto> selectByPub(String pub) {
		return sqlSessionTemplate.selectList("selectByPub", pub);
	}

}
