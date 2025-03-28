package demo.hello.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import demo.hello.Entity.UserEntity;
import demo.hello.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
//get
    public List<UserEntity> getdata() {
        return userRepository.findAll();
    }

//post
    public UserEntity postdata(@RequestBody UserEntity entity) {
        return userRepository.save(entity);
    }

//put 
    public UserEntity putdata(Long id,UserEntity entity) {
       entity.setId(id);
       return userRepository.save(entity);
    }

//delete 
    public String deletedata( Long id){
        userRepository.deleteById(id);
        return "success";
    }





//sorting
public List<UserEntity> getSorted(String field) {
    return userRepository.findAll(Sort.by(Sort.Direction.ASC,field));
}


//JPA Methods
public List<UserEntity> findByName(String name)
{
    return userRepository.findByName(name);
}
  

//Pagination
    public Page<UserEntity> getpageEmployee(int page,int size)
    {
        PageRequest pageable=PageRequest.of(page,size);
        return userRepository.findAll(pageable);
    }



    //JPQL 

    public String findByEmail(String email) {
       return  userRepository.findByEmail(email);
      

    }





    public boolean isUserExists(UserEntity user) {
        return userRepository.existsByEmail(user.getEmail()) ||
                userRepository.existsByPhone(user.getPhone()) ||
                userRepository.existsByName(user.getName());
    }
}









































// public String deleteByName(String password){
//     userRepository.deleteByName(password);
//     return "success";
// }
