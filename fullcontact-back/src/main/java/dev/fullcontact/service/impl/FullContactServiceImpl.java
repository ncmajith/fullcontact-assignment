package dev.fullcontact.service.impl;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullcontact.apilib.FullContactException;
import com.fullcontact.apilib.enrich.FullContact;
import com.fullcontact.apilib.models.Profile;
import com.fullcontact.apilib.models.Request.PersonRequest;
import com.fullcontact.apilib.models.Response.PersonResponse;

import dev.fullcontact.exceptions.BusinessException;
import dev.fullcontact.exceptions.ErrorVO;
import dev.fullcontact.model.PeopleModel;
import dev.fullcontact.service.FullContactService;

@Service
public class FullContactServiceImpl implements FullContactService {
	public static final Logger logger = LoggerFactory.getLogger(FullContactServiceImpl.class.getName());

	@Autowired
	FullContact fcClient;

	@Override
	public PersonResponse addPeople(PeopleModel peopleModel) throws BusinessException {
		logger.info("addPeople");
		PersonResponse person = null;
		try {
			PersonRequest personRequest = fcClient.buildPersonRequest().email(peopleModel.getEmail())
					.phone(peopleModel.getPhone())
					.profile(Profile.builder().service(peopleModel.getService()).url(peopleModel.getUrl()).build())
					.build();
			CompletableFuture<PersonResponse> personResponseCompletableFuture = fcClient.enrich(personRequest);
			person = personResponseCompletableFuture.get();
			catchAndThrowException(person);
		} catch (FullContactException | InterruptedException | ExecutionException e) {
			ErrorVO errorVO = new ErrorVO("03", "Profile not found");
			throw new BusinessException(Arrays.asList(errorVO));
		}
		return person;
	}

	private void catchAndThrowException(PersonResponse person) {
		// TODO Auto-generated method stub
		if(!person.isSuccessful) {
			ErrorVO errorVO = new ErrorVO("02", person.message);
			throw new BusinessException(Arrays.asList(errorVO));
		}
	}
}
