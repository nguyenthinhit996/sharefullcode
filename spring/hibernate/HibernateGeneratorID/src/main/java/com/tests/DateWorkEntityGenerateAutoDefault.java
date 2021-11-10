package com.tests;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DateWorkEntityGenerateAutoDefault")
public class DateWorkEntityGenerateAutoDefault {

    /**
     * iddatework is primary key column in Database
     */
    @Id
    @GeneratedValue
    @Column(name = "iddatework")
    private Integer idDateWork;

    @Column(name = "listuserworkfullday", length = 5000)
    private String listUserWorkFullDay;

    @Column(name = "listuserhalfday", length = 5000)
    private String listUserHalfDay;

    @Column(name = "regulation")
    private Integer regulation;

    public DateWorkEntityGenerateAutoDefault(Integer idDateWork, String listUserWorkFullDay, String listUserHalfDay, Integer regulation) {
        this.idDateWork = idDateWork;
        this.listUserWorkFullDay = listUserWorkFullDay;
        this.listUserHalfDay = listUserHalfDay;
        this.regulation = regulation;
    }

    public DateWorkEntityGenerateAutoDefault() {
    }

    public void setIdDateWork(Integer idDateWork) {
        this.idDateWork = idDateWork;
    }

    public void setListUserWorkFullDay(String listUserWorkFullDay) {
        this.listUserWorkFullDay = listUserWorkFullDay;
    }

    public void setListUserHalfDay(String listUserHalfDay) {
        this.listUserHalfDay = listUserHalfDay;
    }

    public void setRegulation(Integer regulation) {
        this.regulation = regulation;
    }

    public Integer getIdDateWork() {
        return idDateWork;
    }

    public String getListUserWorkFullDay() {
        return listUserWorkFullDay;
    }

    public String getListUserHalfDay() {
        return listUserHalfDay;
    }

    public Integer getRegulation() {
        return regulation;
    }
}