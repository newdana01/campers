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
    @JoinColumn(name = "leader_id")
    private User leader;
    private String name;
    private int recruitNumber;
    @Column(name = "deleted_dt_or_null")
    private LocalDateTime deletedDtOrNull;
    @ManyToMany
    private Set<PreferType> preferTypes;
    @ManyToMany
    private Set<PreferRegion> preferRegions;

    @Builder
    protected Team(
            String name,
            User leader,
            int recruitNumber,
            Set<PreferType> preferTypes,
            Set<PreferRegion> preferRegions) {
        this.name = name;
        this.leader = leader;
        this.recruitNumber = recruitNumber;
        this.preferTypes = preferTypes;
        this.preferRegions = preferRegions;
    }

    public void addPreferType(PreferType preferType) {
        this.preferTypes.add(preferType);
    }
}
