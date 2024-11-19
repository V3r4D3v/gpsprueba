package com.desafio.gps.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.gps.model.GpsData;
import com.desafio.gps.utils.SWSUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.concurrent.atomic.AtomicBoolean;


@Service
public class GpsService {
    private static final Logger log = LoggerFactory.getLogger(GpsService.class);

    private final String REMOTO_URL = "https://test-externalrgw.ar.sitrack.com/frame";
    private final RestTemplate restTemplate = new RestTemplate();
    private final AtomicBoolean activo = new AtomicBoolean(true);
    private LocalDateTime inicio;
    private final String ID = "ReportGeneratorTest";
    private final String SECRET_KEY = "ccd517a1-d39d-4cf6-af65-28d65e192149";

    @Scheduled(fixedRate = 60000)
    public void enviarDatosGPS() {
        if (activo.get()) {
            if (inicio == null) {
                inicio = LocalDateTime.now();
            }
            GpsData datosGPS = simularDatosGPS();
            String json = datosGPS.toJson();
            String authorizationHeader = SWSUtils.generateAuthorizationHeader(ID, SECRET_KEY, json);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Authorization", authorizationHeader);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);
            ResponseEntity<String> respuesta = restTemplate.exchange(REMOTO_URL, HttpMethod.PUT, entity, String.class);
            if (respuesta.getStatusCode().is2xxSuccessful()) {
                log.info("mensaje procesado: " + respuesta.getBody());
            } else {
                log.error("mensaje no procesado:" + respuesta.getBody());
            }
            long minutosTranscurridos = ChronoUnit.MINUTES.between(inicio, LocalDateTime.now());
            if (minutosTranscurridos >= 10) {
                activo.set(false);
            }
        }

    }

    public GpsData simularDatosGPS() {
        return new GpsData(
                "98173",
                (double) Math.random(),
                (double) Math.random(),
                1.0,
                45.0,
                this.getFechaFormat(),
                "2",
                3,
                335,
                "GPS",
                "Cristian Vera",
                "TAG∫"
        );
    }

    private String getFechaFormat() {
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        return fmt.format(now);
    }
}
