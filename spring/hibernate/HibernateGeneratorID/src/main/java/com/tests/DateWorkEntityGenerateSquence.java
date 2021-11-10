package com.tests;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "DateWorkEntityGenerateSquence")
public class DateWorkEntityGenerateSquence {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "iddatework")
    private Integer idDateWork;

    @Column(name = "listuserworkfullday", length = 5000)
    private String listUserWorkFullDay;

    @Column(name = "listuserhalfday", length = 5000)
    private String listUserHalfDay;

    @Column(name = "regulation")
    private Integer regulation;

    public DateWorkEntityGenerateSquence(Integer idDateWork, String listUserWorkFullDay, String listUserHalfDay, Integer regulation) {
        this.idDateWork = idDateWork;
        this.listUserWorkFullDay = listUserWorkFullDay;
        this.listUserHalfDay = listUserHalfDay;
        this.regulation = regulation;
    }

    public DateWorkEntityGenerateSquence() {
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