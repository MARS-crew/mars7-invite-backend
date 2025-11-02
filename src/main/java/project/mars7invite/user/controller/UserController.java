package project.mars7invite.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import project.mars7invite.common.response.ApiResponse;
import project.mars7invite.user.dto.RequestUserDto;
import project.mars7invite.user.dto.ResponseUserDto;
import project.mars7invite.user.service.UserService;

import java.util.List;

@Tag(name = "지원", description = "지원")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "지원서 생성", description = "새로운 지원서를 등록합니다.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ResponseUserDto> save(@Valid @RequestBody RequestUserDto dto) {
        ResponseUserDto data = userService.save(dto);
        return ApiResponse.success("지원서 저장 성공", data);
    }   

    @Operation(summary = "지원서 전체 조회", description = "등록된 모든 지원서를 조회합니다.")
    @GetMapping
    public ApiResponse<List<ResponseUserDto>> getUsers() {
        List<ResponseUserDto> data = userService.getUsers();
        return ApiResponse.success("지원서 조회 성공", data);
    }
}

