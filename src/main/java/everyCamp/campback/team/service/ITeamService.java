package everyCamp.campback.team.service;

import everyCamp.campback.team.dto.TeamCreateDto;
import everyCamp.campback.team.dto.TeamResponse;
import everyCamp.campback.team.dto.TeamUpdateDto;
import org.springframework.stereotype.Service;

public interface ITeamService {
    String createTeam(TeamCreateDto team);
    TeamResponse findTeam(String teamId);

    TeamResponse updateTeam(TeamUpdateDto team);

    void deleteTeam(String teamId);
}
