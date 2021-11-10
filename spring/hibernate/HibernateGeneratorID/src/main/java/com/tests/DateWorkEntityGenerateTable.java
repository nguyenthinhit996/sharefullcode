package com.tests;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "DateWorkEntityGenerateTable")
public class DateWorkEntityGenerateTable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "table-generator")
    @TableGenerator(name = "table-generator",
            table = "dep_ids",
            pkColumnName = "seq_id",
            valueColumnName = "seq_value")
    @Column(name = "iddatework")
    private Integer idDateWork;

    @Column(name = "listuserworkfullday", length = 5000)
    private String listUserWorkFullDay;

    @Column(name = "listuserhalfday", length = 5000)
    private String listUserHalfDay;

    @Column(name = "regulation")
    private Integer regulation;

    public DateWorkEntityGenerateTable(Integer idDateWork, String listUserWorkFullDay, String listUserHalfDay, Integer regulation) {
        this.idDateWork = idDateWork;
        this.listUserWorkFullDay = listUserWorkFullDay;
        this.listUserHalfDay = listUserHalfDay;
        this.regulation = regulation;
    }

    public DateWorkEntityGenerateTable() {
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