package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.database.dao.OrderDao
import com.haunp.mybookstore.domain.entity.OrderEntity
import com.haunp.mybookstore.domain.repository.IOrderRepository

class OrderRepositoryImpl(private val orderDao: OrderDao): IOrderRepository {
    override suspend fun insertOrder(order: OrderEntity) {
        return orderDao.insertOrder(order)
    }
}