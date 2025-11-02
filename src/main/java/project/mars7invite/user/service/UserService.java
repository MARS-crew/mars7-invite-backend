package project.mars7invite.user.service;

import lombok.RequiredArgsConstructor;
import project.mars7invite.user.dto.RequestUserDto;
import project.mars7invite.user.dto.ResponseUserDto;
import project.mars7invite.user.entity.User;
import project.mars7invite.user.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public ResponseUserDto save(RequestUserDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .position(dto.getPosition())
                .age(dto.getAge())
                .motivation(dto.getMotivation())
                .phoneNumber(dto.getPhoneNumber())
                .privacyAgreement(dto.getPrivacyAgreement())
                .build();

        User saveUser = userRepository.save(user);
        return ResponseUserDto.from(saveUser);
    }

    public List<ResponseUserDto> getUsers() {
        return userRepository.findAll().stream()
                .map(ResponseUserDto::from)
                .collect(Collectors.toList());
    }
}

