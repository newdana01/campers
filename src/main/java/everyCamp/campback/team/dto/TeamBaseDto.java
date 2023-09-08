package everyCamp.campback.team.dto;

import everyCamp.campback.common.entity.PreferRegion;
import everyCamp.campback.common.entity.PreferType;

import java.util.ArrayList;
import java.util.List;

public abstract class TeamBaseDto {
    private String name;
    private int recruitNumber;
    private List<PreferRegion> preferRegions = new ArrayList<>();
    private List<PreferType> preferTypes = new ArrayList<>();
}
