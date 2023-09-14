package everyCamp.campback.team.service;

import everyCamp.campback.team.dto.TeamCreateDto;
import everyCamp.campback.team.dto.TeamResponse;
import everyCamp.campback.team.dto.TeamUpdateDto;
import everyCamp.campback.team.entity.Team;
import everyCamp.campback.team.entity.User;
import everyCamp.campback.team.repository.TeamRepository;
import everyCamp.campback.team.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamServiceImpl implements ITeamService{
    private final TeamRepository teamRepository;
    private final IUserRepository userRepository;

    @Override
    @Transactional
    public String createTeam(TeamCreateDto createTeam) {
        User leader = userRepository.findById(createTeam.getUserId()).orElseThrow(IllegalArgumentException::new);
        Team team = Team.builder()
                .name(createTeam.getTeamName())
                .recruitNumber(createTeam.getRecruitNumber())
                .preferTypes(createTeam.getPreferTypes())
                .preferRegions(createTeam.getPreferRegions())
                .leader(leader)
                .build();

        teamRepository.save(team);
        return team.getId();
    }

    @Override
    public TeamResponse findTeam(String teamId) {
        Team team = teamRepository.findById(teamId).get();
        TeamResponse res = TeamResponse.from(team);
        return res;
    }

    @Override
    @Transactional
    public String updateTeam(String teamId, TeamUpdateDto updateTeam) {
        Team team = teamRepository.findById(teamId).orElseThrow(IllegalArgumentException::new);
        team.updateTeam(
                updateTeam.getTeamName(),
                updateTeam.getIntro(),
                updateTeam.getRecruitNumber(),
                updateTeam.getPreferRegions(),
                updateTeam.getPreferTypes()
        );
        return teamId;
    }

    @Override
    @Transactional
    public void deleteTeam(String teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(IllegalArgumentException::new);
        team.deleteTeam();
    }

    @Override
    public List<TeamResponse> findTemporaryTeamList(String userId) {
        List<Team> notPostedTeams = teamRepository.findAllNotPostedTeams(userId);
        return notPostedTeams.stream().map(TeamResponse::from).toList();
    }

}
