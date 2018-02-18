package com.example.pmohale.mycloset.repo;

import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.task.wardrobeitem.DeleteWardrobeItemAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by PMohale on 2018/02/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class WardrobeItemRepositoryImplTest {

    @Mock
    DeleteWardrobeItemAsyncTask deleteWardrobeItemAsyncTask;

    @Mock
    WardrobeItemDao wardrobeItemDao;

    @InjectMocks
    WardrobeItemRepositoryImpl wardrobeItemRepository;

    @Test
    public void shouldCallDAOToDeleteItem(){
        long id = 1;

        wardrobeItemRepository.deleteWardrobeItem(id);

        verify(wardrobeItemDao, times(1)).deleteWardrobeItem(id);

    }
}