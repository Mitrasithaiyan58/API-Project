package demo.hello.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import demo.hello.Entity.AdminEntity;

import demo.hello.Repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public List<AdminEntity> getdata() {
        return adminRepository.findAll();
    }

    
    public AdminEntity postdata(@RequestBody AdminEntity entity) {
        return adminRepository.save(entity);
    }

   
    public AdminEntity putdata(Long id,AdminEntity entity) {
       entity.setId(id);
       return adminRepository.save(entity);
    }

    
    public String deletedata( Long id){
        adminRepository.deleteById(id);
        return "success";
    }


    //sorting
public List<AdminEntity> getSorted(String field) {
    return adminRepository.findAll(Sort.by(Sort.Direction.ASC,field));
}



//JPA Methods
public List<AdminEntity> findByUsername(String username)
{
    return adminRepository.findByUsername(username);
}
  



    //JPQL 

    public String findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

  

    public Page<AdminEntity> getpageEmployee(int page,int size)
    {
        PageRequest pageable=PageRequest.of(page,size);
        return adminRepository.findAll(pageable);
    }


   
}
