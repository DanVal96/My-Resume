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
public class RealmPastJobRealmProxy extends com.example.data.models.cache.RealmPastJob
    implements RealmObjectProxy, RealmPastJobRealmProxyInterface {

    static final class RealmPastJobColumnInfo extends ColumnInfo {
        long idIndex;
        long companyIndex;
        long positionIndex;
        long urlImageIndex;
        long startDateIndex;
        long endDateIndex;
        long summaryIndex;

        RealmPastJobColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmPastJob");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.companyIndex = addColumnDetails("company", objectSchemaInfo);
            this.positionIndex = addColumnDetails("position", objectSchemaInfo);
            this.urlImageIndex = addColumnDetails("urlImage", objectSchemaInfo);
            this.startDateIndex = addColumnDetails("startDate", objectSchemaInfo);
            this.endDateIndex = addColumnDetails("endDate", objectSchemaInfo);
            this.summaryIndex = addColumnDetails("summary", objectSchemaInfo);
        }

        RealmPastJobColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmPastJobColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmPastJobColumnInfo src = (RealmPastJobColumnInfo) rawSrc;
            final RealmPastJobColumnInfo dst = (RealmPastJobColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.companyIndex = src.companyIndex;
            dst.positionIndex = src.positionIndex;
            dst.urlImageIndex = src.urlImageIndex;
            dst.startDateIndex = src.startDateIndex;
            dst.endDateIndex = src.endDateIndex;
            dst.summaryIndex = src.summaryIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(7);
        fieldNames.add("id");
        fieldNames.add("company");
        fieldNames.add("position");
        fieldNames.add("urlImage");
        fieldNames.add("startDate");
        fieldNames.add("endDate");
        fieldNames.add("summary");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmPastJobColumnInfo columnInfo;
    private ProxyState<com.example.data.models.cache.RealmPastJob> proxyState;

    RealmPastJobRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmPastJobColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.data.models.cache.RealmPastJob>(this);
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
    @SuppressWarnings("cast")
    public String realmGet$company() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.companyIndex);
    }

    @Override
    public void realmSet$company(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'company' to null.");
            }
            row.getTable().setString(columnInfo.companyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'company' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.companyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$position() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.positionIndex);
    }

    @Override
    public void realmSet$position(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'position' to null.");
            }
            row.getTable().setString(columnInfo.positionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'position' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.positionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$urlImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlImageIndex);
    }

    @Override
    public void realmSet$urlImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'urlImage' to null.");
            }
            row.getTable().setString(columnInfo.urlImageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'urlImage' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.urlImageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$startDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.startDateIndex);
    }

    @Override
    public void realmSet$startDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'startDate' to null.");
            }
            row.getTable().setString(columnInfo.startDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'startDate' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.startDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$endDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.endDateIndex);
    }

    @Override
    public void realmSet$endDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'endDate' to null.");
            }
            row.getTable().setString(columnInfo.endDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'endDate' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.endDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$summary() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.summaryIndex);
    }

    @Override
    public void realmSet$summary(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'summary' to null.");
            }
            row.getTable().setString(columnInfo.summaryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'summary' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.summaryIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmPastJob", 7, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("company", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("position", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("urlImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("startDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("endDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("summary", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmPastJobColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmPastJobColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmPastJob";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.data.models.cache.RealmPastJob createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.data.models.cache.RealmPastJob obj = null;
        if (update) {
            Table table = realm.getTable(com.example.data.models.cache.RealmPastJob.class);
            RealmPastJobColumnInfo columnInfo = (RealmPastJobColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmPastJob.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmPastJob.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmPastJobRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.RealmPastJobRealmProxy) realm.createObjectInternal(com.example.data.models.cache.RealmPastJob.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmPastJobRealmProxy) realm.createObjectInternal(com.example.data.models.cache.RealmPastJob.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final RealmPastJobRealmProxyInterface objProxy = (RealmPastJobRealmProxyInterface) obj;
        if (json.has("company")) {
            if (json.isNull("company")) {
                objProxy.realmSet$company(null);
            } else {
                objProxy.realmSet$company((String) json.getString("company"));
            }
        }
        if (json.has("position")) {
            if (json.isNull("position")) {
                objProxy.realmSet$position(null);
            } else {
                objProxy.realmSet$position((String) json.getString("position"));
            }
        }
        if (json.has("urlImage")) {
            if (json.isNull("urlImage")) {
                objProxy.realmSet$urlImage(null);
            } else {
                objProxy.realmSet$urlImage((String) json.getString("urlImage"));
            }
        }
        if (json.has("startDate")) {
            if (json.isNull("startDate")) {
                objProxy.realmSet$startDate(null);
            } else {
                objProxy.realmSet$startDate((String) json.getString("startDate"));
            }
        }
        if (json.has("endDate")) {
            if (json.isNull("endDate")) {
                objProxy.realmSet$endDate(null);
            } else {
                objProxy.realmSet$endDate((String) json.getString("endDate"));
            }
        }
        if (json.has("summary")) {
            if (json.isNull("summary")) {
                objProxy.realmSet$summary(null);
            } else {
                objProxy.realmSet$summary((String) json.getString("summary"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.data.models.cache.RealmPastJob createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.data.models.cache.RealmPastJob obj = new com.example.data.models.cache.RealmPastJob();
        final RealmPastJobRealmProxyInterface objProxy = (RealmPastJobRealmProxyInterface) obj;
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
            } else if (name.equals("company")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$company((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$company(null);
                }
            } else if (name.equals("position")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$position((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$position(null);
                }
            } else if (name.equals("urlImage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$urlImage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$urlImage(null);
                }
            } else if (name.equals("startDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$startDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$startDate(null);
                }
            } else if (name.equals("endDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$endDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$endDate(null);
                }
            } else if (name.equals("summary")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$summary((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$summary(null);
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

    public static com.example.data.models.cache.RealmPastJob copyOrUpdate(Realm realm, com.example.data.models.cache.RealmPastJob object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.data.models.cache.RealmPastJob) cachedRealmObject;
        }

        com.example.data.models.cache.RealmPastJob realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.data.models.cache.RealmPastJob.class);
            RealmPastJobColumnInfo columnInfo = (RealmPastJobColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmPastJob.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstString(pkColumnIndex, ((RealmPastJobRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmPastJob.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmPastJobRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.example.data.models.cache.RealmPastJob copy(Realm realm, com.example.data.models.cache.RealmPastJob newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.data.models.cache.RealmPastJob) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.data.models.cache.RealmPastJob realmObject = realm.createObjectInternal(com.example.data.models.cache.RealmPastJob.class, ((RealmPastJobRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmPastJobRealmProxyInterface realmObjectSource = (RealmPastJobRealmProxyInterface) newObject;
        RealmPastJobRealmProxyInterface realmObjectCopy = (RealmPastJobRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$company(realmObjectSource.realmGet$company());
        realmObjectCopy.realmSet$position(realmObjectSource.realmGet$position());
        realmObjectCopy.realmSet$urlImage(realmObjectSource.realmGet$urlImage());
        realmObjectCopy.realmSet$startDate(realmObjectSource.realmGet$startDate());
        realmObjectCopy.realmSet$endDate(realmObjectSource.realmGet$endDate());
        realmObjectCopy.realmSet$summary(realmObjectSource.realmGet$summary());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.data.models.cache.RealmPastJob object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.data.models.cache.RealmPastJob.class);
        long tableNativePtr = table.getNativePtr();
        RealmPastJobColumnInfo columnInfo = (RealmPastJobColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmPastJob.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((RealmPastJobRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$company = ((RealmPastJobRealmProxyInterface) object).realmGet$company();
        if (realmGet$company != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
        }
        String realmGet$position = ((RealmPastJobRealmProxyInterface) object).realmGet$position();
        if (realmGet$position != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.positionIndex, rowIndex, realmGet$position, false);
        }
        String realmGet$urlImage = ((RealmPastJobRealmProxyInterface) object).realmGet$urlImage();
        if (realmGet$urlImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlImageIndex, rowIndex, realmGet$urlImage, false);
        }
        String realmGet$startDate = ((RealmPastJobRealmProxyInterface) object).realmGet$startDate();
        if (realmGet$startDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.startDateIndex, rowIndex, realmGet$startDate, false);
        }
        String realmGet$endDate = ((RealmPastJobRealmProxyInterface) object).realmGet$endDate();
        if (realmGet$endDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.endDateIndex, rowIndex, realmGet$endDate, false);
        }
        String realmGet$summary = ((RealmPastJobRealmProxyInterface) object).realmGet$summary();
        if (realmGet$summary != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.summaryIndex, rowIndex, realmGet$summary, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.data.models.cache.RealmPastJob.class);
        long tableNativePtr = table.getNativePtr();
        RealmPastJobColumnInfo columnInfo = (RealmPastJobColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmPastJob.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.data.models.cache.RealmPastJob object = null;
        while (objects.hasNext()) {
            object = (com.example.data.models.cache.RealmPastJob) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((RealmPastJobRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$company = ((RealmPastJobRealmProxyInterface) object).realmGet$company();
            if (realmGet$company != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
            }
            String realmGet$position = ((RealmPastJobRealmProxyInterface) object).realmGet$position();
            if (realmGet$position != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.positionIndex, rowIndex, realmGet$position, false);
            }
            String realmGet$urlImage = ((RealmPastJobRealmProxyInterface) object).realmGet$urlImage();
            if (realmGet$urlImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlImageIndex, rowIndex, realmGet$urlImage, false);
            }
            String realmGet$startDate = ((RealmPastJobRealmProxyInterface) object).realmGet$startDate();
            if (realmGet$startDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.startDateIndex, rowIndex, realmGet$startDate, false);
            }
            String realmGet$endDate = ((RealmPastJobRealmProxyInterface) object).realmGet$endDate();
            if (realmGet$endDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.endDateIndex, rowIndex, realmGet$endDate, false);
            }
            String realmGet$summary = ((RealmPastJobRealmProxyInterface) object).realmGet$summary();
            if (realmGet$summary != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.summaryIndex, rowIndex, realmGet$summary, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.data.models.cache.RealmPastJob object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.data.models.cache.RealmPastJob.class);
        long tableNativePtr = table.getNativePtr();
        RealmPastJobColumnInfo columnInfo = (RealmPastJobColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmPastJob.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((RealmPastJobRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$company = ((RealmPastJobRealmProxyInterface) object).realmGet$company();
        if (realmGet$company != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.companyIndex, rowIndex, false);
        }
        String realmGet$position = ((RealmPastJobRealmProxyInterface) object).realmGet$position();
        if (realmGet$position != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.positionIndex, rowIndex, realmGet$position, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.positionIndex, rowIndex, false);
        }
        String realmGet$urlImage = ((RealmPastJobRealmProxyInterface) object).realmGet$urlImage();
        if (realmGet$urlImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlImageIndex, rowIndex, realmGet$urlImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlImageIndex, rowIndex, false);
        }
        String realmGet$startDate = ((RealmPastJobRealmProxyInterface) object).realmGet$startDate();
        if (realmGet$startDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.startDateIndex, rowIndex, realmGet$startDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.startDateIndex, rowIndex, false);
        }
        String realmGet$endDate = ((RealmPastJobRealmProxyInterface) object).realmGet$endDate();
        if (realmGet$endDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.endDateIndex, rowIndex, realmGet$endDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.endDateIndex, rowIndex, false);
        }
        String realmGet$summary = ((RealmPastJobRealmProxyInterface) object).realmGet$summary();
        if (realmGet$summary != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.summaryIndex, rowIndex, realmGet$summary, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.summaryIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.data.models.cache.RealmPastJob.class);
        long tableNativePtr = table.getNativePtr();
        RealmPastJobColumnInfo columnInfo = (RealmPastJobColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmPastJob.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.data.models.cache.RealmPastJob object = null;
        while (objects.hasNext()) {
            object = (com.example.data.models.cache.RealmPastJob) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((RealmPastJobRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$company = ((RealmPastJobRealmProxyInterface) object).realmGet$company();
            if (realmGet$company != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.companyIndex, rowIndex, realmGet$company, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.companyIndex, rowIndex, false);
            }
            String realmGet$position = ((RealmPastJobRealmProxyInterface) object).realmGet$position();
            if (realmGet$position != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.positionIndex, rowIndex, realmGet$position, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.positionIndex, rowIndex, false);
            }
            String realmGet$urlImage = ((RealmPastJobRealmProxyInterface) object).realmGet$urlImage();
            if (realmGet$urlImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlImageIndex, rowIndex, realmGet$urlImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.urlImageIndex, rowIndex, false);
            }
            String realmGet$startDate = ((RealmPastJobRealmProxyInterface) object).realmGet$startDate();
            if (realmGet$startDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.startDateIndex, rowIndex, realmGet$startDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.startDateIndex, rowIndex, false);
            }
            String realmGet$endDate = ((RealmPastJobRealmProxyInterface) object).realmGet$endDate();
            if (realmGet$endDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.endDateIndex, rowIndex, realmGet$endDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.endDateIndex, rowIndex, false);
            }
            String realmGet$summary = ((RealmPastJobRealmProxyInterface) object).realmGet$summary();
            if (realmGet$summary != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.summaryIndex, rowIndex, realmGet$summary, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.summaryIndex, rowIndex, false);
            }
        }
    }

    public static com.example.data.models.cache.RealmPastJob createDetachedCopy(com.example.data.models.cache.RealmPastJob realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.data.models.cache.RealmPastJob unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.data.models.cache.RealmPastJob();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.data.models.cache.RealmPastJob) cachedObject.object;
            }
            unmanagedObject = (com.example.data.models.cache.RealmPastJob) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmPastJobRealmProxyInterface unmanagedCopy = (RealmPastJobRealmProxyInterface) unmanagedObject;
        RealmPastJobRealmProxyInterface realmSource = (RealmPastJobRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$company(realmSource.realmGet$company());
        unmanagedCopy.realmSet$position(realmSource.realmGet$position());
        unmanagedCopy.realmSet$urlImage(realmSource.realmGet$urlImage());
        unmanagedCopy.realmSet$startDate(realmSource.realmGet$startDate());
        unmanagedCopy.realmSet$endDate(realmSource.realmGet$endDate());
        unmanagedCopy.realmSet$summary(realmSource.realmGet$summary());

        return unmanagedObject;
    }

    static com.example.data.models.cache.RealmPastJob update(Realm realm, com.example.data.models.cache.RealmPastJob realmObject, com.example.data.models.cache.RealmPastJob newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmPastJobRealmProxyInterface realmObjectTarget = (RealmPastJobRealmProxyInterface) realmObject;
        RealmPastJobRealmProxyInterface realmObjectSource = (RealmPastJobRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$company(realmObjectSource.realmGet$company());
        realmObjectTarget.realmSet$position(realmObjectSource.realmGet$position());
        realmObjectTarget.realmSet$urlImage(realmObjectSource.realmGet$urlImage());
        realmObjectTarget.realmSet$startDate(realmObjectSource.realmGet$startDate());
        realmObjectTarget.realmSet$endDate(realmObjectSource.realmGet$endDate());
        realmObjectTarget.realmSet$summary(realmObjectSource.realmGet$summary());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmPastJob = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{company:");
        stringBuilder.append(realmGet$company());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{position:");
        stringBuilder.append(realmGet$position());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{urlImage:");
        stringBuilder.append(realmGet$urlImage());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{startDate:");
        stringBuilder.append(realmGet$startDate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{endDate:");
        stringBuilder.append(realmGet$endDate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{summary:");
        stringBuilder.append(realmGet$summary());
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
        RealmPastJobRealmProxy aRealmPastJob = (RealmPastJobRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmPastJob.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmPastJob.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmPastJob.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
