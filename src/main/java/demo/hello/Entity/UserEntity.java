package demo.hello.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;



@Entity
public class UserEntity {
    @Id
    // @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String password;
    private String email;
    private String phone;
   

    
 @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_recipe",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Set<RecipeEntity> savedRecipes ;



    

    public UserEntity(long id, String name, String password,String email,String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone= phone;
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
    public void setName(String name) {
        this.name = name;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserEntity(){
        
    }

    
}
