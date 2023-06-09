package nguyenhoangthinh.quanlysachCSDLlap3.services;
import nguyenhoangthinh.quanlysachCSDLlap3.entity.User;
import nguyenhoangthinh.quanlysachCSDLlap3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nguyenhoangthinh.quanlysachCSDLlap3.repository.IRoleRepository;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    public void save(User user){
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("USER");
        if(roleId!=0 && userId !=0){
            userRepository.addRoleToUser(userId, roleId);
        }
    }

}
