package clients;

import in.projecteka.library.clients.UserServiceClient;
import in.projecteka.library.clients.model.PatientName;
import in.projecteka.library.clients.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

import static clients.TestBuilders.user;
import static common.TestBuilders.OBJECT_MAPPER;
import static common.TestBuilders.string;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

class UserServiceClientTest {
    @Captor
    private ArgumentCaptor<ClientRequest> captor;
    @Mock
    private ExchangeFunction exchangeFunction;
    private UserServiceClient userServiceClient;
    private String token;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        WebClient.Builder webClientBuilder = WebClient.builder().exchangeFunction(exchangeFunction);
        token = string();
        userServiceClient = new UserServiceClient(webClientBuilder.build(),
                "http://user-service/",
                () -> Mono.just(token),
                AUTHORIZATION);
    }

    @Test
    void shouldGetUser() throws IOException {
        User user = user().name(PatientName.builder()
                .first("first name")
                .middle("")
                .last("")
                .build())
                .build();
        String patientResponseBody = OBJECT_MAPPER.writeValueAsString(user);
        when(exchangeFunction.exchange(captor.capture()))
                .thenReturn(Mono.just(ClientResponse.create(HttpStatus.OK)
                        .header("Content-Type", "application/json")
                        .body(patientResponseBody).build()));

        StepVerifier.create(userServiceClient.userOf("1"))
                .assertNext(response -> assertThat(response.getName().createFullName()).isEqualTo(user.getName().createFullName()))
                .verifyComplete();

        assertThat(captor.getValue().url().toString()).hasToString("http://user-service/internal/users/1/");
        assertThat(captor.getValue().headers().get(HttpHeaders.AUTHORIZATION).get(0)).isEqualTo(token);
    }
}
