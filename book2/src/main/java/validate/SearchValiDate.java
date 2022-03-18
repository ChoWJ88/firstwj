package validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.RegCommand;
import command.SearchCommand;

public class SearchValiDate implements Validator {
	@Override
	public boolean supports(Class<?> arg0) {
		return SearchCommand.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "searchValue", "required");

	}

}
