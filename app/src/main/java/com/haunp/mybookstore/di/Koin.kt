package com.haunp.mybookstore.di

import androidx.room.Room
import com.haunp.mybookstore.data.database.db.AppDatabase
import com.haunp.mybookstore.data.repository.AdminRepositoryImpl
import com.haunp.mybookstore.data.repository.UserRepositoryImpl
import com.haunp.mybookstore.domain.repository.IAdminRepository
import com.haunp.mybookstore.domain.repository.IUserRepository
import com.haunp.mybookstore.domain.usecase.AdminUseCase
import com.haunp.mybookstore.domain.usecase.LoginUseCase
import com.haunp.mybookstore.domain.usecase.RegisterUseCase
import com.haunp.mybookstore.presenters.fragment.admin.book.BookViewModel
import com.haunp.mybookstore.presenters.fragment.admin.category_admin.CategoryAdminViewModel
import com.haunp.mybookstore.presenters.fragment.admin.statistical.StatisticalViewModel
import com.haunp.mybookstore.presenters.fragment.admin.user.UserViewModel
import com.haunp.mybookstore.presenters.fragment.login.LoginViewModel
import com.haunp.mybookstore.presenters.fragment.register.RegisterViewModel
import com.haunp.mybookstore.presenters.fragment.user.category_user.CategoryUserViewModel
import com.haunp.mybookstore.presenters.fragment.user.home.HomeViewModel
import com.haunp.mybookstore.presenters.fragment.user.search.SearchViewModel
import com.haunp.mybookstore.presenters.fragment.user.setting.SettingViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            viewModelModule,
            useCaseModule,
            repositoryModule,
            databaseModule
        )
    }

var viewModelModule = module {
    viewModel { RegisterViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { BookViewModel(get(),get()) }
    viewModel { UserViewModel() }
    viewModel { CategoryAdminViewModel(get(),get()) }
    viewModel { StatisticalViewModel() }
    viewModel { CategoryUserViewModel() }
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel() }
    viewModel { SettingViewModel() }
}


var useCaseModule = module {
    factory { RegisterUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { AdminUseCase(get()) }
}

var repositoryModule = module {
    single<IUserRepository> { UserRepositoryImpl(get(),get()) }
    single<IAdminRepository> { AdminRepositoryImpl(get(),get(),get(),get())}
}

val databaseModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "app_database").build() }
    single { get<AppDatabase>().getUserDao() }
    single { get<AppDatabase>().getBookDao() }
    single { get<AppDatabase>().getCategoriesDao() }
    single { get<AppDatabase>().getCartDao() }
    single { get<AppDatabase>().getOrderDao() }
    single { get<AppDatabase>().getRateDao() }
}

