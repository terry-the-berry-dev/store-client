package com.wizzdi.runtime.flows;

import com.wizzdi.runtime.api.OpenAPIdefinition;
import com.wizzdi.runtime.api.request.LoginRequest;
import com.wizzdi.runtime.api.request.StoreCreate;
import com.wizzdi.runtime.api.response.Store;
import com.wizzdi.runtime.security.UserSecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class StoreFlow {
  private static final Logger logger = LoggerFactory.getLogger(StoreFlow.class);

  @Value("${store.admin.username}")
  private java.lang.String storeadminusername;

  @Value("${store.admin.password}")
  private java.lang.String storeadminpassword;

  public Store run(StoreCreate storeBody, UserSecurityContext securityContext) {

    OpenAPIdefinition openapidefinition = new OpenAPIdefinition();

    var storeLoginRequest =
        openapidefinition.login(
            new LoginRequest()
                .setUsername(this.storeadminusername)
                .setPassword(this.storeadminpassword));

    logger.info("Store Login Request: " + storeLoginRequest.toString());

    if (!(storeLoginRequest.getStatusCode().is2xxSuccessful())) {

      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Couldn't Login");
    }

    java.lang.String storeJWTauthorizationToken =
        storeLoginRequest.getHeaders().getFirst("authorization");

    openapidefinition.setToken(storeJWTauthorizationToken);

    var createStoreRequest =
        openapidefinition.createStore(new StoreCreate().setName(storeBody.getName()));

    logger.info("Create Store Log: " + createStoreRequest.toString());

    if (!(createStoreRequest.getStatusCode().is2xxSuccessful())) {

      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create the store");
    }

    Store createdStore = createStoreRequest.getBody();

    return createdStore;
  }
}
