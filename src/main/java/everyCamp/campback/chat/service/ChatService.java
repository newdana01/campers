package everyCamp.campback.chat.service;

import everyCamp.campback.chat.dto.ChatMessage;
import everyCamp.campback.chat.dto.ChatResponse;

import java.util.List;

public interface ChatService {
    public void createMessage(ChatMessage message);
    public List<ChatResponse> getMessages(String teamId);
}
