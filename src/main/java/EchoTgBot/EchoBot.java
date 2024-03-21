package EchoTgBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashSet;
import java.util.Set;

public class EchoBot extends TelegramLongPollingBot {

    Set<String> ids;

    public EchoBot() {
        ids = new HashSet<>();
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        SendMessage sm = new SendMessage();

        ids.add(msg.getFrom().getId().toString());

        for (String id : ids) {
            if (!id.equals(msg.getFrom().getId().toString())) {
                sm.setText("user: `" + msg.getFrom().getFirstName() + "`\nusername: @" + msg.getFrom().getUserName() + "\nid: `" + msg.getFrom().getId() + "`\n ```" + msg.getText() + "```");
                sm.setChatId(id);
                sm.enableMarkdown(true);
            }
        }

        System.out.println(msg.getFrom().getFirstName() + " - " + msg.getText());
//
//        sm.setText(msg.getText());
//        sm.setChatId(msg.getChatId());

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "kursphpbot";
    }

    @Override
    public String getBotToken() {
        return "2144861992:AAExMQc1Qd-xu4b-HUpRhrckZeuvVoYgBxQ";
    }
}
