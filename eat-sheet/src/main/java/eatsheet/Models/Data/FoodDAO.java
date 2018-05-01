package eatsheet.Models.Data;


import eatsheet.Models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FoodDAO extends CrudRepository<Food, Integer> {

}