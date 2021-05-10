package next.race.app.nextrace.service;

import next.race.app.nextrace.dto.UserRegistrationDto;
import next.race.app.nextrace.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
