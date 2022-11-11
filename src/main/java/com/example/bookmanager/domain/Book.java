package com.example.bookmanager.domain;

import com.example.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.lang.reflect.Type;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    private Long publisherId;

    @OneToOne(mappedBy = "book")//이쪽엔느 포합시키지 않겠다는 뜻
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

//    @CreatedDate //BaseEntity클래스로 뺴주어서 일일이 어노테이션을 달필요가 없습니다
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate //BaseEntity클래스로 뺴주어서 일일이 어노테이션을 달필요가 없습니다
//    private LocalDateTime updatedAt;

//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
}
