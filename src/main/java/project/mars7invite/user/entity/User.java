package project.mars7invite.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mars7invite.common.utils.BaseTimeEntity;
import project.mars7invite.user.enums.Position;

@Entity
@Table(name = "TB_USER")
@Getter
@NoArgsConstructor()
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100)
    private String department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Position position;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 500)
    private String motivation;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(nullable = false)
    private Boolean privacyAgreement;

    @Builder
    public User(String name, String department, Position position, Integer age, 
                      String motivation, String phoneNumber, Boolean privacyAgreement) {
        this.name = name;
        this.department = department;
        this.position = position;
        this.age = age;
        this.motivation = motivation;
        this.phoneNumber = phoneNumber;
        this.privacyAgreement = privacyAgreement;
    }
}

