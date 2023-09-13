package everyCamp.campback.team.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import everyCamp.campback.team.entity.QTeam;
import everyCamp.campback.team.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static everyCamp.campback.team.entity.QTeam.*;

@Repository
@RequiredArgsConstructor
public class TeamRepositoryImpl implements ITeamCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Team> findAllNotPostedTeams(String userId) {
        return jpaQueryFactory
                .selectFrom(team)
                .where(team.leader.id.eq(userId).and(team.isPosted.isFalse()))
                .fetch();
    }
}
