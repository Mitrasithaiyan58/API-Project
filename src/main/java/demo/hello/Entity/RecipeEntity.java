
package demo.hello.Entity;
// import java.util.Set;

import java.util.Set;

import jakarta.persistence.CascadeType;

// import java.util.HashSet;
// import java.util.Set;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

//  import jakarta.persistence.ManyToMany;



@Entity
public class RecipeEntity {
    @Id
    // @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String ingredients;
    private String description;
    private String cookingtime;
    private String instructions;
    
   

    
  

    @ManyToMany(mappedBy = "savedRecipes",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<UserEntity> users;


    public RecipeEntity(long id, String name, String ingredients,String description,String cookingtime,String instructions) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.cookingtime = cookingtime;
        this.instructions = instructions;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setname(String name) {
        this.name= name;
    }
    public String getingredients() {
        return ingredients;
    }
    public void setingredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getdescription() {
        return description;
    }
    public void setdescription(String description) {
        this.description = description;
    }
    public String getcookingtime() {
        return cookingtime;
    }
    public void setcookingtime(String cookingtime) {
        this.cookingtime = cookingtime;
    }
    public String instructions() {
        return instructions;
    }
    public void setinstructions(String instructions) {
        this.instructions= instructions;
    }



    
     



    public RecipeEntity(){
        
    }
    
}
