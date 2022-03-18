package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.SearchCommand;
import dto.BookDto;
import service.ListService;

@Controller
public class ListController {
	private ListService listService;

	public void setListService(ListService listService) {
		this.listService = listService;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showList(@ModelAttribute("searchCommand") SearchCommand searchCommand, Model model) {
		List<BookDto> book = listService.viewList();
		model.addAttribute("book", book);
		
		return "book_list";
	}

}
