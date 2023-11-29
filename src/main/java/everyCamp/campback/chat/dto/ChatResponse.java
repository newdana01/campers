package everyCamp.campback.chat.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ChatResponse {
    private String userId;
    private String teamId;
    private String message;
    private LocalDateTime createdDt;
}
