package com.myfood.cqrs.myfood.sync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfood.cqrs.myfood.sync.service.SyncService;

@RestController
public class SyncController {

  @Autowired
  private SyncService syncService;

  @PostMapping("/sync")
  public void sync() {
    syncService.sync();
  }
}
