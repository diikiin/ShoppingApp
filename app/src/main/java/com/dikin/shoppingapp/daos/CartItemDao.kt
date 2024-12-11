package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.CartItem
import com.dikin.shoppingapp.models.CartItemWithProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface CartItemDao {
    @Query("select * from cart_items")
    fun getAll(): Flow<List<CartItem>>

    @Query("select * from cart_items where cartItemId = :id")
    suspend fun getById(id: Int): CartItem?

    @Query(
        """
        select ci.cartItemId, ci.cartId, ci.productId, ci.quantity, 
               p.name as productName, p.description as productDescription, 
               p.price as productPrice, p.imageUrl as productImageUrl
        from cart_items ci
        inner join products p on ci.productId = p.productId
        where ci.cartId = :cartId
    """
    )
    fun getByCartId(cartId: Int): Flow<List<CartItemWithProduct>>

    @Insert
    suspend fun insert(cartItem: CartItem)

    @Update
    suspend fun update(cartItem: CartItem)

    @Delete
    suspend fun delete(cartItem: CartItem)

    @Query("delete from cart_items where cartItemId = :id")
    suspend fun deleteById(id: Int)
}