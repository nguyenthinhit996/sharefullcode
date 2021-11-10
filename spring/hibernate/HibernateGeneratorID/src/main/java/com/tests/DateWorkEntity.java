package com.tests;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "datework")
public class DateWorkEntity {

    /**
     * iddatework is primary key column in Database
     */
    @Id
    @Column(name = "iddatework")
    private LocalDate idDateWork;

    @Column(name = "listuserworkfullday", length = 5000)
    private String listUserWorkFullDay;

    @Column(name = "listuserhalfday", length = 5000)
    private String listUserHalfDay;

    @Column(name = "regulation")
    private Integer regulation;

    public DateWorkEntity(LocalDate idDateWork, String listUserWorkFullDay, String listUserHalfDay, Integer regulation) {
        this.idDateWork = idDateWork;
        this.listUserWorkFullDay = listUserWorkFullDay;
        this.listUserHalfDay = listUserHalfDay;
        this.regulation = regulation;
    }

    public DateWorkEntity() {
    }

    public void setIdDateWork(LocalDate idDateWork) {
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

    public LocalDate getIdDateWork() {
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