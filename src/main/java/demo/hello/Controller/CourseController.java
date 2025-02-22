
package demo.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;


import demo.hello.Entity.CourseEntity;

import demo.hello.Service.CourseService;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired 
    CourseService courseService;

    @GetMapping("/getpath")
    public List<CourseEntity> getuser() {
        return courseService.getdata();
    }
    @GetMapping("/welcome")
    public String display(){
        return "Welcome to Springboot";
    }
    @PostMapping("/path")
    public CourseEntity postuser(@RequestBody CourseEntity entity) {
        return courseService.postdata(entity);
    }

    @PutMapping("/put/{id}")
    public CourseEntity putuser(@PathVariable Long id, @RequestBody CourseEntity entity) {
       return courseService.putdata(id,entity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteuser(@PathVariable Long id){
         courseService.deletedata(id);
         return "success";
    }

  




 //sorting

    @GetMapping("/sorting")
    public List<CourseEntity> getSorted(@RequestParam String field) {
        return courseService.getSorted(field);
    }



    
 //JPA Methods
 @GetMapping("/get/by-coursename/{coursename}")
 public List<CourseEntity> findByCoursename(@PathVariable String coursename)
 {
     return courseService.findByCoursename(coursename);
 }     


  //JPQL

  @GetMapping("/get/cuisinetype/{cuisinetype}")
  public List<String> findByCuisinetype(@PathVariable String cuisinetype) {
      return courseService.findByCuisinetype(cuisinetype);
  }




//pagination
    @GetMapping("/paging")
    public Page<CourseEntity> getEmployee(@RequestParam (defaultValue="2")int page,@RequestParam (defaultValue="3")int size) {
        return courseService.getpageEmployee(page, size);
    }
    
    
    
}
