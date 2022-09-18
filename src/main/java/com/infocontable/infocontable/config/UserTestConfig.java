//package com.infocontable.infocontable.config;
//
//import com.infocontable.infocontable.model.User;
//import com.infocontable.infocontable.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//
//@Configuration
//public class UserTestConfig {
//
//
//        @Bean
//        CommandLineRunner commandLineRunner(UserRepository repository){
//            return args -> {
//                User monkey = new User(
//                        "4",
//                        "user",
//                        "Monkey",
//                        "DLuffy",
//                        "Homecenter",
//                );
//
//                User portgas = new User(
//                        "Portgas",
//                        "portgasDace@gmail.com",
//                        LocalDate.of(2005, Month.FEBRUARY, 10)
//                );
//                repository.saveAll(List.of(monkey,portgas));
//            };
//        }
//    }
//}
