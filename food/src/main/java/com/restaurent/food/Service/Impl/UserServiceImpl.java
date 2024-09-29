package com.restaurent.food.Service.Impl;

import com.restaurent.food.DTO.UserDto;
import com.restaurent.food.Entity.User;
import com.restaurent.food.Entity.UserRole;
import com.restaurent.food.Model.RoleEnum;
import com.restaurent.food.Repository.UserRepository;
import com.restaurent.food.Repository.UserRoleRepository;
import com.restaurent.food.Service.MappingService;
import com.restaurent.food.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final MappingServiceImpl mappingService;

    @Override
    public UserDto login(long mobile) {

        User user = userRepository.findByMobile(mobile);

        if(user != null) {
            return mappingService.convertToUserDto(user);
        } else {

            UserRole role = userRoleRepository.findByRole(RoleEnum.USER);
            User newUser = User.builder()
                    .mobile(mobile)
                    .role(role)
                    .build();
            userRepository.save(newUser);
            return mappingService.convertToUserDto(newUser);
        }
    }
}
