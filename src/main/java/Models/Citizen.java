package Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "citizens")
public class Citizen {

    private Long id;
    private String fname;
    private String mname;
    private String lname;
    private String gender;
    private Date date_of_birth;

    public Citizen(){}

    public Citizen(String fname, String mname, String lname, String gender, Date date_of_birth){
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "fname", nullable = false)
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }

    @Column(name = "mname", nullable = false)
    public String getMname() {
        return mname;
    }
    public void setMname(String mname) {
        this.mname = mname;
    }

    @Column(name = "lname", nullable = false)
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

    @Column(name = "gender", nullable = false)
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "getDate_of_birth", nullable = false)
    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString(){
        return "Employee [id=" + id + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname
                + ", gender=" + gender + ", date_of_birth=" + date_of_birth + "]";
    }


}
