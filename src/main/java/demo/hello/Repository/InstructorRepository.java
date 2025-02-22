package demo.hello.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demo.hello.Entity.InstructorEntity;


@Repository

public interface InstructorRepository extends JpaRepository<InstructorEntity,Long>{



      
    //JPA Methods

    List<InstructorEntity> findByName(String name);
    


    
//JPQL

    @Query("SELECT i.name from InstructorEntity i  where i.experience=:experience")
    public List<String> findByExperience(@Param("experience")String experience);
    
} 
    
