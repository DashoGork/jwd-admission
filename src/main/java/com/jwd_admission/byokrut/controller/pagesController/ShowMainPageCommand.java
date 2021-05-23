package com.jwd_admission.byokrut.controller.pagesController;

import com.jwd_admission.byokrut.controller.Command;
import com.jwd_admission.byokrut.controller.CommandRequest;
import com.jwd_admission.byokrut.controller.CommandResponse;
import com.jwd_admission.byokrut.dao.impl.FacultyDaoImpl;
import com.jwd_admission.byokrut.entity.Faculty;
import com.jwd_admission.byokrut.entity.User;
import com.jwd_admission.byokrut.util.InputDeserializer;

import javax.servlet.http.HttpSession;

import java.util.List;

import static com.jwd_admission.byokrut.controller.ServiceDestination.MAIN_PAGE;

public class ShowMainPageCommand implements Command {
    private FacultyDaoImpl facultyDao = new FacultyDaoImpl();

    @Override
    public CommandResponse execute(CommandRequest request) {
        List<Faculty> faculties = facultyDao.findAll();
        String pathnameToMmfFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\java\\output\\passedMMF.ser";
        String pathnameToRfiktFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\java\\output\\passedRFIKT.ser";
        String pathnameToFmoFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\java\\output\\passedFMO.ser";
        String pathnameToBioFile = "C:\\Users\\Юзер\\Documents\\GitHub\\jwd-admission\\src\\main\\java\\output\\passedBio.ser";

        final HttpSession session = request.createSession();
        session.setAttribute("allFaculties", faculties);

        List<User> userListFromMmf = (List<User>) InputDeserializer.deserialize(pathnameToMmfFile);
        List<User> userListFromRfikt = (List<User>) InputDeserializer.deserialize(pathnameToRfiktFile);
        List<User> userListFromFmo = (List<User>) InputDeserializer.deserialize(pathnameToFmoFile);
        List<User> userListFromBio = (List<User>) InputDeserializer.deserialize(pathnameToBioFile);

        if (userListFromMmf!=null) {
            session.setAttribute("calculated", true);
            session.setAttribute("listOfPassedFromMMf", userListFromMmf);
            session.setAttribute("listOfPassedFromRfikt", userListFromRfikt);
            session.setAttribute("listOfPassedFromFmo", userListFromFmo);
            session.setAttribute("listOfPassedFromBio", userListFromBio);
        }
        return () -> MAIN_PAGE;
    }


}
