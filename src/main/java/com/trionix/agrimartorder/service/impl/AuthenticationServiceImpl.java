package com.trionix.agrimartorder.service.impl;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.trionix.agrimartorder.constant.Role;
import com.trionix.agrimartorder.dto.SignupDto;
import com.trionix.agrimartorder.entity.User;
import com.trionix.agrimartorder.repository.UserRepository;
import com.trionix.agrimartorder.security.UserPrincipal;
import com.trionix.agrimartorder.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final FirebaseAuth firebaseAuth;
    private final UserRepository userRepository;
    @Override
    public UserPrincipal validateToken(String idToken) throws FirebaseAuthException {
        FirebaseToken firebaseToken = firebaseAuth.verifyIdToken(idToken);
        String uid = firebaseToken.getUid();

        Optional<User> id = userRepository.findById(uid);

        if(id.isPresent()){
            User user = id.get();
            return getUserPrincipal(user);
        }else {
            throw new UsernameNotFoundException("Cannot find user");
        }
    }

    @Override
    public String register(SignupDto signupDto) {
        UserRecord userRecord = null;
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(signupDto.getEmail())
                    .setEmailVerified(true)
                    .setPassword(signupDto.getPassword())
                    .setDisplayName(signupDto.getFullName())
                    .setDisabled(false);

            userRecord = firebaseAuth.createUser(request);

            User user = new User(
                    userRecord.getUid(),
                    signupDto.getFullName(),
                    signupDto.getEmail(),
                    Role.USER,
                    signupDto.getPhoneNo(),
                    signupDto.getAddress(),
                    signupDto.getGender()
            );
            User save = userRepository.save(user);
            String customToken = firebaseAuth.createCustomToken(userRecord.getUid());
            return customToken;
        } catch (Exception e) {
            if(userRecord != null)
                userRepository.deleteById(userRecord.getUid());
            log.error(null, e);
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }


    public UserPrincipal getUserPrincipal(User user) {
        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setId(user.getId());
        userPrincipal.setEmail(user.getEmail());
        userPrincipal.setAuthorities(new ArrayList<>(Collections.singletonList(user.getRole())));
        return userPrincipal;
    }
}
