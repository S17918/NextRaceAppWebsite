package next.race.app.nextrace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class NextraceApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(NextraceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(applicationClass);
    }

    private static Class<NextraceApplication> applicationClass = NextraceApplication.class;
}
