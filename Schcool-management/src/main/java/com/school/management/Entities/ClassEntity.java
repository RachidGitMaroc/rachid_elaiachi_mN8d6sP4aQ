package com.school.management.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Class_Entity")
@Data
public class ClassEntity {
    @Id
    private int ID;

    @Column(name = "Name", nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    
    public ClassEntity() {
    }

}
