package everyCamp.campback.team.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import everyCamp.campback.team.entity.QTeamApplier;
import everyCamp.campback.team.entity.TeamApplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static everyCamp.campback.team.entity.QTeamApplier.teamApplier;

@Repository
@RequiredArgsConstructor
public class TeamApplierRepositoryImpl implements TeamApplierCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public TeamApplier findApplierByTeamIdUserId(String teamId, String userId) {
        return jpaQueryFactory.selectFrom(teamApplier)
                .where(teamApplier.team.id.eq(teamId).and(teamApplier.user.id.eq(userId)))
                .fetchOne();

    }

}
