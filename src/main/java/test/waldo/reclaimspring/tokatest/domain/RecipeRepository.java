package test.waldo.reclaimspring.tokatest.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecipeRepository extends CrudRepository <Recipe, Long>{
    List<Recipe> findByRecipeName(@Param("recipeName") String recipeName);
}
