package project.mars7invite.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mars7invite.user.entity.User;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDto {

    private Long id;
    private String name;
    private String department;
    private String positionLabel;
    private Integer age;
    private String motivation;
    private String phoneNumber;
    private Boolean privacyAgreement;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static ResponseUserDto from(User user) {
        return ResponseUserDto.builder()
                .id(user.getUserId())
                .name(user.getName())
                .department(user.getDepartment())
                .positionLabel( user.getPosition().getLabel())
                .age(user.getAge())
                .motivation(user.getMotivation())
                .phoneNumber(user.getPhoneNumber())
                .privacyAgreement(user.getPrivacyAgreement())
                .createdAt(user.getCreatedAt())
                .modifiedAt(user.getModifiedAt())
                .build();
    }
}

