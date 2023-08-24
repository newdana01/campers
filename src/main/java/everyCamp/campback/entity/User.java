package everyCamp.campback.entity;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id @Column(name = "user_id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String id;

    private String email;
    @Column(name = "profile_image_url")
    private String profileImageUrl;
    private String nickname;
    private String sex;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String intro;
    @Column(name = "created_dt")
    private LocalDateTime createdDate;
    @Column(name = "updated_dt")
    private LocalDateTime updatedDate;
    @Column(name = "deleted_dt_or_null")
    private LocalDateTime deletedDateOrNull;

    @Column(name = "prefer_type")
    @Type(ListArrayType.class)
    private List<PreferType> preferTypeList = new ArrayList<>();
    @Column(name = "prefer_region")
    @Type(ListArrayType.class)
    private List<PreferRegion> preferRegionList = new ArrayList<>();
}
