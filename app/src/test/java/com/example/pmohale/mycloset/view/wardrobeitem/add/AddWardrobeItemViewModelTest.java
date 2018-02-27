package com.example.pmohale.mycloset.view.wardrobeitem.add;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Completable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by PMohale on 2018/02/27.
 */
public class AddWardrobeItemViewModelTest {

    private AddWardrobeItemViewModel addWardrobeItemViewModel;

    @Mock
    private WardrobeItemRepository wardrobeItemRepository;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @BeforeClass
    public static void setUpClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());
    }

    @AfterClass
    public static void tearDownClass() {
        RxAndroidPlugins.reset();
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        addWardrobeItemViewModel = new AddWardrobeItemViewModel();
        addWardrobeItemViewModel.itemRepository = wardrobeItemRepository;
    }

    @Test
    public void shouldCallRepoToAddNewItem() {

        when(wardrobeItemRepository.addWardrobeItem(any())).thenReturn(Completable.complete());

        addWardrobeItemViewModel.addWardrobeItem("", "", "", "", "");
        verify(wardrobeItemRepository, times(1)).addWardrobeItem(any());
    }

}