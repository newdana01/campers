package everyCamp.campback.team.service;

import everyCamp.campback.team.dto.TeamMemberResponse;

import java.util.List;

public interface ITeamMemberService {
    List<TeamMemberResponse> findAllMembers();

    void dropMember(String userId);

    void assignLeader(String toUserId, String fromUserId);
}
