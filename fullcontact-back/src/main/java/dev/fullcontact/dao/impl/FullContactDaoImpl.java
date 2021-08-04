package dev.fullcontact.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.fullcontact.dao.FullContactDao;
import dev.fullcontact.entity.PeopleEnity;
import dev.fullcontact.exceptions.BusinessException;
import dev.fullcontact.repositories.PeopleEntityRepository;

@Repository
public class FullContactDaoImpl implements FullContactDao {
	
	@Autowired
	PeopleEntityRepository peopleEntityRepository;

	@Override
	public void saveHistory(PeopleEnity peopleEntity) {
		peopleEntityRepository.save(peopleEntity);
	}

	@Override
	public List<PeopleEnity> listHistory() throws BusinessException {
		return peopleEntityRepository.findAll();
	}

}
