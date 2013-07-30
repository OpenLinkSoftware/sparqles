/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package core.discovery;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class VoidStoreResult extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"VoidStoreResult\",\"namespace\":\"core.discovery\",\"fields\":[{\"name\":\"voidFile\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"Exception\",\"type\":[\"string\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.util.List<java.lang.CharSequence> voidFile;
  @Deprecated public java.lang.CharSequence Exception;

  /**
   * Default constructor.
   */
  public VoidStoreResult() {}

  /**
   * All-args constructor.
   */
  public VoidStoreResult(java.util.List<java.lang.CharSequence> voidFile, java.lang.CharSequence Exception) {
    this.voidFile = voidFile;
    this.Exception = Exception;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return voidFile;
    case 1: return Exception;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: voidFile = (java.util.List<java.lang.CharSequence>)value$; break;
    case 1: Exception = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'voidFile' field.
   */
  public java.util.List<java.lang.CharSequence> getVoidFile() {
    return voidFile;
  }

  /**
   * Sets the value of the 'voidFile' field.
   * @param value the value to set.
   */
  public void setVoidFile(java.util.List<java.lang.CharSequence> value) {
    this.voidFile = value;
  }

  /**
   * Gets the value of the 'Exception' field.
   */
  public java.lang.CharSequence getException() {
    return Exception;
  }

  /**
   * Sets the value of the 'Exception' field.
   * @param value the value to set.
   */
  public void setException(java.lang.CharSequence value) {
    this.Exception = value;
  }

  /** Creates a new VoidStoreResult RecordBuilder */
  public static core.discovery.VoidStoreResult.Builder newBuilder() {
    return new core.discovery.VoidStoreResult.Builder();
  }
  
  /** Creates a new VoidStoreResult RecordBuilder by copying an existing Builder */
  public static core.discovery.VoidStoreResult.Builder newBuilder(core.discovery.VoidStoreResult.Builder other) {
    return new core.discovery.VoidStoreResult.Builder(other);
  }
  
  /** Creates a new VoidStoreResult RecordBuilder by copying an existing VoidStoreResult instance */
  public static core.discovery.VoidStoreResult.Builder newBuilder(core.discovery.VoidStoreResult other) {
    return new core.discovery.VoidStoreResult.Builder(other);
  }
  
  /**
   * RecordBuilder for VoidStoreResult instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<VoidStoreResult>
    implements org.apache.avro.data.RecordBuilder<VoidStoreResult> {

    private java.util.List<java.lang.CharSequence> voidFile;
    private java.lang.CharSequence Exception;

    /** Creates a new Builder */
    private Builder() {
      super(core.discovery.VoidStoreResult.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(core.discovery.VoidStoreResult.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing VoidStoreResult instance */
    private Builder(core.discovery.VoidStoreResult other) {
            super(core.discovery.VoidStoreResult.SCHEMA$);
      if (isValidValue(fields()[0], other.voidFile)) {
        this.voidFile = data().deepCopy(fields()[0].schema(), other.voidFile);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.Exception)) {
        this.Exception = data().deepCopy(fields()[1].schema(), other.Exception);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'voidFile' field */
    public java.util.List<java.lang.CharSequence> getVoidFile() {
      return voidFile;
    }
    
    /** Sets the value of the 'voidFile' field */
    public core.discovery.VoidStoreResult.Builder setVoidFile(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[0], value);
      this.voidFile = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'voidFile' field has been set */
    public boolean hasVoidFile() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'voidFile' field */
    public core.discovery.VoidStoreResult.Builder clearVoidFile() {
      voidFile = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'Exception' field */
    public java.lang.CharSequence getException() {
      return Exception;
    }
    
    /** Sets the value of the 'Exception' field */
    public core.discovery.VoidStoreResult.Builder setException(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.Exception = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'Exception' field has been set */
    public boolean hasException() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'Exception' field */
    public core.discovery.VoidStoreResult.Builder clearException() {
      Exception = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public VoidStoreResult build() {
      try {
        VoidStoreResult record = new VoidStoreResult();
        record.voidFile = fieldSetFlags()[0] ? this.voidFile : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[0]);
        record.Exception = fieldSetFlags()[1] ? this.Exception : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
