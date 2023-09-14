package everyCamp.campback.team.service;

import everyCamp.campback.team.dto.TeamMemberResponse;
import everyCamp.campback.team.entity.TeamMember;
import everyCamp.campback.team.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamMemberServiceImpl implements ITeamMemberService{
    private final TeamMemberRepository teamMemberRepository;

    @Override
    public List<TeamMemberResponse> findAllMembers(String teamId) {
        List<TeamMember> teamMembers = teamMemberRepository.findTeamMembers(teamId);
        return teamMembers.stream().map(TeamMemberResponse::from).toList();
    }

    @Override
    @Transactional
    public void dropMember(String teamId, String userId) {
        TeamMember teamMember = teamMemberRepository.findOneByTeamIdUserId(teamId, userId);
        teamMember.exitTeam();
    }
}
