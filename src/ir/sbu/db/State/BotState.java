package ir.sbu.db.State;

import org.telegram.telegrambots.api.objects.Update;

public interface BotState
{
    public void validate(Update update);
    public void changeState(String state);
    public void response(String message, String keyboardMessage);
}