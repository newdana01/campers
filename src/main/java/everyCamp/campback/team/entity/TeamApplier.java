package everyCamp.campback.team.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "team_appliers")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamApplier {
    @Id
    @Column(name = "team_id")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Column(name = "applied_dt")
    @CreatedDate
    private LocalDateTime appliedDt;

    @Builder
    protected TeamApplier(
            Team team,
            User user,
            int recruitNumber
    ) {
        this.team = team;
        this.user = user;
    }
}
