package everyCamp.campback.chat.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatMessage {
    private String userId;
    private String teamId;
    private String message;
}
