package everyCamp.campback.chat.api;

import everyCamp.campback.chat.dto.ChatMessage;
import everyCamp.campback.chat.service.ChatService;
import everyCamp.campback.common.config.WebsocketConfig;
import everyCamp.campback.common.utils.MessageDecoder;
import everyCamp.campback.common.utils.MessageEncoder;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
@ServerEndpoint(
        value = "/chat",
        configurator = WebsocketConfig.class,
        encoders = {MessageEncoder.class},
        decoders = MessageDecoder.class
)
public class ChatSocketController {
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
    private final ChatService chatService;

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(session.toString());

        if (clients.contains(session)) {
            System.out.println("--Session is already connected--");
        } else {
            clients.add(session);
            System.out.println("--New Session--");
        }
    }

    @OnClose
    public void onClose(Session session) throws Exception {
        clients.remove(session);
        System.out.println("--Session Closed--");
    }

    @OnMessage
    public void onMessage(ChatMessage message, Session session) throws Exception {
        System.out.println("--Entered Message: " + message + "--");

        for (Session client : clients) {
            System.out.println("client: " + client.toString());
            System.out.printf("--Sent Message: " + message + "--");
            client.getBasicRemote().sendObject(message);
        }

        chatService.createMessage(message);
    }
}
