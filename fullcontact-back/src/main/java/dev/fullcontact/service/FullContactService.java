package dev.fullcontact.service;

import com.fullcontact.apilib.models.Response.PersonResponse;

import dev.fullcontact.exceptions.BusinessException;
import dev.fullcontact.model.PeopleModel;


public interface FullContactService {
	
	public PersonResponse addPeople(PeopleModel peopleModel) throws BusinessException;

}
