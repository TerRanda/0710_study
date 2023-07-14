package com.tj.edu.practice5.model;

import java.time.LocalDateTime;

public interface TimeAuditable {
    LocalDateTime getCreateAt();
    LocalDateTime getUpdateAt();

    void setCreateAt(LocalDateTime createAt);
    void setUpdateAt(LocalDateTime updateAt);
}
