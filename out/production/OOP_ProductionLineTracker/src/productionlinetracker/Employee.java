package productionlinetracker;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Eployee class allows the user to create an employee account. @Author: Nickolas Gadomski */
public class Employee {
  /** Class level fields to be used throughout the code */
  StringBuilder name;

  String username;
  String password;
  String email;

  /**
   * Employee class constructor for local fields
   *
   * @param name local String name
   * @param password local String password
   */
  Employee(String name, String password) {
    StringBuilder sBName = new StringBuilder(name);
    StringBuilder defaultUsername = new StringBuilder("default");
    StringBuilder defaultEmail = new StringBuilder("user");
    this.name = sBName;
    this.password = password;
    if (checkName(sBName)) {
      setUsername(sBName);
      setEmail(sBName);
    } else {
      JFrame frame = new JFrame("");
      JOptionPane.showMessageDialog(
          frame.getContentPane(),
          "Input First name & Last name to create custom account\n" + "Default account is set.",
          "Default Username",
          JOptionPane.ERROR_MESSAGE);
      setUsername(defaultUsername);
      setEmail(defaultEmail);
    }
    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
      JFrame frame = new JFrame("");
      JOptionPane.showMessageDialog(
          frame.getContentPane(),
          "Password must contain Upper and Lower case letter & Special Character\n"
              + "Default password is set.",
          "Default Password",
          JOptionPane.ERROR_MESSAGE);
      setUsername(defaultUsername);
    }
    }

  /**
   * Method to check if the name entered by the user is valid.
   *
   * @param name local StringBuilder name
   * @return true
   */
  private boolean checkName(StringBuilder name) {
    String[] splitArray = name.toString().split(" ");
    return splitArray.length == 1 ? false : true;
  }

  /**
   * Method to set the username from the entered name by the user
   *
   * @param name local StringBuilder name
   */
  private void setUsername(StringBuilder name) {
    String[] splitArray = name.toString().split(" ");
    if (splitArray.length > 1) {
      this.username = (splitArray[0].substring(0, 1) + splitArray[1]).toLowerCase();
    } else {
      this.username = (splitArray[0]).toLowerCase();
    }
  }

  /**
   * Method to set the email from the entered name by the user
   *
   * @param name local StringBuilder name
   */
  private void setEmail(StringBuilder name) {
    String[] splitArray = name.toString().split(" ");
    if (splitArray.length > 1) {
      this.email = (splitArray[0] + "." + splitArray[1]).toLowerCase() + "@oracleacademy.Test";
    } else {
      this.email = (splitArray[0]).toLowerCase() + "@oracleacademy.Test";
    }
  }

  /**
   * Method to check if the password created by the user is valid.
   *
   * @param password local String password
   * @return matcher
   */
  private boolean isValidPassword(String password) {
    final String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).*$";
    final Pattern pattern = Pattern.compile(regex);
    final Matcher matcher = pattern.matcher(password);
    return matcher.matches();
  }

  /**
   * Format String Method
   *
   * @return formatted String
   */
  public String toString() {
    return String.format(
        "Employee Details"
            + "\nName : "
            + name
            + "\nUsername : "
            + username
            + "\nEmail : "
            + email
            + "\nInitial Password : "
            + password);
  }
}
