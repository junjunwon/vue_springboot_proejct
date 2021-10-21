package com.timegate.vportal.login.service;

import com.timegate.vportal.login.domain.UserDto;
import com.timegate.vportal.login.domain.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    /**
     * Spring Security 필수 메소드 구현
     *
     * @param email 이메일
     * @return UserEntity
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
    public UserEntity loadUserByUsername(String email) throws UsernameNotFoundException;

    /**
     * 회원정보 저장
     *
     * @param userDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    public UserDto save(UserDto userDto) ;
}
