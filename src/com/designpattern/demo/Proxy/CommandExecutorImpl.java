package com.designpattern.demo.Proxy;

import java.io.IOException;

public class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void runCommand(String cmd) throws IOException {
        System.out.println("'" + cmd + "' command executed.");
    }

}
