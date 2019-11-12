package framework.util;

import org.apache.log4j.*;

public class Log {

	private Logger _LOG;
	private static String logFolder = "./build/logs/";
	private String testCaseName;
	private String testClassName;

	//---------------------------------------------------------------

    public Log(String testClassName) {
        this.testClassName = testClassName;
        setupLogging();
    }

    public Log(Logger LOGGER){
        _LOG = LOGGER;
    }

    //---------------------------------------------------------------

    protected void setupLogging() {
        _LOG = Logger.getLogger(Log.class);
        _LOG.removeAllAppenders();
        _LOG.setLevel(Level.ALL);
        _LOG.setAdditivity(false);
        PatternLayout patternLayout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %m%n");
        try {
            FileAppender fileAppender = new FileAppender(patternLayout, logFolder + this.testClassName + ".log", true);
            _LOG.addAppender(fileAppender);
        } catch (Exception e) {
            // do nothing
        }
        ConsoleAppender consoleAppender = new ConsoleAppender(patternLayout, "System.out");
        _LOG.addAppender(consoleAppender);
    }

    //---------------------------------------------------------------

    public void setMethodName(String testCaseName){
        this.testCaseName = testCaseName;
    }

    //---------------------------------------------------------------

    //We can use it when starting tests
    public void startLog (String testMethodName){
    	_LOG.info("--------- " + testMethodName + " ---------");
    	setMethodName(testMethodName);
    }

    //---------------------------------------------------------------

    //Info Level Logs
    public void info (String message) {
        _LOG.info(message);
        String scriptName = getClassAndMethodName();
    }

    //---------------------------------------------------------------

    //Error Level Logs
    public void error (String message) {
    	String scriptName = getClassAndMethodName();
        //_LOG.error(scriptName + message);
    	//_LOG.info("[ERROR]" + scriptName + message);
        _LOG.info("[ERROR] " + message);
    }

    //---------------------------------------------------------------

    //Warning Level Logs
    public void warning (String message) {
        _LOG.info("[WARNING] " + message);
        String scriptName = getClassAndMethodName();
    }

    //---------------------------------------------------------------

    private static String getClassAndMethodName(){
    	String fullClassName =  Thread.currentThread().getStackTrace()[3].getClassName();
    	String[] arrayStr = fullClassName.split("\\.");
    	String className = arrayStr[arrayStr.length-1];
    	String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
    	int line = Thread.currentThread().getStackTrace()[3].getLineNumber();
    	String scriptName =  " " + className + "." + methodName + ":" + line + " - ";
    	return scriptName;
    }

    //---------------------------------------------------------------

    public void logMember (String MemberID){
        _LOG.info(
                "<" +
                        Thread.currentThread().getStackTrace()[2].getMethodName()
                        + " TestData>" + MemberID.toUpperCase()
        );
        _LOG.info(
                "<" + testCaseName + " TestData>" + MemberID.toUpperCase()
        );

    }

}
