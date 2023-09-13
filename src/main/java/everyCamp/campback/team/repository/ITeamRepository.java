package everyCamp.campback.team.repository;

import everyCamp.campback.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, String>, ITeamCustomRepository{
}
