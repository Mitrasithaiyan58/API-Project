package demo.hello.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demo.hello.Entity.UserEntity;




@Repository

public interface UserRepository extends JpaRepository<UserEntity,Long>{
  
   
    //JPA Methods

    List<UserEntity> findByName(String name);


   




    //JPQL 

    @Query("SELECT u.name  from UserEntity u where u.email=:email")
     public String findByEmail(@Param("email")String email);




     boolean existsByEmail(String email);
     boolean existsByPhone(String phone);
     boolean existsByName(String name);







   
    // @Query("DELETE from UserEntity u where u.email=:email")
    // @Transactional
    // public String deleteByEmail(@Param("email")String email);





    
} 



























// @Transactional
// public List<UserEntity> deleteByName(String password);
    


