package test.waldo.reclaimspring.tokatest;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import test.waldo.reclaimspring.tokatest.domain.Ingredient;
import test.waldo.reclaimspring.tokatest.domain.IngredientRepository;
import test.waldo.reclaimspring.tokatest.domain.Recipe;
import test.waldo.reclaimspring.tokatest.domain.RecipeRepository;

@SpringBootApplication
public class TokatestApplication {

	private static final Logger log = LoggerFactory.getLogger(TokatestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TokatestApplication.class, args);
	}

	@Bean
	public CommandLineRunner recipesTest(IngredientRepository ingRepo, RecipeRepository recRepository) {
		return (args) -> {
			log.info("Server is running in http://localhost:8080/\n");
			Recipe recipe = new Recipe("Chili con Carne");
			recRepository.save(recipe);
			recipe = new Recipe("Fisksoppa");
			recRepository.save(recipe);
			List<Ingredient> ingredientsList = createIngredientsList(recipe);
			saveIngredientsToRepository(ingRepo, ingredientsList);
			log.info(recipe.getRecipeName());
		};
		
	};
	
	public List<Ingredient> createIngredientsList(Recipe recipe) {

		String[] ingNames = {"Chili", "Beef", "Salt", "Beans","Oil"};
		log.info("Save " + ingNames.length + " ingredients.");
		List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
		
		for (String ingName : ingNames) {
			Ingredient ing = new Ingredient(ingName, recipe);
			ingredientsList.add(ing);
			log.info("Added " + ingName + " to list.");
		};
		return ingredientsList;
	};

	public void saveIngredientsToRepository(IngredientRepository ingRepo, List<Ingredient> ingredientsList) {
		for (Ingredient ing : ingredientsList) {
			ingRepo.save(ing);
			log.info("Saved \"" + ing.returnIngredientName() + "\" to repository.");
		};
	};
};

