package everyCamp.campback.team.dto;


import everyCamp.campback.team.entity.Team;
import everyCamp.campback.team.entity.TeamMember;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
@SuperBuilder
public class TeamResponse extends TeamBaseDto {
    private String teamId;
    private String leaderId;
    private String intro;
    private LocalDateTime createdDt;
    private Set<TeamMemberResponse> members;

    public static TeamResponse from(Team team) {
        Set<TeamMemberResponse> memberRes = new HashSet<>();
        for (TeamMember teamMember : team.getTeamMembers()) {
            memberRes.add(TeamMemberResponse.from(teamMember));
        }

        return TeamResponse.builder()
                .teamId(team.getId())
                .teamName(team.getName())
                .recruitNumber(team.getRecruitNumber())
                .leaderId(team.getLeader().getId())
                .preferTypes(team.getPreferTypes())
                .preferRegions(team.getPreferRegions())
                .intro(team.getIntro())
                .createdDt(team.getCreatedDt())
                .members(memberRes)
                .build();
    }
}
