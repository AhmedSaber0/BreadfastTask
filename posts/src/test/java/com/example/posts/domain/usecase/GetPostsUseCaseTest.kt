package com.example.posts.domain.usecase

import com.example.core_testing.scheduler.TestSchedulerProvider
import com.example.posts.domain.model.Post
import com.example.posts.domain.repository.PostsRepository
import com.example.posts.test.factory.PostFactory
import io.reactivex.rxjava3.core.Single
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GetPostsUseCaseTest {

    private val repository = mock<PostsRepository>()
    private val schedulerProvider = TestSchedulerProvider()

    private val getPostsUseCase = GetPostsUseCase(
        repository = repository,
        schedulerProvider = schedulerProvider
    )

    @Test
    fun `build use case observable calls repository`() {
        val pageSize = 20

        getPostsUseCase.execute().test()

        verify(repository).getPosts(pageSize)
    }

    @Test
    fun `build use case observable update use case result list in success`() {
        val posts = listOf(PostFactory.makePost())

        stubGetPost(Single.just(posts))

        getPostsUseCase.execute().test()

        assertEquals(posts, getPostsUseCase.currentList())
    }

    private fun stubGetPost(single: Single<List<Post>>) {
        whenever(repository.getPosts(pageSize = 20)).thenReturn(single)
    }
}
