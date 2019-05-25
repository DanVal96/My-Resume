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
public class RealmBasicsRealmProxy extends com.example.data.models.cache.RealmBasics
    implements RealmObjectProxy, RealmBasicsRealmProxyInterface {

    static final class RealmBasicsColumnInfo extends ColumnInfo {
        long idIndex;
        long nameIndex;
        long labelIndex;
        long pictureIndex;
        long emailIndex;
        long summaryIndex;

        RealmBasicsColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmBasics");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.labelIndex = addColumnDetails("label", objectSchemaInfo);
            this.pictureIndex = addColumnDetails("picture", objectSchemaInfo);
            this.emailIndex = addColumnDetails("email", objectSchemaInfo);
            this.summaryIndex = addColumnDetails("summary", objectSchemaInfo);
        }

        RealmBasicsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmBasicsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmBasicsColumnInfo src = (RealmBasicsColumnInfo) rawSrc;
            final RealmBasicsColumnInfo dst = (RealmBasicsColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.labelIndex = src.labelIndex;
            dst.pictureIndex = src.pictureIndex;
            dst.emailIndex = src.emailIndex;
            dst.summaryIndex = src.summaryIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(6);
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("label");
        fieldNames.add("picture");
        fieldNames.add("email");
        fieldNames.add("summary");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmBasicsColumnInfo columnInfo;
    private ProxyState<com.example.data.models.cache.RealmBasics> proxyState;

    RealmBasicsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmBasicsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.data.models.cache.RealmBasics>(this);
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
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'name' to null.");
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'name' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$label() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.labelIndex);
    }

    @Override
    public void realmSet$label(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'label' to null.");
            }
            row.getTable().setString(columnInfo.labelIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'label' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.labelIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$picture() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pictureIndex);
    }

    @Override
    public void realmSet$picture(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'picture' to null.");
            }
            row.getTable().setString(columnInfo.pictureIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'picture' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.pictureIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'email' to null.");
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'email' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmBasics", 6, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("label", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("picture", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("summary", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmBasicsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmBasicsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmBasics";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.data.models.cache.RealmBasics createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.data.models.cache.RealmBasics obj = null;
        if (update) {
            Table table = realm.getTable(com.example.data.models.cache.RealmBasics.class);
            RealmBasicsColumnInfo columnInfo = (RealmBasicsColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmBasics.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmBasics.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RealmBasicsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.RealmBasicsRealmProxy) realm.createObjectInternal(com.example.data.models.cache.RealmBasics.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RealmBasicsRealmProxy) realm.createObjectInternal(com.example.data.models.cache.RealmBasics.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final RealmBasicsRealmProxyInterface objProxy = (RealmBasicsRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("label")) {
            if (json.isNull("label")) {
                objProxy.realmSet$label(null);
            } else {
                objProxy.realmSet$label((String) json.getString("label"));
            }
        }
        if (json.has("picture")) {
            if (json.isNull("picture")) {
                objProxy.realmSet$picture(null);
            } else {
                objProxy.realmSet$picture((String) json.getString("picture"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
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
    public static com.example.data.models.cache.RealmBasics createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.data.models.cache.RealmBasics obj = new com.example.data.models.cache.RealmBasics();
        final RealmBasicsRealmProxyInterface objProxy = (RealmBasicsRealmProxyInterface) obj;
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
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("label")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$label((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$label(null);
                }
            } else if (name.equals("picture")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$picture((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$picture(null);
                }
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
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

    public static com.example.data.models.cache.RealmBasics copyOrUpdate(Realm realm, com.example.data.models.cache.RealmBasics object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.data.models.cache.RealmBasics) cachedRealmObject;
        }

        com.example.data.models.cache.RealmBasics realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.data.models.cache.RealmBasics.class);
            RealmBasicsColumnInfo columnInfo = (RealmBasicsColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmBasics.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstString(pkColumnIndex, ((RealmBasicsRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmBasics.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.RealmBasicsRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.example.data.models.cache.RealmBasics copy(Realm realm, com.example.data.models.cache.RealmBasics newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.data.models.cache.RealmBasics) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.data.models.cache.RealmBasics realmObject = realm.createObjectInternal(com.example.data.models.cache.RealmBasics.class, ((RealmBasicsRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmBasicsRealmProxyInterface realmObjectSource = (RealmBasicsRealmProxyInterface) newObject;
        RealmBasicsRealmProxyInterface realmObjectCopy = (RealmBasicsRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$label(realmObjectSource.realmGet$label());
        realmObjectCopy.realmSet$picture(realmObjectSource.realmGet$picture());
        realmObjectCopy.realmSet$email(realmObjectSource.realmGet$email());
        realmObjectCopy.realmSet$summary(realmObjectSource.realmGet$summary());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.data.models.cache.RealmBasics object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.data.models.cache.RealmBasics.class);
        long tableNativePtr = table.getNativePtr();
        RealmBasicsColumnInfo columnInfo = (RealmBasicsColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmBasics.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((RealmBasicsRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((RealmBasicsRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$label = ((RealmBasicsRealmProxyInterface) object).realmGet$label();
        if (realmGet$label != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
        }
        String realmGet$picture = ((RealmBasicsRealmProxyInterface) object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        }
        String realmGet$email = ((RealmBasicsRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$summary = ((RealmBasicsRealmProxyInterface) object).realmGet$summary();
        if (realmGet$summary != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.summaryIndex, rowIndex, realmGet$summary, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.data.models.cache.RealmBasics.class);
        long tableNativePtr = table.getNativePtr();
        RealmBasicsColumnInfo columnInfo = (RealmBasicsColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmBasics.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.data.models.cache.RealmBasics object = null;
        while (objects.hasNext()) {
            object = (com.example.data.models.cache.RealmBasics) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((RealmBasicsRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((RealmBasicsRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$label = ((RealmBasicsRealmProxyInterface) object).realmGet$label();
            if (realmGet$label != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
            }
            String realmGet$picture = ((RealmBasicsRealmProxyInterface) object).realmGet$picture();
            if (realmGet$picture != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
            }
            String realmGet$email = ((RealmBasicsRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            }
            String realmGet$summary = ((RealmBasicsRealmProxyInterface) object).realmGet$summary();
            if (realmGet$summary != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.summaryIndex, rowIndex, realmGet$summary, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.data.models.cache.RealmBasics object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.data.models.cache.RealmBasics.class);
        long tableNativePtr = table.getNativePtr();
        RealmBasicsColumnInfo columnInfo = (RealmBasicsColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmBasics.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((RealmBasicsRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((RealmBasicsRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$label = ((RealmBasicsRealmProxyInterface) object).realmGet$label();
        if (realmGet$label != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.labelIndex, rowIndex, false);
        }
        String realmGet$picture = ((RealmBasicsRealmProxyInterface) object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
        }
        String realmGet$email = ((RealmBasicsRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$summary = ((RealmBasicsRealmProxyInterface) object).realmGet$summary();
        if (realmGet$summary != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.summaryIndex, rowIndex, realmGet$summary, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.summaryIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.data.models.cache.RealmBasics.class);
        long tableNativePtr = table.getNativePtr();
        RealmBasicsColumnInfo columnInfo = (RealmBasicsColumnInfo) realm.getSchema().getColumnInfo(com.example.data.models.cache.RealmBasics.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.data.models.cache.RealmBasics object = null;
        while (objects.hasNext()) {
            object = (com.example.data.models.cache.RealmBasics) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((RealmBasicsRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, (String)primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((RealmBasicsRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$label = ((RealmBasicsRealmProxyInterface) object).realmGet$label();
            if (realmGet$label != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.labelIndex, rowIndex, false);
            }
            String realmGet$picture = ((RealmBasicsRealmProxyInterface) object).realmGet$picture();
            if (realmGet$picture != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
            }
            String realmGet$email = ((RealmBasicsRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
            }
            String realmGet$summary = ((RealmBasicsRealmProxyInterface) object).realmGet$summary();
            if (realmGet$summary != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.summaryIndex, rowIndex, realmGet$summary, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.summaryIndex, rowIndex, false);
            }
        }
    }

    public static com.example.data.models.cache.RealmBasics createDetachedCopy(com.example.data.models.cache.RealmBasics realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.data.models.cache.RealmBasics unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.data.models.cache.RealmBasics();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.data.models.cache.RealmBasics) cachedObject.object;
            }
            unmanagedObject = (com.example.data.models.cache.RealmBasics) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmBasicsRealmProxyInterface unmanagedCopy = (RealmBasicsRealmProxyInterface) unmanagedObject;
        RealmBasicsRealmProxyInterface realmSource = (RealmBasicsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$label(realmSource.realmGet$label());
        unmanagedCopy.realmSet$picture(realmSource.realmGet$picture());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$summary(realmSource.realmGet$summary());

        return unmanagedObject;
    }

    static com.example.data.models.cache.RealmBasics update(Realm realm, com.example.data.models.cache.RealmBasics realmObject, com.example.data.models.cache.RealmBasics newObject, Map<RealmModel, RealmObjectProxy> cache) {
        RealmBasicsRealmProxyInterface realmObjectTarget = (RealmBasicsRealmProxyInterface) realmObject;
        RealmBasicsRealmProxyInterface realmObjectSource = (RealmBasicsRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$label(realmObjectSource.realmGet$label());
        realmObjectTarget.realmSet$picture(realmObjectSource.realmGet$picture());
        realmObjectTarget.realmSet$email(realmObjectSource.realmGet$email());
        realmObjectTarget.realmSet$summary(realmObjectSource.realmGet$summary());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmBasics = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{label:");
        stringBuilder.append(realmGet$label());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{picture:");
        stringBuilder.append(realmGet$picture());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email());
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
        RealmBasicsRealmProxy aRealmBasics = (RealmBasicsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmBasics.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmBasics.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmBasics.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
