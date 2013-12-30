package tableeasy;

import tableeasy.graphicaluserinterface.widgets.LoginBox;

/*inside package tableeasy*/
public class MainActivity
{
     public static int usernames=0;
     public static String databases[]=new String[10];public static int noofdata=0;
     
     public static int selecteddata=0;
    public static void main(String[] args)
    {
        
        TextCheckThread tct = new TextCheckThread();
        GraphicalUserInterface gui = new GraphicalUserInterface();
        LoginBox lb=new LoginBox(tableeasy.GraphicalUserInterface._mainframe);
        lb.setVisible(true);
       
        TheStaticClass._static_gui = gui;
        TheStaticClass.printDetailsOfStaticObjects();
        try
        {
            tct.keywordChecker.join();
        }
        catch(InterruptedException ie )
        {
            ie.printStackTrace();
        }
    }
}
