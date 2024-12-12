package com.dikin.shoppingapp.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dikin.shoppingapp.entities.Product
import com.dikin.shoppingapp.models.ProductWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("""
        select p.productId, p.name, p.description, p.price, p.imageUrl, p.categoryId,
               c.categoryName
        from products p
        inner join categories c on p.categoryId = c.categoryId
    """)
    fun getAll(): Flow<List<ProductWithCategory>>

    @Query("""
        select p.productId, p.name, p.description, p.price, p.imageUrl, p.categoryId,
               c.categoryName
        from products p
        inner join categories c on p.categoryId = c.categoryId
        where p.productId = :id
    """)
    fun getById(id: Long): ProductWithCategory?

    @Insert
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("delete from products where productId = :id")
    suspend fun deleteById(id: Long)
}