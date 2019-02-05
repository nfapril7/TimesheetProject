package com.ets.timesheet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
 
import org.hibernate.annotations.NaturalId;
 
@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private AccountRole roleName;
 
    public Role(AccountRole roleName) {
        this.roleName = roleName;
    }
 
}