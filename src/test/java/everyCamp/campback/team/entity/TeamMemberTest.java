package everyCamp.campback.team.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TeamMemberTest {
    @Test
    @DisplayName("팀을 추가한다")
    void exitTeamTest() {
        //given
        Team team = Team.builder().name("team1").build();
        TeamMember teamMember = TeamMember.builder().build();
        //when
        teamMember.setTeam(team);
        //then
        assertThat(team.getTeamMembers().size()).isEqualTo(1);
        assertThat(teamMember.getTeam().getName()).isEqualTo("team1");
        assertThat(team.getTeamMembers().toArray(new TeamMember[1])[0].getId()).isEqualTo(teamMember.getId());
    }
}
