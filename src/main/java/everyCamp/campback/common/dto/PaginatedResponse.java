package everyCamp.campback.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
@NoArgsConstructor
public class PaginatedResponse<T> {
    private Integer offset;
    private Integer limit;
    private List<T> data;
}
