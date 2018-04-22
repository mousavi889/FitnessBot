package ir.sbu.db.Controller;

import ir.sbu.db.Model.User;
import ir.sbu.db.Model.UserModel;
import ir.sbu.db.State.*;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class MainController extends TelegramLongPollingBot
{
    boolean debug = true;
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            String message = update.getMessage().getText().toString();

            User user = new User();
            if (!user.isExist("id", chat_id)) {
                UserModel userModel = new UserModel();
                userModel.setId(chat_id);
                userModel.setState("null");
                user.insert(userModel);
            }

            String userState = user.getState(chat_id);

            if(debug) {
                System.out.println("user state: " + userState);
                System.out.println("user message: " + message);
            }

            switch (userState)
            {
                case "null":
                    if (message.equals("/start"))
                    {
                        StartState startState = new StartState(this, chat_id);
                        startState.validate(update);
                    }
                    break;
                case "start":
                    if (message.equals("عضویت"))
                    {
                        Q1State q1State = new Q1State(this, chat_id);
                        q1State.validate(update);
                    }
                    break;
                case "q1":
                    if (message.equals("زن") || message.equals("مرد"))
                    {
                        Q2State q2State = new Q2State(this, chat_id);
                        q2State.validate(update);
                    }
                    break;
                case "q2":
                    if (message.matches("-?\\d+(\\.\\d+)?"))
                    {
                        Q3State q3State = new Q3State(this, chat_id);
                        q3State.validate(update);
                    }
                    break;
                case "q3":
                    if (message.matches("-?\\d+(\\.\\d+)?"))
                    {
                        Q4State q4State = new Q4State(this, chat_id);
                        q4State.validate(update);
                    }
                    break;
                case "q4":
                    if (message.matches("-?\\d+(\\.\\d+)?"))
                    {
                        Q5State q5State = new Q5State(this, chat_id);
                        q5State.validate(update);
                    }
                    break;
                case "q5":
                    if (true)
                    {
                        RequestState requestState = new RequestState(this, chat_id);
                        requestState.validate(update);
                    }
                    break;
                case "request":
                    if (message.equals("برنامه غذایی"))
                    {
                        FoodPlanState foodPlanState = new FoodPlanState(this, chat_id);
                        foodPlanState.validate(update);
                    }
                    else if (message.equals("برنامه ورزشی در خانه"))
                    {
                        WorkoutPlanState workoutPlanState = new WorkoutPlanState(this, chat_id);
                        workoutPlanState.validate(update);
                    }
                    else if (message.equals("نکات سلامتی"))
                    {
                        HealthTipsState healthTipsState = new HealthTipsState(this, chat_id);
                        healthTipsState.validate(update);
                    }
                    else if (message.equals("برنامه ورزشی در باشگاه"))
                    {
                        GymPlanState gymPlanState = new GymPlanState(this, chat_id);
                        gymPlanState.validate(update);
                    }
                    break;
                case "foodPlan":
                    if (message.equals("اوکی"))
                    {
                        RequestState requestState = new RequestState(this, chat_id);
                        requestState.validate(update);
                    }
                    break;
                case "gymPlan":
                    if (message.equals("اوکی"))
                    {
                        RequestState requestState = new RequestState(this, chat_id);
                        requestState.validate(update);
                    }
                    break;
                case "workoutPlan":
                    if (message.equals("اوکی"))
                    {
                        RequestState requestState = new RequestState(this, chat_id);
                        requestState.validate(update);
                    }
                    break;
                case "healthTipsPlan":
                    if (message.equals("اوکی"))
                    {
                        RequestState requestState = new RequestState(this, chat_id);
                        requestState.validate(update);
                    }
                    break;


            }
        }
    }

    @Override
    public String getBotUsername()
    {
        // Return bot username
        // If bot username is @MainController, it must return 'MainController'
        return "DBLAB_Fitness_Bot";
    }

    @Override
    public String getBotToken()
    {
        // Return bot token from BotFather
        return "552909310:AAFnbtggLUWU9uhd0NfOLuPRbbwuDjLRuIY";
    }
}
