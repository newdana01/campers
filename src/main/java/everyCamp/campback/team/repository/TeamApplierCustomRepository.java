package everyCamp.campback.team.repository;

import everyCamp.campback.team.entity.TeamApplier;

public interface TeamApplierCustomRepository {
    TeamApplier findApplierByTeamIdUserId(String teamId, String userId);
}
