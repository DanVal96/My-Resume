// Generated by Dagger (https://google.github.io/dagger).
package com.example.data.di;

import com.example.myresume.domain.executor.UiThreadExecutor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class DataModule_ProvidesPostExecutionThreadFactory
    implements Factory<UiThreadExecutor> {
  private final DataModule module;

  public DataModule_ProvidesPostExecutionThreadFactory(DataModule module) {
    this.module = module;
  }

  @Override
  public UiThreadExecutor get() {
    return provideInstance(module);
  }

  public static UiThreadExecutor provideInstance(DataModule module) {
    return proxyProvidesPostExecutionThread(module);
  }

  public static DataModule_ProvidesPostExecutionThreadFactory create(DataModule module) {
    return new DataModule_ProvidesPostExecutionThreadFactory(module);
  }

  public static UiThreadExecutor proxyProvidesPostExecutionThread(DataModule instance) {
    return Preconditions.checkNotNull(
        instance.providesPostExecutionThread(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
