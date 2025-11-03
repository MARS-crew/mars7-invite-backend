package project.mars7invite.user.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TB_USER_POSITIONS", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "position", nullable = false, length = 20)
    private List<Position> positions = new ArrayList<>();

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 500)
    private String motivation;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(nullable = false)
    private Boolean privacyAgreement;

    @Builder
    public User(String name, String department, List<Position> positions, Integer age, 
                      String motivation, String phoneNumber, Boolean privacyAgreement) {
        this.name = name;
        this.department = department;
        if (positions != null) {
            this.positions = positions;
        }
        this.age = age;
        this.motivation = motivation;
        this.phoneNumber = phoneNumber;
        this.privacyAgreement = privacyAgreement;
    }
}

