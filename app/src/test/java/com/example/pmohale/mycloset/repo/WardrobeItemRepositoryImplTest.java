package com.example.pmohale.mycloset.repo;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by PMohale on 2018/02/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class WardrobeItemRepositoryImplTest {

    @Mock
    WardrobeItemDao wardrobeItemDao;

    private WardrobeItemRepository wardrobeItemRepository;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        wardrobeItemRepository = new WardrobeItemRepositoryImpl(wardrobeItemDao);
    }

    @Test
    public void shouldCallDAOToAddItem() {

        WardrobeItem fakeItem = new WardrobeItem("description", "type", "color", "dress code", "weather condition");
        wardrobeItemRepository.addWardrobeItem(fakeItem).test().onComplete();

        verify(wardrobeItemDao, times(1)).addItem(fakeItem);
    }

    @Test
    public void shouldCallDAOToDeleteItem() {

        long fakeItemId = 1L;
        wardrobeItemRepository.deleteWardrobeItem(fakeItemId).test().onComplete();

        verify(wardrobeItemDao, times(1)).deleteWardrobeItem(fakeItemId);
    }

    @Test
    public void shouldCallDAOtOGetAllWardrobeItems() {

        wardrobeItemRepository.getAllWardrobeItems();
        verify(wardrobeItemDao, times(1)).getAllItems();
    }
}