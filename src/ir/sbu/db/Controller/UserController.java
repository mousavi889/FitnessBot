package ir.sbu.db.Controller;

import ir.sbu.db.Model.User;
import ir.sbu.db.Model.UserModel;
import java.util.List;

public class UserController {
    public static Boolean add(){
        //get Data from view, or controller Caller, in this ex, view = MainController
        String username = "admin";
        String state = "123";
        String email = "diyardownload@gmail.com";
        //get Data from view, or controller Caller, in this ex, view = MainController


        UserModel userModel = new UserModel();
        userModel.setAliasName(username);
        userModel.setState(state);
        userModel.setEmail(email);

        Boolean result = User.insert(userModel);

        return result;
    }

    public static Boolean update(){
        //get Data from view, or controller Caller, in this ex, view = MainController
        String findUsername = "admin";
        String username = "admin2";
        String state = "1234";
        String email = "diyardownload2@gmail.com";
        //get Data from view, or controller Caller, in this ex, view = MainController

        UserModel userModel = new UserModel();
        userModel.setAliasName(username);
        userModel.setState(state);
        userModel.setEmail(email);

        Boolean result = User.update(userModel, findUsername);
        return result;
    }

    public static Boolean remove(){
        //get Data from view, or controller Caller, in this ex, view = MainController
        String findUsername = "admin2";
        //get Data from view, or controller Caller, in this ex, view = MainController


        Boolean result = User.remove(findUsername);
        return result;
    }


    public static void showAll(){
        List<UserModel> userModelList = User.getAll();


        //show data in view, in this ex, view = MainController
        for (UserModel usermodel : userModelList) {

            System.out.println("id: "+ usermodel.getId() + " | username: " + usermodel.getAliasName());
        }
        //show data in view, in this ex, view = MainController
    }

}
