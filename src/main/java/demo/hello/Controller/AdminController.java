package demo.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import demo.hello.Entity.AdminEntity;

import demo.hello.Service.AdminService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired 
    AdminService adminService;

    @GetMapping("/getpath")
    public List<AdminEntity> getadmin() {
        return adminService.getdata();
    }
    @GetMapping("/welcome")
    public String display(){
        return "Welcome to Springboot";
    }
    @PostMapping("/path")
    public AdminEntity postuser(@RequestBody AdminEntity entity) {
        return adminService.postdata(entity);
    }

    @PutMapping("/put/{id}")
    public AdminEntity putuser(@PathVariable Long id, @RequestBody AdminEntity entity) {
       return adminService.putdata(id,entity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteuser(@PathVariable Long id){
         adminService.deletedata(id);
         return "success";
    }


      //sorting

    @GetMapping("/sorting")
    public List<AdminEntity> getSorted(@RequestParam String field) {
        return adminService.getSorted(field);
    }


    
    //JPA Methods
    @GetMapping("/get/by-username/{username}")
    public List<AdminEntity> findByUsername(@PathVariable String username)
    {
        return adminService.findByUsername(username);
    }     



    
    //JPQL

    @GetMapping("/get/email/{email}")
    public String findByEmail(@PathVariable String email) {
        return adminService.findByEmail(email);
    }




    @GetMapping("/paging")
    public Page<AdminEntity> getEmployee(@RequestParam (defaultValue="2")int page,@RequestParam (defaultValue="3")int size) {
        return adminService.getpageEmployee(page, size);
    }
    
    
    
}
