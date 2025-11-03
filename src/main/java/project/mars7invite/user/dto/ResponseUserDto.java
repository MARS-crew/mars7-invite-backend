package project.mars7invite.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mars7invite.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDto {

    private Long id;
    private String name;
    private String department;
    private List<String> positions;
    private Integer age;
    private String motivation;
    private String phoneNumber;
    private Boolean privacyAgreement;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static ResponseUserDto from(User user) {
        List<String> labels = null;
        if (user.getPositions() != null && !user.getPositions().isEmpty()) {
            labels = user.getPositions().stream()
                    .map(p -> p.getLabel())
                    .collect(Collectors.toList());
        }

        return ResponseUserDto.builder()
                .id(user.getUserId())
                .name(user.getName())
                .department(user.getDepartment())
                .positions(labels)
                .age(user.getAge())
                .motivation(user.getMotivation())
                .phoneNumber(user.getPhoneNumber())
                .privacyAgreement(user.getPrivacyAgreement())
                .createdAt(user.getCreatedAt())
                .modifiedAt(user.getModifiedAt())
                .build();
    }
}

