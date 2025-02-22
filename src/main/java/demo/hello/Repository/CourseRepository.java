package demo.hello.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demo.hello.Entity.CourseEntity;


@Repository

public interface CourseRepository extends JpaRepository<CourseEntity,Long>{




    List<CourseEntity> findByCoursename(String coursename);



      //JPQL 

    @Query("SELECT c.coursename from CourseEntity c where c.cuisinetype=:cuisinetype")
    public List<String> findByCuisinetype(@Param("cuisinetype")String cuisinetype);
    
}

    
