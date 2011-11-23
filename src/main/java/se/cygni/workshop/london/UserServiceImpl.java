package se.cygni.workshop.london;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(int userId) {
        return userRepository.getUserById(userId);
    }
}
