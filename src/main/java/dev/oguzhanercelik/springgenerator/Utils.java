package dev.oguzhanercelik.springgenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Utils {

    private final static Path PATH = Path.of(".");
    private final static String CONTROLLER = """
            package PACKAGE_NAME
                        
            import lombok.RequiredArgsConstructor;
            import org.springframework.web.bind.annotation.RequestMapping;
            import org.springframework.web.bind.annotation.RestController;
                        
            @RestController
            @RequestMapping("/")
            @RequiredArgsConstructor
            public class FILE_NAME {
                        
                        
                        
            }
            """;
    private final static String SERVICE = """
            package PACKAGE_NAME
                        
            import lombok.RequiredArgsConstructor;
            import org.springframework.stereotype.Service;
                        
            @Service
            @RequiredArgsConstructor
            public class FILE_NAME {
                        
                        
                        
            }
            """;
    private final static String REPO = """
            package PACKAGE_NAME
                        
            public interface FILE_NAME extends JpaRepository<MODEL, Integer> {
                        
                        
            }
            """;

    public static void createController(String arg) {

        final String name = arg.substring(0, 1).toUpperCase() + arg.substring(1);

        try (Stream<Path> walk = Files.walk(PATH)) {

            walk.forEach(item -> {
                if (item.toString().contains("controller") || item.toString().contains("controllers")) {

                    String content = CONTROLLER
                            .replace("PACKAGE_NAME", getPackageName(item))
                            .replace("FILE_NAME", name + "Controller");

                    try {
                        Files.writeString(Path.of(item + "/" + name + "Controller.java"), content);
                    } catch (IOException ignored) {
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createService(String arg) {

        final String name = arg.substring(0, 1).toUpperCase() + arg.substring(1);

        try (Stream<Path> walk = Files.walk(PATH)) {

            walk.forEach(item -> {
                if (item.toString().contains("service")) {

                    String content = SERVICE
                            .replace("PACKAGE_NAME", getPackageName(item))
                            .replace("FILE_NAME", name + "Service");

                    try {
                        Files.writeString(Path.of(item + "/" + name + "Service.java"), content);
                    } catch (IOException ignored) {
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createRepo(String arg) {

        final String name = arg.substring(0, 1).toUpperCase() + arg.substring(1);

        try (Stream<Path> walk = Files.walk(PATH)) {

            walk.forEach(item -> {
                if (item.toString().contains("repository")) {

                    String content = REPO
                            .replace("PACKAGE_NAME", getPackageName(item))
                            .replace("FILE_NAME", name + "Repository")
                            .replace("MODEL", name);

                    try {
                        Files.writeString(Path.of(item + "/" + name + "Repository.java"), content);
                    } catch (IOException ignored) {
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String getPackageName(Path path) {
        String packageName = path.toString()
                .replace("src/main/java/", "")
                .replace("/", ".");
        packageName = packageName.substring(2);
        return packageName + ";";
    }
}
