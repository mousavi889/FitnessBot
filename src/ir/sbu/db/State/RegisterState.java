package ir.sbu.db.State;

import ir.sbu.db.Controller.MainController;
import ir.sbu.db.Model.User;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class RegisterState implements BotState
{

    private long chatId;
    MainController mainController;
    public RegisterState(MainController mainController, long chatId)
    {
        this.chatId = chatId;
        this.mainController = mainController;
    }

    @Override
    public void validate(Update update)
    {
        if(update.getMessage().getText().length()<25)
        {
            String message = "نام خود را وارد کنید";
            String keyboardMessage = "";
            this.changeState("name");
            this.response(message, keyboardMessage);
        }
    }

    @Override
    public void changeState(String state)
    {
        User user = new User();
        //save state register for user in database !
        user.updateState(this.chatId, state);
    }

    @Override
    public void response(String message, String keyboardMessage) {
        SendMessage sm = new SendMessage() // Create a message object object
                .setChatId(this.chatId)
                .setText(message);

        ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();
        sm.setReplyMarkup(keyboardMarkup);

        try {
            this.mainController.execute(sm);// Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
