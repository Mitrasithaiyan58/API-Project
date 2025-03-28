package demo.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import demo.hello.Entity.UserEntity;
import demo.hello.Service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired 
    UserService userService;

    @GetMapping("/getpath")
    public List<UserEntity> getuser() {
        return userService.getdata();
    }
    // @GetMapping("/welcome")
    // public String display(){
    //     return "Welcome to Springboot";
    // }
    @PostMapping("/path")
    public UserEntity postuser(@RequestBody UserEntity entity) {
        if (userService.isUserExists(entity)) {
            throw new IllegalArgumentException("User already exists with the given email, phone, or username.");
        }
        return userService.postdata(entity);
    }

    @PutMapping("/put/{id}")
    public UserEntity putuser(@PathVariable Long id, @RequestBody UserEntity entity) {
       return userService.putdata(id,entity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteuser(@PathVariable Long id){
         userService.deletedata(id);
         return "success";
    }




    


    //sorting

    @GetMapping("/sorting")
    public List<UserEntity> getSorted(@RequestParam String field) {
        return userService.getSorted(field);
    }



    //JPA Methods
    @GetMapping("/get/by-name/{name}")
    public List<UserEntity> findByName(@PathVariable String name)
    {
        return userService.findByName(name);
    }    





  
  
    //Pagination
    @GetMapping("/paging")
    public Page<UserEntity> getEmployee(@RequestParam (defaultValue="2")int page,@RequestParam (defaultValue="3")int size) {
        return userService.getpageEmployee(page, size);
    }
    

    //JPQL

    @GetMapping("/get/email/{email}")
     public String findByEmail(@PathVariable String email) {
         return userService.findByEmail(email);
     }


    }

























































    

    // @DeleteMapping("/delete/email/{email}")
    // public String deleteByEmail(@PathVariable String email) {
    //     return userService.deleteByEmail(email);
    // } 
    






























// @DeleteMapping("/delete/by-name/{name}")
// public String deleteByName(@PathVariable String password){
//      return userService.deleteByName(password);   
// }
