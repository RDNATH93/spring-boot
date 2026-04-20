package com.example.demo;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.restclient.autoconfigure.RestClientAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.client.HttpSyncGraphQlClient;
import org.springframework.web.client.RestClient;

import com.example.demo.book.Book;

@Import(RestClientAutoConfiguration.class)
class ClientApi implements ApplicationRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(ClientApi.class); 
	private final HttpSyncGraphQlClient client;
	
	public ClientApi(RestClient.Builder builder) {
		RestClient restClient = builder.baseUrl("http://localhost:8080/graphql").build();
		this.client = HttpSyncGraphQlClient.builder(restClient).build();
	}

	
	static void main(String[]args) {
		new SpringApplicationBuilder(ClientApi.class).web(WebApplicationType.NONE).run(args);
	}
	
	@Override
	public void run(ApplicationArguments args) {
		logger.info("ClientApi Started");
		
		var document="""
				query findBookById($id: ID!){
					book(id: $id){
						id
						title
						author{
							id
							name
						}
						
					}
				}
				""";
		
		@Nullable
		Book book = client.document(document)
		   .variable("id", 1L)
		   .retrieveSync("book")
		   .toEntity(Book.class);
		
		logger.info("Book retrieved {}",book);
		
	}
}
