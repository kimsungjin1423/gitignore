package com.tj.edu.practice5.jpa.model;


import com.tj.edu.practice5.jpa.model.enums.Nation;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "member")
//@EntityListeners(value = { MemberEntityListener.class, TimeAuditEntityListener.class})
//@EntityListeners(value = {AuditingEntityListener.class, MemberEntityListener.class})
@EntityListeners(value = {MemberEntityListener.class})
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue
    private Long id;
    //    @NonNull
    @Column(nullable = false, columnDefinition = "varchar(5)")
    @ToString.Exclude
    private String name;
    @Column(columnDefinition = "varchar(100)")
    private String email;

//    @Column(name = "colTest2", unique = true)
//    @Column(name = "colTest2", insertable = false, updatable = false)
////    @Transient
//    private Integer test2;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

    private Boolean male;

    @Transient
    private String testData;

    //    @Column(columnDefinition = "varchar(100)")
    @Enumerated(value = EnumType.STRING)
    private Nation nation;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<MemberLogHistory> memberLogHistories;

    //    @OneToMany(fetch = FetchType.EAGER)
    @OneToMany
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private List<Review> reviews;

    @PreRemove
    public void preDelete1() {
        System.out.println(">>> preDelete1()");
    }
    @PostPersist
    public void afterInsert1() {
        System.out.println(">>> afterInsert1()");
    }
    @PostUpdate
    public void afterUpdate1() {
        System.out.println(">>> afterUpdate1()");
    }
    @PostRemove
    public void afterDelete1() {
        System.out.println(">>> afterDelete1()");
    }
    @PostLoad
    public void afterSelect1() {
        System.out.println(">>> afterSelect1()");
    }
}