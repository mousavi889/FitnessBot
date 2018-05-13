package ir.sbu.db.State;

import ir.sbu.db.Controller.MainController;
import ir.sbu.db.Model.User;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class RequestState implements BotState
{

    private long chatId;
    MainController mainController;
    public RequestState(MainController mainController, long chatId)
    {
        this.chatId = chatId;
        this.mainController = mainController;
    }

    @Override
    public void validate(Update update)
    {
        if(update.getMessage().getText().length() < 40) {
            User user = new User();
            user.updateColumnBloodType(update.getMessage().getText(), chatId);
            long weight = user.getWeight(chatId);
            long height = user.getHeight(chatId);
            String gender = user.getGender(chatId);
            long bmi = weight * 10000 / height / height;
            long category;
            if (gender.equals("زن"))
            {
                if (bmi < 18)
                {
                    category = 1;
                }
                else if (bmi < 30)
                {
                    category = 2;
                }
                else
                {
                    category = 3;
                }
            }
            else
            {
                if (bmi < 18)
                {
                    category = 4;
                }
                else if (bmi < 30)
                {
                    category = 5;
                }
                else
                {
                    category = 6;
                }
            }
            user.updateColumnCategory(category, chatId);
            String message = "سرویس مورد نظر خود را انتخاب کنید.";
            String keyboardMessage = "برنامه غذایی,نکات سلامتی,برنامه ورزشی در خانه,برنامه ورزشی در باشگاه,بازگشت به صفحه اصلی";
            this.changeState("request");
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

        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList();
        // Create a keyboard row
        KeyboardRow row0 = new KeyboardRow(), row1 = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        System.out.println();
        String[] kmessages = keyboardMessage.split(",");
        for (int i = 0; i < kmessages.length / 2; i++)
        {
            row0.add(kmessages[i]);
        }
        for (int i = kmessages.length / 2; i < kmessages.length; i++)
        {
            row1.add(kmessages[i]);
        }
        keyboard.add(row0);
        keyboard.add(row1);
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