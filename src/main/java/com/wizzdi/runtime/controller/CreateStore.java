package com.wizzdi.runtime.controller;

import com.wizzdi.runtime.api.request.StoreCreate;
import com.wizzdi.runtime.api.response.Store;
import com.wizzdi.runtime.flows.StoreFlow;
import com.wizzdi.runtime.security.UserSecurityContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("CreateStore")
@Tag(name = "CreateStore")
public class CreateStore {

  @Autowired private StoreFlow storeFlow;

  @PostMapping("createStore")
  @Operation(summary = "createStore", description = "")
  public Store createStore(@RequestBody StoreCreate storeCreate, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return storeFlow.run(storeCreate, securityContext);
  }
}
