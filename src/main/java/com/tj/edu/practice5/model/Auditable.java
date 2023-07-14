package com.tj.edu.practice5.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getCreateAt();
    LocalDateTime getUpdateAt();

    void setCreateAt(LocalDateTime createAt);
    void setUpdateAt(LocalDateTime updateAt);
}
