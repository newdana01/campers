package everyCamp.campback.team.repository;

import everyCamp.campback.team.entity.Team;
import everyCamp.campback.team.entity.TeamMember;
import everyCamp.campback.team.entity.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class TeamMemberRepositoryTest {
    @Autowired
    private TeamMemberRepository teamMemberRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("user 테이블과 조인하여 teamMember를 가져온다")
    void findTeamMembersTest() {
        //given
        Team team = Team.builder().name("team1").build();
        User user = User.builder().name("user1").nickname("nickname").profileImageUrl("http://").build();
        TeamMember teamMember = TeamMember.builder().user(user).build();
        teamMember.setTeam(team);
        entityManager.persist(team);
        entityManager.persist(user);
        entityManager.persist(teamMember);
        List<Team> teams = entityManager.createQuery("select t from Team t", Team.class).getResultList();
        Team getTeam = teams.get(0);

        // when
        List<TeamMember> teamMembers = teamMemberRepository.findTeamMembers(getTeam.getId());
        TeamMember getMember = teamMembers.get(0);

        //then
        assertThat(teamMembers.size()).isEqualTo(1);
        assertThat(getMember.getTeam().getName()).isEqualTo("team1");
        assertThat(getMember.getUser().getName()).isEqualTo("user1");
    }
}
