package dev.fullcontact.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fullcontact.entity.PeopleEnity;

public interface PeopleEntityRepository extends JpaRepository<PeopleEnity, Integer>  {

}
