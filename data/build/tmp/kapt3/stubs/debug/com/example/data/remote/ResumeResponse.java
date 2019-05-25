package com.example.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005H\u00c6\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/example/data/remote/ResumeResponse;", "", "basics", "Lcom/example/data/models/Basics;", "pastJob", "", "Lcom/example/data/models/PastJob;", "abilities", "Lcom/example/data/models/Abilities;", "(Lcom/example/data/models/Basics;Ljava/util/List;Ljava/util/List;)V", "getAbilities", "()Ljava/util/List;", "getBasics", "()Lcom/example/data/models/Basics;", "getPastJob", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "data_debug"})
public final class ResumeResponse {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "basics")
    private final com.example.data.models.Basics basics = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "pastJob")
    private final java.util.List<com.example.data.models.PastJob> pastJob = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "abilities")
    private final java.util.List<com.example.data.models.Abilities> abilities = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.models.Basics getBasics() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.data.models.PastJob> getPastJob() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.data.models.Abilities> getAbilities() {
        return null;
    }
    
    public ResumeResponse(@org.jetbrains.annotations.Nullable()
    com.example.data.models.Basics basics, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.data.models.PastJob> pastJob, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.data.models.Abilities> abilities) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.models.Basics component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.data.models.PastJob> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.data.models.Abilities> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.remote.ResumeResponse copy(@org.jetbrains.annotations.Nullable()
    com.example.data.models.Basics basics, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.data.models.PastJob> pastJob, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.data.models.Abilities> abilities) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}