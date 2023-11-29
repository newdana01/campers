package everyCamp.campback.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import everyCamp.campback.chat.dto.ChatMessage;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<ChatMessage>{
    @Override
    public String encode(ChatMessage resMessage) throws EncodeException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(resMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        Text.super.init(endpointConfig);
    }

    @Override
    public void destroy() {
        Text.super.destroy();
    }
}