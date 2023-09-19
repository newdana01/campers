package everyCamp.campback.team.repository;

import everyCamp.campback.team.entity.TeamMember;

import java.util.List;

public interface ITeamMemberCustomRepository {
    List<TeamMember> findTeamMembers(String teamId);

    TeamMember findOneByTeamIdUserId(String teamId, String userId);

    List<TeamMember> findByTeamIdWithUser(String teamId);
}
