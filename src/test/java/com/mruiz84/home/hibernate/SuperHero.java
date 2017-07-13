package com.mruiz84.home.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class SuperHero {
    @Id
    @GeneratedValue
    public Long id;
    @Column(unique = true, nullable = false)
    public String name;
}
