
package test.waldo.reclaimspring.tokatest.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.waldo.reclaimspring.tokatest.domain.Ingredient;
import test.waldo.reclaimspring.tokatest.domain.IngredientRepository;
import test.waldo.reclaimspring.tokatest.domain.Recipe;
import test.waldo.reclaimspring.tokatest.domain.RecipeRepository;

@CrossOrigin
@Controller

public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@RequestMapping("/")
	public String returnFrontPage() {
		return "index";
	}

	@RequestMapping("/hello")
	public String sayHello() {
		return "PersonForm";
	}

	@GetMapping("/recipeslist")
	public String getRecipes(Model model) {
		List<Recipe> recipes = (List <Recipe>) recipeRepository.findAll();
		model.addAttribute("recipes", recipes);
		return "recipelist";
	}

	@GetMapping("/recipes")
	public @ResponseBody List<Recipe> getRecipesRest() {
		return (List <Recipe>) recipeRepository.findAll();
	}
	
	@GetMapping("/ingredients")
	public @ResponseBody List<Ingredient> getIngredientsRest() {
		return (List <Ingredient>) ingredientRepository.findAll();
	}
}
