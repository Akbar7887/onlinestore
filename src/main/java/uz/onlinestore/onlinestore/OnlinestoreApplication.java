package uz.onlinestore.onlinestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.onlinestore.onlinestore.fileupload.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class OnlinestoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinestoreApplication.class, args);
	}


}
