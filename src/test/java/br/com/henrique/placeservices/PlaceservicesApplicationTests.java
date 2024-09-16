package br.com.henrique.placeservices;

import br.com.henrique.placeservices.api.PlaceRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaceservicesApplicationTests {
	@Autowired
	WebTestClient webTestClient;

	@Test
	public void testCreatedPlaceSucess(){
		var name = "Valid name";
		var state = "Valid State";
		var slug="valid-name";

		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest(name, state)
				)
				.exchange()
				.expectBody()
				.jsonPath("name").isEqualTo(name)
				.jsonPath("state").isEqualTo(state)
				.jsonPath("slug").isEqualTo(slug)
				.jsonPath("createdAt").isNotEmpty()
				.jsonPath("updatedAt").isNotEmpty();
	}

	@Test
	public void testCreatePlaceFailure(){
		var name = "";
		var state = "";
		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest(name, state)
				)
				.exchange()
				.expectStatus().isBadRequest();
	}

}
