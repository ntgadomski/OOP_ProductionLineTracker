package productionlinetracker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee{
    StringBuilder name;
    String username;
    String password;
    String email;

    Employee(String name, String password){
        StringBuilder sBName = new StringBuilder(name);
        StringBuilder defaultUsername = new StringBuilder("default");
        StringBuilder defaultEmail = new StringBuilder("user");
        this.name = sBName;
        this.password = password;
        if(checkName(sBName)){
            setUsername(sBName);
            setEmail(sBName);
        }
        else{
            setUsername(defaultUsername);
            setEmail(defaultEmail);
        }
        if(isValidPassword(password)){
            this.password = password;
        }
        else{
            this.password = "pw";
        }
    }
    private boolean checkName(StringBuilder name){
        String[] splitArray = name.toString().split(" ");
        return splitArray.length == 1 ? false : true;
    }
    private void setUsername(StringBuilder name){
        String[] splitArray = name.toString().split(" ");
        if(splitArray.length > 1){
            this.username = (splitArray[0].substring(0, 1) + splitArray[1]).toLowerCase();
        }
        else{
            this.username = (splitArray[0]).toLowerCase();
        }
    }
    private void setEmail(StringBuilder name){
        String[] splitArray = name.toString().split(" ");
        if(splitArray.length > 1){
            this.email = (splitArray[0] + "." + splitArray[1]).toLowerCase() + "@oracleacademy.Test";
        }
        else{
            this.email = (splitArray[0]).toLowerCase() + "@oracleacademy.Test";
        }
    }
    private boolean isValidPassword(String password){
        final String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).*$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public String toString(){
        return String.format("Employee Details" + "\nName : " + name + "\nUsername : " + username + "\nEmail : " + email + "\nInitial Password : " + password);
    }
}

