package com.example.pmohale.mycloset.repo;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;
import com.example.pmohale.mycloset.testutils.FakeDataTestUtil;
import com.example.pmohale.mycloset.testutils.LiveDataTestUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by PMohale on 2018/02/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class WardrobeItemRepositoryImplTest {

    @Mock
    private WardrobeItemDao wardrobeItemDao;

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

        WardrobeItem fakeItem = FakeDataTestUtil.getFakeWardrobeItem();
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
    public void shouldGetAllWardrobeItems() throws InterruptedException {

        MutableLiveData<List<WardrobeItem>> fakeWardrobeItems = FakeDataTestUtil.getWardrobeItemsListMutableLiveData();
        when(wardrobeItemDao.getAllItems()).thenReturn(fakeWardrobeItems);

        List<WardrobeItem> returnedWardrobeItems = LiveDataTestUtil.getValue(wardrobeItemRepository.getAllWardrobeItems());

        assertArrayEquals(fakeWardrobeItems.getValue().toArray(), returnedWardrobeItems.toArray());
        verify(wardrobeItemDao, times(1)).getAllItems();
    }

    @Test
    public void shouldGetWardrobeItemById() throws InterruptedException {

        long fakeId = 1L;
        MutableLiveData<WardrobeItem> fakeWardrobeItem = FakeDataTestUtil.getWardrobeItemMutableLiveData();
        when(wardrobeItemDao.getWardrobeItem(fakeId)).thenReturn(fakeWardrobeItem);

        WardrobeItem returnedItem = LiveDataTestUtil.getValue(wardrobeItemRepository.getWardrobeItem(fakeId));
        assertEquals(fakeWardrobeItem.getValue(), returnedItem);
        verify(wardrobeItemDao, times(1)).getWardrobeItem(fakeId);
    }

    @Test
    public void shouldGetWardrobeItemsListByDressCode() throws InterruptedException {

        String fakeDressCode = "casual";
        MutableLiveData<List<WardrobeItem>> fakeWardrobeItems = FakeDataTestUtil.getWardrobeItemsListMutableLiveData();
        when(wardrobeItemDao.getItemsByDressCode(fakeDressCode)).thenReturn(fakeWardrobeItems);

        List<WardrobeItem> returnedWardrobeItems = LiveDataTestUtil.getValue(wardrobeItemRepository.getItemsByDressCode(fakeDressCode));
        assertArrayEquals(fakeWardrobeItems.getValue().toArray(), returnedWardrobeItems.toArray());
    }
}