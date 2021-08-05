package com.example.composeplayground.data.remote

import kotlinx.coroutines.flow.Flow

abstract class NetworkBoundResource<ResultType, RequestType> {
    protected abstract suspend fun saveCallResult(item: RequestType)
    protected abstract fun shouldFetch(data: ResultType?): Boolean
    protected abstract suspend fun loadFromDb(): Flow<ResultType>
    protected abstract fun createCall(): Flow<ApiResponse<RequestType>>

    // Called when the fetch fails. The child class may want to reset components
    // like rate limiter.
    protected open fun onFetchFailed() {}
}