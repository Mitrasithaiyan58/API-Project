
package demo.hello.Entity;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CourseEntity {
    @Id
    // @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String coursename;
    private String cuisinetype;
    private String level;
    private String duration;
  
    private String startdate;
    private String enddate;
    private String price;
   


    public CourseEntity(long id, String coursename, String cuisinetype,String level,String duration,InstructorEntity instructor,String startdate,String enddate,String price) {
        this.id = id;
        this.coursename = coursename;
        this.cuisinetype = cuisinetype;
        this.level = level;
        this.duration = duration;
        this.instructor= instructor;
        this.startdate = startdate;
        this.enddate= enddate;
        this.price = price;
    }



      // Many Courses belong to One Instructor
    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private InstructorEntity instructor;

    



    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getcoursename() {
        return coursename;
    }
    public void setcoursename(String coursename) {
        this.coursename = coursename;
    }
    public String getcuisinetype() {
        return cuisinetype;
    }
    public void setcuisinetype(String cuisinetype) {
        this.cuisinetype = cuisinetype;
    }
    public String getlevel() {
        return level;
    }
    public void setlevel(String level) {
        this.level= level;
    }
    public String getduration() {
        return duration;
    }
    public void setduration(String duration) {
        this.duration = duration;
    }
    
    public InstructorEntity getInstructor() {
        return instructor;
    }
    public void setInstructor(InstructorEntity instructor) {
        this.instructor = instructor;
    }
    public String getstartdate() {
        return startdate;
    }
    public void setstartdate(String startdate) {
        this.startdate = startdate;
    }
    public String getenddate() {
        return enddate;
    }
    public void setenadate(String enddate) {
        this.enddate = enddate;
    }
    public String getprice() {
        return price;
    }
    public void setprice(String price) {
        this.price = price;
    }

    public CourseEntity(){
        
    }
    
}
