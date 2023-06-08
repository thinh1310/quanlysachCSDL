package nguyenhoangthinh.quanlysachCSDLlap3.services;
import nguyenhoangthinh.quanlysachCSDLlap3.entity.User;
import nguyenhoangthinh.quanlysachCSDLlap3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
            public void save(User user )
            {
                userRepository.save(user );
            }
}
