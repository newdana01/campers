package everyCamp.campback.team.service;

import everyCamp.campback.team.dto.TeamCreateDto;
import everyCamp.campback.team.dto.TeamResponse;
import everyCamp.campback.team.dto.TeamUpdateDto;
import everyCamp.campback.team.entity.Team;
import everyCamp.campback.team.entity.TeamMember;
import everyCamp.campback.team.repository.TeamMemberRepository;
import everyCamp.campback.user.entity.User;
import everyCamp.campback.team.repository.TeamRepository;
import everyCamp.campback.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamServiceImpl implements ITeamService{
    private final TeamRepository teamRepository;
    private final IUserRepository userRepository;
    private final TeamMemberRepository teamMemberRepository;

    @Override
    @Transactional
    public String createTeam(TeamCreateDto createTeam) {
        User leader = userRepository.findById(createTeam.getUserId()).orElseThrow(NoSuchElementException::new);
        Team team = Team.builder()
                .name(createTeam.getTeamName())
                .recruitNumber(createTeam.getRecruitNumber())
                .preferTypes(createTeam.getPreferTypes())
                .preferRegions(createTeam.getPreferRegions())
                .isPosted(createTeam.getIsPosted())
                .leader(leader)
                .build();
        TeamMember teamMember = TeamMember.builder().user(leader).build();
        teamMember.setTeam(team);
        teamRepository.save(team);
        teamMemberRepository.save(teamMember);
        return team.getId();
    }

    @Override
    public TeamResponse findTeam(String teamId) {
        Team team = teamRepository.findTeamJoinedUser(teamId);
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

    @Override
    @Transactional
    public void assignLeader(String teamId, String fromUserId, String toUserId) {
        Team team = teamRepository.findById(teamId).orElseThrow(NoSuchElementException::new);
        User substituteLeader = userRepository.findById(toUserId).orElseThrow(NoSuchElementException::new);

        if (team.getLeader().getId().equals(fromUserId)) {
            team.assignLeader(substituteLeader);
        }
    }
}
