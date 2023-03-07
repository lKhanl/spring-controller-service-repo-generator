package dev.oguzhanercelik.springgenerator;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Commands {

    @ShellMethod(key = "c", value = "generate controller", prefix = "-c")
    public void generateController(@ShellOption String name) {
        Utils.createController(name);
        System.exit(0);
    }

    @ShellMethod(key = "s", value = "generate service", prefix = "-m")
    public void generateService(@ShellOption String name) {
        Utils.createService(name);
        System.exit(0);
    }

    @ShellMethod(key = "r", value = "generate repo", prefix = "-r")
    public void generateRepo(@ShellOption String name) {
        Utils.createRepo(name);
        System.exit(0);
    }

}
