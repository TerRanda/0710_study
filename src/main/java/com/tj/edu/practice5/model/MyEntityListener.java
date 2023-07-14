package com.tj.edu.practice5.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class MyEntityListener {
    @PrePersist
    public void prePersist(Object o){
        if(o instanceof Auditable) {
            ((Auditable) o).setCreateAt(LocalDateTime.now());
        }
    }
    @PreUpdate
    public void postUpdate(Object O){
        if(O instanceof Auditable) {
            ((Auditable) O).setUpdateAt(LocalDateTime.now());
        }
    }
}
