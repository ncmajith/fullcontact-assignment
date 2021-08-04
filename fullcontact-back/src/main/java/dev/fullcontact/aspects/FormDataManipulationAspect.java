package dev.fullcontact.aspects;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import dev.fullcontact.exceptions.BusinessException;
import dev.fullcontact.exceptions.ErrorVO;
import dev.fullcontact.model.PeopleModel;

@Aspect
@Component
public class FormDataManipulationAspect {
	public static final Logger logger = LoggerFactory.getLogger(FormDataManipulationAspect.class.getName());

	@Before("execution(* dev.fullcontact.controller.FullContactResource.add*(..)) &&" + "args(people,..)")
	public void doAccessCheck(PeopleModel people) throws BusinessException {
		logger.info("doAccessCheck aspect");
		String email = people.getEmail();
		String phone = people.getPhone();
		String service = people.getService();
		String url = people.getUrl();
		List<ErrorVO> errors = new ArrayList<>();
		if (email.trim().isEmpty())
			errors.add(new ErrorVO("01", "Email is required"));
		if (phone.trim().isEmpty())
			errors.add(new ErrorVO("01", "Phone number is required"));
		if (service.trim().isEmpty())
			errors.add(new ErrorVO("01", "Service is required"));
		if (url.trim().isEmpty())
			errors.add(new ErrorVO("01", "Url is required"));
		if (!errors.isEmpty())
			throw new BusinessException(errors);
	}

}
