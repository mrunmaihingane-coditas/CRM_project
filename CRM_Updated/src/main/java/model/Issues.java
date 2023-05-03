package model;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;
@Entity
public class Issues implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int complainId;

    private String complain;

    private String complain_date;

    public Issues(String complain, String complain_date, User user) {
        this.complain = complain;
        this.complain_date = complain_date;
        this.user = user;
    }

    public Issues() {
    }

    @ManyToOne()
    private User user;

    @ManyToOne
    private CRM crm;

    public String getComplain_date() {
        return complain_date;
    }

    public CRM getCrm() {
        return crm;
    }

    public void setCrm(CRM crm) {
        this.crm = crm;
    }

    public void setComplain_date(String complain_date) {
        this.complain_date = complain_date;
    }

    public int getCompleteId() {
        return complainId;
    }

    public void setComplainId(int completeId) {
        this.complainId = completeId;
    }

    public String getComplainId() {
        return complain;
    }

    public void setComplain(String complete) {
        this.complain = complete;
    }

    public String getComplain() {
        return complain;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
