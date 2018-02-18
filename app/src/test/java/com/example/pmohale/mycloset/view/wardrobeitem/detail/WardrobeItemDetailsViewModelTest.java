package com.example.pmohale.mycloset.view.wardrobeitem.detail;

import android.app.Application;

import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by PMohale on 2018/02/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class WardrobeItemDetailsViewModelTest {

    @Mock
    private WardrobeItemRepository wardrobeItemRepository;

    @Mock
    Application application;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deleteWardrobeItem() {

    }
}
