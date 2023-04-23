package AdminPages;
import javax.swing.*;
import java.awt.*;

public class AdminHomeRunner extends JPanel {
    JLabel nameDetail, userDetail, positionDetail,phoneDetail, emailDetail;

    public AdminHomeRunner() {
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

// Set preferred size for the dashboardPanel
        dashboardPanel.setPreferredSize(new Dimension(300, 400));

// Set background color for panels
        name.setOpaque(false);
        user.setOpaque(false);
        position.setOpaque(false);
        phone.setOpaque(false);
        email.setOpaque(false);
        dashboardPanel.setOpaque(false);

// Set font styles for labels
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        nameDash.setFont(labelFont);
        userDash.setFont(labelFont);
        positionDash.setFont(labelFont);
        phoneDash.setFont(labelFont);
        emailDash.setFont(labelFont);

// Set font styles for detail labels
        Font detailFont = new Font("Arial", Font.PLAIN, 16);
        nameDetail.setFont(detailFont);
        userDetail.setFont(detailFont);
        positionDetail.setFont(detailFont);
        phoneDetail.setFont(detailFont);
        emailDetail.setFont(detailFont);

// Add the dashboardPanel to the container
        this.setBounds(0, 60, 700, 700);
        this.add(dashboardPanel);

// Set background color of the container to white
        setBackground(new Color(229, 190, 236));

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

