
package demo.hello.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String coursename;
    private String cuisinetype;
    private String level;
    private String duration;
    private String instructor;
    private String startdate;
    private String enddate;
    private String price;
   


    public CourseEntity(long id, String coursename, String cuisinetype,String level,String duration,String instructor,String startdate,String enddate,String price) {
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
    public String getinstructor() {
        return instructor;
    }
    public void setinstructor(String instructor) {
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
