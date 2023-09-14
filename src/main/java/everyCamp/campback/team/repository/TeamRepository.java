package everyCamp.campback.team.repository;

import everyCamp.campback.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String>, ITeamCustomRepository{
}
