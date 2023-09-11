package everyCamp.campback.team.entity;

import everyCamp.campback.common.entity.BaseEntity;
import everyCamp.campback.common.entity.PreferRegion;
import everyCamp.campback.common.entity.PreferType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teams")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team extends BaseEntity {
    @Id @Column(name = "team_id")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User leader;
    private String name;
    private int recruitNumber;
    @Column(name = "deleted_dt_or_null")
    private LocalDateTime deletedDtOrNull;
    @ManyToMany
    private List<PreferType> preferTypes;
    @ManyToMany
    private List<PreferRegion> preferRegions;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<TeamMember> teamMembers;
    private String intro;

    @Builder
    protected Team(
            String name,
            User leader,
            int recruitNumber,
            List<PreferType> preferTypes,
            List<PreferRegion> preferRegions,
            List<TeamMember> teamMembers
            ) {
        this.name = name;
        this.leader = leader;
        this.recruitNumber = recruitNumber;
        this.preferTypes = preferTypes;
        this.preferRegions = preferRegions;
        this.teamMembers = teamMembers;
    }

    public void addPreferType(PreferType preferType) {
        this.preferTypes.add(preferType);
    }

    public void addPreferRegion(PreferRegion preferRegion) {
        this.preferRegions.add(preferRegion);
    }

    public void deleteTeam() {
        this.deletedDtOrNull = LocalDateTime.now();
    }

    public void addTeamMember(TeamMember teamMember) {
        teamMembers.add(teamMember);
    }
}
