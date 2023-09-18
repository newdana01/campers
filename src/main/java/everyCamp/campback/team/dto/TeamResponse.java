package everyCamp.campback.team.dto;


import everyCamp.campback.team.entity.Team;
import everyCamp.campback.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@SuperBuilder
public class TeamResponse extends TeamBaseDto {
    private String teamId;
    private User leader;
    private String intro;
    private LocalDateTime createdDt;

    public static TeamResponse from(Team team) {
        return TeamResponse.builder()
                .teamId(team.getId())
                .teamName(team.getName())
                .recruitNumber(team.getRecruitNumber())
                .leader(team.getLeader())
                .preferTypes(team.getPreferTypes())
                .preferRegions(team.getPreferRegions())
                .intro(team.getIntro())
                .build();

    }

}
