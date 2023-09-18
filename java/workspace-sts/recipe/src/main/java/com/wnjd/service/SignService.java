package com.wnjd.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wnjd.common.CommonResponse;
import com.wnjd.model.dto.SignInResultDto;
import com.wnjd.model.dto.SignUpResultDto;
import com.wnjd.model.entity.User;
import com.wnjd.repository.UserRepository;
import com.wnjd.security.JwtTokenProvider;

@Service
public class SignService {
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private JwtTokenProvider jwtTokenProvider;
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   public SignUpResultDto signUp(String id, String password, String name, String role) {
      User user;
      if(role.equalsIgnoreCase("admin")) { 
         user = User.builder().uid(id).name(name).password(passwordEncoder.encode(password))
               .roles(Collections.singletonList("ROLE_ADMIN")).build();
      } else {
         user = User.builder().uid(id).name(name).password(passwordEncoder.encode(password))
               .roles(Collections.singletonList("ROLE_USER")).build();
      }
      User savedUser = userRepository.save(user);
      SignUpResultDto signUpResultDto = new SignUpResultDto();
      if(!savedUser.getName().isEmpty()) {
         setSuccessResult(signUpResultDto);
         
      } else {
         setFailResult(signUpResultDto);
      }
      
      return signUpResultDto;
   }
   
   private void setSuccessResult(SignUpResultDto result) {
      result.setSuccess(true);
      result.setCode(CommonResponse.SUCCESS.getCode());
      result.setMsg(CommonResponse.SUCCESS.getMsg());
   }
   
   private void setFailResult(SignUpResultDto result) {
      result.setSuccess(false);
      result.setCode(CommonResponse.FAIL.getCode());
      result.setMsg(CommonResponse.FAIL.getMsg());
   }
   
   public SignInResultDto signIn(String id, String password) throws RuntimeException {
      User user = userRepository.getByUid(id);
      
      if(!passwordEncoder.matches(password, user.getPassword())) {
         throw new RuntimeException();
      }
      
      SignInResultDto signInResultDto = SignInResultDto.builder()
            .token(jwtTokenProvider.createToken(user.getUid(), user.getRoles()))
            .build();
      
      setSuccessResult(signInResultDto);
      
      return signInResultDto;
   }
}