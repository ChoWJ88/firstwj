package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.SearchCommand;
import dto.BookDto;
import service.SearchService;
import validate.SearchValiDate;

@Controller
public class SearchController {
	private SearchService searchService;

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@ModelAttribute("searchCommand") SearchCommand searchCommand, Errors errors, Model model) {
		new SearchValiDate().validate("searchCommand", errors);
	
		List<BookDto> sbook = searchService.search(searchCommand);
		model.addAttribute("book", sbook);

		return "book_list";
	}
}
