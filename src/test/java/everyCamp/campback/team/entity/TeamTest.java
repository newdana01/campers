package everyCamp.campback.team.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TeamTest {
    @Test
    @DisplayName("팀을 삭제한다")
    void deleteTeamTest() {
        LocalDateTime now = LocalDateTime.now();
        Team team = Team.builder().name("team").build();
        team.deleteTeam();
        Assertions.assertThat(team.getDeletedDtOrNull()).isNotNull();
        Assertions.assertThat(team.getDeletedDtOrNull()).isAfter(now);
    }
}
