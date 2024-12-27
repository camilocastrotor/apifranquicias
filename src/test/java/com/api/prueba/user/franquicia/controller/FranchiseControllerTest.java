package com.api.prueba.user.franquicia.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.api.prueba.user.franquicia.model.dto.BranchDTO;
import com.api.prueba.user.franquicia.model.dto.FranchiseDTO;
import com.api.prueba.user.franquicia.services.FranchiseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class FranchiseControllerTest {

    @Mock
    private FranchiseService franchiseService;

    @InjectMocks
    private FranchiseController franchiseController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(franchiseController).build();
    }

    @Test
    public void testAddFranchise() throws Exception {
        FranchiseDTO franchiseDTO = new FranchiseDTO();
        franchiseDTO.setName("Franquicia Test");

        when(franchiseService.addFranchise(any(FranchiseDTO.class))).thenReturn(franchiseDTO);

        mockMvc.perform(post("/api/franchises")
                        .contentType("application/json")
                        .content("{\"name\":\"Franquicia Test\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Franquicia Test"));
    }

    @Test
    public void testAddBranch() throws Exception {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setName("Sucursal Test");

        when(franchiseService.addBranch(anyLong(), any(BranchDTO.class))).thenReturn(branchDTO);

        mockMvc.perform(post("/api/franchises/1/branches")
                        .contentType("application/json")
                        .content("{\"name\":\"Sucursal Test\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sucursal Test"));
    }


}

