package demo.hello.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demo.hello.Entity.RecipeEntity;

@Repository

public interface RecipeRepository extends JpaRepository<RecipeEntity,Long>{

    List<RecipeEntity> findByName(String name);



//JPQL

    @Query("SELECT r.name from RecipeEntity r  where r.cookingtime=:cookingtime")
    public List<String> findByCookingtime(@Param("cookingtime")String cookingtime);
    
    
}
