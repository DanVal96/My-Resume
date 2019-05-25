package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(4);
        modelClasses.add(com.example.data.models.cache.RealmBasics.class);
        modelClasses.add(com.example.data.models.cache.RealmPastJob.class);
        modelClasses.add(com.example.data.models.cache.RealmResume.class);
        modelClasses.add(com.example.data.models.cache.RealmAbilities.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(4);
        infoMap.put(com.example.data.models.cache.RealmBasics.class, io.realm.RealmBasicsRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.example.data.models.cache.RealmPastJob.class, io.realm.RealmPastJobRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.example.data.models.cache.RealmResume.class, io.realm.RealmResumeRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.example.data.models.cache.RealmAbilities.class, io.realm.RealmAbilitiesRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
            return io.realm.RealmBasicsRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
            return io.realm.RealmPastJobRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
            return io.realm.RealmResumeRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
            return io.realm.RealmAbilitiesRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
            return io.realm.RealmBasicsRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
            return io.realm.RealmPastJobRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
            return io.realm.RealmResumeRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
            return io.realm.RealmAbilitiesRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
            return io.realm.RealmBasicsRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
            return io.realm.RealmPastJobRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
            return io.realm.RealmResumeRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
            return io.realm.RealmAbilitiesRealmProxy.getSimpleClassName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
                return clazz.cast(new io.realm.RealmBasicsRealmProxy());
            }
            if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
                return clazz.cast(new io.realm.RealmPastJobRealmProxy());
            }
            if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
                return clazz.cast(new io.realm.RealmResumeRealmProxy());
            }
            if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
                return clazz.cast(new io.realm.RealmAbilitiesRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
            return clazz.cast(io.realm.RealmBasicsRealmProxy.copyOrUpdate(realm, (com.example.data.models.cache.RealmBasics) obj, update, cache));
        }
        if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
            return clazz.cast(io.realm.RealmPastJobRealmProxy.copyOrUpdate(realm, (com.example.data.models.cache.RealmPastJob) obj, update, cache));
        }
        if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
            return clazz.cast(io.realm.RealmResumeRealmProxy.copyOrUpdate(realm, (com.example.data.models.cache.RealmResume) obj, update, cache));
        }
        if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
            return clazz.cast(io.realm.RealmAbilitiesRealmProxy.copyOrUpdate(realm, (com.example.data.models.cache.RealmAbilities) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
            io.realm.RealmBasicsRealmProxy.insert(realm, (com.example.data.models.cache.RealmBasics) object, cache);
        } else if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
            io.realm.RealmPastJobRealmProxy.insert(realm, (com.example.data.models.cache.RealmPastJob) object, cache);
        } else if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
            io.realm.RealmResumeRealmProxy.insert(realm, (com.example.data.models.cache.RealmResume) object, cache);
        } else if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
            io.realm.RealmAbilitiesRealmProxy.insert(realm, (com.example.data.models.cache.RealmAbilities) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
                io.realm.RealmBasicsRealmProxy.insert(realm, (com.example.data.models.cache.RealmBasics) object, cache);
            } else if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
                io.realm.RealmPastJobRealmProxy.insert(realm, (com.example.data.models.cache.RealmPastJob) object, cache);
            } else if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
                io.realm.RealmResumeRealmProxy.insert(realm, (com.example.data.models.cache.RealmResume) object, cache);
            } else if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
                io.realm.RealmAbilitiesRealmProxy.insert(realm, (com.example.data.models.cache.RealmAbilities) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
                    io.realm.RealmBasicsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
                    io.realm.RealmPastJobRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
                    io.realm.RealmResumeRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
                    io.realm.RealmAbilitiesRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
            io.realm.RealmBasicsRealmProxy.insertOrUpdate(realm, (com.example.data.models.cache.RealmBasics) obj, cache);
        } else if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
            io.realm.RealmPastJobRealmProxy.insertOrUpdate(realm, (com.example.data.models.cache.RealmPastJob) obj, cache);
        } else if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
            io.realm.RealmResumeRealmProxy.insertOrUpdate(realm, (com.example.data.models.cache.RealmResume) obj, cache);
        } else if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
            io.realm.RealmAbilitiesRealmProxy.insertOrUpdate(realm, (com.example.data.models.cache.RealmAbilities) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
                io.realm.RealmBasicsRealmProxy.insertOrUpdate(realm, (com.example.data.models.cache.RealmBasics) object, cache);
            } else if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
                io.realm.RealmPastJobRealmProxy.insertOrUpdate(realm, (com.example.data.models.cache.RealmPastJob) object, cache);
            } else if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
                io.realm.RealmResumeRealmProxy.insertOrUpdate(realm, (com.example.data.models.cache.RealmResume) object, cache);
            } else if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
                io.realm.RealmAbilitiesRealmProxy.insertOrUpdate(realm, (com.example.data.models.cache.RealmAbilities) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
                    io.realm.RealmBasicsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
                    io.realm.RealmPastJobRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
                    io.realm.RealmResumeRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
                    io.realm.RealmAbilitiesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
            return clazz.cast(io.realm.RealmBasicsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
            return clazz.cast(io.realm.RealmPastJobRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
            return clazz.cast(io.realm.RealmResumeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
            return clazz.cast(io.realm.RealmAbilitiesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
            return clazz.cast(io.realm.RealmBasicsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
            return clazz.cast(io.realm.RealmPastJobRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
            return clazz.cast(io.realm.RealmResumeRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
            return clazz.cast(io.realm.RealmAbilitiesRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.example.data.models.cache.RealmBasics.class)) {
            return clazz.cast(io.realm.RealmBasicsRealmProxy.createDetachedCopy((com.example.data.models.cache.RealmBasics) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.example.data.models.cache.RealmPastJob.class)) {
            return clazz.cast(io.realm.RealmPastJobRealmProxy.createDetachedCopy((com.example.data.models.cache.RealmPastJob) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.example.data.models.cache.RealmResume.class)) {
            return clazz.cast(io.realm.RealmResumeRealmProxy.createDetachedCopy((com.example.data.models.cache.RealmResume) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.example.data.models.cache.RealmAbilities.class)) {
            return clazz.cast(io.realm.RealmAbilitiesRealmProxy.createDetachedCopy((com.example.data.models.cache.RealmAbilities) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
