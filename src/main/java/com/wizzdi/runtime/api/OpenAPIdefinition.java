package com.wizzdi.runtime.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wizzdi.runtime.api.request.AppUserCreate;
import com.wizzdi.runtime.api.request.AppUserFilter;
import com.wizzdi.runtime.api.request.AppUserUpdate;
import com.wizzdi.runtime.api.request.LoginRequest;
import com.wizzdi.runtime.api.request.StoreCreate;
import com.wizzdi.runtime.api.request.StoreFilter;
import com.wizzdi.runtime.api.request.StoreUpdate;
import com.wizzdi.runtime.api.response.AppUser;
import com.wizzdi.runtime.api.response.Login200Response;
import com.wizzdi.runtime.api.response.PaginationResponseAppUser;
import com.wizzdi.runtime.api.response.PaginationResponseStore;
import com.wizzdi.runtime.api.response.Store;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

public class OpenAPIdefinition {

  private static final String DEFAULT_BASE_PATH = "https://store-app.workspace.cluster.wizzdi.com";
  private static final Logger logger = LoggerFactory.getLogger(OpenAPIdefinition.class);

  private static final ObjectMapper objectMapper =
      new ObjectMapper()
          .setSerializationInclusion(JsonInclude.Include.NON_NULL)
          .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
          .registerModule(new JavaTimeModule());

  private String basePath = DEFAULT_BASE_PATH;
  private final RestTemplate restTemplate;

  private String token;

  public OpenAPIdefinition() {
    this.restTemplate = getRestTemplate();
  }

  public <T extends OpenAPIdefinition> T setBasePath(String basePath) {
    if (basePath == null || basePath.isBlank()) {
      return (T) this;
    }
    this.basePath = basePath;
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(basePath));
    return (T) this;
  }

  private RestTemplate getRestTemplate() {
    return new RestTemplateBuilder()
        .uriTemplateHandler(new DefaultUriBuilderFactory(DEFAULT_BASE_PATH))
        .requestFactory(() -> new JdkClientHttpRequestFactory())
        .errorHandler(new NonThrowingErrorHandler())
        .additionalMessageConverters(
            new MappingJackson2HttpMessageConverter(objectMapper), new FormHttpMessageConverter())
        .additionalInterceptors(this::tokenInterceptor)
        .build();
  }

  public class NonThrowingErrorHandler implements ResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
      // your error handling here
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
      return false;
    }
  }

  private ClientHttpResponse tokenInterceptor(
      HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution)
      throws IOException {
    if (this.token != null) {
      httpRequest.getHeaders().add("Authorization", "Bearer " + token);
    }
    return clientHttpRequestExecution.execute(httpRequest, bytes);
  }

  public String getToken() {
    return this.token;
  }

  public <T extends OpenAPIdefinition> T setToken(String token) {
    this.token = token;
    return (T) this;
  }

  public ResponseEntity<AppUser> updateAppUser(AppUserUpdate appUserUpdate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.PUT;
    String path = "/api/AppUser/updateAppUser";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<AppUserUpdate> entity = new HttpEntity<>(appUserUpdate, headers);

    ParameterizedTypeReference<AppUser> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<AppUser> deleteAppUser(String id) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.DELETE;
    String path = "/api/AppUser/{id}";

    uriParameters.put("id", id);

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<Void> entity = new HttpEntity<>(null, headers);

    ParameterizedTypeReference<AppUser> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<PaginationResponseAppUser> getAllAppUsers(AppUserFilter appUserFilter) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/AppUser/getAllAppUsers";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<AppUserFilter> entity = new HttpEntity<>(appUserFilter, headers);

    ParameterizedTypeReference<PaginationResponseAppUser> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<AppUser> register(AppUserCreate appUserCreate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/register";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<AppUserCreate> entity = new HttpEntity<>(appUserCreate, headers);

    ParameterizedTypeReference<AppUser> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Login200Response> login(LoginRequest loginRequest) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/login";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<LoginRequest> entity = new HttpEntity<>(loginRequest, headers);

    ParameterizedTypeReference<Login200Response> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<PaginationResponseStore> getAllStores(StoreFilter storeFilter) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/Store/getAllStores";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<StoreFilter> entity = new HttpEntity<>(storeFilter, headers);

    ParameterizedTypeReference<PaginationResponseStore> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Store> updateStore(StoreUpdate storeUpdate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.PUT;
    String path = "/api/Store/updateStore";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<StoreUpdate> entity = new HttpEntity<>(storeUpdate, headers);

    ParameterizedTypeReference<Store> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Store> createStore(StoreCreate storeCreate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/Store/createStore";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<StoreCreate> entity = new HttpEntity<>(storeCreate, headers);

    ParameterizedTypeReference<Store> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<AppUser> createAppUser(AppUserCreate appUserCreate) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/api/AppUser/createAppUser";

    headers.setContentType(MediaType.valueOf("application/json"));

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<AppUserCreate> entity = new HttpEntity<>(appUserCreate, headers);

    ParameterizedTypeReference<AppUser> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }

  public ResponseEntity<Store> deleteStore(String id) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.DELETE;
    String path = "/api/Store/{id}";

    uriParameters.put("id", id);

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<Void> entity = new HttpEntity<>(null, headers);

    ParameterizedTypeReference<Store> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }
}
