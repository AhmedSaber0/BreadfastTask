package com.example.posts.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.core.data.ApiResult
import com.example.core_testing.factory.DataFactory
import com.example.posts.data.datasource.PostsRemoteDataSource
import com.example.posts.data.mapper.PostCommentMapper
import com.example.posts.data.mapper.PostMapper
import com.example.posts.data.model.PostCommentEntity
import com.example.posts.data.model.PostEntity
import com.example.posts.domain.model.Post
import com.example.posts.domain.model.PostComment
import com.example.posts.test.factory.PostCommentFactory
import com.example.posts.test.factory.PostFactory
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PostsRepositoryImplTest {

    private lateinit var postsRemoteDataSource: PostsRemoteDataSource
    private lateinit var postMapper: PostMapper
    private lateinit var postCommentMapper: PostCommentMapper
    private lateinit var postsRepositoryImpl: PostsRepositoryImpl

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        postsRemoteDataSource = mockk()
        postMapper = mockk()
        postCommentMapper = mockk()
        postsRepositoryImpl = PostsRepositoryImpl(
            postsRemoteDataSource = postsRemoteDataSource,
            postCommentMapper = postCommentMapper,
            postMapper = postMapper
        )
    }

    @Test
    fun `getPosts returns success`() = runTest {
        val post = PostFactory.makePost()
        val apiResult = ApiResult.Success(listOf(PostFactory.makePostEntity()))

        stubPostsMapper(listOf(post))
        stubGetPosts(apiResult)

        val result = postsRepositoryImpl.getPosts()
        assertTrue(result is ApiResult.Success)
    }

    @Test
    fun `getPosts returns error`() = runTest {
        val apiResult = ApiResult.Error(mockk())

        stubGetPosts(apiResult)

        val result = postsRepositoryImpl.getPosts()
        assertTrue(result is ApiResult.Error)
    }

    @Test
    fun `getPostComments returns success`() = runTest {
        val postComment = PostCommentFactory.makePostComment()
        val apiResult = ApiResult.Success(listOf(PostCommentFactory.makePostCommentEntity()))

        stubPostCommentMapper(listOf(postComment))
        stubGetPostComments(apiResult)

        val result = postsRepositoryImpl.getPostComments(DataFactory.randomString())
        assertTrue(result is ApiResult.Success)
    }

    @Test
    fun `getPostComments returns error`() = runTest {
        val apiResult = ApiResult.Error(mockk())

        stubGetPostComments(apiResult)

        val result = postsRepositoryImpl.getPostComments(DataFactory.randomString())
        assertTrue(result is ApiResult.Error)
    }

    private fun stubPostsMapper(posts: List<Post>) {
        every { postMapper.mapList(any()) } returns posts
    }

    private fun stubPostCommentMapper(postComments: List<PostComment>) {
        every { postCommentMapper.mapList(any()) } returns postComments
    }

    private fun stubGetPosts(posts: ApiResult<List<PostEntity>>) {
        coEvery { postsRemoteDataSource.getPosts() } returns posts
    }

    private fun stubGetPostComments(postComments: ApiResult<List<PostCommentEntity>>) {
        coEvery { postsRemoteDataSource.getPostComments(any()) } returns postComments
    }
}
