package com.example.business.gym;

import com.example.business.gym.entity.Chest;
import com.example.business.gym.repository.ChestRepository;
import com.example.business.gym.service.impl.ChestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ChestServiceImplTest {


    @Mock
    private ChestRepository chestRepository;

    @InjectMocks
    private ChestServiceImpl chestService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createChest() {
        Chest chest = new Chest();
        chest.setAccessories("Test Chest");

        when(chestRepository.save(any())).thenReturn(chest);

        Chest createdChest = chestService.createChest(chest);

        ArgumentCaptor<Chest> chestCaptor = ArgumentCaptor.forClass(Chest.class);
        verify(chestRepository).save(chestCaptor.capture());

        Chest capturedChest = chestCaptor.getValue();
        assertNotNull(capturedChest);
        assertEquals("Test Chest", capturedChest.getAccessories());
    }

    @Test
    void getChestById() {
        Chest chest = new Chest();
        chest.setChestId(1L);

        when(chestRepository.findById(1L)).thenReturn(Optional.of(chest));

        Optional<Chest> foundChest = chestService.getChestById(1L);

        assertTrue(foundChest.isPresent());
        assertEquals(1L, foundChest.get().getChestId());
        verify(chestRepository, times(1)).findById(1L);
    }

    @Test
    void updateChestById() {
        Chest existingChest = new Chest();
        existingChest.setChestId(1L);
        existingChest.setAccessories("Old Chest");

        Chest updatedChest = new Chest();
        updatedChest.setAccessories("Updated Chest");

        when(chestRepository.findById(1L)).thenReturn(Optional.of(existingChest));
        when(chestRepository.save(any(Chest.class))).thenReturn(existingChest);

        Chest result = chestService.updateChestById(1L, updatedChest);

        assertNotNull(result);
        assertEquals("Updated Chest", result.getAccessories());
        verify(chestRepository, times(1)).findById(1L);
        verify(chestRepository, times(1)).save(existingChest);
    }

    @Test
    void deleteChestById() {
        Chest chest = new Chest();
        chest.setChestId(1L);

        when(chestRepository.findById(1L)).thenReturn(Optional.of(chest));

        boolean isDeleted = chestService.deleteChestById(1L);

        assertTrue(isDeleted);
        verify(chestRepository, times(1)).findById(1L);
        verify(chestRepository, times(1)).delete(chest);
    }

}
