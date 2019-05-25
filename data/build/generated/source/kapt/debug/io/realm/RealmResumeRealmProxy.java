package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class RealmResumeRealmProxy extends com.example.data.models.cache.RealmResume
    implements RealmObjectProxy, RealmResumeRealmProxyInterface {

    static final class RealmResumeColumnInfo extends ColumnInfo {
        long idIndex;
        long basicsIndex;
        long pastJobIndex;
        long skillsIndex;

        RealmResumeColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmResume");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.basicsIndex = addColumnDetails("basics", objectSchemaInfo);
            this.pastJobIndex = addColumnDetails("pastJob", objectSchemaInfo);
            this.skillsIndex = addColumnDetails("skills", objectSchemaInfo);
        }

        RealmResumeColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmResumeColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmResumeColumnInfo src = (RealmResumeColumnInfo) rawSrc;
            final RealmResumeColumnInfo dst = (RealmResumeColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.basicsIndex = src.basicsIndex;
            dst.pastJobIndex = src.pastJobIndex;
            dst.skillsIndex = src.skillsIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(4);
        fieldNames.add("id");
        fieldNames.add("basics");
        fieldNames.add("pastJob");
        fieldNames.add("skills");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmResumeColumnInfo columnInfo;
    private ProxyState<com.example.data.models.cache.RealmResume> proxyState;
    private RealmList<com.example.data.models.cache.RealmPastJob> pastJobRealmList;
    private RealmList<com.example.data.models.cache.RealmAbilities> skillsRealmList;

    RealmResumeRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmResumeColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.data.models.cache.RealmResume>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    public com.example.data.models.cache.RealmBasics realmGet$basics() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.basicsIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.data.models.cache.RealmBasics.class, proxyState.getRow$realm().getLink(columnInfo.basicsIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$basics(com.example.data.models.cache.RealmBasics value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("basics")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.basicsIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.basicsIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.basicsIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.basicsIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public RealmList<com.example.data.models.cache.RealmPastJob> realmGet$pastJob() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (pastJobRealmList != null) {
            return pastJobRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.pastJobIndex);
            pastJobRealmList = new RealmList<com.example.data.models.cache.RealmPastJob>(com.example.data.models.cache.RealmPastJob.class, osList, proxyState.getRealm$realm());
            return pastJobRealmList;
        }
    }

    @Override
    public void realmSet$pastJob(RealmList<com.example.data.models.cache.RealmPastJob> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("pastJob")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.data.models.cache.RealmPastJob> original = value;
                value = new RealmList<com.example.data.models.cache.RealmPastJob>();
                for (com.example.data.models.cache.RealmPastJob item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.pastJobIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.example.data.models.cache.RealmPastJob linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.example.data.models.cache.RealmPastJob linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public RealmList<com.example.data.models.cache.RealmAbilities> realmGet$skills() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (skillsRealmList != null) {
            return skillsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.skillsIndex);
            skillsRealmList = new RealmList<com.example.data.models.cache.RealmAbilities>(com.example.data.models.cache.RealmAbilities.class, osList, proxyState.getRealm$realm());
            return skillsRealmList;
        }
    }

    @Override
    public void realmSet$skills(RealmList<com.example.data.models.cache.RealmAbilities> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("skills")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.data.models.cache.RealmAbilities> original = value;
                value = new RealmList<com.example.data.models.cache.RealmAbilities>();
                for (com.example.data.models.cache.RealmAbilities item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.skillsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.example.data.models.cache.RealmAbilities linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.example.data.models.cache.RealmAbilities linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmResume", 4, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("basics", RealmFieldType.OBJECT, "RealmBasics");
        builder.addPersistedLinkProperty("pastJob", RealmFieldType.LIST, "RealmPastJob");
        builder.addPersistedLinkProperty("skills", RealmFieldType.LIST, "RealmAbilities");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmResumeColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmResumeColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmResume";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.data.models.cache.RealmResume createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(3);
        com.example.data.models.cache.RealmResume obj = null;
        if (update) {
            Table table = realm.getTable(com.example.data.models.cache.RealmResume.class);
            RealmResumeColumnInfo columnInfo = (RealmResumeColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmResume.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmResume.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmResumeRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("basics")) {
                excludeFields.add("basics");
            }
            if (json.has("pastJob")) {
                excludeFields.add("pastJob");
            }
            if (json.has("skills")) {
                excludeFields.add("skills");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.RealmResumeRealmProxy) realm.createObjectInternal(com.example.data.models.cache.RealmResume.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmResumeRealmProxy) realm.createObjectInternal(com.example.data.models.cache.RealmResume.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final RealmResumeRealmProxyInterface objProxy = (RealmResumeRealmProxyInterface) obj;
        if (json.has("basics")) {
            if (json.isNull("basics")) {
                objProxy.realmSet$basics(null);
            } else {
                com.example.data.models.cache.RealmBasics basicsObj = RealmBasicsRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("basics"), update);
                objProxy.realmSet$basics(basicsObj);
            }
        }
        if (json.has("pastJob")) {
            if (json.isNull("pastJob")) {
                objProxy.realmSet$pastJob(null);
            } else {
                objProxy.realmGet$pastJob().clear();
                JSONArray array = json.getJSONArray("pastJob");
                for (int i = 0; i < array.length(); i++) {
                    com.example.data.models.cache.RealmPastJob item = RealmPastJobRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$pastJob().add(item);
                }
            }
        }
        if (json.has("skills")) {
            if (json.isNull("skills")) {
                objProxy.realmSet$skills(null);
            } else {
                objProxy.realmGet$skills().clear();
                JSONArray array = json.getJSONArray("skills");
                for (int i = 0; i < array.length(); i++) {
                    com.example.data.models.cache.RealmAbilities item = RealmAbilitiesRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$skills().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.data.models.cache.RealmResume createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.data.models.cache.RealmResume obj = new com.example.data.models.cache.RealmResume();
        final RealmResumeRealmProxyInterface objProxy = (RealmResumeRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("basics")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$basics(null);
                } else {
                    com.example.data.models.cache.RealmBasics basicsObj = RealmBasicsRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$basics(basicsObj);
                }
            } else if (name.equals("pastJob")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$pastJob(null);
                } else {
                    objProxy.realmSet$pastJob(new RealmList<com.example.data.models.cache.RealmPastJob>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.data.models.cache.RealmPastJob item = RealmPastJobRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$pastJob().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("skills")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$skills(null);
                } else {
                    objProxy.realmSet$skills(new RealmList<com.example.data.models.cache.RealmAbilities>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.data.models.cache.RealmAbilities item = RealmAbilitiesRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$skills().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.example.data.models.cache.RealmResume copyOrUpdate(Realm realm, com.example.data.models.cache.RealmResume object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.data.models.cache.RealmResume) cachedRealmObject;
        }

        com.example.data.models.cache.RealmResume realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.data.models.cache.RealmResume.class);
            RealmResumeColumnInfo columnInfo = (RealmResumeColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmResume.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstString(pkColumnIndex, ((RealmResumeRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmResume.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmResumeRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.example.data.models.cache.RealmResume copy(Realm realm, com.example.data.models.cache.RealmResume newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.data.models.cache.RealmResume) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.data.models.cache.RealmResume realmObject = realm.createObjectInternal(com.example.data.models.cache.RealmResume.class, ((RealmResumeRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmResumeRealmProxyInterface realmObjectSource = (RealmResumeRealmProxyInterface) newObject;
        RealmResumeRealmProxyInterface realmObjectCopy = (RealmResumeRealmProxyInterface) realmObject;


        com.example.data.models.cache.RealmBasics basicsObj = realmObjectSource.realmGet$basics();
        if (basicsObj == null) {
            realmObjectCopy.realmSet$basics(null);
        } else {
            com.example.data.models.cache.RealmBasics cachebasics = (com.example.data.models.cache.RealmBasics) cache.get(basicsObj);
            if (cachebasics != null) {
                realmObjectCopy.realmSet$basics(cachebasics);
            } else {
                realmObjectCopy.realmSet$basics(RealmBasicsRealmProxy.copyOrUpdate(realm, basicsObj, update, cache));
            }
        }

        RealmList<com.example.data.models.cache.RealmPastJob> pastJobList = realmObjectSource.realmGet$pastJob();
        if (pastJobList != null) {
            RealmList<com.example.data.models.cache.RealmPastJob> pastJobRealmList = realmObjectCopy.realmGet$pastJob();
            pastJobRealmList.clear();
            for (int i = 0; i < pastJobList.size(); i++) {
                com.example.data.models.cache.RealmPastJob pastJobItem = pastJobList.get(i);
                com.example.data.models.cache.RealmPastJob cachepastJob = (com.example.data.models.cache.RealmPastJob) cache.get(pastJobItem);
                if (cachepastJob != null) {
                    pastJobRealmList.add(cachepastJob);
                } else {
                    pastJobRealmList.add(RealmPastJobRealmProxy.copyOrUpdate(realm, pastJobItem, update, cache));
                }
            }
        }


        RealmList<com.example.data.models.cache.RealmAbilities> skillsList = realmObjectSource.realmGet$skills();
        if (skillsList != null) {
            RealmList<com.example.data.models.cache.RealmAbilities> skillsRealmList = realmObjectCopy.realmGet$skills();
            skillsRealmList.clear();
            for (int i = 0; i < skillsList.size(); i++) {
                com.example.data.models.cache.RealmAbilities skillsItem = skillsList.get(i);
                com.example.data.models.cache.RealmAbilities cacheskills = (com.example.data.models.cache.RealmAbilities) cache.get(skillsItem);
                if (cacheskills != null) {
                    skillsRealmList.add(cacheskills);
                } else {
                    skillsRealmList.add(RealmAbilitiesRealmProxy.copyOrUpdate(realm, skillsItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, com.example.data.models.cache.RealmResume object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.data.models.cache.RealmResume.class);
        long tableNativePtr = table.getNativePtr();
        RealmResumeColumnInfo columnInfo = (RealmResumeColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmResume.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((RealmResumeRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);

        com.example.data.models.cache.RealmBasics basicsObj = ((RealmResumeRealmProxyInterface) object).realmGet$basics();
        if (basicsObj != null) {
            Long cachebasics = cache.get(basicsObj);
            if (cachebasics == null) {
                cachebasics = RealmBasicsRealmProxy.insert(realm, basicsObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.basicsIndex, rowIndex, cachebasics, false);
        }

        RealmList<com.example.data.models.cache.RealmPastJob> pastJobList = ((RealmResumeRealmProxyInterface) object).realmGet$pastJob();
        if (pastJobList != null) {
            OsList pastJobOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.pastJobIndex);
            for (com.example.data.models.cache.RealmPastJob pastJobItem : pastJobList) {
                Long cacheItemIndexpastJob = cache.get(pastJobItem);
                if (cacheItemIndexpastJob == null) {
                    cacheItemIndexpastJob = RealmPastJobRealmProxy.insert(realm, pastJobItem, cache);
                }
                pastJobOsList.addRow(cacheItemIndexpastJob);
            }
        }

        RealmList<com.example.data.models.cache.RealmAbilities> skillsList = ((RealmResumeRealmProxyInterface) object).realmGet$skills();
        if (skillsList != null) {
            OsList skillsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.skillsIndex);
            for (com.example.data.models.cache.RealmAbilities skillsItem : skillsList) {
                Long cacheItemIndexskills = cache.get(skillsItem);
                if (cacheItemIndexskills == null) {
                    cacheItemIndexskills = RealmAbilitiesRealmProxy.insert(realm, skillsItem, cache);
                }
                skillsOsList.addRow(cacheItemIndexskills);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.data.models.cache.RealmResume.class);
        long tableNativePtr = table.getNativePtr();
        RealmResumeColumnInfo columnInfo = (RealmResumeColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmResume.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.data.models.cache.RealmResume object = null;
        while (objects.hasNext()) {
            object = (com.example.data.models.cache.RealmResume) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((RealmResumeRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);

            com.example.data.models.cache.RealmBasics basicsObj = ((RealmResumeRealmProxyInterface) object).realmGet$basics();
            if (basicsObj != null) {
                Long cachebasics = cache.get(basicsObj);
                if (cachebasics == null) {
                    cachebasics = RealmBasicsRealmProxy.insert(realm, basicsObj, cache);
                }
                table.setLink(columnInfo.basicsIndex, rowIndex, cachebasics, false);
            }

            RealmList<com.example.data.models.cache.RealmPastJob> pastJobList = ((RealmResumeRealmProxyInterface) object).realmGet$pastJob();
            if (pastJobList != null) {
                OsList pastJobOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.pastJobIndex);
                for (com.example.data.models.cache.RealmPastJob pastJobItem : pastJobList) {
                    Long cacheItemIndexpastJob = cache.get(pastJobItem);
                    if (cacheItemIndexpastJob == null) {
                        cacheItemIndexpastJob = RealmPastJobRealmProxy.insert(realm, pastJobItem, cache);
                    }
                    pastJobOsList.addRow(cacheItemIndexpastJob);
                }
            }

            RealmList<com.example.data.models.cache.RealmAbilities> skillsList = ((RealmResumeRealmProxyInterface) object).realmGet$skills();
            if (skillsList != null) {
                OsList skillsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.skillsIndex);
                for (com.example.data.models.cache.RealmAbilities skillsItem : skillsList) {
                    Long cacheItemIndexskills = cache.get(skillsItem);
                    if (cacheItemIndexskills == null) {
                        cacheItemIndexskills = RealmAbilitiesRealmProxy.insert(realm, skillsItem, cache);
                    }
                    skillsOsList.addRow(cacheItemIndexskills);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.data.models.cache.RealmResume object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.data.models.cache.RealmResume.class);
        long tableNativePtr = table.getNativePtr();
        RealmResumeColumnInfo columnInfo = (RealmResumeColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmResume.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((RealmResumeRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);

        com.example.data.models.cache.RealmBasics basicsObj = ((RealmResumeRealmProxyInterface) object).realmGet$basics();
        if (basicsObj != null) {
            Long cachebasics = cache.get(basicsObj);
            if (cachebasics == null) {
                cachebasics = RealmBasicsRealmProxy.insertOrUpdate(realm, basicsObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.basicsIndex, rowIndex, cachebasics, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.basicsIndex, rowIndex);
        }

        OsList pastJobOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.pastJobIndex);
        RealmList<com.example.data.models.cache.RealmPastJob> pastJobList = ((RealmResumeRealmProxyInterface) object).realmGet$pastJob();
        if (pastJobList != null && pastJobList.size() == pastJobOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = pastJobList.size();
            for (int i = 0; i < objects; i++) {
                com.example.data.models.cache.RealmPastJob pastJobItem = pastJobList.get(i);
                Long cacheItemIndexpastJob = cache.get(pastJobItem);
                if (cacheItemIndexpastJob == null) {
                    cacheItemIndexpastJob = RealmPastJobRealmProxy.insertOrUpdate(realm, pastJobItem, cache);
                }
                pastJobOsList.setRow(i, cacheItemIndexpastJob);
            }
        } else {
            pastJobOsList.removeAll();
            if (pastJobList != null) {
                for (com.example.data.models.cache.RealmPastJob pastJobItem : pastJobList) {
                    Long cacheItemIndexpastJob = cache.get(pastJobItem);
                    if (cacheItemIndexpastJob == null) {
                        cacheItemIndexpastJob = RealmPastJobRealmProxy.insertOrUpdate(realm, pastJobItem, cache);
                    }
                    pastJobOsList.addRow(cacheItemIndexpastJob);
                }
            }
        }


        OsList skillsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.skillsIndex);
        RealmList<com.example.data.models.cache.RealmAbilities> skillsList = ((RealmResumeRealmProxyInterface) object).realmGet$skills();
        if (skillsList != null && skillsList.size() == skillsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = skillsList.size();
            for (int i = 0; i < objects; i++) {
                com.example.data.models.cache.RealmAbilities skillsItem = skillsList.get(i);
                Long cacheItemIndexskills = cache.get(skillsItem);
                if (cacheItemIndexskills == null) {
                    cacheItemIndexskills = RealmAbilitiesRealmProxy.insertOrUpdate(realm, skillsItem, cache);
                }
                skillsOsList.setRow(i, cacheItemIndexskills);
            }
        } else {
            skillsOsList.removeAll();
            if (skillsList != null) {
                for (com.example.data.models.cache.RealmAbilities skillsItem : skillsList) {
                    Long cacheItemIndexskills = cache.get(skillsItem);
                    if (cacheItemIndexskills == null) {
                        cacheItemIndexskills = RealmAbilitiesRealmProxy.insertOrUpdate(realm, skillsItem, cache);
                    }
                    skillsOsList.addRow(cacheItemIndexskills);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.data.models.cache.RealmResume.class);
        long tableNativePtr = table.getNativePtr();
        RealmResumeColumnInfo columnInfo = (RealmResumeColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmResume.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.data.models.cache.RealmResume object = null;
        while (objects.hasNext()) {
            object = (com.example.data.models.cache.RealmResume) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((RealmResumeRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);

            com.example.data.models.cache.RealmBasics basicsObj = ((RealmResumeRealmProxyInterface) object).realmGet$basics();
            if (basicsObj != null) {
                Long cachebasics = cache.get(basicsObj);
                if (cachebasics == null) {
                    cachebasics = RealmBasicsRealmProxy.insertOrUpdate(realm, basicsObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.basicsIndex, rowIndex, cachebasics, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.basicsIndex, rowIndex);
            }

            OsList pastJobOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.pastJobIndex);
            RealmList<com.example.data.models.cache.RealmPastJob> pastJobList = ((RealmResumeRealmProxyInterface) object).realmGet$pastJob();
            if (pastJobList != null && pastJobList.size() == pastJobOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = pastJobList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.example.data.models.cache.RealmPastJob pastJobItem = pastJobList.get(i);
                    Long cacheItemIndexpastJob = cache.get(pastJobItem);
                    if (cacheItemIndexpastJob == null) {
                        cacheItemIndexpastJob = RealmPastJobRealmProxy.insertOrUpdate(realm, pastJobItem, cache);
                    }
                    pastJobOsList.setRow(i, cacheItemIndexpastJob);
                }
            } else {
                pastJobOsList.removeAll();
                if (pastJobList != null) {
                    for (com.example.data.models.cache.RealmPastJob pastJobItem : pastJobList) {
                        Long cacheItemIndexpastJob = cache.get(pastJobItem);
                        if (cacheItemIndexpastJob == null) {
                            cacheItemIndexpastJob = RealmPastJobRealmProxy.insertOrUpdate(realm, pastJobItem, cache);
                        }
                        pastJobOsList.addRow(cacheItemIndexpastJob);
                    }
                }
            }


            OsList skillsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.skillsIndex);
            RealmList<com.example.data.models.cache.RealmAbilities> skillsList = ((RealmResumeRealmProxyInterface) object).realmGet$skills();
            if (skillsList != null && skillsList.size() == skillsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = skillsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.example.data.models.cache.RealmAbilities skillsItem = skillsList.get(i);
                    Long cacheItemIndexskills = cache.get(skillsItem);
                    if (cacheItemIndexskills == null) {
                        cacheItemIndexskills = RealmAbilitiesRealmProxy.insertOrUpdate(realm, skillsItem, cache);
                    }
                    skillsOsList.setRow(i, cacheItemIndexskills);
                }
            } else {
                skillsOsList.removeAll();
                if (skillsList != null) {
                    for (com.example.data.models.cache.RealmAbilities skillsItem : skillsList) {
                        Long cacheItemIndexskills = cache.get(skillsItem);
                        if (cacheItemIndexskills == null) {
                            cacheItemIndexskills = RealmAbilitiesRealmProxy.insertOrUpdate(realm, skillsItem, cache);
                        }
                        skillsOsList.addRow(cacheItemIndexskills);
                    }
                }
            }

        }
    }

    public static com.example.data.models.cache.RealmResume createDetachedCopy(com.example.data.models.cache.RealmResume realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.data.models.cache.RealmResume unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.data.models.cache.RealmResume();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.data.models.cache.RealmResume) cachedObject.object;
            }
            unmanagedObject = (com.example.data.models.cache.RealmResume) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmResumeRealmProxyInterface unmanagedCopy = (RealmResumeRealmProxyInterface) unmanagedObject;
        RealmResumeRealmProxyInterface realmSource = (RealmResumeRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());

        // Deep copy of basics
        unmanagedCopy.realmSet$basics(RealmBasicsRealmProxy.createDetachedCopy(realmSource.realmGet$basics(), currentDepth + 1, maxDepth, cache));

        // Deep copy of pastJob
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$pastJob(null);
        } else {
            RealmList<com.example.data.models.cache.RealmPastJob> managedpastJobList = realmSource.realmGet$pastJob();
            RealmList<com.example.data.models.cache.RealmPastJob> unmanagedpastJobList = new RealmList<com.example.data.models.cache.RealmPastJob>();
            unmanagedCopy.realmSet$pastJob(unmanagedpastJobList);
            int nextDepth = currentDepth + 1;
            int size = managedpastJobList.size();
            for (int i = 0; i < size; i++) {
                com.example.data.models.cache.RealmPastJob item = RealmPastJobRealmProxy.createDetachedCopy(managedpastJobList.get(i), nextDepth, maxDepth, cache);
                unmanagedpastJobList.add(item);
            }
        }

        // Deep copy of skills
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$skills(null);
        } else {
            RealmList<com.example.data.models.cache.RealmAbilities> managedskillsList = realmSource.realmGet$skills();
            RealmList<com.example.data.models.cache.RealmAbilities> unmanagedskillsList = new RealmList<com.example.data.models.cache.RealmAbilities>();
            unmanagedCopy.realmSet$skills(unmanagedskillsList);
            int nextDepth = currentDepth + 1;
            int size = managedskillsList.size();
            for (int i = 0; i < size; i++) {
                com.example.data.models.cache.RealmAbilities item = RealmAbilitiesRealmProxy.createDetachedCopy(managedskillsList.get(i), nextDepth, maxDepth, cache);
                unmanagedskillsList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.example.data.models.cache.RealmResume update(Realm realm, com.example.data.models.cache.RealmResume realmObject, com.example.data.models.cache.RealmResume newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmResumeRealmProxyInterface realmObjectTarget = (RealmResumeRealmProxyInterface) realmObject;
        RealmResumeRealmProxyInterface realmObjectSource = (RealmResumeRealmProxyInterface) newObject;
        com.example.data.models.cache.RealmBasics basicsObj = realmObjectSource.realmGet$basics();
        if (basicsObj == null) {
            realmObjectTarget.realmSet$basics(null);
        } else {
            com.example.data.models.cache.RealmBasics cachebasics = (com.example.data.models.cache.RealmBasics) cache.get(basicsObj);
            if (cachebasics != null) {
                realmObjectTarget.realmSet$basics(cachebasics);
            } else {
                realmObjectTarget.realmSet$basics(RealmBasicsRealmProxy.copyOrUpdate(realm, basicsObj, true, cache));
            }
        }
        RealmList<com.example.data.models.cache.RealmPastJob> pastJobList = realmObjectSource.realmGet$pastJob();
        RealmList<com.example.data.models.cache.RealmPastJob> pastJobRealmList = realmObjectTarget.realmGet$pastJob();
        if (pastJobList != null && pastJobList.size() == pastJobRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = pastJobList.size();
            for (int i = 0; i < objects; i++) {
                com.example.data.models.cache.RealmPastJob pastJobItem = pastJobList.get(i);
                com.example.data.models.cache.RealmPastJob cachepastJob = (com.example.data.models.cache.RealmPastJob) cache.get(pastJobItem);
                if (cachepastJob != null) {
                    pastJobRealmList.set(i, cachepastJob);
                } else {
                    pastJobRealmList.set(i, RealmPastJobRealmProxy.copyOrUpdate(realm, pastJobItem, true, cache));
                }
            }
        } else {
            pastJobRealmList.clear();
            if (pastJobList != null) {
                for (int i = 0; i < pastJobList.size(); i++) {
                    com.example.data.models.cache.RealmPastJob pastJobItem = pastJobList.get(i);
                    com.example.data.models.cache.RealmPastJob cachepastJob = (com.example.data.models.cache.RealmPastJob) cache.get(pastJobItem);
                    if (cachepastJob != null) {
                        pastJobRealmList.add(cachepastJob);
                    } else {
                        pastJobRealmList.add(RealmPastJobRealmProxy.copyOrUpdate(realm, pastJobItem, true, cache));
                    }
                }
            }
        }
        RealmList<com.example.data.models.cache.RealmAbilities> skillsList = realmObjectSource.realmGet$skills();
        RealmList<com.example.data.models.cache.RealmAbilities> skillsRealmList = realmObjectTarget.realmGet$skills();
        if (skillsList != null && skillsList.size() == skillsRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = skillsList.size();
            for (int i = 0; i < objects; i++) {
                com.example.data.models.cache.RealmAbilities skillsItem = skillsList.get(i);
                com.example.data.models.cache.RealmAbilities cacheskills = (com.example.data.models.cache.RealmAbilities) cache.get(skillsItem);
                if (cacheskills != null) {
                    skillsRealmList.set(i, cacheskills);
                } else {
                    skillsRealmList.set(i, RealmAbilitiesRealmProxy.copyOrUpdate(realm, skillsItem, true, cache));
                }
            }
        } else {
            skillsRealmList.clear();
            if (skillsList != null) {
                for (int i = 0; i < skillsList.size(); i++) {
                    com.example.data.models.cache.RealmAbilities skillsItem = skillsList.get(i);
                    com.example.data.models.cache.RealmAbilities cacheskills = (com.example.data.models.cache.RealmAbilities) cache.get(skillsItem);
                    if (cacheskills != null) {
                        skillsRealmList.add(cacheskills);
                    } else {
                        skillsRealmList.add(RealmAbilitiesRealmProxy.copyOrUpdate(realm, skillsItem, true, cache));
                    }
                }
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmResume = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{basics:");
        stringBuilder.append(realmGet$basics() != null ? "RealmBasics" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pastJob:");
        stringBuilder.append("RealmList<RealmPastJob>[").append(realmGet$pastJob().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{skills:");
        stringBuilder.append("RealmList<RealmAbilities>[").append(realmGet$skills().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealmResumeRealmProxy aRealmResume = (RealmResumeRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmResume.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmResume.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmResume.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
