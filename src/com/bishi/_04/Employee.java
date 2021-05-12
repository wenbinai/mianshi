package com.bishi._04;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Employee {
    private Integer id;
    private String name;
    private BigDecimal money;
    private int month;
    private LocalDateTime dateTime;

    public Employee(String name, BigDecimal money, int month, LocalDateTime dateTime) {
        this.name = name;
        this.money = money;
        this.month = month;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

// 员工: name, money, id, month, time

