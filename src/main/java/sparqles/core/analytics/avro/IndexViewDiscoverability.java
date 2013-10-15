/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package sparqles.core.analytics.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class IndexViewDiscoverability extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"IndexViewDiscoverability\",\"namespace\":\"sparqles.core.analytics.avro\",\"fields\":[{\"name\":\"serverName\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"IndexViewDiscoverabilityData\",\"namespace\":\"sparqles.analytics.avro\",\"fields\":[{\"name\":\"key\",\"type\":\"string\"},{\"name\":\"values\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"IndexViewDiscoverabilityDataValues\",\"fields\":[{\"name\":\"label\",\"type\":\"string\"},{\"name\":\"value\",\"type\":\"double\"}]}}}]}}},{\"name\":\"VoIDDescription\",\"type\":\"double\"},{\"name\":\"SDDescription\",\"type\":\"double\"},{\"name\":\"NoDescription\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.util.List<sparqles.analytics.avro.IndexViewDiscoverabilityData> serverName;
  @Deprecated public double VoIDDescription;
  @Deprecated public double SDDescription;
  @Deprecated public double NoDescription;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public IndexViewDiscoverability() {}

  /**
   * All-args constructor.
   */
  public IndexViewDiscoverability(java.util.List<sparqles.analytics.avro.IndexViewDiscoverabilityData> serverName, java.lang.Double VoIDDescription, java.lang.Double SDDescription, java.lang.Double NoDescription) {
    this.serverName = serverName;
    this.VoIDDescription = VoIDDescription;
    this.SDDescription = SDDescription;
    this.NoDescription = NoDescription;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return serverName;
    case 1: return VoIDDescription;
    case 2: return SDDescription;
    case 3: return NoDescription;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: serverName = (java.util.List<sparqles.analytics.avro.IndexViewDiscoverabilityData>)value$; break;
    case 1: VoIDDescription = (java.lang.Double)value$; break;
    case 2: SDDescription = (java.lang.Double)value$; break;
    case 3: NoDescription = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'serverName' field.
   */
  public java.util.List<sparqles.analytics.avro.IndexViewDiscoverabilityData> getServerName() {
    return serverName;
  }

  /**
   * Sets the value of the 'serverName' field.
   * @param value the value to set.
   */
  public void setServerName(java.util.List<sparqles.analytics.avro.IndexViewDiscoverabilityData> value) {
    this.serverName = value;
  }

  /**
   * Gets the value of the 'VoIDDescription' field.
   */
  public java.lang.Double getVoIDDescription() {
    return VoIDDescription;
  }

  /**
   * Sets the value of the 'VoIDDescription' field.
   * @param value the value to set.
   */
  public void setVoIDDescription(java.lang.Double value) {
    this.VoIDDescription = value;
  }

  /**
   * Gets the value of the 'SDDescription' field.
   */
  public java.lang.Double getSDDescription() {
    return SDDescription;
  }

  /**
   * Sets the value of the 'SDDescription' field.
   * @param value the value to set.
   */
  public void setSDDescription(java.lang.Double value) {
    this.SDDescription = value;
  }

  /**
   * Gets the value of the 'NoDescription' field.
   */
  public java.lang.Double getNoDescription() {
    return NoDescription;
  }

  /**
   * Sets the value of the 'NoDescription' field.
   * @param value the value to set.
   */
  public void setNoDescription(java.lang.Double value) {
    this.NoDescription = value;
  }

  /** Creates a new IndexViewDiscoverability RecordBuilder */
  public static sparqles.core.analytics.avro.IndexViewDiscoverability.Builder newBuilder() {
    return new sparqles.core.analytics.avro.IndexViewDiscoverability.Builder();
  }
  
  /** Creates a new IndexViewDiscoverability RecordBuilder by copying an existing Builder */
  public static sparqles.core.analytics.avro.IndexViewDiscoverability.Builder newBuilder(sparqles.core.analytics.avro.IndexViewDiscoverability.Builder other) {
    return new sparqles.core.analytics.avro.IndexViewDiscoverability.Builder(other);
  }
  
  /** Creates a new IndexViewDiscoverability RecordBuilder by copying an existing IndexViewDiscoverability instance */
  public static sparqles.core.analytics.avro.IndexViewDiscoverability.Builder newBuilder(sparqles.core.analytics.avro.IndexViewDiscoverability other) {
    return new sparqles.core.analytics.avro.IndexViewDiscoverability.Builder(other);
  }
  
  /**
   * RecordBuilder for IndexViewDiscoverability instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<IndexViewDiscoverability>
    implements org.apache.avro.data.RecordBuilder<IndexViewDiscoverability> {

    private java.util.List<sparqles.analytics.avro.IndexViewDiscoverabilityData> serverName;
    private double VoIDDescription;
    private double SDDescription;
    private double NoDescription;

    /** Creates a new Builder */
    private Builder() {
      super(sparqles.core.analytics.avro.IndexViewDiscoverability.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(sparqles.core.analytics.avro.IndexViewDiscoverability.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.serverName)) {
        this.serverName = data().deepCopy(fields()[0].schema(), other.serverName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.VoIDDescription)) {
        this.VoIDDescription = data().deepCopy(fields()[1].schema(), other.VoIDDescription);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.SDDescription)) {
        this.SDDescription = data().deepCopy(fields()[2].schema(), other.SDDescription);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.NoDescription)) {
        this.NoDescription = data().deepCopy(fields()[3].schema(), other.NoDescription);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing IndexViewDiscoverability instance */
    private Builder(sparqles.core.analytics.avro.IndexViewDiscoverability other) {
            super(sparqles.core.analytics.avro.IndexViewDiscoverability.SCHEMA$);
      if (isValidValue(fields()[0], other.serverName)) {
        this.serverName = data().deepCopy(fields()[0].schema(), other.serverName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.VoIDDescription)) {
        this.VoIDDescription = data().deepCopy(fields()[1].schema(), other.VoIDDescription);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.SDDescription)) {
        this.SDDescription = data().deepCopy(fields()[2].schema(), other.SDDescription);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.NoDescription)) {
        this.NoDescription = data().deepCopy(fields()[3].schema(), other.NoDescription);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'serverName' field */
    public java.util.List<sparqles.analytics.avro.IndexViewDiscoverabilityData> getServerName() {
      return serverName;
    }
    
    /** Sets the value of the 'serverName' field */
    public sparqles.core.analytics.avro.IndexViewDiscoverability.Builder setServerName(java.util.List<sparqles.analytics.avro.IndexViewDiscoverabilityData> value) {
      validate(fields()[0], value);
      this.serverName = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'serverName' field has been set */
    public boolean hasServerName() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'serverName' field */
    public sparqles.core.analytics.avro.IndexViewDiscoverability.Builder clearServerName() {
      serverName = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'VoIDDescription' field */
    public java.lang.Double getVoIDDescription() {
      return VoIDDescription;
    }
    
    /** Sets the value of the 'VoIDDescription' field */
    public sparqles.core.analytics.avro.IndexViewDiscoverability.Builder setVoIDDescription(double value) {
      validate(fields()[1], value);
      this.VoIDDescription = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'VoIDDescription' field has been set */
    public boolean hasVoIDDescription() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'VoIDDescription' field */
    public sparqles.core.analytics.avro.IndexViewDiscoverability.Builder clearVoIDDescription() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'SDDescription' field */
    public java.lang.Double getSDDescription() {
      return SDDescription;
    }
    
    /** Sets the value of the 'SDDescription' field */
    public sparqles.core.analytics.avro.IndexViewDiscoverability.Builder setSDDescription(double value) {
      validate(fields()[2], value);
      this.SDDescription = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'SDDescription' field has been set */
    public boolean hasSDDescription() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'SDDescription' field */
    public sparqles.core.analytics.avro.IndexViewDiscoverability.Builder clearSDDescription() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'NoDescription' field */
    public java.lang.Double getNoDescription() {
      return NoDescription;
    }
    
    /** Sets the value of the 'NoDescription' field */
    public sparqles.core.analytics.avro.IndexViewDiscoverability.Builder setNoDescription(double value) {
      validate(fields()[3], value);
      this.NoDescription = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'NoDescription' field has been set */
    public boolean hasNoDescription() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'NoDescription' field */
    public sparqles.core.analytics.avro.IndexViewDiscoverability.Builder clearNoDescription() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public IndexViewDiscoverability build() {
      try {
        IndexViewDiscoverability record = new IndexViewDiscoverability();
        record.serverName = fieldSetFlags()[0] ? this.serverName : (java.util.List<sparqles.analytics.avro.IndexViewDiscoverabilityData>) defaultValue(fields()[0]);
        record.VoIDDescription = fieldSetFlags()[1] ? this.VoIDDescription : (java.lang.Double) defaultValue(fields()[1]);
        record.SDDescription = fieldSetFlags()[2] ? this.SDDescription : (java.lang.Double) defaultValue(fields()[2]);
        record.NoDescription = fieldSetFlags()[3] ? this.NoDescription : (java.lang.Double) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
