package project.mars7invite.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.mars7invite.user.enums.Position;

@Data
@NoArgsConstructor
@Schema(description = "지원서 요청 DTO")
public class RequestUserDto {

    @Schema(description = "이름", example = "홍길동", maxLength = 50)
    @NotBlank(message = "이름은 필수입니다.")
    @Size(max = 50, message = "이름은 50자 이하여야 합니다.")
    private String name;

    @Schema(description = "학과", example = "컴퓨터공학과",  maxLength = 100)
    @NotBlank(message = "학과는 필수입니다.")
    @Size(max = 100, message = "학과는 100자 이하여야 합니다.")
    private String department;

    @Schema(description = "포지션", example = "FRONTEND")
    @NotNull(message = "포지션은 필수입니다.")
    private Position position;

    @Schema(description = "나이", example = "22", minimum = "1", maximum = "30")
    @NotNull(message = "나이는 필수입니다.")
    private Integer age;

    @Schema(description = "지원 동기", example = "열정적으로 개발하고 싶습니다.", maxLength = 500)
    @NotBlank(message = "지원 동기는 필수입니다.")
    @Size(max = 500, message = "지원 동기는 500자 이하여야 합니다.")
    private String motivation;

    @Schema(description = "전화번호", example = "01012341234")
    @NotBlank(message = "전화번호는 필수입니다.")
    @Pattern(regexp = "^010\\d{8}$", message = "전화번호 형식이 올바르지 않습니다. (01012341234)")
    private String phoneNumber;

    @Schema(description = "개인정보 동의", example = "true")
    @NotNull(message = "개인정보 동의는 필수입니다.")
    @AssertTrue(message = "개인정보 동의는 필수입니다.")
    private Boolean privacyAgreement;
}

