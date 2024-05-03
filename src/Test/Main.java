package Test;


import View.GUI_Login;
import View.GUI_SplashScreen;

public class Main {
    public static void main(String[] args) {
        GUI_SplashScreen sc = new GUI_SplashScreen();
        try {
            for(int i=0;i<=100;i++){
                Thread.sleep(30);
                sc.lblNewLabel_1.setText(Integer.toString(i)+"%");
                sc.progressBar.setValue(i);
                if(i==100){
                    Thread.sleep(1000);
                    sc.dispose();
                    new GUI_Login();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
