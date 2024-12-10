package com.haunp.mybookstore.domain.repository

import com.haunp.mybookstore.domain.entity.OrderEntity

interface IOrderRepository {
    suspend fun insertOrder(order: OrderEntity)
}