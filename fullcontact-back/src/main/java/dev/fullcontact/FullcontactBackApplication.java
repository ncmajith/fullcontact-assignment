package dev.fullcontact;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.fullcontact.apilib.FullContactException;
import com.fullcontact.apilib.auth.CredentialsProvider;
import com.fullcontact.apilib.auth.StaticApiKeyCredentialProvider;
import com.fullcontact.apilib.enrich.FullContact;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FullcontactBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullcontactBackApplication.class, args);
	}

	@Value("${fullcontact.api.key}")
	private String fullContactApi;
	
	@Bean
	FullContact getWebClient() throws FullContactException {
		CredentialsProvider staticCredentialsProvider = new StaticApiKeyCredentialProvider(fullContactApi);
		return FullContact.builder().credentialsProvider(staticCredentialsProvider)
				.connectTimeoutMillis(5000).build();
	}

}
