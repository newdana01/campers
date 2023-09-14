package everyCamp.campback.team.repository;

import everyCamp.campback.team.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, String>, ITeamMemberCustomRepository{
}
