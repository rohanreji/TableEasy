
package tableeasy;

public final class TheStaticClass 
{
 public static GraphicalUserInterface _static_gui= null;
 public static OracleDatabaseConnection _static_jdbcodbc = null;
 public void assignStaticGui( GraphicalUserInterface _static_gui)
    {
 this._static_gui=_static_gui;            
    }
public void assignStaticJdbcOdbc(OracleDatabaseConnection _static_jdbcodbc)
    {
    this._static_jdbcodbc=_static_jdbcodbc;
    }
public static void printDetailsOfStaticObjects()
{
    System.out.println("GraphicalUserInterface object:"+_static_gui);
    System.out.println("OracleDataBaseConnection object:"+_static_jdbcodbc);
}
}