package everyCamp.campback.team.dto;

import everyCamp.campback.common.entity.PreferType;
import everyCamp.campback.team.entity.Team;
import everyCamp.campback.team.entity.TeamMember;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Builder
public class TeamMemberResponse {
    private String userId;
    private String userName;
    private String userNickname;
    private String userProfileImageUrl;
    private Set<PreferType> preferTypes;
    private LocalDateTime joinDt;
    private LocalDateTime appliedDt;

    public static TeamMemberResponse from(TeamMember teamMember) {
        return TeamMemberResponse.builder()
                .userId(teamMember.getUser().getName())
                .userNickname(teamMember.getUser().getNickname())
                .joinDt(teamMember.getJoinDtOrNull())
                .build();
    }
}
