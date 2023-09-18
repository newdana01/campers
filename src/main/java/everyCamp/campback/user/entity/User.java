package everyCamp.campback.user.entity;

import everyCamp.campback.common.entity.PreferRegion;
import everyCamp.campback.common.entity.PreferType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String id;
    private String name;
    private String nickname;
    private String profileImageUrl;
    private String email;
    private String password;
    private String sex;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToMany
    private Set<PreferRegion> preferRegions;
    @ManyToMany
    private Set<PreferType> preferTypes;
    @Column(columnDefinition = "TEXT")
    private String intro;
    @CreatedDate
    @Column(name = "created_dt")
    private LocalDateTime createdDt;
    @LastModifiedDate
    @Column(name = "updated_dt")
    private LocalDateTime updatedDt;
    @Column(name = "deleted_or_null")
    private LocalDateTime deletedDtOrNull;
}

