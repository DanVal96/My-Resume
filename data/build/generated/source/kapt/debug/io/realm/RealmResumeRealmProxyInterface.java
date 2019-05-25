package io.realm;


public interface RealmResumeRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public com.example.data.models.cache.RealmBasics realmGet$basics();
    public void realmSet$basics(com.example.data.models.cache.RealmBasics value);
    public RealmList<com.example.data.models.cache.RealmPastJob> realmGet$pastJob();
    public void realmSet$pastJob(RealmList<com.example.data.models.cache.RealmPastJob> value);
    public RealmList<com.example.data.models.cache.RealmAbilities> realmGet$skills();
    public void realmSet$skills(RealmList<com.example.data.models.cache.RealmAbilities> value);
}
