package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.local.dao.OrderDao
import com.haunp.mybookstore.data.model.entity.Order

class OrderRepository(private val orderDao: OrderDao){
    suspend fun insertOrder(order: Order) {
        return orderDao.insertOrder(order)
    }

    suspend fun getOrdersByUserId(userId: Int): List<Order> {
        return orderDao.getOrdersByUserId(userId)
    }

    suspend fun getAllOrders(): List<Order> {
        return orderDao.getAllOrders()
    }

    suspend fun updateOrder(order: Order) {
        return orderDao.updateOrder(order)
    }
}