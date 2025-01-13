package com.wizzdi.runtime.controller;

import com.wizzdi.runtime.model.AppUser;
import com.wizzdi.runtime.request.AppUserCreate;
import com.wizzdi.runtime.request.AppUserFilter;
import com.wizzdi.runtime.request.AppUserUpdate;
import com.wizzdi.runtime.response.PaginationResponse;
import com.wizzdi.runtime.security.UserSecurityContext;
import com.wizzdi.runtime.service.AppUserService;
import com.wizzdi.runtime.validation.Create;
import com.wizzdi.runtime.validation.Update;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("AppUser")
@Tag(name = "AppUser")
public class AppUserController {

  @Autowired private AppUserService appUserService;

  @DeleteMapping("{id}")
  @Operation(summary = "deleteAppUser", description = "Deletes AppUser")
  public AppUser deleteAppUser(@PathVariable("id") String id, Authentication authentication) {
    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return appUserService.deleteAppUser(id, securityContext);
  }

  @PostMapping("getAllAppUsers")
  @Operation(summary = "getAllAppUsers", description = "lists AppUsers")
  public PaginationResponse<AppUser> getAllAppUsers(
      @Valid @RequestBody AppUserFilter appUserFilter, Authentication authentication) {
    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return appUserService.getAllAppUsers(appUserFilter, securityContext);
  }

  @PutMapping("updateAppUser")
  @Operation(summary = "updateAppUser", description = "Updates AppUser")
  public AppUser updateAppUser(
      @Validated(Update.class) @RequestBody AppUserUpdate appUserUpdate,
      Authentication authentication) {
    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return appUserService.updateAppUser(appUserUpdate, securityContext);
  }

  @PostMapping("createAppUser")
  @Operation(summary = "createAppUser", description = "Creates AppUser")
  public AppUser createAppUser(
      @Validated(Create.class) @RequestBody AppUserCreate appUserCreate,
      Authentication authentication) {
    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return appUserService.createAppUser(appUserCreate, securityContext);
  }
}
