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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "team_members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class TeamMember{
    @Id
    @Column(name = "team_id")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "join_dt_or_null")
    private LocalDateTime joinDtOrNull;
    @Column(name = "applied_dt")
    @CreatedDate
    private LocalDateTime appliedDt;
    @Column(name = "exit_dt_or_null")
    private LocalDateTime exitDtOrNull;

    @Builder
    protected TeamMember(
            User user
    ) {
        this.user = user;
    }

    public void exitTeam() {
        this.exitDtOrNull = LocalDateTime.now();
    }

    public void setTeam(Team team) {
        team.getTeamMembers().add(this);
        this.team = team;
    }

    public void joinTeam() {this.joinDtOrNull = LocalDateTime.now();}
}
