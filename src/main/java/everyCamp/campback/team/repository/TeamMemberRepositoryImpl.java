package everyCamp.campback.team.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import everyCamp.campback.team.entity.TeamMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static everyCamp.campback.team.entity.QTeamMember.teamMember;

@Repository
@RequiredArgsConstructor
public class TeamMemberRepositoryImpl implements ITeamMemberCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<TeamMember> findTeamMembers(String teamId) {
        return jpaQueryFactory
                .selectFrom(teamMember)
                .leftJoin(teamMember.user).fetchJoin()
                .where(teamMember.team.id.eq(teamId))
                .fetch();
    }

    @Override
    public TeamMember findOneByTeamIdUserId(String teamId, String userId) {
        return jpaQueryFactory
                .selectFrom(teamMember)
                .where(teamMember.team.id.eq(teamId)
                        .and(teamMember.user.id.eq(userId)))
                .fetchOne();
    }

    public List<TeamMember> findByTeamIdWithUser(String teamId) {
        return jpaQueryFactory.selectFrom(teamMember)
                .leftJoin(teamMember.user).fetchJoin()
                .leftJoin(teamMember.user.preferRegions).fetchJoin()
                .leftJoin(teamMember.user.preferTypes).fetchJoin()
                .where(teamMember.exitDtOrNull.isNull())
                .where(teamMember.team.id.eq(teamId))
                .fetch();
    }


}
