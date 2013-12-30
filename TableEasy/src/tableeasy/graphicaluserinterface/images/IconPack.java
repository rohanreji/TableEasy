package tableeasy.graphicaluserinterface.images;
import javax.swing.ImageIcon;
public class IconPack 
{
final public  ImageIcon _exit_icon; 
final public  ImageIcon _about_icon; 
final public  ImageIcon _commit_icon; 
final public  ImageIcon _connect_icon; 
final public  ImageIcon _copy_icon; 
final public  ImageIcon _database_icon; 
final public  ImageIcon _databases_icon;
final public  ImageIcon _disconnect_icon; 
final public  ImageIcon _easytable_icon;  
final public  ImageIcon _help_icon;
final public  ImageIcon _feedback_icon;
final public  ImageIcon _new_icon; 
final public  ImageIcon _paste_icon; 
final public  ImageIcon _reportbug_icon;
final public  ImageIcon _table_icon; 
final public  ImageIcon _table_add_icon; 
final public ImageIcon _save_password;
public IconPack()
{
   _exit_icon = new ImageIcon(getClass().getResource("exit.png"));
   _about_icon = new ImageIcon(getClass().getResource("about.png"));
   _commit_icon = new ImageIcon(getClass().getResource("commit.png"));
   _connect_icon = new ImageIcon(getClass().getResource("connect.png"));
   _copy_icon = new ImageIcon(getClass().getResource("copy.png"));
   _database_icon = new ImageIcon(getClass().getResource("database.png"));
   _databases_icon = new ImageIcon(getClass().getResource("databases.png"));
   _disconnect_icon = new ImageIcon(getClass().getResource("disconnect.png"));
   _easytable_icon = new ImageIcon(getClass().getResource("easytable.png"));
   _help_icon = new ImageIcon(getClass().getResource("help.png"));
   _new_icon = new ImageIcon(getClass().getResource("new.png"));
   _paste_icon = new ImageIcon(getClass().getResource("paste.png"));
   _reportbug_icon = new ImageIcon(getClass().getResource("reportbug.png"));
   _table_icon = new ImageIcon(getClass().getResource("table.png"));
   _table_add_icon = new ImageIcon(getClass().getResource("table_add.png"));
   _feedback_icon = new ImageIcon(getClass().getResource("feedback.png"));
   _save_password=new ImageIcon(getClass().getResource("savebutton.png"));
}
}
