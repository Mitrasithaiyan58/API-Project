package demo.hello.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;


import demo.hello.Entity.InstructorEntity;

import demo.hello.Repository.InstructorRepository;


@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    public List<InstructorEntity> getdata() {
        return instructorRepository.findAll();
    }

    
    public InstructorEntity postdata(@RequestBody InstructorEntity entity) {
        return instructorRepository.save(entity);
    }

   
    public InstructorEntity putdata(Long id,InstructorEntity entity) {
       entity.setId(id);
       return instructorRepository.save(entity);
    }

    
    public String deletedata( Long id){
        instructorRepository.deleteById(id);
        return "success";
    }



    
//sorting
public List<InstructorEntity> getSorted(String field) {
    return instructorRepository.findAll(Sort.by(Sort.Direction.ASC,field));
}


//JPA Methods
public List<InstructorEntity> findByName(String name)
{
    return instructorRepository.findByName(name);
}



    //JPQL 

    public List<String>findByExperience(String experience) {
        return instructorRepository.findByExperience(experience);
    }

  





   //paging

    public Page<InstructorEntity> getpageEmployee(int page,int size)
    {
        PageRequest pageable=PageRequest.of(page,size);
        return instructorRepository.findAll(pageable);
    }


   
}
