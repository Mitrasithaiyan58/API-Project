
package demo.hello.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import demo.hello.Entity.RecipeEntity; // Change the package as per your project structure

import demo.hello.Service.RecipeService; // Change the package as per your project structure





import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired 
    RecipeService recipeService;

    @GetMapping("/getpath")
    public List<RecipeEntity> getuser() {
        return recipeService.getdata();
    }
    @GetMapping("/welcome")
    public String display(){
        return "Welcome to Springboot";
    }
    @PostMapping("/path")
    public RecipeEntity postuser(@RequestBody RecipeEntity entity) {
        return recipeService.postdata(entity);
    }

    @PutMapping("/put/{id}")
    public RecipeEntity putuser(@PathVariable Long id, @RequestBody RecipeEntity entity) {
       return recipeService.putdata(id,entity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteuser(@PathVariable Long id){
         recipeService.deletedata(id);
         return "success";
    }






      //sorting

    @GetMapping("/sorting")
    public List<RecipeEntity> getSorted(@RequestParam String field) {
        return recipeService.getSorted(field);
    }

 //JPA Methods
 @GetMapping("/get/by-name/{name}")
 public List<RecipeEntity> findByName(@PathVariable String name)
 {
     return recipeService.findByName(name);
 }     


//pagination

    @GetMapping("/paging")
    public Page<RecipeEntity> getEmployee(@RequestParam (defaultValue="2")int page,@RequestParam (defaultValue="3")int size) {
        return recipeService.getpageEmployee(page, size);
    }
    

      //JPQL

      @GetMapping("/get/cookingtime/{cookingtime}")
      public List<String>findByCookingtime(@PathVariable String cookingtime) {
          return recipeService.findByCookingtime(cookingtime);
      }
  
    
    
}
