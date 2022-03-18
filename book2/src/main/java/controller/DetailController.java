package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.BookDto;
import service.DetailService;

@Controller
public class DetailController {
	private DetailService detailService;

	public void setDetailService(DetailService detailService) {
		this.detailService = detailService;
	}

	@RequestMapping(value = "/read/{num}", method = RequestMethod.GET)
	public String read(@PathVariable("num") Long num, Model model) {
		BookDto bookDto = (BookDto) detailService.selectView(num);
	
		model.addAttribute("bookDto", bookDto);
		return "book_detail";

	}

}
