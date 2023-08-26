package com.example.posts.data.repository

import com.example.posts.data.datasource.PostsRemoteDataSource
import com.example.posts.domain.model.Post
import com.example.posts.test.factory.PostFactory
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class PostsRepositoryImplTest {

    private val postsRemoteDataSource = mock<PostsRemoteDataSource>()
    private val postsResultMapper = mock<PostsResultMapper>()

    private val postsRepositoryImpl = PostsRepositoryImpl(
        postsRemoteDataSource = postsRemoteDataSource,
        postsResultMapper = postsResultMapper
    )

    @Test
    fun `getPosts call datasource with correct param`() {
        val pageSize = 20

        stubGetPosts(Single.never())

        postsRepositoryImpl.getPosts(pageSize = pageSize)

        verify(postsRemoteDataSource).getPosts(pageSize = pageSize)
    }

    @Test
    fun `getPosts return data and complete`() {
        val entity = listOf(PostFactory.makePostEntity())
        val domain = listOf(PostFactory.makePost())
        val pageSize = 20

        (Single.just(entity))
        stubPostsResultMapper(domain)

        val testObservable = postsRepositoryImpl.getPosts(pageSize = pageSize).test()

        testObservable.assertResult(domain)
    }

    private fun stubPostsResultMapper(posts: List<Post>) {
        whenever(postsResultMapper.map(any())).thenReturn(posts)
    }

    private fun stubGetPosts(single: Single<PostsResultEntity>) {
        whenever(postsRemoteDataSource.getPosts(pageSize = 10)).thenReturn(single)
    }
}
