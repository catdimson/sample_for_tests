package com.geekbrains.tests.presenter.details

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var view: ViewDetailsContract

    private val count = 5

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        presenter = DetailsPresenter(count)
        presenter.onAttach(view)
    }

    @Test
    fun detailsPresenterTest_onAttach() {
        presenter.onIncrement()

        verify(view, times(1)).setCount(count + 1)
    }

    @Test
    fun detailsPresenterTest_onDetach() {
        presenter.onDetach()
        presenter.onIncrement()

        verify(view, times(0)).setCount(any())
    }

    @Test
    fun detailsPresenterTest_setCounter() {
        presenter.setCounter(count + count)
        presenter.onIncrement()

        verify(view, times(1)).setCount(count + count + 1)
    }

    @Test
    fun detailsPresenterTest_onIncrement() {
        presenter.onIncrement()

        verify(view, times(1)).setCount(count + 1)
    }

    @Test
    fun detailsPresenterTest_onDecrement() {
        presenter.onDecrement()

        verify(view, times(1)).setCount(count - 1)
    }
}