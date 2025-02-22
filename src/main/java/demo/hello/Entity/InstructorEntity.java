
package demo.hello.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InstructorEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String experience;
    private String availability;
   private String specialization;
    
   


    public InstructorEntity(long id, String name, String email,String phone,String experience,String availability,String specialization) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.experience = experience;
        this.availability = availability;
        this.specialization = specialization;

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setname(String name) {
        this.name= name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getexperience() {
        return experience;
    }
    public void setexperience(String experience) {
        this.experience = experience;
    }
    public String getavailability() {
        return availability;
    }
    public void setavailability(String availability) {
        this.availability = availability;
    }
    public String getspecialization() {
        return specialization;
    }
    public void setspecialization(String specialization) {
        this.specialization = specialization;
    }

    public InstructorEntity(){
        
    }
    
}
