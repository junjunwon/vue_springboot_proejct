package com.timegate.vportal.login.service;

import com.timegate.vportal.login.domain.UserDto;
import com.timegate.vportal.login.domain.UserEntity;
import com.timegate.vportal.login.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername() !!!!!!!!!!!!!!!");
        // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException((username)));
    }

    public UserDto save(UserDto userDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDto.setPassword(encoder.encode(userDto.getPassword()));

        return modelMapper.map(userRepository.save(new UserEntity.UserBuilder(userDto).build()), UserDto.class);
    }
}
