package com.jwd_admission.byokrut.commandController;

import com.jwd_admission.byokrut.database.dao.UserDao;
import com.jwd_admission.byokrut.database.dao.impl.UserDaoImpl;
import com.jwd_admission.byokrut.entity.User;

import javax.servlet.http.HttpSession;

import static com.jwd_admission.byokrut.commandController.ServiceDestination.*;

public class UserLoginCommand implements Command{
    UserDaoImpl userDao=new UserDaoImpl();


    public static final CommandResponsr COMMAND_RESPONSR=new CommandResponsr() {
        @Override
        public boolean isRedirect(){return false;}
        @Override
        public Destination getDestination() {
            return MAIN_PAGE;
        }

    };

    @Override
    public CommandResponsr execute(CommandRequest request) {
        //String login=(String) request.getRequestParameter("login");
        //String password=(String)request.getRequestParameter("password");
        System.out.println(" lll in logusercom");
//        User user= new User();
//        user.setLogin(login);
//        user.setPassword(password);
//        if(userDao.findUserByLoginAndPassword(user)!=-1) {
//            user.setRoleId(userDao.findUserRoleId(user));
//            final HttpSession session = request.createSession();
//            session.setAttribute("username", user.getFirstName());
//            session.setAttribute("role",user.getRoleId());
//        }
//        else {
//            //RequestDispatcher dispatcher=request.getRequestDispatcher("/error");
//            //dispatcher.forward(request,response);
//        }
        final HttpSession session = request.createSession();
           session.setAttribute("username", "username");
           session.setAttribute("role", 1);
        return COMMAND_RESPONSR;
    }
}
