package everyCamp.campback.team.service;

import everyCamp.campback.team.dto.TeamMemberResponse;

import java.util.List;

public interface ITeamMemberService {
    List<TeamMemberResponse> findAllMembers(String teamId);

    void dropMember(String teamId, String userId);
}
