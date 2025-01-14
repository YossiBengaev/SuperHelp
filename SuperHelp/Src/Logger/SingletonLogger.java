package Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SingletonLogger {
    private static final SingletonLogger _firstInstance = new SingletonLogger();
    private final Logger _logger = Logger.getLogger(SingletonLogger.class.getName());
    private static boolean _createTemplate = true;

    private SingletonLogger() { }

    public static SingletonLogger getInstance() {
        return _firstInstance;
    }

    public Logger configLogger() {
        if (_createTemplate) {
            String path = "C:\\Users\\97250\\IdeaProjects\\SuperHelp\\SuperHelp\\Src\\Logger\\Logs";
            FileHandler fh = null;
            SimpleDateFormat format = new SimpleDateFormat("M-d_HHmmss");

            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdir();
            }

            try {
                fh = new FileHandler(path + "\\Logs_"
                        + format.format(Calendar.getInstance().getTime()) + ".log");
            } catch (IOException e) {
                e.printStackTrace();
            }

            fh.setFormatter(new SimpleFormatter());
            _logger.addHandler(fh);
            _logger.setUseParentHandlers(false);

            _createTemplate = false;
        }
        return _logger;
    }
}
