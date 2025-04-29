package icet.edu.com.config;

import icet.edu.com.util.EmailCheck;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Config {

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
    @Bean
    public BCryptPasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public EmailCheck emailCheck(){
        return new EmailCheck();
    }

}
