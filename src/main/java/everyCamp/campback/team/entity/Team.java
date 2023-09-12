package everyCamp.campback.team.entity;

import everyCamp.campback.common.entity.BaseEntity;
import everyCamp.campback.common.entity.PreferRegion;
import everyCamp.campback.common.entity.PreferType;
import everyCamp.campback.team.dto.TeamUpdateDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teams")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
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
    @Builder.Default
    private Set<PreferType> preferTypes = new HashSet<>();
    @ManyToMany
    @Builder.Default
    private Set<PreferRegion> preferRegions = new HashSet<>();
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<TeamMember> teamMembers = new HashSet<>();
    private String intro;
    @Column(name = "is_posted")
    private boolean isPosted;

    public void addPreferType(PreferType preferType) {
        this.preferTypes.add(preferType);
    }

    public void addPreferRegion(PreferRegion preferRegion) {
        this.preferRegions.add(preferRegion);
    }

    public void deleteTeam() {
        this.deletedDtOrNull = LocalDateTime.now();
    }

    public void updateTeam(TeamUpdateDto teamUpdateDto) {
        this.name = teamUpdateDto.getTeamName();
        this.intro = teamUpdateDto.getIntro();
        this.recruitNumber = teamUpdateDto.getRecruitNumber();
        teamUpdateDto.getPreferTypes().forEach(this::addPreferType);
        teamUpdateDto.getPreferRegions().forEach(this::addPreferRegion);
    }
}
