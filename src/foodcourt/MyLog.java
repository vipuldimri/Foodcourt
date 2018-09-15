/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import java.util.logging.SimpleFormatter;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class MyLog {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatText;
    static private Logger logger;
    static private Date date;
    static private SimpleDateFormat yyddmm;
    
    static public void setup() throws IOException {
        date = new Date();
        yyddmm = new SimpleDateFormat("dd-MM-YYYY");
        String todaysDate = yyddmm.format(date);
        String logFile = todaysDate.concat(".txt");
        System.out.println(logFile);
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        
        // suppress the logging output to the console
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }
        logger.setLevel(Level.INFO);
        
        fileTxt = new FileHandler(logFile,true);
        // create a TXT formatter
        formatText = new SimpleFormatter();
        fileTxt.setFormatter(formatText);
        logger.addHandler(fileTxt);
        
    }
    
    public static Logger getLogger()
    {
        return logger;
    }
    
}
