package com.schewe.dualisbot.adapters;

import java.io.IOException;

public class DualisWebscraper {

    public static String COMMAND_RUN = "java -jar dualis-webscraper.jar";

    private static final DualisWebscraper instance = new DualisWebscraper();

    public static DualisWebscraper getInstance(){
        return instance;
    }

    public Process run() throws InterruptedException, IOException {
        Process process = runAsync();
        process.waitFor();
        return process;
    }

    public Process runAsync() throws IOException {
        return Runtime.getRuntime().exec(COMMAND_RUN);
    }

}
