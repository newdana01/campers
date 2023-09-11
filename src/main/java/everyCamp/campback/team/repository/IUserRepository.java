package everyCamp.campback.team.repository;

import everyCamp.campback.team.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository  extends JpaRepository<User, String> {
}
