package test.waldo.reclaimspring.tokatest.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ingredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientId;
    private String ingredientName;
    private String ingredientDescription;
    private LocalDate ingredientCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "recipeId")
    private Recipe recipe;

    public Ingredient() {
        super();
        this.ingredientId = null;
        this.ingredientName = null;
        this.ingredientDescription = null;
        this.ingredientCreated = null;
        this.recipe = null;
    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Ingredient(String ingredientName, Recipe recipe) {
        this.ingredientName = ingredientName;
        this.recipe = recipe;

    }

    public String returnIngredientName() {
        return this.ingredientName;
    }
}
