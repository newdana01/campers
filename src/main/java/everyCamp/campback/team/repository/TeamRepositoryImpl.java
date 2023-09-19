package everyCamp.campback.team.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import everyCamp.campback.team.entity.Team;
import everyCamp.campback.team.entity.TeamMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static everyCamp.campback.team.entity.QTeam.*;

@Repository
@RequiredArgsConstructor
public class TeamRepositoryImpl implements ITeamCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;
    private final TeamMemberRepository teamMemberRepository;

    @Override
    public List<Team> findAllNotPostedTeams(String userId) {
        return jpaQueryFactory
                .selectFrom(team)
                .where(team.leader.id.eq(userId).and(team.isPosted.isFalse()))
                .fetch();
    }

    @Override
    public Team findTeamJoinedUser(String teamId) {
        Team res = jpaQueryFactory
                .selectFrom(team)
                .leftJoin(team.leader).fetchJoin()
                .leftJoin(team.preferRegions).fetchJoin()
                .leftJoin(team.preferTypes).fetchJoin()
                .leftJoin(team.teamMembers).fetchJoin()
                .where(team.id.eq(teamId).and(team.deletedDtOrNull.isNull()))
                .where(team.isPosted.isTrue())
                .fetchOne();

        List<TeamMember> teamMembers = teamMemberRepository.findByTeamIdWithUser(teamId);
        teamMembers.forEach(tm -> res.addTeamMember(tm));
        return res;
    }
}
