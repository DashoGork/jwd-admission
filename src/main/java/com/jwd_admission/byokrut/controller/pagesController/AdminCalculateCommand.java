package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.controller.Destination;
import com.jwd_admission.byokrut.dao.impl.InformationDaoImpl;
import com.jwd_admission.byokrut.dao.impl.RequestDaoImpl;
import com.jwd_admission.byokrut.dao.impl.UserDaoImpl;
import com.jwd_admission.byokrut.entity.FacultyName;
import com.jwd_admission.byokrut.entity.Request;
import com.jwd_admission.byokrut.entity.User;
import com.jwd_admission.byokrut.util.OutputSerilizer;

import javax.servlet.http.HttpSession;
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

    private List<User> createUserListFromRequestList(List<Request> requestList){
        List<User> userList = new ArrayList<>();
        for (Request userRequest : requestList) {
            User user = userDao.findEntityById(userRequest.getUserId());
            User.copyAllNotNullFields(user, informationDao.findEntityById(user.getInfId()));
            userList.add(user);
        }
        return userList;
    }


    @Override
    public CommandResponse execute(CommandRequest request) {
        String pathnameToMmfFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\java\\output\\passedMMF.ser";
        String pathnameToRfiktFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\java\\output\\passedRFIKT.ser";
        String pathnameToFmoFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\java\\output\\passedFMO.ser";
        String pathnameToBioFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\java\\output\\passedBio.ser";

        List<User> userListFromMmf = createUserListFromRequestList(requestDao.findAllPassed(FacultyName.MMF));
        List<User> userListFromRfikt = createUserListFromRequestList(requestDao.findAllPassed(FacultyName.RFIKT));
        List<User> userListFromFmo = createUserListFromRequestList(requestDao.findAllPassed(FacultyName.FMO));
        List<User> userListFromBio = createUserListFromRequestList(requestDao.findAllPassed(FacultyName.BIO));

        OutputSerilizer.Serialize(userListFromMmf, pathnameToMmfFile);
        OutputSerilizer.Serialize(userListFromFmo, pathnameToFmoFile);
        OutputSerilizer.Serialize(userListFromRfikt, pathnameToRfiktFile);
        OutputSerilizer.Serialize(userListFromBio, pathnameToBioFile);

        final HttpSession session = request.createSession();
        session.setAttribute("listOfPassedFromMMf", userListFromMmf);
        session.setAttribute("listOfPassedFromRfikt", userListFromRfikt);
        session.setAttribute("listOfPassedFromFmo", userListFromFmo);
        session.setAttribute("listOfPassedFromBio", userListFromBio);

        return COMMAND_RESPONSE;
    }
}
