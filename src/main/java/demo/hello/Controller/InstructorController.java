
package demo.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import demo.hello.Entity.InstructorEntity;

import demo.hello.Service.InstructorService;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired 
    InstructorService instructorService;

    @GetMapping("/getpath")
    public List<InstructorEntity> getuser() {
        return instructorService.getdata();
    }
    @GetMapping("/welcome")
    public String display(){
        return "Welcome to Springboot";
    }
    @PostMapping("/path")
    public InstructorEntity postuser(@RequestBody InstructorEntity entity) {
        return instructorService.postdata(entity);
    }

    @PutMapping("/put/{id}")
    public InstructorEntity putuser(@PathVariable Long id, @RequestBody InstructorEntity entity) {
       return instructorService.putdata(id,entity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteuser(@PathVariable Long id){
         instructorService.deletedata(id);
         return "success";
    }





    //sorting

    @GetMapping("/sorting")
    public List<InstructorEntity> getSorted(@RequestParam String field) {
        return instructorService.getSorted(field);
    }


     //JPA Methods
 @GetMapping("/get/by-name/{name}")
 public List<InstructorEntity> findByName(@PathVariable String name)
 {
     return instructorService.findByName(name);
 }     


 
    //   //JPQL

       @GetMapping("/get/experience/{experience}")
       public List<String>findByExperience(@PathVariable String experience) {
          return instructorService.findByExperience(experience);
      }
  



//Pagination
    @GetMapping("/paging")
    public Page<InstructorEntity> getEmployee(@RequestParam (defaultValue="2")int page,@RequestParam (defaultValue="3")int size) {
        return instructorService.getpageEmployee(page, size);
    }
    
    
    
}
