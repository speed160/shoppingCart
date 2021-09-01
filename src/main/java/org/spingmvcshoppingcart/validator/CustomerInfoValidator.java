package org.spingmvcshoppingcart.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.spingmvcshoppingcart.model.CustomerInfo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// Component : As a bean
@Component
public class CustomerInfoValidator implements Validator {

	private EmailValidator emailValidator = EmailValidator.getInstance();

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == CustomerInfo.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerInfo custInfo = (CustomerInfo) target;
		// Check the fields of CustomerInfo class
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerform.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.customerform.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerform.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerform.phone");

		if (!emailValidator.isValid(custInfo.getEmail())) {
			errors.rejectValue("email", "Pattern.cutomerForm.email");
		}
	}

}
