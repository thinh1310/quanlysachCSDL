package nguyenhoangthinh.quanlysachCSDLlap3.services;
import nguyenhoangthinh.quanlysachCSDLlap3.entity.CustomUserDetail;
import nguyenhoangthinh.quanlysachCSDLlap3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import nguyenhoangthinh.quanlysachCSDLlap3.repository.IUserRepository;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return new CustomUserDetail(user,userRepository);
    }
}
