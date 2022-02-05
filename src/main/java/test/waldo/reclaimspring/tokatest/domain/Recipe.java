package test.waldo.reclaimspring.tokatest.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeId;
    private String recipeName;
    private String recipeDescription;
    private LocalDate recipeCreated;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Ingredient> recipeIngredients; 

    public Recipe() {
        super();
        this.recipeId = null;
        this.recipeName = null;
        this.recipeDescription = null;
        this.recipeCreated = null;
        this.recipeIngredients = null;
    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public Recipe(String recipeName, List<Ingredient> recipeIngredients) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public String returnRecipeNameAndIngredients() {
        return this.recipeName + " " + this.recipeIngredients;
    }
}
