package model;

import javax.persistence.*;
import javax.servlet.annotation.WebServlet;
import java.io.Serializable;
import java.util.List;

@WebServlet("/CRM")
@Entity
public class CRM implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String username;
    private String avaible_date;

    public String getAvaible_date() {
        return avaible_date;
    }

    public void setAvaible_date(String avaible_date) {
        this.avaible_date = avaible_date;
    }

    @OneToMany(mappedBy = "crm",cascade = CascadeType.ALL)
    List<Issues> Issueslist;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
