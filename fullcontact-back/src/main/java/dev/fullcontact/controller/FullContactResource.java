package dev.fullcontact.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullcontact.apilib.models.Response.PersonResponse;

import dev.fullcontact.exceptions.BusinessException;
import dev.fullcontact.model.PeopleModel;
import dev.fullcontact.service.FullContactService;

@RestController
public class FullContactResource {

	public static final Logger logger = LoggerFactory.getLogger(FullContactResource.class.getName());
	@Autowired
	FullContactService fullContactService;

	@PostMapping("/people")
	@CrossOrigin
	public PersonResponse addPeople(@Valid @RequestBody PeopleModel peopleModel) throws BusinessException {
		logger.info("/people");
		return fullContactService.addPeople(peopleModel);
	}

}
