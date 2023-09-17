package com.javaguide.springsecurityjwtguide;


import com.javaguide.springsecurityjwtguide.system.entity.Role;
import com.javaguide.springsecurityjwtguide.system.entity.User;
import com.javaguide.springsecurityjwtguide.system.entity.UserRole;
import com.javaguide.springsecurityjwtguide.system.enums.RoleType;
import com.javaguide.springsecurityjwtguide.system.repository.RoleRepository;
import com.javaguide.springsecurityjwtguide.system.repository.UserRepository;
import com.javaguide.springsecurityjwtguide.system.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityJwtGuideApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public static void main(String args[]){
        SpringApplication.run(SpringSecurityJwtGuideApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (RoleType roleType : RoleType.values()) {
            roleRepository.save(new Role(roleType.getName(), roleType.getDescription()));
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = User.builder().enabled(true).fullName("admin").userName("root").password(bCryptPasswordEncoder.encode("root")).build();
        userRepository.save(user);
        Role role = roleRepository.findByName(RoleType.ADMIN.getName()).get();
        userRoleRepository.save(new UserRole(user, role));
    }
}
