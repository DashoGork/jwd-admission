package com.jwd_admission.byokrut.commandController;

import com.jwd_admission.byokrut.database.dao.impl.InformationDaoImpl;
import com.jwd_admission.byokrut.database.dao.impl.RequestDaoImpl;
import com.jwd_admission.byokrut.database.dao.impl.UserDaoImpl;
import com.jwd_admission.byokrut.entity.Request;
import com.jwd_admission.byokrut.entity.User;

import javax.servlet.http.HttpSession;

import static com.jwd_admission.byokrut.commandController.ServiceDestination.PERSONAL_ACCOUNT_PAGE;

public class ShowPersonalAccountCommand implements Command{
    private UserDaoImpl userDao = new UserDaoImpl();
    private RequestDaoImpl requestDao=new RequestDaoImpl();
    private InformationDaoImpl informationDao=new InformationDaoImpl();


    public static final CommandResponse COMMAND_RESPONSE = new CommandResponse() {
        @Override
        public boolean isRedirect() {
            return false;
        }

        @Override
        public Destination getDestination() {
            return PERSONAL_ACCOUNT_PAGE;
        }

    };

    @Override
    public CommandResponse execute(CommandRequest request) {
        HttpSession session=request.createSession();
        User user =new User();
        user.setRoleId(Integer.parseInt(String.valueOf(session.getAttribute("role"))));
        user.setLogin(session.getAttribute("login").toString());
        user.setId(userDao.findUserId(user));

        User.copyAllNotNullFields(user,userDao.findEntityById(user.getId()));
        User.copyAllNotNullFields(user,informationDao.findEntityById(user.getInfId()));

        Request userRequest=requestDao.findRequestByUser(user);

        session.setAttribute("user",user);
        session.setAttribute("req",userRequest);
        return COMMAND_RESPONSE;
    }
}
