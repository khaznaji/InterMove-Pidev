package com.example.intermove.Repositories.Accomodation;

import com.example.intermove.Entities.Accomodation.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHousesRepository extends CrudRepository<House,Integer> {
}
