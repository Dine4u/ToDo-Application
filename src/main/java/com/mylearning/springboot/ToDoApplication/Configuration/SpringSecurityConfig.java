package com.mylearning.springboot.ToDoApplication.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfig {

    //In Production app, we use LDAP or Database for Users management
    //In this app, we use InMemoryUserDetailsManager for Users management

    @Bean
    public InMemoryUserDetailsManager getUsersManager(PasswordEncoder passwordEncoder){    //PasswordEncoder autowired with BCryptPasswordEncoder as BCryptPasswordEncoder is bean
        Function<String,String> passwordEncoderFunc= input -> passwordEncoder.encode(input);    //defines how BCryptPasswordEncoder needs to work like take every password and encode it as per above function
        UserDetails userDetail1= createUser(passwordEncoderFunc, "Dinesh","28111997", "ADMIN");

        UserDetails userDetail2= createUser(passwordEncoderFunc, "Naveen","28111997", "USER");

        return new InMemoryUserDetailsManager(userDetail1,userDetail2);
    }

    private UserDetails createUser(Function<String, String> passwordEncoderFunc, String userName, String password, String roles) {
        return User.builder().passwordEncoder(passwordEncoderFunc)
                .username(userName)
                .password(password)
                .roles(roles)
                .build();
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public Authentication getUserAuthenication(){   // not working since authentication returned is null, check on it
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication;
//    }

}
