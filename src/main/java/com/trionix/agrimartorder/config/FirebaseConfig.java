package com.trionix.agrimartorder.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
public class FirebaseConfig {
    //get property value to firebase app
    @Value("${app.firebase-config}")
    private String firebaseConfig;

    /**
     * Initialize the firebase auth instance.
     *
     * @return The firebase auth instance
     * @throws IOException If there is an error occurred during fetching admin details
     */
    @Bean
    public FirebaseAuth firebaseInit() throws IOException {
        FirebaseApp firebaseApp = initFirebase();
        return FirebaseAuth.getInstance(firebaseApp);
    }

    @Bean
    public FirebaseApp initFirebase() throws IOException {
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(
                        GoogleCredentials.fromStream(
                                new ClassPathResource(firebaseConfig).getInputStream()
                        )
                ).build();
        FirebaseApp firebaseApp;
        if (FirebaseApp.getApps().isEmpty()) {
            firebaseApp = FirebaseApp.initializeApp(options);
        } else {
            firebaseApp = FirebaseApp.getInstance();
        }
        return firebaseApp;
    }
}
