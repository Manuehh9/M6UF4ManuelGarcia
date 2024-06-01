package com.gestioManuel.gestioManuel;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.gestioManuel.gestioManuel.backend.business.model.Topo;
import com.gestioManuel.gestioManuel.backend.business.services.TopoService;
import com.gestioManuel.gestioManuel.backend.presentation.config.RespuestaError;
import com.gestioManuel.gestioManuel.backend.presentation.restcontrollers.TopoController;

@SpringBootTest
class GestioManuelApplicationTests {

    private MockMvc mockMvc;

    @Mock
    private TopoService topoService;

    @InjectMocks
    private TopoController topoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(topoController)
                .build();
    }

    @Test
    void testGetAll() throws Exception {
        Topo topo1 = new Topo();
        topo1.setId(1L);
        Topo topo2 = new Topo();
        topo2.setId(2L);

        when(topoService.getAll()).thenReturn(Arrays.asList(topo1, topo2));

        mockMvc.perform(get("/topos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\": 1}, {\"id\": 2}]"));
    }

    @Test
    void testRead_ValidId() throws Exception {
        Topo topo = new Topo();
        topo.setId(1L);

        when(topoService.read(1L)).thenReturn(Optional.of(topo));

        mockMvc.perform(get("/topos/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\": 1}"));
    }

    @Test
    void testRead_InvalidId() throws Exception {
        when(topoService.read(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/topos/999"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"error\": \"El número 999 no es válido.\"}"));
    }




    @Test
    void testRead_IdGreaterThan300() throws Exception {
        mockMvc.perform(get("/topos/301"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"error\": \"El número 301 no es válido.\"}"));
    }
}
