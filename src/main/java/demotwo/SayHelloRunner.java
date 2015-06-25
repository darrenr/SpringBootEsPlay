package demotwo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SayHelloRunner implements CommandLineRunner{

   @Override
   public void run(String... arg0) throws Exception {
      System.out.println("Hello I will run once!!!!!!!!!!!!!!!!!!!!!");
   }
}