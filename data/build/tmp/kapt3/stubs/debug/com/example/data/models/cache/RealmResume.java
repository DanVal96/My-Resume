package com.example.data.models.cache;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\tB\u0005\u00a2\u0006\u0002\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/example/data/models/cache/RealmResume;", "Lio/realm/RealmObject;", "basics", "Lcom/example/data/models/cache/RealmBasics;", "pastJobs", "Lio/realm/RealmList;", "Lcom/example/data/models/cache/RealmPastJob;", "skills", "Lcom/example/data/models/cache/RealmAbilities;", "(Lcom/example/data/models/cache/RealmBasics;Lio/realm/RealmList;Lio/realm/RealmList;)V", "()V", "getBasics", "()Lcom/example/data/models/cache/RealmBasics;", "setBasics", "(Lcom/example/data/models/cache/RealmBasics;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "pastJob", "getPastJob", "()Lio/realm/RealmList;", "setPastJob", "(Lio/realm/RealmList;)V", "getSkills", "setSkills", "data_debug"})
public class RealmResume extends io.realm.RealmObject {
    @org.jetbrains.annotations.NotNull()
    @io.realm.annotations.PrimaryKey()
    private java.lang.String id;
    @org.jetbrains.annotations.Nullable()
    private com.example.data.models.cache.RealmBasics basics;
    @org.jetbrains.annotations.NotNull()
    private io.realm.RealmList<com.example.data.models.cache.RealmPastJob> pastJob;
    @org.jetbrains.annotations.NotNull()
    private io.realm.RealmList<com.example.data.models.cache.RealmAbilities> skills;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.models.cache.RealmBasics getBasics() {
        return null;
    }
    
    public final void setBasics(@org.jetbrains.annotations.Nullable()
    com.example.data.models.cache.RealmBasics p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.realm.RealmList<com.example.data.models.cache.RealmPastJob> getPastJob() {
        return null;
    }
    
    public final void setPastJob(@org.jetbrains.annotations.NotNull()
    io.realm.RealmList<com.example.data.models.cache.RealmPastJob> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.realm.RealmList<com.example.data.models.cache.RealmAbilities> getSkills() {
        return null;
    }
    
    public final void setSkills(@org.jetbrains.annotations.NotNull()
    io.realm.RealmList<com.example.data.models.cache.RealmAbilities> p0) {
    }
    
    public RealmResume() {
        super();
    }
    
    public RealmResume(@org.jetbrains.annotations.NotNull()
    com.example.data.models.cache.RealmBasics basics, @org.jetbrains.annotations.NotNull()
    io.realm.RealmList<com.example.data.models.cache.RealmPastJob> pastJobs, @org.jetbrains.annotations.NotNull()
    io.realm.RealmList<com.example.data.models.cache.RealmAbilities> skills) {
        super();
    }
}