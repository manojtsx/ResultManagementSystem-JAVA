package FacilitatorPages;

import Reusable.FacilitatorNavigationBar;

import javax.swing.*;
import java.awt.*;

public class FacilitatorHomeRunner extends JPanel {
    JLabel nameDetail, userDetail, positionDetail, classDetail,phoneDetail, emailDetail;
    public FacilitatorHomeRunner(){
        FacilitatorNavigationBar menu  = new FacilitatorNavigationBar();
        this.add(menu, BorderLayout.NORTH);
        JPanel dashboardPanel = new JPanel();

        JPanel name = new JPanel();
        JPanel user = new JPanel();
        JPanel position = new JPanel();
        JPanel classs = new JPanel();
        JPanel phone = new JPanel();
        JPanel email = new JPanel();

        JLabel nameDash = new JLabel("Name : ");
        JLabel userDash = new JLabel("Username : ");
        JLabel positionDash = new JLabel("Position : ");
        JLabel classDash = new JLabel("Class : ");
        JLabel phoneDash = new JLabel("PhoneNo : ");
        JLabel emailDash = new JLabel("Email : ");

        nameDetail = new JLabel();
        userDetail = new JLabel();
        positionDetail = new JLabel();
        classDetail = new JLabel();
        phoneDetail  =new JLabel();
        emailDetail = new JLabel();

        name.setLayout(new FlowLayout());
        name.add(nameDash);
        name.add(nameDetail);
        user.setLayout(new FlowLayout());
        user.add(userDash);
        user.add(userDetail);
        position.setLayout(new FlowLayout());
        position.add(positionDash);
        position.add(positionDetail);
        classs.setLayout(new FlowLayout());
        classs.add(classDash);
        classs.add(classDetail);
        phone.setLayout(new FlowLayout());
        phone.add(phoneDash);
        phone.add(phoneDetail);
        email.setLayout(new FlowLayout());
        email.add(emailDash);
        email.add(emailDetail);

        dashboardPanel.setLayout(new GridLayout(6, 1));
        dashboardPanel.add(name);
        dashboardPanel.add(user);
        dashboardPanel.add(position);
        dashboardPanel.add(classs);
        dashboardPanel.add(phone);
        dashboardPanel.add(email);

        this.add(dashboardPanel, BorderLayout.CENTER);
    }
    public JLabel getNameDetail() {
        return nameDetail;
    }
    public JLabel getUserDetail(){
        return userDetail;
    }
    public JLabel getPositionDetail(){
        return positionDetail;
    }
    public JLabel getClassDetail(){
        return  classDetail;
    }
    public JLabel getPhoneDetail(){
        return phoneDetail;
    }
    public JLabel getEmailDetail(){
        return emailDetail;
    }
}
