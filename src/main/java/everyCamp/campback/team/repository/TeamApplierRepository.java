package everyCamp.campback.team.repository;

import everyCamp.campback.team.entity.TeamApplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamApplierRepository extends JpaRepository<TeamApplier, String>, TeamApplierCustomRepository {
}
