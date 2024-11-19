package com.desafio.gps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.gps.service.GpsService;

@RestController
public class GpsController {
    @Autowired
    private GpsService gpsService;
}
