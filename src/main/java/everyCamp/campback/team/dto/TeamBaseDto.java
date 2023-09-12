package everyCamp.campback.team.dto;

import everyCamp.campback.common.entity.PreferRegion;
import everyCamp.campback.common.entity.PreferType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuperBuilder
@Getter
@NoArgsConstructor
public abstract class TeamBaseDto {
    private String teamName;
    private int recruitNumber;
    @Builder.Default
    private Set<PreferRegion> preferRegions = new HashSet<>();
    @Builder.Default
    private Set<PreferType> preferTypes = new HashSet<>();
}
