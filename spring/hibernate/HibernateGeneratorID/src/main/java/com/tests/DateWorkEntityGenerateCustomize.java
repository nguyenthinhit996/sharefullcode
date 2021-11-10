package com.tests;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "date_work_entity_generate_customize")
public class DateWorkEntityGenerateCustomize {

    @Id
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @Parameter(name = "prefix", value = "prod"),
            strategy = "com.tests.MyGenerator")
    @Column(name = "prodid")
    private Integer prodId;

    @Column(name = "listuserworkfullday", length = 5000)
    private String listUserWorkFullDay;

    @Column(name = "listuserhalfday", length = 5000)
    private String listUserHalfDay;

    @Column(name = "regulation")
    private Integer regulation;

    public DateWorkEntityGenerateCustomize(Integer idDateWork, String listUserWorkFullDay, String listUserHalfDay, Integer regulation) {
        this.prodId = idDateWork;
        this.listUserWorkFullDay = listUserWorkFullDay;
        this.listUserHalfDay = listUserHalfDay;
        this.regulation = regulation;
    }

    public DateWorkEntityGenerateCustomize() {
    }

    public void setIdDateWork(Integer idDateWork) {
        this.prodId = idDateWork;
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
        return prodId;
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