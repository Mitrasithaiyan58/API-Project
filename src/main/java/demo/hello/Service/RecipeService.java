package demo.hello.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import demo.hello.Entity.RecipeEntity;

import demo.hello.Repository.RecipeRepository;


@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    public List<RecipeEntity> getdata() {
        return recipeRepository.findAll();
    }

    
    public  RecipeEntity postdata(@RequestBody RecipeEntity entity) {
        return recipeRepository.save(entity);
    }

   
    public RecipeEntity putdata(Long id,RecipeEntity entity) {
       entity.setId(id);
       return recipeRepository.save(entity);
    }

    
    public String deletedata( Long id){
        recipeRepository.deleteById(id);
        return "success";
    }


 

//sorting

public List<RecipeEntity> getSorted(String field) {
    return recipeRepository.findAll(Sort.by(Sort.Direction.ASC,field));
}



//JPA Methods
public List<RecipeEntity> findByName(String name)
{
    return recipeRepository.findByName(name);
}
  



    //JPQL 

    public List<String>findByCookingtime(String cookingtime) {
        return recipeRepository.findByCookingtime(cookingtime);
    }




    public Page<RecipeEntity> getpageEmployee(int page,int size)
    {
        PageRequest pageable=PageRequest.of(page,size);
        return recipeRepository.findAll(pageable);
    }


   
}
