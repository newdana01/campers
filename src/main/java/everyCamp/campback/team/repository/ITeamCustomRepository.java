package everyCamp.campback.team.repository;

import everyCamp.campback.team.entity.Team;

import java.util.List;

public interface ITeamCustomRepository {
    List<Team> findAllNotPostedTeams(String userId);

    Team findTeamJoinedUser(String teamId);
}
