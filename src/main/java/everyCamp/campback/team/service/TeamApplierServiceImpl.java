package everyCamp.campback.team.service;

import everyCamp.campback.team.entity.Team;
import everyCamp.campback.team.entity.TeamApplier;
import everyCamp.campback.team.entity.TeamMember;
import everyCamp.campback.team.entity.User;
import everyCamp.campback.team.repository.IUserRepository;
import everyCamp.campback.team.repository.TeamApplierRepository;
import everyCamp.campback.team.repository.TeamMemberRepository;
import everyCamp.campback.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamApplierServiceImpl implements ITeamApplierService{
    private final TeamApplierRepository teamApplierRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final IUserRepository userRepository;
    private final TeamRepository teamRepository;

    @Override
    @Transactional
    public void approveMember(String teamId, String userId, boolean approveOrDeny) {
        TeamApplier teamApplier = teamApplierRepository.findApplierByTeamIdUserId(teamId, userId);
        teamApplierRepository.delete(teamApplier);

        if (approveOrDeny){
            User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
            Team team = teamRepository.findById(teamId).orElseThrow(NoSuchElementException::new);
            TeamMember teamMember = TeamMember.builder().user(user).build();
            teamMember.setTeam(team);
            teamMemberRepository.save(teamMember);
        }
    }
}
