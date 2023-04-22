package FacilitatorPages;

import Reusable.TotalNumber;

import javax.swing.*;
import java.awt.*;

public class FacilitatorHomeRunner extends JPanel {
    JLabel nameDetail, userDetail, positionDetail,phoneDetail, emailDetail;
    public FacilitatorHomeRunner(){
        TotalNumber t = new TotalNumber();
        JPanel dashboardPanel = new JPanel();

        JPanel name = new JPanel();
        JPanel user = new JPanel();
        JPanel position = new JPanel();
        JPanel phone = new JPanel();
        JPanel email = new JPanel();

        JLabel nameDash = new JLabel("Name : ");
        JLabel userDash = new JLabel("Username : ");
        JLabel positionDash = new JLabel("Position : ");
        JLabel phoneDash = new JLabel("PhoneNo : ");
        JLabel emailDash = new JLabel("Email : ");

        nameDetail = new JLabel();
        userDetail = new JLabel();
        positionDetail = new JLabel();
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
        dashboardPanel.add(phone);
        dashboardPanel.add(email);
        dashboardPanel.add(t);

        this.add(dashboardPanel, BorderLayout.CENTER);
        // Set background color of the container to white
        setBackground(new Color(229, 190, 236));

        //make the background transparent
        name.setOpaque(false);
        user.setOpaque(false);
        position.setOpaque(false);
        phone.setOpaque(false);
        email.setOpaque(false);
        dashboardPanel.setOpaque(false);

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
    public JLabel getPhoneDetail(){
        return phoneDetail;
    }
    public JLabel getEmailDetail(){
        return emailDetail;
    }
}
