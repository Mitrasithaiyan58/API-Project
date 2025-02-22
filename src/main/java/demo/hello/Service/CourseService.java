package demo.hello.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import demo.hello.Entity.CourseEntity;

import demo.hello.Repository.CourseRepository;


@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<CourseEntity> getdata() {
        return courseRepository.findAll();
    }

    
    public CourseEntity postdata(@RequestBody CourseEntity entity) {
        return courseRepository.save(entity);
    }

   
    public CourseEntity putdata(Long id,CourseEntity entity) {
       entity.setId(id);
       return courseRepository.save(entity);
    }

    
    public String deletedata( Long id){
        courseRepository.deleteById(id);
        return "success";
    }


    
//sorting
public List<CourseEntity> getSorted(String field) {
    return courseRepository.findAll(Sort.by(Sort.Direction.ASC,field));
}


//JPA Methods
public List<CourseEntity> findByCoursename(String coursename)
{
    return courseRepository.findByCoursename(coursename);
}



//pagination
    public Page<CourseEntity> getpageEmployee(int page,int size)
    {
        PageRequest pageable=PageRequest.of(page,size);
        return courseRepository.findAll(pageable);
    }



     //JPQL 

     public List<String> findByCuisinetype(String cuisinetype) {
        return courseRepository.findByCuisinetype(cuisinetype);
    }


}
