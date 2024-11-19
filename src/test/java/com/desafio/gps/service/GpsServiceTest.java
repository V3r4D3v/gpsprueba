package com.desafio.gps.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.desafio.gps.model.GpsData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GpsServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GpsService gpsService;

    private GpsData gpsData;
    private String json;
    private HttpHeaders headers;
    private HttpEntity<String> entity;

    @BeforeEach
    void setup() {
        gpsData = new GpsData(
                "98173",
                (double) Math.random(),
                (double) Math.random(),
                1.0,
                45.0,
                "2015-04-30T13:55:20Z",
                "2",
                3,
                335,
                "GPS",
                "Cristian Vera",
                "TAG∫"
        );
        json = gpsData.toJson();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        entity = new HttpEntity<>(json, headers);
    }

    /*@Test
    void testEnviarDatosGPS() {
        // Configuración del mock
        when(restTemplate.exchange(any(String.class), any(HttpMethod.class),any(HttpEntity.class),String.class)).thenReturn(any());

        // Ejecución del método a probar
        gpsService.enviarDatosGPS();

        // Verificación de la llamada al mock
        verify(restTemplate).exchange(any(String.class),any(HttpMethod.class),any(HttpEntity.class), String.class);

        // Verificación de la entidad enviada
        assertNotNull(entity);
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        assertEquals(json, entity.getBody());
    }*/

    @Test
    void testSimularDatosGPS() {
        // Ejecución del método a probar
        GpsData datosGPS = gpsService.simularDatosGPS();

        // Verificación de los datos simulados
        assertNotNull(datosGPS);
    }
}
