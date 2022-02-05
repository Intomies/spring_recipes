package test.waldo.reclaimspring.tokatest.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
    List<Ingredient> findByIngredientName(@Param("ingredientName") String ingredientName);
}
