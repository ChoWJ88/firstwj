package validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.RegCommand;

public class RegValiDate implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		return RegCommand.class.isAssignableFrom(arg0);
	}
	@Override
	public void validate(Object target, Errors errors) {
		
		RegCommand rc = (RegCommand) target;
		if(rc.getImgFile().isEmpty()) {
			errors.rejectValue("imgFile", "required");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookname", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pub", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");
		ValidationUtils.rejectIfEmpty(errors, "imgFile", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "info", "required");
	}

}
