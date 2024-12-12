package com.dikin.shoppingapp.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dikin.shoppingapp.daos.CartItemDao
import com.dikin.shoppingapp.daos.CategoryDao
import com.dikin.shoppingapp.daos.OrderDao
import com.dikin.shoppingapp.daos.OrderItemDao
import com.dikin.shoppingapp.daos.PaymentDao
import com.dikin.shoppingapp.daos.ProductDao
import com.dikin.shoppingapp.daos.ReviewDao
import com.dikin.shoppingapp.daos.ShoppingCartDao
import com.dikin.shoppingapp.daos.UserAddressDao
import com.dikin.shoppingapp.daos.UserDao
import com.dikin.shoppingapp.entities.CartItem
import com.dikin.shoppingapp.entities.Category
import com.dikin.shoppingapp.entities.Order
import com.dikin.shoppingapp.entities.OrderItem
import com.dikin.shoppingapp.entities.Payment
import com.dikin.shoppingapp.entities.Product
import com.dikin.shoppingapp.entities.Review
import com.dikin.shoppingapp.entities.ShoppingCart
import com.dikin.shoppingapp.entities.User
import com.dikin.shoppingapp.entities.UserAddress

@Database(
    entities = [
        CartItem::class,
        Category::class,
        Order::class,
        OrderItem::class,
        Payment::class,
        Product::class,
        Review::class,
        ShoppingCart::class,
        User::class,
        UserAddress::class
    ], version = 2, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartItemDao(): CartItemDao
    abstract fun categoryDao(): CategoryDao
    abstract fun orderDao(): OrderDao
    abstract fun orderItemDao(): OrderItemDao
    abstract fun paymentDao(): PaymentDao
    abstract fun productDao(): ProductDao
    abstract fun reviewDao(): ReviewDao
    abstract fun shoppingCartDao(): ShoppingCartDao
    abstract fun userDao(): UserDao
    abstract fun userAddressDao(): UserAddressDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}