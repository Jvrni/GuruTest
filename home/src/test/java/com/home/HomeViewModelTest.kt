package com.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.domain.feature.story.StoryUseCase
import com.domain.models.Items
import com.domain.models.Story
import com.home.view.HomeViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    @MockK
    private lateinit var storyUseCase: StoryUseCase

    private val viewModel by lazy {
        spyk(HomeViewModel(storyUseCase = storyUseCase))
    }

    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = false)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `WHEN initialize view get a storys THEN return success value`() {
        val story = Story(
            listOf(
                Items(
                    title = "Open Finance impulsiona corrida por transformação no mercado financeiro no Brasil",
                    origin = "InfoMoney",
                    link = "https://www.infomoney.com.br/economia/open-finance-impulsiona-corrida-por-transformacao-no-mercado-financeiro-no-brasil/",
                    isPriority = false,
                    image = "https://www.infomoney.com.br/wp-content/uploads/2021/04/clay-banks-XvS-uKUoUao-unsplash.jpg",
                    published = "2021-04-26T12:57:30:000+0000"
                )
            )
        )

        // When
        coEvery {
            storyUseCase.getStory()
        } returns story

        viewModel.init()

        //Then
        verify(exactly = 1){
            viewModel.init()
        }

        viewModel.storys().observeForever { result ->
            assertEquals(story.items[0].title, result.items[0].title)
            assertEquals(story.items[0].origin, story.items[0].origin)
            assertEquals(story.items[0].link, story.items[0].link)
            assertEquals(story.items[0].isPriority, story.items[0].isPriority)
            assertEquals(story.items[0].image, story.items[0].image)
            assertEquals(story.items[0].published, story.items[0].published)
        }
    }

    @Test
    fun `WHEN initialize view get a storys THEN return error value`() {
        val story = Story(emptyList())

        // When
        coEvery {
            storyUseCase.getStory()
        } returns story

        viewModel.init()

        //Then
        verify(exactly = 1){
            viewModel.init()
        }

        viewModel.emptyStorys().observeForever { result ->
            assertEquals(Unit, result)
        }
    }
}