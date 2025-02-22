package demo.hello.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demo.hello.Entity.AdminEntity;


@Repository

public interface AdminRepository extends JpaRepository<AdminEntity,Long>{

      List<AdminEntity> findByUsername(String username);




          //JPQL 

    @Query("SELECT a.username  from  AdminEntity a where a.email=:email")
    public String findByEmail(@Param("email")String email);
}