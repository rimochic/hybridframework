package bank.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

    Properties pro;

    public readConfig() {
        File src = new File("./Configurations/Config.properties");
        try {
            FileInputStream fi = new FileInputStream(src);
            pro = new Properties();
            pro.load(fi);
        }catch (Exception e){
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getAppUrl(){
        String url = pro.getProperty("url");
        return url;
    }
    public String getUsername(){
        String username = pro.getProperty("userID");
        return username;
    }
    public String getPassword(){
        String password = pro.getProperty("pwd");
        return password;
    }

}
