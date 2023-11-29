package everyCamp.campback.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import everyCamp.campback.chat.dto.ChatMessage;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<ChatMessage> {
    @Override
    public ChatMessage decode(String s) throws DecodeException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(s, ChatMessage.class);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean willDecode(String s) {
        return true;
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
