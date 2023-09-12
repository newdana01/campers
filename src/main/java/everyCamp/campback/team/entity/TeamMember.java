package everyCamp.campback.team.entity;

import everyCamp.campback.common.entity.BaseEntity;
import everyCamp.campback.common.entity.PreferRegion;
import everyCamp.campback.common.entity.PreferType;
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
import java.util.Set;

@Entity
@Table(name = "team_members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamMember{
    @Id
    @Column(name = "team_id")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String id;
    @ManyToOne
    private Team team;
    @ManyToOne
    private User user;
    @Column(name = "join_dt")
    @CreatedDate
    private LocalDateTime joinDt;
    @Column(name = "exit_dt_or_null")
    private LocalDateTime exitDtOrNull;

    @Builder
    protected TeamMember(
            Team team,
            User user,
            int recruitNumber
    ) {
        this.team = team;
        this.user = user;
    }

    public void exitTeam() {
        this.exitDtOrNull = LocalDateTime.now();
    }

    public void setTeam(Team team) {
        team.getTeamMembers().add(this);
        this.team = team;
    }
}
