package everyCamp.campback.team.entity;

import everyCamp.campback.common.entity.PreferRegion;
import everyCamp.campback.common.entity.PreferType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

public class TeamTest {
    @Test
    @DisplayName("팀을 삭제한다")
    void deleteTeamTest() {
        LocalDateTime now = LocalDateTime.now();
        Team team = Team.builder().name("team").build();
        team.deleteTeam();
        assertThat(team.getDeletedDtOrNull()).isNotNull();
        assertThat(team.getDeletedDtOrNull()).isAfter(now);
    }

    @Test
    @DisplayName("선호지역을 추가한다")
    void addPreferRegionTest() {
        Team team = Team.builder().name("team").build();
        PreferRegion preferRegion = PreferRegion.builder().name("서울").build();
        team.addPreferRegion(preferRegion);
        PreferRegion p = team.getPreferRegions().get(0);
        assertThat(team.getPreferRegions().size()).isEqualTo(1);
        assertThat(p.getName()).isEqualTo("서울");
    }

    @Test
    @DisplayName("선호유형을 추가한다")
    void addPreferTypeTest() {
        Team team = Team.builder().name("team").build();
        PreferType preferType = PreferType.builder().name("글램핑").build();
        team.addPreferType(preferType);
        PreferType p = team.getPreferTypes().get(0);
        assertThat(team.getPreferTypes().size()).isEqualTo(1);
        assertThat(p.getName()).isEqualTo("글램핑");
    }
}
