// Generated by Dagger (https://google.github.io/dagger).
package com.example.data.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public final class ApiModule_ProvidesRetrofitFactory implements Factory<Retrofit> {
  private final ApiModule module;

  private final Provider<Gson> gsonProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<RxJava2CallAdapterFactory> rx2AdapterFactoryProvider;

  public ApiModule_ProvidesRetrofitFactory(
      ApiModule module,
      Provider<Gson> gsonProvider,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<RxJava2CallAdapterFactory> rx2AdapterFactoryProvider) {
    this.module = module;
    this.gsonProvider = gsonProvider;
    this.okHttpClientProvider = okHttpClientProvider;
    this.rx2AdapterFactoryProvider = rx2AdapterFactoryProvider;
  }

  @Override
  public Retrofit get() {
    return provideInstance(module, gsonProvider, okHttpClientProvider, rx2AdapterFactoryProvider);
  }

  public static Retrofit provideInstance(
      ApiModule module,
      Provider<Gson> gsonProvider,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<RxJava2CallAdapterFactory> rx2AdapterFactoryProvider) {
    return proxyProvidesRetrofit(
        module, gsonProvider.get(), okHttpClientProvider.get(), rx2AdapterFactoryProvider.get());
  }

  public static ApiModule_ProvidesRetrofitFactory create(
      ApiModule module,
      Provider<Gson> gsonProvider,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<RxJava2CallAdapterFactory> rx2AdapterFactoryProvider) {
    return new ApiModule_ProvidesRetrofitFactory(
        module, gsonProvider, okHttpClientProvider, rx2AdapterFactoryProvider);
  }

  public static Retrofit proxyProvidesRetrofit(
      ApiModule instance,
      Gson gson,
      OkHttpClient okHttpClient,
      RxJava2CallAdapterFactory rx2AdapterFactory) {
    return Preconditions.checkNotNull(
        instance.providesRetrofit(gson, okHttpClient, rx2AdapterFactory),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
