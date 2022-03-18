package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.RegCommand;
import error.AlreadyExistingBookException;
import error.NoImageException;
import service.RegService;
import validate.RegValiDate;

@Controller
public class RegController {

	private RegService regService;

	public void setRegService(RegService regService) {
		this.regService = regService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String goRegForm(@ModelAttribute("regForm") RegCommand regCommand) {
		return "book_regForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String register(@ModelAttribute("regForm") RegCommand regCommand, Errors errors) {

		new RegValiDate().validate(regCommand, errors);

		if (errors.hasErrors()) {
			return "book_regForm";
		}
		try {
			regService.register(regCommand);
			return "redirect:/list";

		} catch (AlreadyExistingBookException e) {
			errors.rejectValue("isbn", "dupBook");
			return "book_regForm";

		} catch (NoImageException e) {
			errors.rejectValue("imgFile", "noImage");
			return "book_regForm";
		}

	}

}
