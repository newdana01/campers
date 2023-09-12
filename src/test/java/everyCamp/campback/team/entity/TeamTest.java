package everyCamp.campback.team.entity;

import everyCamp.campback.common.entity.PreferRegion;
import everyCamp.campback.common.entity.PreferType;
import everyCamp.campback.team.dto.TeamUpdateDto;
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
        PreferRegion p = team.getPreferRegions().toArray(new PreferRegion[1])[0];
        assertThat(team.getPreferRegions().size()).isEqualTo(1);
        assertThat(p.getName()).isEqualTo("서울");
    }

    @Test
    @DisplayName("선호유형을 추가한다")
    void addPreferTypeTest() {
        Team team = Team.builder().name("team").build();
        PreferType preferType = PreferType.builder().name("글램핑").build();
        team.addPreferType(preferType);
        PreferType p = team.getPreferTypes().toArray(new PreferType[1])[0];
        assertThat(team.getPreferTypes().size()).isEqualTo(1);
        assertThat(p.getName()).isEqualTo("글램핑");
    }

    @Test
    @DisplayName("팀을 수정한다")
    void updateTeamTest() {
        // given
        Team team = Team.builder().name("team").intro("hello").build();
        TeamUpdateDto updateTeam = TeamUpdateDto.builder().teamName("myTeam").recruitNumber(4).build();
        //when
        team.updateTeam(
                updateTeam.getTeamName(),
                updateTeam.getIntro(),
                updateTeam.getRecruitNumber(),
                updateTeam.getPreferRegions(),
                updateTeam.getPreferTypes()
        );
        //then
        assertThat(team.getName()).isEqualTo("myTeam");
        assertThat(team.getRecruitNumber()).isEqualTo(4);
        assertThat(team.getIntro()).isEqualTo("hello");
    }
}
