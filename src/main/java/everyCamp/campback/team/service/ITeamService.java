package everyCamp.campback.team.service;

import everyCamp.campback.team.dto.TeamCreateDto;
import everyCamp.campback.team.dto.TeamResponse;
import everyCamp.campback.team.dto.TeamUpdateDto;

import java.util.List;

public interface ITeamService {
    String createTeam(TeamCreateDto team);
    TeamResponse findTeam(String teamId);

    String updateTeam(String teamId, TeamUpdateDto team);

    void deleteTeam(String teamId);

    List<TeamResponse> findTemporaryTeamList(String userId);

    void assignLeader(String teamId, String fromUserId, String toUserId);
}
