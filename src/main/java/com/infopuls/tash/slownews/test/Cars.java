package com.infopuls.tash.slownews.test;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "MARK")
    private String mark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Cars(String number, String mark , String color ) {
        this.color = color;
        this.number = number;
        this.mark = mark;
    }

    public Cars() {
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", number='" + number + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
