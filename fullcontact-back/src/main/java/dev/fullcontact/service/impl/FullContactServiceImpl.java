package dev.fullcontact.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullcontact.apilib.FullContactException;
import com.fullcontact.apilib.enrich.FullContact;
import com.fullcontact.apilib.models.Profile;
import com.fullcontact.apilib.models.Request.PersonRequest;
import com.fullcontact.apilib.models.Response.PersonResponse;

import dev.fullcontact.dao.FullContactDao;
import dev.fullcontact.entity.PeopleEnity;
import dev.fullcontact.exceptions.BusinessException;
import dev.fullcontact.exceptions.ErrorVO;
import dev.fullcontact.model.PeopleModel;
import dev.fullcontact.service.FullContactService;

@Service
public class FullContactServiceImpl implements FullContactService {
	public static final Logger logger = LoggerFactory.getLogger(FullContactServiceImpl.class.getName());

	@Autowired
	FullContact fcClient;

	@Autowired
	FullContactDao fullContactDao;

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
			saveHistory(peopleModel, person);
			catchAndThrowException(person);
		} catch (FullContactException | InterruptedException | ExecutionException e) {
			ErrorVO errorVO = new ErrorVO("03", "Profile not found");
			throw new BusinessException(Arrays.asList(errorVO));
		}
		return person;
	}

	private void saveHistory(PeopleModel person, PersonResponse personResponse) {
		PeopleEnity entity = new PeopleEnity(person.getEmail(), person.getPhone(), person.getService(), person.getUrl(),
				personResponse.isSuccessful, LocalDateTime.now());
		fullContactDao.saveHistory(entity);
	}

	private void catchAndThrowException(PersonResponse person) {
		if (!person.isSuccessful) {
			ErrorVO errorVO = new ErrorVO("02", person.message);
			throw new BusinessException(Arrays.asList(errorVO));
		}
	}

	@Override
	public List<PeopleModel> listHistory() throws BusinessException {
		List<PeopleEnity> peopleList = fullContactDao.listHistory();
		return peopleList.isEmpty() ? new ArrayList<>()
				: peopleList
						.stream().map(people -> new PeopleModel(people.getEmail(), people.getPhone(),
								people.getService(), people.getUrl(), people.isSuccess(), people.getCreated()))
						.collect(Collectors.toList());
	}
}
