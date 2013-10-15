/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package sparqles.analytics.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AvailabilityView extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvailabilityView\",\"namespace\":\"sparqles.analytics.avro\",\"fields\":[{\"name\":\"endpoint\",\"type\":{\"type\":\"record\",\"name\":\"Endpoint\",\"namespace\":\"sparqles.core\",\"fields\":[{\"name\":\"uri\",\"type\":\"string\"},{\"name\":\"datasets\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Dataset\",\"fields\":[{\"name\":\"uri\",\"type\":\"string\"},{\"name\":\"label\",\"type\":\"string\"}]}}}]}},{\"name\":\"upNow\",\"type\":\"boolean\"},{\"name\":\"uptimeLast24h\",\"type\":\"double\"},{\"name\":\"uptimeLast7d\",\"type\":\"double\"},{\"name\":\"lastUpdate\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public sparqles.core.Endpoint endpoint;
  @Deprecated public boolean upNow;
  @Deprecated public double uptimeLast24h;
  @Deprecated public double uptimeLast7d;
  @Deprecated public long lastUpdate;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public AvailabilityView() {}

  /**
   * All-args constructor.
   */
  public AvailabilityView(sparqles.core.Endpoint endpoint, java.lang.Boolean upNow, java.lang.Double uptimeLast24h, java.lang.Double uptimeLast7d, java.lang.Long lastUpdate) {
    this.endpoint = endpoint;
    this.upNow = upNow;
    this.uptimeLast24h = uptimeLast24h;
    this.uptimeLast7d = uptimeLast7d;
    this.lastUpdate = lastUpdate;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return endpoint;
    case 1: return upNow;
    case 2: return uptimeLast24h;
    case 3: return uptimeLast7d;
    case 4: return lastUpdate;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: endpoint = (sparqles.core.Endpoint)value$; break;
    case 1: upNow = (java.lang.Boolean)value$; break;
    case 2: uptimeLast24h = (java.lang.Double)value$; break;
    case 3: uptimeLast7d = (java.lang.Double)value$; break;
    case 4: lastUpdate = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'endpoint' field.
   */
  public sparqles.core.Endpoint getEndpoint() {
    return endpoint;
  }

  /**
   * Sets the value of the 'endpoint' field.
   * @param value the value to set.
   */
  public void setEndpoint(sparqles.core.Endpoint value) {
    this.endpoint = value;
  }

  /**
   * Gets the value of the 'upNow' field.
   */
  public java.lang.Boolean getUpNow() {
    return upNow;
  }

  /**
   * Sets the value of the 'upNow' field.
   * @param value the value to set.
   */
  public void setUpNow(java.lang.Boolean value) {
    this.upNow = value;
  }

  /**
   * Gets the value of the 'uptimeLast24h' field.
   */
  public java.lang.Double getUptimeLast24h() {
    return uptimeLast24h;
  }

  /**
   * Sets the value of the 'uptimeLast24h' field.
   * @param value the value to set.
   */
  public void setUptimeLast24h(java.lang.Double value) {
    this.uptimeLast24h = value;
  }

  /**
   * Gets the value of the 'uptimeLast7d' field.
   */
  public java.lang.Double getUptimeLast7d() {
    return uptimeLast7d;
  }

  /**
   * Sets the value of the 'uptimeLast7d' field.
   * @param value the value to set.
   */
  public void setUptimeLast7d(java.lang.Double value) {
    this.uptimeLast7d = value;
  }

  /**
   * Gets the value of the 'lastUpdate' field.
   */
  public java.lang.Long getLastUpdate() {
    return lastUpdate;
  }

  /**
   * Sets the value of the 'lastUpdate' field.
   * @param value the value to set.
   */
  public void setLastUpdate(java.lang.Long value) {
    this.lastUpdate = value;
  }

  /** Creates a new AvailabilityView RecordBuilder */
  public static sparqles.analytics.avro.AvailabilityView.Builder newBuilder() {
    return new sparqles.analytics.avro.AvailabilityView.Builder();
  }
  
  /** Creates a new AvailabilityView RecordBuilder by copying an existing Builder */
  public static sparqles.analytics.avro.AvailabilityView.Builder newBuilder(sparqles.analytics.avro.AvailabilityView.Builder other) {
    return new sparqles.analytics.avro.AvailabilityView.Builder(other);
  }
  
  /** Creates a new AvailabilityView RecordBuilder by copying an existing AvailabilityView instance */
  public static sparqles.analytics.avro.AvailabilityView.Builder newBuilder(sparqles.analytics.avro.AvailabilityView other) {
    return new sparqles.analytics.avro.AvailabilityView.Builder(other);
  }
  
  /**
   * RecordBuilder for AvailabilityView instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvailabilityView>
    implements org.apache.avro.data.RecordBuilder<AvailabilityView> {

    private sparqles.core.Endpoint endpoint;
    private boolean upNow;
    private double uptimeLast24h;
    private double uptimeLast7d;
    private long lastUpdate;

    /** Creates a new Builder */
    private Builder() {
      super(sparqles.analytics.avro.AvailabilityView.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(sparqles.analytics.avro.AvailabilityView.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.endpoint)) {
        this.endpoint = data().deepCopy(fields()[0].schema(), other.endpoint);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.upNow)) {
        this.upNow = data().deepCopy(fields()[1].schema(), other.upNow);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.uptimeLast24h)) {
        this.uptimeLast24h = data().deepCopy(fields()[2].schema(), other.uptimeLast24h);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.uptimeLast7d)) {
        this.uptimeLast7d = data().deepCopy(fields()[3].schema(), other.uptimeLast7d);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.lastUpdate)) {
        this.lastUpdate = data().deepCopy(fields()[4].schema(), other.lastUpdate);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing AvailabilityView instance */
    private Builder(sparqles.analytics.avro.AvailabilityView other) {
            super(sparqles.analytics.avro.AvailabilityView.SCHEMA$);
      if (isValidValue(fields()[0], other.endpoint)) {
        this.endpoint = data().deepCopy(fields()[0].schema(), other.endpoint);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.upNow)) {
        this.upNow = data().deepCopy(fields()[1].schema(), other.upNow);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.uptimeLast24h)) {
        this.uptimeLast24h = data().deepCopy(fields()[2].schema(), other.uptimeLast24h);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.uptimeLast7d)) {
        this.uptimeLast7d = data().deepCopy(fields()[3].schema(), other.uptimeLast7d);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.lastUpdate)) {
        this.lastUpdate = data().deepCopy(fields()[4].schema(), other.lastUpdate);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'endpoint' field */
    public sparqles.core.Endpoint getEndpoint() {
      return endpoint;
    }
    
    /** Sets the value of the 'endpoint' field */
    public sparqles.analytics.avro.AvailabilityView.Builder setEndpoint(sparqles.core.Endpoint value) {
      validate(fields()[0], value);
      this.endpoint = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'endpoint' field has been set */
    public boolean hasEndpoint() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'endpoint' field */
    public sparqles.analytics.avro.AvailabilityView.Builder clearEndpoint() {
      endpoint = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'upNow' field */
    public java.lang.Boolean getUpNow() {
      return upNow;
    }
    
    /** Sets the value of the 'upNow' field */
    public sparqles.analytics.avro.AvailabilityView.Builder setUpNow(boolean value) {
      validate(fields()[1], value);
      this.upNow = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'upNow' field has been set */
    public boolean hasUpNow() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'upNow' field */
    public sparqles.analytics.avro.AvailabilityView.Builder clearUpNow() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'uptimeLast24h' field */
    public java.lang.Double getUptimeLast24h() {
      return uptimeLast24h;
    }
    
    /** Sets the value of the 'uptimeLast24h' field */
    public sparqles.analytics.avro.AvailabilityView.Builder setUptimeLast24h(double value) {
      validate(fields()[2], value);
      this.uptimeLast24h = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'uptimeLast24h' field has been set */
    public boolean hasUptimeLast24h() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'uptimeLast24h' field */
    public sparqles.analytics.avro.AvailabilityView.Builder clearUptimeLast24h() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'uptimeLast7d' field */
    public java.lang.Double getUptimeLast7d() {
      return uptimeLast7d;
    }
    
    /** Sets the value of the 'uptimeLast7d' field */
    public sparqles.analytics.avro.AvailabilityView.Builder setUptimeLast7d(double value) {
      validate(fields()[3], value);
      this.uptimeLast7d = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'uptimeLast7d' field has been set */
    public boolean hasUptimeLast7d() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'uptimeLast7d' field */
    public sparqles.analytics.avro.AvailabilityView.Builder clearUptimeLast7d() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'lastUpdate' field */
    public java.lang.Long getLastUpdate() {
      return lastUpdate;
    }
    
    /** Sets the value of the 'lastUpdate' field */
    public sparqles.analytics.avro.AvailabilityView.Builder setLastUpdate(long value) {
      validate(fields()[4], value);
      this.lastUpdate = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'lastUpdate' field has been set */
    public boolean hasLastUpdate() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'lastUpdate' field */
    public sparqles.analytics.avro.AvailabilityView.Builder clearLastUpdate() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public AvailabilityView build() {
      try {
        AvailabilityView record = new AvailabilityView();
        record.endpoint = fieldSetFlags()[0] ? this.endpoint : (sparqles.core.Endpoint) defaultValue(fields()[0]);
        record.upNow = fieldSetFlags()[1] ? this.upNow : (java.lang.Boolean) defaultValue(fields()[1]);
        record.uptimeLast24h = fieldSetFlags()[2] ? this.uptimeLast24h : (java.lang.Double) defaultValue(fields()[2]);
        record.uptimeLast7d = fieldSetFlags()[3] ? this.uptimeLast7d : (java.lang.Double) defaultValue(fields()[3]);
        record.lastUpdate = fieldSetFlags()[4] ? this.lastUpdate : (java.lang.Long) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
