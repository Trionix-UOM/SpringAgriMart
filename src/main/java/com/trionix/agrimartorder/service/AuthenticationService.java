package com.trionix.agrimartorder.service;

import com.google.firebase.auth.FirebaseAuthException;
import com.trionix.agrimartorder.dto.SignupDto;
import com.trionix.agrimartorder.security.UserPrincipal;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    UserPrincipal validateToken(String idToken) throws FirebaseAuthException;

    String register(SignupDto signupDto);

}
