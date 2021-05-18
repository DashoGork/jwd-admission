package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.dao.impl.InformationDaoImpl;
import com.jwd_admission.byokrut.dao.impl.RequestDaoImpl;
import com.jwd_admission.byokrut.dao.impl.UserDaoImpl;
import com.jwd_admission.byokrut.entity.Request;
import com.jwd_admission.byokrut.entity.User;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;

public class AdminCalculateCommand implements Command {
    InformationDaoImpl informationDao = new InformationDaoImpl();
    UserDaoImpl userDao = new UserDaoImpl();
    RequestDaoImpl requestDao = new RequestDaoImpl();

    public static final CommandResponse COMMAND_RESPONSE = new CommandResponse() {
        @Override
        public boolean isRedirect() {
            return false;
        }

        @Override
        public Destination getDestination() {
            return MAIN_PAGE;
        }

    };

    @Override
    public CommandResponse execute(CommandRequest request) {
        String pathname = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\java\\output\\passed.ser";
        List<Request> requestList = requestDao.findAllPassedInAllFacultets();
        List<User> userList = new ArrayList<>();
        for (Request userRequest : requestList) {
            User user = userDao.findEntityById(userRequest.getUserId());
            User.copyAllNotNullFields(user, informationDao.findEntityById(user.getInfId()));
            userList.add(user);
        }

        File output = new File(pathname);
        try (FileOutputStream outputStream = new FileOutputStream(output);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            if (!output.exists()) {
                output.createNewFile();
            }
            objectOutputStream.writeObject(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final HttpSession session = request.createSession();
        session.setAttribute("listOfPassed", userList);
        return COMMAND_RESPONSE;
    }
}
