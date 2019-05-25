package io.realm;


public interface RealmAbilitiesRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$level();
    public void realmSet$level(String value);
    public RealmList<String> realmGet$keywords();
    public void realmSet$keywords(RealmList<String> value);
}
