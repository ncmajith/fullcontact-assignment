package dev.fullcontact.dao;

import java.util.List;

import dev.fullcontact.entity.PeopleEnity;
import dev.fullcontact.exceptions.BusinessException;

public interface FullContactDao {
	public void saveHistory(PeopleEnity peopleEntity);
	public List<PeopleEnity> listHistory() throws BusinessException;
}
