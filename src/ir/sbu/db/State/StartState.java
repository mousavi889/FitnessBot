package ir.sbu.db.State;

import ir.sbu.db.Controller.MainController;
import ir.sbu.db.Model.User;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class StartState implements BotState {

    private long chatId;
    MainController mainController;
    public StartState(MainController mainController, long chatId){
        this.chatId = chatId;
        this.mainController = mainController;
    }

    @Override
    public void validate(Update update) {
        if(update.getMessage().getText().equals("/start")){
            String message = "بر روی عضویت کلیک کنید";
            String keyboardMessage = "عضویت";
            this.changeState("start");
            this.response(message, keyboardMessage);
        }
    }

    @Override
    public void changeState(String state) {
        User user = new User();
        //save state register for user in database !
        user.updateState(this.chatId, state);
    }

    @Override
    public void response(String message, String keyboardMessage) {
        SendMessage sm = new SendMessage() // Create a message object object
                .setChatId(this.chatId)
                .setText(message);

        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add(keyboardMessage);
        keyboard.add(row);
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message

        sm.setReplyMarkup(keyboardMarkup);

        try {
            this.mainController.execute(sm);// Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
