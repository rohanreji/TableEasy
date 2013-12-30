
package tableeasy;
public class TextCheckThread implements Runnable
{
    public Thread keywordChecker;
    TextCheckThread()
    {
        keywordChecker = new Thread(this,"TextCheckThread");
        keywordChecker.start();
    }
    public void run()
    {
        int i;
        for(i=0;i<10;++i)
        {
            if(TheStaticClass._static_gui!=null)
        System.out.println("---"+TheStaticClass._static_gui.returnMaintabbedPane().returnSqlEditText()+"---");
        try
        {
            keywordChecker.sleep(500);
        }
        catch(InterruptedException ie)
        {
         ie.printStackTrace();
        }
        }
    }
    
}
